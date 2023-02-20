class Producer extends Thread
{
	int buffer[];
	Producer(int buffer[])
	{
		this.buffer = buffer;
	}

	@Override
	public void run()
	{
		produce(buffer);
	}

	synchronized public void produce(int buffer[])
	{
		for (int x = 0; x < buffer.length; x++)
		{
			buffer[x] = x + 1;
		}
	}
}
