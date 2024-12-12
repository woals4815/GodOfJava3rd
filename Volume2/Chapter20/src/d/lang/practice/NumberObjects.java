package d.lang.practice;

public class NumberObjects {

	public static void main(String[] args) {
		NumberObjects sample=new NumberObjects();
		
		sample.parseLong("r1024");
		sample.parseLong("1024");
		sample.printOtherBase(1024);
	}
	public long parseLong(String data) {
		long retLong=-1;
		try {
			retLong=Long.parseLong(data);
			System.out.println(retLong);
			printNull();
		} catch(NumberFormatException ne) {
			System.out.println(data+" is not a number.");
		} catch(Exception e) {
		}
		return retLong;
	}
	public void printOtherBase(long value) {
		System.out.println("Original:"+value);
		System.out.println("Binary  :"+Long.toBinaryString(value));
		System.out.println("Hex     :"+Long.toHexString(value));
		System.out.println("Octal   :"+Long.toOctalString(value));
	}
	public void printNull(){
		Object obj = null;
		System.out.println(obj);
		/**
		 *  Stirng의 valueOf 메소드 호출 하여 결과 받은 후 출력
		 *  객체의 String 값을 호출할 때는 String.valueOf 메소드를 사용하는 것이 훨씬 안전
		 *  아래의 출력문은 함 수내에 있는 표현식을 StringBuilder로 변환하기 때문에 덧셈 연산자가 가능한 것
		 */
		System.out.println(obj + " is object's vlaue");
		System.out.println(null + " is nul");
	}

}
