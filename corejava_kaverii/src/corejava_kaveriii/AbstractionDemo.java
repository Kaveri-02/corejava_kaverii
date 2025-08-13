package corejava_kaveriii;

public class AbstractionDemo{

	public static void main(String[] args) {
		Mahesh obj=new Suresh();
		obj.calling();
		obj.AIIntegration();
		obj.SatelliteComm();
		obj.HealthMonitoring();
	}

}


abstract class Mahesh{
	public void calling()
    {
		
	 System.out.println("calling");
    }
    public abstract void AIIntegration();
    public abstract void SatelliteComm();
    public abstract void HealthMonitoring();
}


abstract class Ramesh extends Mahesh{
	public void AIIntegration() {
			System.out.println("Phone is integrated with AI");
     }
    public abstract void SatelliteComm();
    public abstract void HealthMonitoring();
}


class Suresh extends Ramesh{
	public void SatelliteComm() {
	System.out.println("Phone is integrated with SatelliteComm");	
	}

	public void HealthMonitoring() {
	System.out.println("PHone is integrated with HealthMonitoring ");
	}
}
	
	
	

