package Question2;


class MyThread implements Runnable {
    private final Resource resource1;
    private final Resource resource2;

    public MyThread(Resource resource1, Resource resource2) {
        this.resource1 = resource1;
        this.resource2 = resource2;
    }

    @Override
    public void run() {
        synchronized (resource1) {
            System.out.println(Thread.currentThread().getName() + " acquired lock on " + resource1.name());
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            synchronized (resource2) {
                System.out.println(Thread.currentThread().getName() + " acquired lock on " + resource2.name());
            }
        }
    }
}