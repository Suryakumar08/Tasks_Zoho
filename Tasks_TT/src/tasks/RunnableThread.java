package tasks;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RunnableThread implements Runnable {
	private static final Logger logger = Logger.getLogger(ExtendedThread.class.toString());
	private long sleepTime = 0;
	private volatile boolean continueLoop = false;
	
	public RunnableThread() {
		
	}
	
	public RunnableThread(long sleepTime) {
		sleepTime = Math.abs(sleepTime);
		this.sleepTime = sleepTime;
	}
	
	public void toggleLoop() {
		this.continueLoop = !this.continueLoop;
	}
	
	ThreadLocal<Integer> local = new ThreadLocal<>();
	
	
	
	
	
	@Override
	public void run() {
		try {
			
			Thread currentThread = Thread.currentThread();
			int rand = (int)(Math.random() * 25);
			local.set(rand);
			logger.info("Thread name : " + currentThread.getName() +"\nRandom : " + local.get());
			
			logger.info("\nName(In Runnable Thread) : " + currentThread.getName() + "\nPriority (In Runnable Thread): "
					+ currentThread.getPriority() + "\nState (In Runnable Thread): " + currentThread.getState()
					+ "\n\n");
			logger.info("Before sleeping : " + currentThread.getName());
			Thread.sleep(sleepTime);
			logger.info("After sleeping : " + currentThread.getName());
			
			while(continueLoop) {
				try {
					Thread.sleep(50);
				}
				catch(Exception e) {}
			}
			logger.info("Looping ended..." + currentThread.getName());
			
		} catch (Exception ex) {
			logger.log(Level.SEVERE, "Exception : ", ex);
		}
	}

}
