package corejava_kaveriii;

class Eclipse extends Thread
{
	public void run() {
		System.out.println("Eclipse id"+ " "+ Thread.currentThread().getId());
	}
}

class OneNote extends Thread{
	public void run() {
		System.out.println("OneNote id"+ " "+ Thread.currentThread().getId());
	}
}

class Chrome extends Thread{
	public void run() {
		System.out.println("Chrome id"+ " "+ Thread.currentThread().getId());
	}
}
public class ExtendingThreadsDemo {

	public static void main(String[] args) {
		Eclipse obj = new Eclipse();
		obj.start();
		obj.setPriority(Thread.MAX_PRIORITY);//10
		OneNote obj1 = new OneNote();
		obj1.start();
		obj.setPriority(Thread.MIN_PRIORITY);//5
		Chrome obj2 = new Chrome();
		obj2.start();
		obj.setPriority(Thread.NORM_PRIORITY);//1
		


	}

}
