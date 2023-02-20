class Consumer extends Thread
{
	int buffer[];
	boolean consumable = false;

	Consumer(int buffer[])
	{
		this.buffer = buffer;
	}

	@Override
	public void run()
	{
		if (consumable)
		{
			//buffer is empty, need to wait
			System.out.println("Buffer is empty, consumer is waiting.");
			wait();
		}
		else
		{
			//buffer isn't empty, consume.
			System.out.println("Buffer full
			consume(buffer);
			notifyAll();
		}
	}

	synchronized public void consume(int buffer[])
	{
		for (int x = 0; x < buffer.length; x++)
		{
			if (buffer[x] != 0)
				this.consumable = true;
			else
				this.consumable = false;

			if (this.consumable)
				buffer[x] = 0;
		}
	}

}
