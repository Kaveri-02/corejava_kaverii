package corejava_kaveriii;

public class DataType_Demo {
		
	public static void main(String[] args) {
		
		int orderId=101;
		double price =299.99;
		boolean isdelivered=false;
		char rating = 'A';
		float deliveryDistance =5.3f;
		long deliveryBoyPhone = 9986675356l;
		byte deliverytime=45;
		short restaurantid=12;
		
		String customerName="Anjali";
		String fooditem[]= {"burger", "fries", "coke"};
		
		//order summary
		
		System.out.println("order summary ");
		System.out.println("Customer Name:"  +customerName);
		System.out.println("Order id:"+ orderId);
		System.out.println("restaurant id:" +restaurantid );
		System.out.println("DeliveryBoy Number:"+deliveryBoyPhone);
		System.out.println("Food items:");
		for (String item:fooditem)
		{
			System.out.println("-   "+item);	
		}
		System.out.println("Total price:"+price);
		System.out.println("delivery distance:"+deliveryDistance);
		System.out.println("is Delivered:" +isdelivered);
		System.out.println("Rating:"+rating);
		
		
		
	}
	
}
