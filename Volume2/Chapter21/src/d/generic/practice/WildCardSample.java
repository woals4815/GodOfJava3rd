package d.generic.practice;

public class WildCardSample {
    public static void main(String[] args) {
        WildCardSample sample = new WildCardSample();
        sample.callWildcardMethod();
    }
    public void callWildcardMethod() {
        WildCardGeneric<String> wildCardGeneric = new WildCardGeneric<String>();
        wildCardGeneric.setWildcard("hihi");
        wildcardStringMethod(wildCardGeneric);

        /**
         * 하단은 컴파일 에러
         */
        WildCardGeneric<?> wildCardGeneric1 = new WildCardGeneric<String>();
//        wildCardGeneric1.setWildcard("asdf");
        WildCardGeneric<Car> wildCardGeneric2 = new WildCardGeneric<Car>();
        wildCardGeneric2.setWildcard(new Car("mustang"));
        boundedWildcardMethod(wildCardGeneric2);
    }

    /**
     *
     * @param c
     * wildcard 를 사용해서 다양한 타입의 WildCardGeneric class를 가질 수 있게 함
     */
    public void wildcardStringMethod(WildCardGeneric<?> c) {
        c.getWildcard();
    }

    public void boundedWildcardMethod(WildCardGeneric<? extends Car> c) {
        Car value = c.getWildcard();
        System.out.println(value);
    }

    /***
     *
     * @param cardGeneric
     * @param value
     * @param <T> -> 이건 리턴 타입이 아니다.
     */
    public <T> void genericMethod(WildCardGeneric<T> cardGeneric, T value) {
        cardGeneric.setWildcard(value);
    }
}


class WildCardGeneric<W> {
    W wildcard;

    public void setWildcard(W wildcard) {
        this.wildcard = wildcard;
    }

    public W getWildcard() {
        return wildcard;
    }
}

class Car {
    protected String brand;
    public Car(String brand) {
        this.brand = brand;
    }
    public String getBrand() {
        return brand;
    }
}

class Bus extends Car {
    public Bus(String brand) {
        super(brand);
    }
    public String toString() {
        return "bus brand " + brand;
    }
}

