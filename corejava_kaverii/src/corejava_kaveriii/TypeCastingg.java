package corejava_kaveriii;

public class TypeCastingg {
	
public static void main(String[] args) {
        
        int quality = 3;
        double pricePerItem = 99.50;
        double totalPrice = quality * pricePerItem;
        
        // narrowing 
        double discount = 10.75;
        int roundedDiscount = (int)discount; 
        
        double finalAmount = totalPrice - roundedDiscount;
        
        System.out.println("Online Shopping Summary");
        System.out.println("Final Amount: " + finalAmount);
    }

}
