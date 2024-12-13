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


## Volume2/chaper23 - Set과 Queue
    HashSet: 순서X, 해시 태ㅔ이블에 저장.
    TreeSet: 저장된 데이터의 값에 따라 정렬됨.
    LinkedHashSet: 연결된 목록 타입으로 해시테이블에 저장


| 생성자                               | 설명                                            |
|-----------------------------------|-----------------------------------------------|
| HashSet()                         | 16개 공간과 0.75의 로드팩터를 갖는 객체 생성                  |
| HasSet(Collection<? extends E> c) | 매개변수로 받은 컬랙션 객체의 데이터를 HashSet에 담는다            |
| HashSet(int initialCapacity)      | 매개변수로 받은 개수만큼의 데이터 저장공간과 0.75의 로드팩터를 갖는 객체 생성 |
| HashSet(int i, float l)           | 상동                                            |

* 로드팩터: (데이터개수)/(저장공간) -> 로드팩터보다 커지면 저장공간 크기가 증가되고 재정리 작업을 해야 한다.

## Volume2/chapter24 - Map

| return type          | method name, parameter                | desc                            |
|----------------------|---------------------------------------|---------------------------------|
| V                    | put(K key, V value)                   | 데이터 저장                          |
| void                 | putAll(Map<? extends K, ? extends V>) | Map의 모든 데이터를 저장                 |
| V                    | get(Object key)                       | 매개 변수로 넘어온 키에 해당하는 값 return     |
| V                    | remove(Object key)                    | key에 해당하는 값 삭제                  |
| Set<K>               | keySet()                              | key들의 집합을 Set type으로 return     |
| Collection<V>        | values()                              | 값의 목록을 Colleciton type으로 return |
| Set<Map.Entry<K, V>> | entrySet()                            | Map안에 Entry라는 타입의 Set을 return   |
| int                  | size()                                | Map의 크기 return                  |
| void                 | clear()                               | 모든 요소 삭제                        |

* HashMap
* TreeMap
* LinkedHashMap
* HashTable
  * Map interface 구현했지만 일반적인 Map 인터페이스를 구현한 클래스들과 다름
    * Map은 컬렉션 뷰를 사용하지만 HashTable은 Enumeration 객체를 통해서 데이터 처리
      * Enumeration객체는 Iterator의 단순한 버전
    * Map은 키, 값, 키-값 쌍으로 데이터를 순환하여 처리 가능. hashtable은 키-값으로 데이터 순환
    * Map은 interation을 처리하는 도중에 데이터를 삭제하는 안전한 방법을 제공하지만 hashtable은 X

| 기능               | HashMap | HashTable |
|------------------|---------|-----------|
| 키나 값에 null 저장 가능 | O       | X         |
| 여러 쓰레드 안전여부      | X       | O         |







