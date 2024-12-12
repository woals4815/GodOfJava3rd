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
        wildCardGeneric1.setWildcard("asdf");
    }

    /**
     *
     * @param c
     * wildcard 를 사용해서 다양한 타입의 WildCardGeneric class를 가질 수 있게 함
     */
    public void wildcardStringMethod(WildCardGeneric<?> c) {
        c.getWildcard();
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