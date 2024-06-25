package Question1;


import java.util.ArrayList;
import java.util.List;

public class SharedResource {
    private boolean evenTurn = true;
    private final List<Integer> list = new ArrayList<>();

    public synchronized void addOddNumber(List<Integer> oddList) {
        for (Integer num : oddList) {
            while (evenTurn) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            list.add(num);
            evenTurn = true;
            notify();
        }

    }

    public synchronized void addEvenNumber(List<Integer> evenList) {
        for (Integer num : evenList) {
            while (!evenTurn) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            list.add(num);
            evenTurn = false;
            notify();
        }

    }

    public List<Integer> getList() {
        return list;
    }
}