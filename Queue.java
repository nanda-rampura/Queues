package queue;

public class Queue
{
	private int[] queueData;
	private int rearIndex;
	private int frontIndex;
	private int size;
	
	public int getSize() {
		return size;
	}

	public Queue(int size)
	{
		queueData = new int[size];
		rearIndex = -1;
		frontIndex = 0;
		size = 0;
	}
	
	public boolean isFull() //O(1)
	{
		if(rearIndex >= queueData.length - 1)
		{
			if(isPartiallyFull())
			{
				return  false;
			}
			else
			{
				return true;
			}
		}
		else
		{
			return false;
		}		
	}
	
	private boolean isPartiallyFull() //O(n)
	{
		if(frontIndex == 0)
		{			
			return false;
		}
		else
		{
			int partialIndex = frontIndex;
			for(int i = 0; i < queueData.length; i++)
			{
				queueData[i] = queueData[partialIndex];
				partialIndex++;
				if(partialIndex > rearIndex)
				{
					rearIndex = i;
					frontIndex = 0;
					break;
				}
			}
			return true;
		}		
	}
	
	public boolean isEmpty() //O(1)
	{
		if(frontIndex > rearIndex)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void enQueue(int data) throws QueueFullException
	{
		if(!isFull())
		{
			queueData[++rearIndex] = data;
			size++;
		}
		else
		{
			throw new QueueFullException();
		}
	}
	
	public int front() //O(1)
	{
		int frontElem = 0;
		if(!isEmpty())
		{
			frontElem = queueData[frontIndex];
		}
		return frontElem;
	}
	
	public int deQueue() throws QueueEmptyException //O(1)
	{
		int ouputElem = 0;
		if(!isEmpty())
		{
			ouputElem = queueData[frontIndex++];
			if(frontIndex > rearIndex)
			{
				frontIndex = 0;
				rearIndex = -1;
			}
			size--;
		}
		else
		{
			throw new QueueEmptyException();
		}
		
		return ouputElem;
	}
	
	public void printData() //O(n)
	{	
		System.out.print("Queue Elements: ");
		for(int i = frontIndex; i <= rearIndex; i++)
		{
			System.out.print(queueData[i]+ " ");
		}
		System.out.println();
		System.out.println();
	}
	
	public class QueueEmptyException extends Exception
	{
		public String toString()
		{
			return "QueueEmptyException";
		}
	}
	
	public class QueueFullException extends Exception
	{
		public String toString()
		{
			return "QueueFullException";
		}
	}
}