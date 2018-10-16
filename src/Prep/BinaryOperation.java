package Prep;
//https://www.quora.com/Can-you-explain-the-XOR-operator-in-java

public class BinaryOperation {
	public static void main(String[] args) {
		int a = 60;	/* 60 = 0011 1100 */  
	     int b = 13;	/* 13 = 0000 1101 */
	     int c =  0;
	     
	     //AND
	     c = a & b;       /* 12 = 0000 1100 */ 
	     System.out.println("a & b = " + c );
	 
	 
	     //OR
	     c = a | b;       /* 61 = 0011 1101 */
	     System.out.println("a | b = " + c );
	 
	 
	     //XOR
	     c = a ^ b;       /* 49 = 0011 0001 */
	     System.out.println("a ^ b = " + c );
	 
	 
	     //NEGATION
	     c = ~a;          /*-61 = 1100 0011 */
	     System.out.println("~a = " + c );
	}
}
