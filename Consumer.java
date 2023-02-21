
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
		synchronized (this)
		{
			if (isBufferEmpty())
			{
				//buffer is empty, need to wait
				printBuffer();
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
				printBuffer();
				System.out.println("Buffer isn't empty, consumer is consuming");
				consume(this.buffer);
				notifyAll();
			}
		}
	}

	synchronized public void printBuffer()
	{
		System.out.println("Buffer: ");
		for (int x = 0; x < this.buffer.length; x++)
		{
			System.out.print((x+1) + ": " + this.buffer[x] + ", ");
		}
	}

	public boolean isBufferEmpty()
	{
		for(int x = 0; x < this.buffer.length; x++)
		{
			if (this.buffer[x] != 0)
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
			if (buffer[x] != 0)
				buffer[x] = 0;
		}
		System.out.print("After consuming, ");
	}

}
