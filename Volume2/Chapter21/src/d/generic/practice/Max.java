package d.generic.practice;

public class Max {
    public static void main(String[] args) {
        Max sample = new Max();
        sample.testGetMax();
    }

    public void testGetMax() {
        System.out.println(getMax(1,2,3));
        System.out.println(getMax("1","2","3"));
    }

    <T extends Comparable> T getMax(T... objs) {
        T max = objs[0];
        for (int i = 0; i < objs.length; i++) {
            if (objs[i].compareTo(max) > 0) {
                max = objs[i];
            }
        }
        return max;
    }
}
