import java.util.Queue;
import java.util.Random;

public class ProducerRunnable implements Runnable {
	public Queue<Integer> Buffer;
	public int size;
	public Random rand;
	
	public ProducerRunnable(Queue<Integer> _Buffer, int size) {
		this.rand = new Random();
		this.Buffer = _Buffer;
		this.size = size;       			
	}
	
	public void run() {
		while (Buffer.size() == size) {
			try {
				System.out.println("Produce");
				Produce();
                Thread.sleep(50);
			}
			catch(InterruptedException ex) {
				System.out.println(ex);
			}
			
			
		}
	}
	
	public void Produce() throws InterruptedException {
		while (Buffer.size() == size) {
			
			System.out.println("Queue is empty so" + Thread.currentThread().getName() + " is waiting" );
		}
		
		synchronized (Buffer) {
			int item = produceItem();
			Buffer.add(item);
		}
		
		
	}
	
	
	public int produceItem() {              //grab item from buffer
		return rand.nextInt();
	}
}
