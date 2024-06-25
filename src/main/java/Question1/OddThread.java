package Question1;


import java.util.ArrayList;
import java.util.List;

public class OddThread implements Runnable {
    private final int number;
    private final SharedResource sharedResource;

    OddThread(int number, SharedResource sharedResource) {
        this.number = number;
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        List<Integer> oddNumber = new ArrayList<>();
        for (int i = 1; i <= number; i += 2) {
            oddNumber.add(i);
        }
        System.out.println("oddNumber List: " + oddNumber);
        sharedResource.addOddNumber(oddNumber);
    }
}
