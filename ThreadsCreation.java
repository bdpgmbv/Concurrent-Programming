
// Threads Creation - Part 1, Thread Capabilities & Debugging.

public class Threads {
	public static void main(String[] args) throws InterruptedException {
		/*
		 * 1. In order to create a new thread, we need to create a new thread object.
		 * The Thread object itself is itself empty by default, so we need to pass the object of the class that implements the Runnable interface, into its constructor.
		 */
		 
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				/*
				 * 2. Whatever code we write inside this run() method, is going to be run on that new thread,
				 * as soon as it's scheduled by the operating system.
				 */
				System.out.println("We are now in thread " + Thread.currentThread().getName());
				System.out.println("Current Thread priority is " +  Thread.currentThread().getPriority());
			}
		});
		
		/*
		 * 6. We saw from output 1 that JVM gave our new thread a pretty unhelpful name "thread-0"
		 * To set the threads name
		 */
		thread.setName("New worker thread");
		
		/*
		 * 7. Thread Scheduling - how the operating system maintains the dynamic priority for each thread.
		 * In more complex programs, where some threads need more responsiveness than the others, This will play an important role.
		 */
		thread.setPriority(Thread.MAX_PRIORITY );
		
		
		/*
		 * 4. Useful methods of Thread class
		 */
		System.out.println("We are in Thread: " + Thread.currentThread().getName() + " before starting the new Thread");
		
		/*
		 * 3. To start a new thread, just creating the thread object is not enough,
		 * we need to actually start the thread by calling the start method on the thread object.
		 * This will instruct the JVM to create a new thread and pass it to the Operating System.
		 */
		thread.start();
		
		System.out.println("We are in Thread: " + Thread.currentThread().getName() + " before starting the new Thread");
		
		
		/*
		 * 5. The thread sleep method, instructs the Operating System to not Schedule the current thread until that time passes.
		 * During that time, this thread is not consuming any CPU.
		 */
		
		Thread.sleep(10000);
	}
}


/*
 * OUTPUT 1
 * We are in Thread: main before starting the new Thread
 * We are in Thread: main before starting the new Thread
 * We are now in thread Thread-0
 */

/*
 * OUTPUT 2
 * We are in Thread: main before starting the new Thread
 * We are in Thread: main before starting the new Thread
 * We are now in thread New worker thread
 */

/*
 * OUTPUT 3
 * We are in Thread: main before starting the new Thread
 * We are in Thread: main before starting the new Thread
 * We are now in thread New worker thread
 * Current Thread priority is 10
 */
