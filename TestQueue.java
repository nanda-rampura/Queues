package queue;
import queue.Queue.QueueEmptyException;
import queue.Queue.QueueFullException;

public class TestQueue {

	public static void main(String[] args)
	{
		System.out.println("Creating queue of capacity = 4:");
		Queue q = new Queue(4);
		System.out.println(q.isEmpty() == true ? "Queue is empty" : "Queue is not empty");
		System.out.println(q.isFull() == true ? "Queue is full" : "Queue is not full");
		System.out.println("Queue size is " + q.getSize());
		System.out.println();
		
		System.out.println("Trying to dequeue empty queue:");
		try {
			q.deQueue();
			System.out.println("Error: Queue empty was expected");
		} catch (QueueEmptyException e) {
			System.out.println("Queue is empty, as expected");
		}
		System.out.println();

		System.out.println("Queuing 10, 20, 30, and 40:");
		try {
			q.enQueue(10);
			q.enQueue(20);
			q.enQueue(30);
			q.enQueue(40);
			System.out.println(q.isEmpty() == true ? "Queue is empty" : "Queue is not empty");
			System.out.println(q.isFull() == true ? "Queue is full" : "Queue is not full");
			System.out.println("Queue size is " + q.getSize());
			q.printData();
		} catch (QueueFullException e) {
			e.printStackTrace();
		}

		System.out.println("Trying to add beyond capacity:");
		try {
			q.enQueue(50);
			System.out.println("Error: Queue full was expected");
		} catch (QueueFullException e) {
			System.out.println("Queue is full, as expected");
			System.out.println();
		}

		try {
			System.out.println("Peeking front of queue:");
			System.out.println("Value at front of queue: " + q.front());
			System.out.println("Getting front of queue:");
			System.out.println("Value at front of queue: " + q.deQueue());
			q.printData();
		} catch (QueueEmptyException e) {
			e.printStackTrace();
		}
		
		System.out.println("Dequeuing remaining elements:");
		try {
			q.deQueue();
			q.deQueue();
			q.deQueue();
		} catch (QueueEmptyException e) {
			e.printStackTrace();
		}
		
		System.out.println(q.isEmpty() == true ? "Queue is empty" : "Queue is not empty");
		System.out.println(q.isFull() == true ? "Queue is full" : "Queue is not full");
		System.out.println("Queue size is " + q.getSize());
	}
}