package Question3;

public class main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(
                () -> {
                    System.out.println("High Thread1 " + Thread.currentThread().getName() + " start");
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("High Thread1 " + Thread.currentThread().getName() + " end");

                }
        );
        Thread thread2 = new Thread(
                () -> {
                    System.out.println("High Thread2 " + Thread.currentThread().getName() + " start");
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("High Thread2 " + Thread.currentThread().getName() + " end");

                }
        );
        Thread thread3 = new Thread(
                () -> {
                    System.out.println("low Thread3 " + Thread.currentThread().getName() + " start");
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("low Thread3 " + Thread.currentThread().getName() + " end");

                }
        );
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);

        thread3.setPriority(Thread.MIN_PRIORITY);

        thread3.start();
        thread1.start();
        thread2.start();
    }
}
