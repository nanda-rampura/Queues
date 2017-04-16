package queue;

public class Deque 
{
	private int[] buffer;
	private int frontIndex;
	private int rearIndex;
	private int capacity;
	private int size;
	
	Deque(int size)
	{
		// Need to allocate one extra slot to
		// differentiate between ifFull and isEmpty
		capacity = size + 1;
		buffer = new int[capacity];
		frontIndex = 0;
		rearIndex = 1;
		size = 0;
	}

	public void addFront(int data)
	{
		if(!isFull())
		{
			buffer[frontIndex--] = data;
			size++;
			if(frontIndex == -1)
			{
				frontIndex = capacity - 1;
			}
		}
		else
		{
			System.out.println("Deque is full");
		}
	}
	
	public void addRear(int data)
	{
		if(!isFull())
		{
			buffer[rearIndex++] = data;
			size++;
			if(rearIndex == capacity)
			{
				rearIndex = 0;
			}
		}
		else
		{
			System.out.println("Deque is full");
		}
	}
	
	public int deleteFront()
	{
		int deletedElement = 0;
		if(!isEmpty())
		{
			++frontIndex;
			if(frontIndex == capacity)
			{
				frontIndex = 0;
			}
			deletedElement = buffer[frontIndex];
			size--;
		}
		else
		{
			System.out.println("Deque is empty");
		}
		return deletedElement;
	}
	
	public int deleteRear()
	{
		int deletedElement = 0;
		if(!isEmpty())
		{
			rearIndex--;
			if(rearIndex == -1)
			{
				rearIndex = capacity -1;
			}
			deletedElement = buffer[rearIndex];
			size--;
		}
		else
		{
			System.out.println("Deque is empty");
		}
		return deletedElement;
	}
	
	public void printDataFrontToBack()
	{
		if (isEmpty())
		{
			return;
		}
		
		System.out.println("Deque Data: ");
		int printIndex = frontIndex;
		do
		{
			printIndex = (printIndex + 1) % capacity;
			System.out.print(buffer[printIndex] + " ");
		} while ((printIndex + 1) % capacity != rearIndex);
		System.out.println();
		System.out.println();
	}
	
	public boolean isFull()
	{
		return (frontIndex == rearIndex) ? true : false;		
	}
	
	public boolean isEmpty()
	{
		if (rearIndex == 0)
		{
			return (frontIndex == capacity - 1) ? true : false;
		}
		else
		{
			return (frontIndex == rearIndex - 1) ? true : false;
		}
	}
	
	public int size()
	{
		return size;
	}
}