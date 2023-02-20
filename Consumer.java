package COP4610;

public class Consumer extends Thread
{
	int buffer[];

	Consumer(int buffer[])
	{
		this.buffer = buffer;
	}

	@Override
	public void run()
	{
		if (isBufferEmpty())
		{
			//buffer is empty, need to wait
			System.out.println("Buffer is empty, consumer is waiting.");
			try
			{
				wait();
			}
			catch(InterruptedException e)
			{
				System.out.println("Error - Interrupted Exception.");
				e.printStackTrace();
			}
		}
		else
		{
			//buffer isn't empty, consume.
			System.out.println("Buffer isn't empty, consumer is consuming");
			consume(buffer);
			notifyAll();
		}
	}

	public boolean isBufferEmpty()
	{
		for(int x = 0; x < buffer.length; x++)
		{
			if (buffer[x] == 1)
				return false;
		}
		//no 1's found, buffer is empty.
		return true;
	}
	//commented out the "synchronized" keyword in the consume method
	public void consume(int buffer[])
	{
		for (int x = 0; x < buffer.length; x++)
		{
			if (buffer[x] == 1)
				buffer[x] = 0;
		}
	}

}
