package lambdas;

/**
 * Demonstrates lambda expressions with Runnable.
 * Creates and executes a thread using a lambda expression instead of anonymous class.
 */
public class Demo1 {
    
    public static void main(String[] args) {
        // Lambda expression: implements Runnable with no parameters
        // Simpler and cleaner than anonymous inner class syntax
        Runnable printNumbers = () -> {
            String threadName = Thread.currentThread().getName();
            for (int i = 0; i <= 10; i++) {
                System.out.println(threadName + " : " + i);
            }
        };
        
        Thread thread1 = new Thread(printNumbers, "PrintThread");
        thread1.start();
    }
}
