package test;

import java.util.Date;
import java.util.logging.Logger;


public class IPersonProxy implements IPerson {
    private IPerson person;
    private Logger logger = Logger.getAnonymousLogger();
    public IPersonProxy(IPerson person) {
        this.person = person;
    }
    public void sleep() {
        logger.info("开始执行时间：" + new Date());
        person.sleep();
        logger.info("执行结束时间：" + new Date());
    }
    public void eating() {
        logger.info("开始执行时间：" + new Date());
        person.eating();
        logger.info("执行结束时间：" + new Date());
    }
}