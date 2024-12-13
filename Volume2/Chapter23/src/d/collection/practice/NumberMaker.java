package d.collection.practice;

import java.util.Hashtable;
import java.util.Random;
import java.util.Set;

public class NumberMaker {
    private final int DATA_BOUNDARY = 50;
    Hashtable<Integer, Integer> hashtable = new Hashtable<Integer, Integer>();

    public static void main(String[] args) {
        NumberMaker numberMaker = new NumberMaker();
        numberMaker.getRandomNumberStatistics();
    }
    public void getRandomNumberStatistics() {
        for(int i=0; i < 5000; i+=1) {
            /***
             * nextInt(int bound)
             * return 0<=value < bound;
             */
            int random = new Random().nextInt(DATA_BOUNDARY) + 1;
            putCurrentNumber(random);
        }

        Set<Integer> keys = hashtable.keySet();

        for(Integer key : keys) {
            if (key % 10 -1 == 0) {
                System.out.println("\n");
            }
            System.out.println(key + "=" + hashtable.get(key));
        }
    }
    public void putCurrentNumber(int tempNumber) {
        Integer count = hashtable.get(tempNumber);

        if (count == null) {
            hashtable.put(tempNumber, 1);
            return;
        }
        hashtable.put(tempNumber, count + 1);

    }
}
