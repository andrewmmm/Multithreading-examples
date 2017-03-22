import java.util.Queue;

public class ConsumerRunnable implements Runnable {
	public Queue<Integer> Buffer;
	public int itemCount;
	public int size;
	
	public ConsumerRunnable(Queue<Integer> Buffer, int size) {
		this.Buffer = Buffer;
		this.size = size;
	}
	
	public void run() {
		while(true) {
			try {
				System.out.println("Consumed");
				Consume();
                Thread.sleep(50);
			}
			catch(InterruptedException ex) {
				System.out.println(ex);
			}
		}	
	}

	public void Consume() throws InterruptedException {
		while(Buffer.isEmpty()) {
			System.out.println("Queue is empty so" + Thread.currentThread().getName() + " is waiting" );
			Buffer.wait();
		}
		
		synchronized (Buffer) {
			Buffer.remove();
		}
		
		
	}
	
}
