package queue;

public class TestCircularBuffer {

	public static void main(String[] args)
	{
		System.out.println("Creating circular buffer of capacity = 4:");
		CircularBuffer buffer = new CircularBuffer(4);
		System.out.println(buffer.isEmpty() == true ? "Buffer is empty" : "Buffer is not empty");
		System.out.println(buffer.isFull() == true ? "Buffer is full" : "Buffer is not full");
		System.out.println("Buffer size is " + buffer.size());
		System.out.println();
		
		System.out.println("Trying to read from empty buffer:");
		buffer.read();
		System.out.println();
		
		System.out.println("Adding 10, 20, 30, and 40:");
		buffer.write(10);
		buffer.write(20);
		buffer.write(30);
		buffer.write(40);
		System.out.println(buffer.isEmpty() == true ? "Buffer is empty" : "Buffer is not empty");
		System.out.println(buffer.isFull() == true ? "Buffer is full" : "Buffer is not full");
		System.out.println("Buffer size is " + buffer.size());
		buffer.printData();

		System.out.println("Trying to add beyond capacity:");
		buffer.write(50);
		System.out.println();

		System.out.println("Getting front of buffer:");
		System.out.println("Value at front of buffer: " + buffer.read());
		buffer.printData();

		System.out.println("Reading remaining elements:");
		buffer.read();
		buffer.read();
		buffer.read();
		
		System.out.println(buffer.isEmpty() == true ? "Buffer is empty" : "Buffer is not empty");
		System.out.println(buffer.isFull() == true ? "Buffer is full" : "Buffer is not full");
		System.out.println("Buffer size is " + buffer.size());
	}
}