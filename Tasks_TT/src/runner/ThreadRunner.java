package runner;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import exception.CustomException;
import tasks.ExtendedThread;
import tasks.RunnableThread;
import utility.CustomLogFormatter;
import utility.Utility;

public class ThreadRunner {
	private static final Logger logger = Logger.getLogger(ExtendedThread.class.toString());

	public static void setLoggerProps() {
		logger.setLevel(Level.ALL);
		logger.setUseParentHandlers(false);
		ConsoleHandler consoleHandler = new ConsoleHandler();
		consoleHandler.setFormatter(new CustomLogFormatter());
		logger.addHandler(consoleHandler);
	}

	public static void main(String... args) {
		logger.finest("Thread task started...");
		boolean continueProgram = true;
		setLoggerProps();
		try (Scanner sc = new Scanner(System.in)) {
			while (continueProgram) {
				logger.info("\nEnter your choice : ");
				int choice = Utility.getIntInput();
				switch (choice) {
				case 1: {
					try {
						ExtendedThread extendedThread = new ExtendedThread();

						logger.info("\nName : " + extendedThread.getName() + "\n" + "Priority : "
								+ extendedThread.getPriority() + "\n" + "State : " + extendedThread.getState()
								+ "\n\n");

						extendedThread.start();

						logger.info("\nName : " + extendedThread.getName() + "\n" + "Priority : "
								+ extendedThread.getPriority() + "\n" + "State : " + extendedThread.getState()
								+ "\n\n");

						extendedThread.join();

						logger.info("\nName : " + extendedThread.getName() + "\n" + "Priority : "
								+ extendedThread.getPriority() + "\n" + "State : " + extendedThread.getState()
								+ "\n\n");

						logger.info("Final State : " + extendedThread.getState() + "\n");

					} catch (Exception ex) {
						logger.throwing("ThreadRunner", "main", ex);
					}
				}
				case 2: {
					try {
						RunnableThread runnable = new RunnableThread();
						Thread runnableThread = new Thread(runnable, "Runnable Thread 1");

						logger.info("\nName : " + runnableThread.getName() + "\n" + "Priority : "
								+ runnableThread.getPriority() + "\n" + "State : " + runnableThread.getState()
								+ "\n\n");

						runnableThread.start();

						logger.info("\nName : " + runnableThread.getName() + "\n" + "Priority : "
								+ runnableThread.getPriority() + "\n" + "State : " + runnableThread.getState()
								+ "\n\n");

						runnableThread.join();

						logger.info("\nName : " + runnableThread.getName() + "\n" + "Priority : "
								+ runnableThread.getPriority() + "\n" + "State : " + runnableThread.getState()
								+ "\n\n");

						logger.info("Final State : " + runnableThread.getState() + "\n");

					} catch (Exception ex) {
						logger.throwing("ThreadRunner", "main", ex);
					}
				}
				case 3: {
					try {
						ExtendedThread extendedThread = new ExtendedThread("Extended Thread");
						RunnableThread runnable = new RunnableThread();
						Thread runnableThread = new Thread(runnable, "Runnable Thread");

						logger.info("\nName : " + extendedThread.getName() + "\n" + "Priority : "
								+ extendedThread.getPriority() + "\n" + "State : " + extendedThread.getState()
								+ "\n\n");
						logger.info("\nName : " + runnableThread.getName() + "\n" + "Priority : "
								+ runnableThread.getPriority() + "\n" + "State : " + runnableThread.getState()
								+ "\n\n");

						extendedThread.start();
						runnableThread.start();

						logger.info("\nName : " + extendedThread.getName() + "\n" + "Priority : "
								+ extendedThread.getPriority() + "\n" + "State : " + extendedThread.getState()
								+ "\n\n");
						logger.info("\nName : " + runnableThread.getName() + "\n" + "Priority : "
								+ runnableThread.getPriority() + "\n" + "State : " + runnableThread.getState()
								+ "\n\n");

					} catch (Exception e) {
						logger.throwing("ThreadRunner", "main", e);
					}
				}
				case 4: {
					try {
						ExtendedThread extendedThread1 = new ExtendedThread("Extended Thread No.1");
						ExtendedThread extendedThread2 = new ExtendedThread("Extended Thread No.2");
						ExtendedThread extendedThread3 = new ExtendedThread("Extended Thread No.3");
						ExtendedThread extendedThread4 = new ExtendedThread("Extended Thread No.4");
						ExtendedThread extendedThread5 = new ExtendedThread("Extended Thread No.5");

						RunnableThread runnable1 = new RunnableThread();
						Thread runnableThread1 = new Thread(runnable1, "Runnable Thread No.1");

						RunnableThread runnable2 = new RunnableThread();
						Thread runnableThread2 = new Thread(runnable2, "Runnable Thread No.2");

						RunnableThread runnable3 = new RunnableThread();
						Thread runnableThread3 = new Thread(runnable3, "Runnable Thread No.3");

						RunnableThread runnable4 = new RunnableThread();
						Thread runnableThread4 = new Thread(runnable4, "Runnable Thread No.4");

						RunnableThread runnable5 = new RunnableThread();
						Thread runnableThread5 = new Thread(runnable5, "Runnable Thread No.5");

						extendedThread1.start();
						extendedThread2.start();
						extendedThread3.start();
						extendedThread4.start();
						extendedThread5.start();
						runnableThread1.start();
						runnableThread2.start();
						runnableThread3.start();
						runnableThread4.start();
						runnableThread5.start();
					} catch (Exception ex) {
						logger.throwing("ThreadRunner", "main", ex);
					}
				}
				case 5: {
					try {

						ExtendedThread extendedThread1 = new ExtendedThread("Extended Thread No.1", 10000);
						ExtendedThread extendedThread2 = new ExtendedThread("Extended Thread No.2", 11000);
						ExtendedThread extendedThread3 = new ExtendedThread("Extended Thread No.3", 12000);
						ExtendedThread extendedThread4 = new ExtendedThread("Extended Thread No.4", 13000);
						ExtendedThread extendedThread5 = new ExtendedThread("Extended Thread No.5", 14000);

						RunnableThread runnable1 = new RunnableThread(15000);
						Thread runnableThread1 = new Thread(runnable1, "Runnable Thread No.1");

						RunnableThread runnable2 = new RunnableThread(16000);
						Thread runnableThread2 = new Thread(runnable2, "Runnable Thread No.2");

						RunnableThread runnable3 = new RunnableThread(17000);
						Thread runnableThread3 = new Thread(runnable3, "Runnable Thread No.3");

						RunnableThread runnable4 = new RunnableThread(18000);
						Thread runnableThread4 = new Thread(runnable4, "Runnable Thread No.4");

						RunnableThread runnable5 = new RunnableThread(19000);
						Thread runnableThread5 = new Thread(runnable5, "Runnable Thread No.5");

						extendedThread1.start();
						extendedThread2.start();
						extendedThread3.start();
						extendedThread4.start();
						extendedThread5.start();
						runnableThread1.start();
						runnableThread2.start();
						runnableThread3.start();
						runnableThread4.start();
						runnableThread5.start();
					} catch (Exception ex) {
						logger.throwing("ThreadRunner", "main", ex);
					}
				}
				case 6: {
					try {

						ExtendedThread extendedThread1 = new ExtendedThread("Extended Thread No.1", 1000);
						extendedThread1.toggleLoop();
						ExtendedThread extendedThread2 = new ExtendedThread("Extended Thread No.2", 1100);
						extendedThread2.toggleLoop();
						ExtendedThread extendedThread3 = new ExtendedThread("Extended Thread No.3", 1200);
						extendedThread3.toggleLoop();
						ExtendedThread extendedThread4 = new ExtendedThread("Extended Thread No.4", 1300);
						extendedThread4.toggleLoop();
						ExtendedThread extendedThread5 = new ExtendedThread("Extended Thread No.5", 1400);
						extendedThread5.toggleLoop();

						RunnableThread runnable1 = new RunnableThread(1500);
						runnable1.toggleLoop();
						Thread runnableThread1 = new Thread(runnable1, "Runnable Thread No.1");

						RunnableThread runnable2 = new RunnableThread(1600);
						runnable2.toggleLoop();
						Thread runnableThread2 = new Thread(runnable2, "Runnable Thread No.2");

						RunnableThread runnable3 = new RunnableThread(1700);
						runnable3.toggleLoop();
						Thread runnableThread3 = new Thread(runnable3, "Runnable Thread No.3");

						RunnableThread runnable4 = new RunnableThread(1800);
						runnable4.toggleLoop();
						Thread runnableThread4 = new Thread(runnable4, "Runnable Thread No.4");

						RunnableThread runnable5 = new RunnableThread(1900);
						runnable5.toggleLoop();
						Thread runnableThread5 = new Thread(runnable5, "Runnable Thread No.5");

						extendedThread1.start();
						extendedThread2.start();
						extendedThread3.start();
						extendedThread4.start();
						extendedThread5.start();
						runnableThread1.start();
						runnableThread2.start();
						runnableThread3.start();
						runnableThread4.start();
						runnableThread5.start();

						Thread.sleep(5000);
						extendedThread1.toggleLoop();
						logger.info("Toggled..");
						Thread.sleep(5000);
						extendedThread2.toggleLoop();
						logger.info("Toggled..");
						Thread.sleep(5000);
						extendedThread3.toggleLoop();
						logger.info("Toggled..");
						Thread.sleep(5000);
						extendedThread4.toggleLoop();
						logger.info("Toggled..");
						Thread.sleep(5000);
						extendedThread5.toggleLoop();
						logger.info("Toggled..");

						Thread.sleep(10000);
						runnable1.toggleLoop();
						Thread.sleep(3000);
						runnable2.toggleLoop();
						Thread.sleep(3000);
						runnable3.toggleLoop();
						Thread.sleep(3000);
						runnable4.toggleLoop();
						Thread.sleep(3000);
						runnable5.toggleLoop();

					} catch (Exception ex) {
						logger.throwing("ThreadRunner", "main", ex);
					}
				}
				case 7: {
					try {

						ExtendedThread extendedThread1 = new ExtendedThread("Extended Thread No.1", 1000);
						extendedThread1.toggleLoop();
						ExtendedThread extendedThread2 = new ExtendedThread("Extended Thread No.2", 1100);
						extendedThread2.toggleLoop();
						ExtendedThread extendedThread3 = new ExtendedThread("Extended Thread No.3", 1200);
						extendedThread3.toggleLoop();
						ExtendedThread extendedThread4 = new ExtendedThread("Extended Thread No.4", 1300);
						extendedThread4.toggleLoop();
						ExtendedThread extendedThread5 = new ExtendedThread("Extended Thread No.5", 1400);
						extendedThread5.toggleLoop();

						RunnableThread runnable1 = new RunnableThread(1500);
						runnable1.toggleLoop();
						Thread runnableThread1 = new Thread(runnable1, "Runnable Thread No.1");

						RunnableThread runnable2 = new RunnableThread(1600);
						runnable2.toggleLoop();
						Thread runnableThread2 = new Thread(runnable2, "Runnable Thread No.2");

						RunnableThread runnable3 = new RunnableThread(1700);
						runnable3.toggleLoop();
						Thread runnableThread3 = new Thread(runnable3, "Runnable Thread No.3");

						RunnableThread runnable4 = new RunnableThread(1800);
						runnable4.toggleLoop();
						Thread runnableThread4 = new Thread(runnable4, "Runnable Thread No.4");

						RunnableThread runnable5 = new RunnableThread(1900);
						runnable5.toggleLoop();
						Thread runnableThread5 = new Thread(runnable5, "Runnable Thread No.5");

						extendedThread1.start();
						extendedThread2.start();
						extendedThread3.start();
						extendedThread4.start();
						extendedThread5.start();
						runnableThread1.start();
						runnableThread2.start();
						runnableThread3.start();
						runnableThread4.start();
						runnableThread5.start();

						Thread.sleep(5000);
						extendedThread1.toggleLoop();
						logger.info("Toggled..");
						Thread.sleep(5000);
						extendedThread2.toggleLoop();
						logger.info("Toggled..");
						Thread.sleep(5000);
						extendedThread3.toggleLoop();
						logger.info("Toggled..");
						Thread.sleep(5000);
						extendedThread4.toggleLoop();
						logger.info("Toggled..");
						Thread.sleep(5000);
						extendedThread5.toggleLoop();
						logger.info("Toggled..");

						Map<Thread, StackTraceElement[]> stackTraces1 = Thread.getAllStackTraces();

						for (Entry<Thread, StackTraceElement[]> el : stackTraces1.entrySet()) {
							StackTraceElement currStackTraceElement[] = el.getValue();
							for (StackTraceElement element : currStackTraceElement) {
								logger.info(element.toString());
							}
						}

						Thread.sleep(10000);
						runnable1.toggleLoop();
						Thread.sleep(3000);
						runnable2.toggleLoop();
						Thread.sleep(3000);
						runnable3.toggleLoop();
						Thread.sleep(3000);
						runnable4.toggleLoop();
						Thread.sleep(3000);
						runnable5.toggleLoop();
						logger.info("" + extendedThread1.getState() + " :: " + extendedThread1.getName());
						logger.info("" + extendedThread2.getState() + " :: " + extendedThread2.getName());
						logger.info("" + extendedThread3.getState() + " :: " + extendedThread3.getName());
						logger.info("" + extendedThread4.getState() + " :: " + extendedThread4.getName());
						logger.info("" + extendedThread5.getState() + " :: " + extendedThread5.getName());

						logger.info("" + runnableThread1.getState() + " :: " + runnableThread1.getName());
						logger.info("" + runnableThread2.getState() + " :: " + runnableThread2.getName());
						logger.info("" + runnableThread3.getState() + " :: " + runnableThread3.getName());
						logger.info("" + runnableThread4.getState() + " :: " + runnableThread4.getName());
						logger.info("" + runnableThread5.getState() + " :: " + runnableThread5.getName());

						logger.info("Task completed!!!");

						Map<Thread, StackTraceElement[]> stackTraces2 = Thread.getAllStackTraces();

						for (Entry<Thread, StackTraceElement[]> el : stackTraces2.entrySet()) {
							StackTraceElement currStackTraceElement[] = el.getValue();
							for (StackTraceElement element : currStackTraceElement) {
								logger.info(element.toString());
							}
						}

					} catch (Exception e) {
						logger.throwing("ThreadRunner", "main", e);
					}
				}
				case 8:{
					try {
						logger.info("Thread local example : ");
						RunnableThread runnable1 = new RunnableThread();
						Thread runnableThread1 = new Thread(runnable1, "Runnable Thread No.1");

						Thread runnableThread2 = new Thread(runnable1, "Runnable Thread No.2");
						
						runnableThread1.start();
						runnableThread2.start();
						
						Thread.sleep(2000);
						break;
					}
					catch(Exception e) {
						logger.warning(e.getMessage());
					}
				}
				default: {
					continueProgram = false;
					logger.info("Task Completed !!!");
					break;
				}
				}
			}
		} catch (CustomException e) {
			logger.log(Level.SEVERE, "\n", e);
		}

	}
}
