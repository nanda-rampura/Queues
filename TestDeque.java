package queue;

public class TestDeque {

	public static void main(String[] args)
	{
		System.out.println("Creating double-ended queue (Deque) of capacity = 4:");
		Deque deque = new Deque(4);
		System.out.println(deque.isEmpty() == true ? "Deque is empty" : "Deque is not empty");
		System.out.println(deque.isFull() == true ? "Deque is full" : "Deque is not full");
		System.out.println("Deque size is " + deque.size());
		System.out.println();
		
		System.out.println("Trying to read front of empty Deque:");
		deque.deleteFront();
		System.out.println("Trying to read rear of empty Deque:");
		deque.deleteRear();
		System.out.println();

		System.out.println("Adding 10, 20, 30, and 40:");
		deque.addFront(20);
		deque.addRear(30);
		deque.addRear(40);
		deque.addFront(10);
		System.out.println(deque.isEmpty() == true ? "Deque is empty" : "Deque is not empty");
		System.out.println(deque.isFull() == true ? "Deque is full" : "Deque is not full");
		System.out.println("Deque size is " + deque.size());
		deque.printDataFrontToBack();
		
		System.out.println("Trying to add at front, beyond capacity:");
		deque.addFront(50);
		System.out.println("Trying to add at rear, beyond capacity:");
		deque.addRear(50);
		System.out.println();

		System.out.println("Getting front of deque:");
		System.out.println("Value at front of deque: " + deque.deleteFront());
		System.out.println("Deque size is " + deque.size());
		System.out.println("Getting rear of deque:");
		System.out.println("Value at rear of deque: " + deque.deleteRear());
		System.out.println("Deque size is " + deque.size());
		deque.printDataFrontToBack();
		
		System.out.println("Dequeuing remaining elements:");
		deque.deleteFront();
		deque.deleteRear();

		System.out.println(deque.isEmpty() == true ? "Deque is empty" : "Deque is not empty");
		System.out.println(deque.isFull() == true ? "Deque is full" : "Deque is not full");
		System.out.println("Deque size is " + deque.size());
	}
}