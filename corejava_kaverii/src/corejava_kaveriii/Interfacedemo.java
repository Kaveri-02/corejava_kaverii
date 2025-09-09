package corejava_kaveriii;


class SmartLight implements SmartDevice {

	@Override
	public void turnOn() {
		System.out.println("Smart light is On");
	
		
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("Smart light is off");
		
	}

	@Override
	public void getStatus() {
		// TODO Auto-generated method stub
		System.out.println("Smart light is in standy mode");
		
	}
	
}

public class Interfacedemo {

	public static void main(String[] args) {
		SmartLight obj=new SmartLight();
		obj.turnOn();
		obj.turnOff();
		obj.getStatus();
	}

}
