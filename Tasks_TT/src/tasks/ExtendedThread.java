package tasks;

import java.util.logging.Level;
import java.util.logging.Logger;

import exception.CustomException;
import validators.Validators;

public class ExtendedThread extends Thread{
	private static final Logger logger = Logger.getLogger(ExtendedThread.class.toString());
	private long sleepTime = 0;
	private volatile boolean continueLoop = false;
	
	public ExtendedThread() {
		
	}
	
	public void toggleLoop() {
		this.continueLoop = !this.continueLoop;
	}
	
	public ExtendedThread(String name) throws CustomException{
		Validators.validateInput(name);
		this.setName(name);
	}
	
	public ExtendedThread(String name, long sleepTime) throws CustomException{
		Validators.validateInput(name);
		sleepTime = Math.abs(sleepTime);
		this.setName(name);
		this.sleepTime = sleepTime;
	}
	
	public void run(){
		try {			
			logger.info("\nName(In Extended Thread) : " + this.getName() + "\nPriority (In Extended Thread): " + this.getPriority() + "\nState (In Extended Thread): " + this.getState()+ "\n\n");
			logger.info("Before Sleeping : " + this.getName());
			sleep(sleepTime);
			logger.info("After sleeping : " + this.getName());
			while(continueLoop) {
				try {
					Thread.sleep(50);
				}
				catch(Exception e) {}
			}
			logger.info("Looping ended... " + this.getName());
		}
		catch(Exception ex) {
			logger.log(Level.SEVERE, "Exception : ", ex);
		}
	}
}
