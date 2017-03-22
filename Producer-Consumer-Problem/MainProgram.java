import java.util.Queue;

public class MainProgram {
	public static final int SIZE = 8;
	
	public static Queue<Integer> Buffer;   //Producer-Consumer Buffer
	
	
	public static void main(String[] args) {
		
		Thread producerThread = new Thread(new ConsumerRunnable(Buffer, SIZE));
		Thread consumerThread = new Thread(new ProducerRunnable(Buffer, SIZE));
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
