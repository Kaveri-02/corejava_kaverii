package corejava_kaveriii;

class Car6 implements Vehicle6{

	private String model;
	
	public Car6(String model) {
		this.model = model;
	}


	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("car"+model+"is starting");
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("car"+model+"is stoping");
		
	}
		
}

class Bike6 implements Vehicle6{
	
	private String type;
	
	public Bike6(String type) {
		this.type = type;
	}



	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("car"+ type+"is stoping");
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("car"+ type+"is stoping");
		
	}
	
}

public class Default_Static_demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle6 car=new Car6("KIA");
		Vehicle6 bike=new Bike6("Royal Enfield"); 
		
		car.start();
		car.stop();
		
		bike.start();
		bike.stop();
		
		car.repair();
		bike.repair();
		
		Vehicle6.checkMaintaince();
		
		
		System.out.println("maximun speed of vehicles" +"     " +  Vehicle6.Max_speed);
		

	}

}
