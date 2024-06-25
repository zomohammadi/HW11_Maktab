package Question1;

import java.util.ArrayList;
import java.util.List;

public class EvenThread implements Runnable {
    private final int number;
    private final SharedResource sharedResource;

    EvenThread(int number, SharedResource sharedResource) {
        this.number = number;
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        List<Integer> evenNumber = new ArrayList<>();
        for (int i = 0; i <= number; i += 2) {
            evenNumber.add(i);
        }
        System.out.println("evenNumber List:" + evenNumber);
        sharedResource.addEvenNumber(evenNumber);
    }
}