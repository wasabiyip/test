    class TimerThread extends Thread {
	// This flag is will be set true to tell the thread to stop running.
	// Note that it is declared volatile, which means that it may be 
	// changed asynchronously by another thread, so threads must always
	// read its true value, and not used a cached version.
	volatile boolean stopped = false;  

	// The constructor
	public TimerThread(boolean isDaemon) { setDaemon(isDaemon); }

	// Ask the thread to stop by setting the flag above
	public void pleaseStop() { stopped = true; }

	// This is the body of the thread
	public void run() {
	    TimerTask readyToRun = null;  // Is there a task to run right now?

	    // The thread loops until the stopped flag is set to true.
	    while(!stopped) {
		// If there is a task that is ready to run, then run it!
		if (readyToRun != null) { 
		    if (readyToRun.cancelled) {  // If it was cancelled, skip.
			readyToRun = null;
			continue;
		    }
		    // Run the task.
		    readyToRun.run();
		    // Ask it to reschedule itself, and if it wants to run 
		    // again, then insert it back into the set of tasks.
		    if (readyToRun.reschedule())
			schedule(readyToRun);
		    // We've run it, so there is nothing to run now
		    readyToRun = null;
		    // Go back to top of the loop to see if we've been stopped
		    continue;
		}

		// Now acquire a lock on the set of tasks
		synchronized(tasks) {
		    long timeout;  // how many ms 'till the next execution?

		    if (tasks.isEmpty()) {   // If there aren't any tasks
			timeout = 0;  // Wait 'till notified of a new task
		    }
		    else {
			// If there are scheduled tasks, then get the first one
			// Since the set is sorted, this is the next one.
			TimerTask t = (TimerTask) tasks.first();
			// How long 'till it is next run?
			timeout = t.nextTime - System.currentTimeMillis();
			// Check whether it needs to run now
			if (timeout <= 0) {
			    readyToRun = t;  // Save it as ready to run
			    tasks.remove(t); // Remove it from the set
			    // Break out of the synchronized section before
			    // we run the task
			    continue;
			}
		    }

		    // If we get here, there is nothing ready to run now,
		    // so wait for time to run out, or wait 'till notify() is
		    // called when something new is added to the set of tasks.
		    try { tasks.wait(timeout); }
		    catch (InterruptedException e) {}

		    // When we wake up, go back up to the top of the while loop
		}
	    }
	}
    }
    
    /** This inner class defines a test program */
    public static class Test {
	public static void main(String[] args) {
	    final TimerTask t1 = new TimerTask() { // Task 1: print "boom"
		    public void run() { System.out.println("boom"); }
		};
	    final TimerTask t2 = new TimerTask() { // Task 2: print "BOOM"
		    public void run() { System.out.println("\tBOOM"); }
		};
	    final TimerTask t3 = new TimerTask() { // Task 3: cancel the tasks
		    public void run() { t1.cancel(); t2.cancel(); }
		};
	    
	    // Create a timer, and schedule some tasks
	    final Timer timer = new Timer();
	    timer.schedule(t1, 0, 500);     // boom every .5sec starting now
	    timer.schedule(t2, 2000, 2000); // BOOM every 2s, starting in 2s
	    timer.schedule(t3, 5000);       // Stop them after 5 seconds

	    // Schedule a final task: starting in 5 seconds, count
	    // down from 5, then destroy the timer, which, since it is
	    // the only remaining thread, will cause the program to exit.
	    timer.scheduleAtFixedRate(new TimerTask() {
		    public int times = 5;
		    public void run() {
			System.out.println(times--);
			if (times == 0) timer.cancel();
		    }
		}, 
				      5000,500);
	}
    }
}