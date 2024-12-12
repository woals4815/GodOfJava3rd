 자바의 신 실행기 

## Volume2/Chapter21 - Generic
    Generic type 기본 규칙

    E: 요소
    K: 키
    T: 타입
    N: 숫자
    V: 값
    S, U, V: 2,3,4번째에 선언된 타입

* 사용하는 이유
  * 타입 안정성
  * 불필요한 타입 캐스팅 줄일 수 있음
  * 코드의 재사용성을 높인다

* wildcard
  * 메소드의 매개 변수로 어떠한 generic type class가 들어갈 때 해당 클래스가 다양한 타입을 지원해야한다면,
* <**? extends 타입**> 를 이용해 wildcard로 사용하는 타입의 범위를 제한할 수 있음
  * 이를 Bounded Wildcards라고 부른다
  * Bounded Wildcard는 값을 할당할 수 없음. 조회용 매개변수로 사용해야만 한다
  * 메소드 선언 시 리턴 타입 앞에 제네릭한 타입을 선언해 주고 그 타입을 매개 변수에서 사용



## Volume2/Chaper22 - Collection

* Collection - interface
  * extends
    * List
      * ArrayList
        * thread unsafe
      * LinkedList
      * Vector(thread safe)
        * Stack
    * Set
      * HashSet
        * LinkedHashSet
      * TreeSet
    * Queue
      * PriorityQueue
  * Map은 별도의 인터페이스를 구현하고 있음
    * HashMap
      * LinkedHashMap
    * TreeMap
    
```java
  public interface Collection<E> extends Iterable<E>
```

| return type | method name, parameter  | description                                  |
|-------------|-------------------------|----------------------------------------------|
| boolean     | add(E e)                | 요소 추가                                        |
| boolean     | addAll(Collection)      | 매개 변수로 넘어온 컬렉션의 모든 요소 추가                     |
| void        | clear()                 | 모든요소 지우기                                     |
| boolean     | contains(Object)        | 매개 변수 객체가 해당 컬렉션에 있는지 확인. 동일한 값이 있으면 true 반환 |
| boolean     | containsAll(Collection) | 매개변소 컬렉션에 있는 요소들과 동일한 값들이 모두 있는 지 확인         |
| boolean     | equals(Object)          | 같은 객체인지 확인                                   |
| int         | hashCode()              | 해시 코드값                                       |  
| boolean     | isEmpty()               |                                              |
| Iterator    | iterator()              |                                              |
| boolean     | remove(Object)          |                                              |
| boolean     | removeAll(Collection)   |                                              |
| boolean     | retainAll(Collection)   | 매개변수로 넘어온 객체들만 컬렉션에 남겨둠                      |
| int         | size()                  | 요소의 개수 리턴                                    |
| Object[]    | toArray()               | 컬렉션에 있는 데이터들을 배열로 복사                         |
| <T> T[]     | toArray(T[])            | 컬렉션에 있는 데이터들을 지정된 타입으로 복사                    |









