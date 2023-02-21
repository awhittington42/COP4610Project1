
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
		synchronized (this)
		{
			if (isBufferFull())
			{
				//Buffer is full, producer is waiting.
				printBuffer();
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
				printBuffer();
				System.out.println("Buffer isn't full, producer is producing.");
				produce(this.buffer);
				notifyAll();
			}
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
		System.out.print("After producing, ");
	}

	synchronized public void printBuffer()
	{
		System.out.println("Buffer: ");
		for (int x = 0; x < this.buffer.length; x++)
		{
			System.out.print((x+1) + ": " + this.buffer[x] + ", ");
		}
	}

	public boolean isBufferFull()
	{
		for(int x = 0; x < this.buffer.length; x++)
		{
			if (this.buffer[x] == 0)
				return false;
		}
		return true;
	}
}
