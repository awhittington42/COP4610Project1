package COP4610;

public class Producer extends Thread
{
	int buffer[];
	Producer(int buffer[])
	{
		this.buffer = buffer;
	}

	@Override
	public void run()
	{
		if (isBufferFull())
		{
			//Buffer is full, producer is waiting.
			System.out.println("Buffer is full, producer is waiting.");
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
			//buffer isn't full, produce.
			System.out.println("Buffer isn't full, producer is producing.");
			produce(buffer);
			notifyAll();
		}
	}
	//removed the "synchronized" keyword from produce method.
	public void produce(int buffer[])
	{
		for (int x = 0; x < buffer.length; x++)
		{
			if(buffer[x] == 0)
				buffer[x] = x + 1;
		}
	}

	public boolean isBufferFull()
	{
		for(int x = 0; x < buffer.length; x++)
		{
			if (buffer[x] == 0)
				return false;
		}
		return true;
	}
}
