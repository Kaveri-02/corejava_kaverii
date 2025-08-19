package org.tnsif.sf.c2tc.keyword;

class Payment
{
	void makePayment()
	{
		System.out.println("Processing payment using generic method");
	}
}
//subclass hema

class UpiPayment extends  Payment
{
	void makePayment()
	{
		System.out.println("Payment made using UPI");
	}
}
//sumanth
class CardPayment extends Payment
{
	void makePayment()
	{
		System.out.println("Payment made using Credit/debit card");
	}
}

//nikitha

class Walletpayment extends Payment
{
	void makePayment()
	{
		System.out.println("Payment made using Digital Wallet");
	}
}

public class MethodOverridingDemo {
	public static void main(String[] args) {
		Payment payment= new Payment();//reference of parent class
		payment.makePayment();
		
		payment=new UpiPayment();
		payment.makePayment();
		
		payment =new CardPayment();
		payment.makePayment();
		
		payment=new Walletpayment();
		payment.makePayment();
	}

}
