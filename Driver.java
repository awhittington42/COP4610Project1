package COP4610;

public class Driver
{
	public static void main(String args[])
	{
		//start with buffer size of 25
		int threadArray[] = new int[25];

		while (true)
		{ 
			System.out.println("Creating new producer and consumer.");
			Producer prodThread = new Producer(threadArray);
			Consumer conThread = new Consumer(threadArray);

			System.out.println("Starting newly created producer & consumer.");
			prodThread.start();
			conThread.start();
		}
	}
}
