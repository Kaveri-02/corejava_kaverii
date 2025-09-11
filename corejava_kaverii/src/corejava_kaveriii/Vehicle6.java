package corejava_kaveriii;






interface Vehicle6
{
	void start();
	void stop();

	int Max_speed=120;
	
	default void repair()
	{
		System.out.println("Vehicle is being repaired");
	}
	static void checkMaintaince()
	{
		System.out.println("vehicle maintaince taken care here");
	}
}






	
