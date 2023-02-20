import Producer.java
import Consumer.java

public static void main(string args)
{
	//start with buffer size of 25
	int threadArray[] = new int[25];

	while (true)
	{
		Producer prodThread = new Producer(threadArray);
		Consumer conThread = new Consumer(threadArray);
		//Need to implement two thread groups, producer and consumer.
	}
}
