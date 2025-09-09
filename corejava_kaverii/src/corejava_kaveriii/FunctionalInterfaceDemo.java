package corejava_kaveriii;

class EmailNotification implements NotificationService {

	@Override
	public void notifyUser(String message) {
		// TODO Auto-generated method stub
		 System.out.println("Sending Email:"+message);
	}
	
}
class SMSNotifiaction implements NotificationService {

	@Override
	public void notifyUser(String message) {
		// TODO Auto-generated method stub
		 System.out.println("Sending Email:"+message);
	}
	
}


public class FunctionalInterfaceDemo {
	public static void main(String[] args) {
		NotificationService email=new EmailNotification();
		NotificationService sms = new SMSNotifiaction();
		
		email.notifyUser("Assignment Uploaded");
		sms.notifyUser("class at 10am");
	}

}
