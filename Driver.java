
public class Driver
{
	public static void main(String args[])
	{
		//start with buffer size of 25
		int threadArray[] = new int[25];
		int threadCtr = 0;

		while (threadCtr < 50) //threadCtr++ != 10)
		{ 
			System.out.println("Creating new producer and consumer.");
			Producer prodThread = new Producer(threadArray);
			Consumer conThread = new Consumer(threadArray);

			System.out.println("Starting newly created producer & consumer.");
			prodThread.start();
			conThread.start();
		}

		System.exit(0);
	}
}
