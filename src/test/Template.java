package test;
//class Template<Type extends Object>{
class Template<Type>{
	 
	 private Type template;
	 
	 public Template( ){
	 }
	 public Template( Type template){
	  setTemplate( template );
	 }
	 
	 public void setTemplate( Type template){
	  this.template = template;
	 }
	 
	 public Type getTemplate(){
	  return template;
	 }
	 
	 public void print(){
	  System.out.println( template.toString());
	 }
	 public static void main(String[] args){
	  Template<String> stringT = new Template<String>();
	  stringT.setTemplate( new String( "Hello Template class" ));
	  stringT.print();
	  Template<Integer> it= new Template<Integer>(8);
	  
	  Template<Integer> integerT = new Template<Integer>( 5 );
	  integerT.print();
	  
	  Template doubleT = new Template<Double>( 3.1415926 );
	  doubleT.print();
	  
	  
	 }
	}
