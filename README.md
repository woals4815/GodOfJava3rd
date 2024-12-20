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


## Volume2/chapter25 - Thread


* Runnable interface, Thread class
  * Thread class는 Runnale을 구현한 클래스

| return | method name,parameter | desc               |
|--------|-----------------------|--------------------|
| void   | run()                 | 쓰레드가 시작되면 수행되는 메소드 |

스레드를 시작하는 방법은 두가지가 있다.
```java
/**
 RunnableSample은 Runnable interface 구현체
 */
RunnableSample runnable = new RunnableSample();
new Thread(runnable).start();

ThreadSample thread = new ThreadSample();
thread.start();
```
두 가지 방법을 제공하는 이유는 class는 다중상속이 되지 않는다. 그래서 만약 어떤 클래스가 다른 클래스를 상속받아야 하는데 해당 부모 클래스가 Thread를 상속받고 있지 않는다면 전자와 같이 실행할 수 있다.

* DaemonThread
  * Thread 클래스에는 setDaemon이라는 메소드
  * Daemon Thread는 start 메소드가 호출되기 전에 지정해줘야 함.
  * Daemon Thread는 사용자 쓰레드가 실행되고 있지 않으면 JVM이 끝난다.
  * 이러한 용도는 부가적인 작업이 필요할 때(다른 쓰레드 모니터링 등)에 사용됨


* Synchronized
  * 같은 자원(하나의 객체)에 접근하는 스레드들의 작업들을 동기화 시키는 역할을 한다
  * 접근 제어자 옆에 작성 가능
  * 다만 메소드 전체에 synchronized를 추가한다면 성능 문제 발생

```java
  public void plus(int value) {
    synchronized (this) {
      amount += value;
    }
  }
```

위와 같은 형식으로 작성하여 중괄호 내에 연산만 동시 처리를 하지 않겠다고 명시한다.
synchronized 매개변수로는 this를 넣어도 되지만 이는 lock 역할을 하는 object를 넣는 것이 일반적
```java
  Object amountLock = new Object();
  Object interestLock = new Object();
  public void addInterest(int interset) {
    synchronized (interestLock) {
        this.interest +=interset;
    }
  }
  public void addAmount(int amount) {
    synchronized (amountLock) {
      this.amount += amount;
    }
  }

```

* Thread를 통제하는 메소드

| return       | method, parameter            | desc                            |
|--------------|------------------------------|---------------------------------|
| Thread.State | getState()                   | check thread states             |
| void         | join()                       | wait until sub thread terminate |
| void         | join(long millis)            | wait until millis amount        |
| void         | join(long millis, int nanos) | wailt until millis + nanos      |
| void         | interrupt()                  | 수행중인 쓰레드에 중지 요청                 |

* ThreadGroup
  * 쓰레드의 관리를 용이하게 하기 위한 클래스

## I/O
    Stream - byte 기반 데이터 처리
    char기반 문자열 처리 Reader / Writer
    jdk 1.4부터는 New I/O 인 NIO -> Buffer & Channel

* File과 Files
  * NIO -> Files, java.io -> File
  * Files는 static 메소드를 제공해서 File 객체 생성 필요 없음

* InputStream, OutputStream
  * abtract class를 통해서 제공됨.

```java
import java.io.Closeable;

public abstract class InputStream extends Object implements Closeable;
```
* 어떤 리소스를 열었던 간, close method를 이용해 닫아야 한다는 것을 의미

| return type  | method, parameter                | desc                                           |
|--------------|----------------------------------|------------------------------------------------|
| int          | available()                      | 스트림에서 중단없이 읽을 수 있는 바이트 개수 반환                   |
| void         | mark(int readlimit)              | 스트림의 현재 위치를 표시해둔다. int 매개변수는 표시해 둔 자리의 최대 유효길이 |
| void         | reset()                          | 현재 위치를 mark() 메소드가 호출됐던 위치로 되돌린다.              |
| boolean      | markSupported()                  | mark(), reset()가능한 지 확인                        |
| abstract int | read()                           | 스트림에서 다음 바이트를 읽는담                              |
| int          | read(byte[] b)                   | 매개 변수로 넘어온 바이트 배열에 데이터를 담는다. 리턴값은 데이터 담은 개수    |
| int          | read(byte[] b, int off, int len) | 바이트 배열에 특정 위치(off)부터 지정한 길이만큼 데이터를 담는다         |  
| long         | skip(long n)                     | n 만큼 데이터를 건너뛴다                                 |
| void         | close()`                          | 스트림에서 작업중인 대상 해제.                              |

* InputStream 확장 클래스
```java
  import javax.sound.sampled.AudioInputStream;
import java.io.*;

AudioInputStream,ByteArrayInputStream,FileInputStream,FilterInputStream,InputStream,ObjectInputStream, PipedInputStream, SequenceInputStream
```

* OutputStream

```java
import java.io.Closeable;
import java.io.Flushable;

