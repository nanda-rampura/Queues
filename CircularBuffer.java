package queue;

public class CircularBuffer
{
	private int[] buffer;
	private int writeIndex;
	private int readIndex;
	
	CircularBuffer(int size)
	{
		// Need to allocate one extra slot to
		// differentiate between ifFull and isEmpty
		buffer = new int[size + 1];
		writeIndex = 0;
		readIndex = 0;
	}
	
	public boolean isEmpty()
	{
		return (writeIndex == readIndex) ? true : false;
	}
	
	private int prevReadindexValue()
	{
		return (readIndex - 1 == -1) ? (buffer.length - 1) : (readIndex - 1);
	}
	
	public boolean isFull()
	{
		return (writeIndex == prevReadindexValue()) ? true : false;
	}
	
	public void write(int data)
	{
		if(!isFull())
		{
			buffer[writeIndex++] = data;
			if(writeIndex == buffer.length)
			{
				writeIndex = writeIndex%buffer.length;
			}
		}
		else
		{
			System.out.println("Buffer is Full");
		}
	}
	
	public int read()
	{
		int readElement = 0;
		if(!isEmpty())
		{
			readElement =  buffer[readIndex++];
			if(readIndex == buffer.length)
			{
				readIndex = readIndex%buffer.length;
			}
		}
		else
		{
			System.out.println("Buffer is Empty");
		}
		return readElement;
	}
	
	public void printData()
	{
		System.out.print("Buffer Data: ");
		int i = readIndex;
		while(i != writeIndex)
		{
			System.out.print(buffer[i]+ " ");
			i++; 
			if(i == buffer.length)
			{
				i = 0;
			}
		}
		System.out.println();
		System.out.println();
	}
	
	public int size()
	{
		int count = 0;
		int i = readIndex;
		while(i != writeIndex)
		{
			count++;
			i++; 
			if(i == buffer.length)
			{
				i = 0;
			}
		}
		return count;
	}
}