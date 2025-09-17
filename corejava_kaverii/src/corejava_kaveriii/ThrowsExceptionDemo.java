package corejava_kaveriii;

import java.io.IOException;

	public class ThrowsExceptionDemo {
	//hema
		void printing() //no exception
		{
			System.out.println("Printing java");
		}
		//prajwal
		void scanning() throws IOException
		{
			System.out.println("Device error");
		}
		//gagan
		void verification() throws ArithmeticException ,IOException,ClassNotFoundException
		{
			System.out.println("technical error");
		}
		
		
		public static void main(String[] args) {
			ThrowsExceptionDemo obj=new ThrowsExceptionDemo();
			
			obj.printing();
			try
			{
				obj.scanning();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
			try
			{
				obj.verification();
			}
			catch(ArithmeticException e)
			{
				System.out.println(e);
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
			catch(ClassNotFoundException e)
			{
				System.out.println(e);
			}
			
		}

	}