public abstract class OutputStream extends Object implements Closeable, Flushable
```
쓰기 요청을 할 때 매 요청마다 쓰고 저장하고 하는 것은 비효율적.
그래서 쓰기 요청 데이터를 버퍼에다가 저장하다가 어느 정도 차면 한번에 쓰기.
그러한 버퍼를 사용할 때 flush 메소드는 현재 버퍼에서 대기하고 있는 데이터를 강제로 쓰도록 한다.

* OutputStream 또한 close() 메소드로 리소스를 닫아주어야 한다.
* 텍스트 기반의 기본 자료형이나 문자열 데이터를 처리할 때는 BufferedReader 대신 Scanner가 편하다

## Serializable과 NIO에 대해
* 용도
  * 생성한 객체를 파일로 저장, 읽기, 다른 서버로 전송 등등을 할 수 있게 해줌
  * static final long serialVersionUID 값을 지정해줘야 한다.
    * 각 서버가 쉽게 전송을 주고 받는 객체가 같은 지 다른지를 확인할 수 있도록 관리하는 용도

* NIO의 Buffer class
  * Bytebuffer, CharBuffer,..etc 등등 확장된 버퍼 클래스가 많다.
  * method
    * capacity return 버퍼에 담을 수 있는 크기
    * limit() - return 버퍼에서 읽거나 쓸 수 없는 첫 위치 
    * position() - return 현재 버퍼의 위치
  

## java8에 추가도니 사항

* Optional
  ```java
    public final class Optional<T> extends Object;
  ```
  * final로 선언돼 있으므로 상속이 불가능
  * 데이터가 없는 Optional 객체 생성에는 empty()메소드 사용
  * null이 추가될 수 있는 상황이라면 ofNullable() 메소드 사용
  * 반드시 데이터가 들어갈 수 있는 상황에는 of()메소드 사용
* default 키워드
  * interface 내에 default 예약어를 통해 default method를 넣을 수 있음
  ```java

    interface Car {
      String brand;
      default String getBrand() {
          return "Toyota";
        }    
      }
  ```
* 날짜 관련 클래스
  * 기존의 api 복잡도 때문에 java.time 추가
* 병렬 배열 정렬
  * binarySearch()
  * copyOf()
  * equals()
  * fill()
  * hashCode()
  * sort()
  * toSTring()
  * sort의 경우 단일 스레드, parallelSort()는 병렬작업
* StringJoiner
  * 순차적으로 나열되는 문자열을 처리할 때 사용

```java
  import java.util.StringJoiner;

public void join(String[] args) {
  StringJoiner joiner = new StringJoiner(",");
  for (String arg: args) {
    joiner.add(arg);
  }
  System.out.println(joiner); // Studyhard,godofjava,book
}
```

## java8에서 변경된 것
* Lambda 표현식
  * 인터페이스에 메소드가 하나인 것들에 적용 가능
  * 익명 클래스 <-> 인터페이스 서로 전환 가능
* java.util.function 패키지
  * Predicate
    * test() -> 두 객체를 비교할 때 사용
  * Supplier
    * get(), 리턴값은 generic으로 선언된 타입을 리턴
  * Consumer
    * accept()라는 매개변수를 하나 갖는 메소드가 있으며 리턴값 없음.
  * Function
    * apply()라는 하나의 매개 변수를 갖는 메소드가 잇음
  * UnaryOperator
    * apply()라는 하나의 매개변수를 갖는 메소드가 있음.
  * BinaryOperator
    * apply()라는 두개의 매개변수를 갖는 메소드가 있음. 

* Stream
  * 컬렉션에는 스트림을 사용할 수 있지만 배열에는 X
  * 그래서 배열을 컬렉션의 List로 변환해서 사용
* 메소드 참조
  * 자바스크립트에서 console.log만 넣어서 콜백 함수를 매개인자로 넣어주듯이 사용(HOC 처럼 사용하기)
  * static 메소드참조
  * 특정 객체의 인스턴스 메소드 참조
  * 특정 유형의 임의이 객체에 대한 인스턴스 메서드 참조
  * 생성자 참

```java
  import java.util.List;//staic method 참조
private void printAll(List<String> args) {
    args.stream().forEach(System.out::println);
}
```

## JAVA9
* Interface의 privaet 메소드 추가 가능
  * abstract 메소드로 선언하면 안됨. private, abstract 제어자를 같이 사용해도 안됨
  * 인터페이스 내에 선언한 메소드와 static이나 static이 아닌 인터페이스 메소드에서만 사용 가능
  * private으로 선언한 static이 아닌 메소드는 다른 private static 메소드에서 사용 불가능
  * private으로만 선언
* 새로운 HttpClient
* Pub-sub framework
* pub sub 할 publish가 한번에 빨리 되지 않는 이유
1. Reactive Stream의 기본 원칙
     Reactive Stream는 **백프레셔(Backpressure)**를 처리하도록 설계.
     SubmissionPublisher는 데이터를 구독자에게 발행할 때, 구독자가 데이터를 처리할 수 있는 속도에 맞춰 발행.
     즉, 구독자가 데이터를 빨리 처리하지 못하면 SubmissionPublisher가 발행 속도를 조절하거나 데이터가 큐에 쌓임.
2. SubmissionPublisher의 내부 동작
   SubmissionPublisher는 내부적으로 큐를 사용하여 데이터를 저장하고 구독자에게 전달.
   구독자가 데이터를 처리하기 전에는 새로운 데이터를 큐에 쌓아두지만, 큐가 가득 차면 submit() 메서드 호출이 블로킹 상태에 빠질 수 있음.
   기본적으로 SubmissionPublisher의 큐 크기는 256. 이를 초과하면 발행자는 대기.
3. 구독자(ReactiveStreamSubscriber)의 처리 속도
   구독자는 데이터를 처리하는 데 시간이 걸림. 예를 들어, onNext 메서드 내부에서 데이터를 처리하는 작업이 오래 걸리면, SubmissionPublisher는 구독자가 데이터를 처리할 때까지 대기.
   이로 인해 발행자(pub.submit(i))가 빠르게 진행되지 않고 점진적으로 진행

* 자바의 모듈화 - 직소 프로젝트
  * 어플리케이션을 모듈이라는 독립적인 단위로 나눔