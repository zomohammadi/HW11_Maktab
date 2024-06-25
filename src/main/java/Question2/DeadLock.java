package Question2;


public class DeadLock {
    public static void main(String[] args) {

        Resource resource1 = new Resource("first");
        Resource resource2 = new Resource("second");
        Thread thread1 = new Thread(new MyThread(resource1, resource2), "Thread1");
        Thread thread2 = new Thread(new MyThread(resource2, resource1), "Thread2");
        thread1.start();
        thread2.start();

    }
}

