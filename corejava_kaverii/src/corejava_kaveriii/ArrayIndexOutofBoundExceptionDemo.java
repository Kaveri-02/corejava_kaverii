package corejava_kaveriii;

public class ArrayIndexOutofBoundExceptionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]=new int[4]; //1 2 3 4 start=0, end=3
		
		try {
		int i=arr[6];
		System.out.println(i);

		}
		catch(Exception e){
			System.out.println(e);
		}

}
}
