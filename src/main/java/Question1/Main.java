package Question1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the input: ");
        int number = scanner.nextInt();
        SharedResource sharedResource = new SharedResource();
        Thread evenThread = new Thread(new EvenThread(number, sharedResource));
        Thread oddThread = new Thread(new OddThread(number, sharedResource));

        evenThread.start();
        oddThread.start();
        try {
            evenThread.join();
            oddThread.join();

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("final List: " + sharedResource.getList());
    }
}



