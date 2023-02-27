package lambdas;

public class Demo1 {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        };
        Thread thread1 = new Thread(runnable);
        thread1.start();
    }
}
