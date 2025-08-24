package tns.ScannerClassDemo;

//import the Scanner Class
// create a scanner object
//prompt the user input
//read input using scanner method
//validate
//close the scanner

import java.util.Scanner;

public class ScannerClassDemo {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
	    System.out.println("Enter your name:");
	    char c = scan.next().charAt(0);
	    
	    scan.close();
	    
	    
	}
	

}
