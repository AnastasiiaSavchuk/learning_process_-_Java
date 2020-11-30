package thread;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Fibonacci usual order!");
        MyThread thread = new MyThread();
        thread.start();
        thread.join();
        System.out.println("\nFibonacci to reverse :");
        RunnableTread runnableTread = new RunnableTread();
        runnableTread.run();
    }
}
