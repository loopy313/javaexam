package E_OOP;

public class TotalTest {//TotalTest를 Method Area에 할당하고 클래스변수와 클래스메서드를 저장한다. (+0)
	public static void main(String[] args) {//Method Area의 TotalTest에 클래스 main함수를 저장하고, CallStack에서 main함수를 실행한다. (+0)

		TvMaker.color = "Blue"; //TvMaker를 Method Area에 할당하고 클래스멤버인 color,inch를 TvMaker에 저장한 후, color변수를 "Blue"로 저장한다. (+0) 
		TvMaker tm = new TvMaker();//1.main함수에 자료형이 TvMaker인 tm 인스턴스 변수를 로드. (+0)
								   //2.Heap영역에 TvMaker 인스턴스를 생성하고 인스턴스 변수(name,age) 및 생성자 로드(TvMaker(),TvMaker(String name, int age))되고 변수는 (+0)
								   //기본형으로 초기화됨. 
								   //3.CallStack에서 main()위에 TvMaker()가 올라감.생성자가 this("man", 25)를 실행하므로
								   //CallStack에TvMaker(String name, int age)가 올라가고 color과 inch는 "man"과 25로 지정됨.
								   //생성자 실행이 끝난 후, TvMaker(String name, int age) -> TvMaker()순으로 CallStack에서 지워짐.
								   //4.TvMaker의 주소를 tm이 참조함. 
		
		tm.age = 30; //tm 인스턴스의 age변수를 30으로 지정. (+0)
		
		// 3. 메서드 호출 (-1)
		// 3.1 println이 실행되기 전,Method Area에 TvControll을 할당하고 클래스 변수(MAX_CHANNEL,MIN_CHANNEL,channel)및
		//클래스메서드(volumeDown)를 올린후 (+0), CallStack에서 println메서드 실행후 TvControll클래스의 channel 클래스변수가 화면 출력된 후 제거.
		System.out.println(TvControll.channel);
		
		TvControll.volumeDown();//TvControll의 클래스 함수인volumeDown 실행
		
		//클래스메서드(volumeDown)를 올린후, CallStack에서 println메서드 실행후 TvControll클래스의 channel 클래스변수가 화면 출력된 후 제거.
		System.out.println(TvControll.channel);

		// 3.2 인스턴스 변수 호출
		TvControll tc; //TvControll클래스가 자료형인 tc 변수가 main함수에 로드. (+0)
		tc = new TvControll(); //1.TvControll클래스가 Heap에 할당되고 인스턴스 변수 및 상수들이 초기화 되고(+0) volumeUp인스턴스 함수 및 초기화 함수 가 로드됨. (+0)
							   //2.TvControll클래스의 기본생성자 CallStack에 올리가며 실행된 후, 제거됨.
							   //3.TvControll의 주소를 tc가 참조함.
		//tc클래스의 volume 인스턴스 변수가 화면출력
		System.out.println(tc.volume);
		//tc클래스의 volumnUp인스턴스 메서드가 호출됨. (+0)
		tc.volumeUp();
		//tc클래스의 volume 인스턴스 변수가 화면출력 
		System.out.println(tc.volume);
		//tc클래스의 volumnUp인스턴스 메서드가 호출됨.
		tc.volumeUp();
		//tc클래스의 volume 인스턴스 변수가 화면출력
		System.out.println(tc.volume);

		
		Calc cc = new Calc();	//1.Calc클래스가 자료형인 cc 변수가 main함수에 로드. (-1) 클래스 로드 (+0)
								//1.Calc클래스가 Heap에 할당되고 오버로딩된 add 인스턴스함수 2개와,minus 인스턴스함수 및 초기화 함수 가 로드됨. (+0)
		   						//2.Calc클래스의 기본생성자 CallStack에 올리가며 실행된 후, 제거됨. ()
		   						//3.Calc의 주소를 cc가 참조함.

		//Calc클래스를 참조하는 cc변수가 add인스턴스 함수에서 실행된 리턴된 값을 화면에 출력 (+0) (-1)
		System.out.println(cc.add(Integer.MAX_VALUE, 4));
		System.out.println(cc.add(3L, Integer.MAX_VALUE));

	}
}

class TvMaker {
	// 1.전역변수 (+0)
	// 1.1클래스멤버변수 (+0)
	static String color;
	static int inch;
	// 1.2인스턴스멤버변수 (+0)
	String name = "";
	int age;

	// 2.생성자 (+0)
	// 2.1 (-1)
	TvMaker() {
		this("man", 25); (+0)(+0)
	}

	// 2.2매개변수가 있는 생성자 (+0)
	TvMaker(String name, int age) {
		this.name = name; (+0)
		this.age = age;
	}
}

class TvControll {
	//인스턴스 멤버상수 (+1)
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	//클래스 멤버상수 (+1)
	static final int MAX_CHANNEL = 50;
	static final int MIN_CHANNEL = 1;

	//클래스 변수
	static int channel = 15;
	//인스턴스 변수
	int volume = 99;
//	(-1)

	// 4. return문
	int volumeUp() {
		if (volume == MAX_VOLUME) {
			volume = MIN_VOLUME;
		} else {
			volume++;
		}

		return volume;
	}
	//클래스 멤버 메서드
	static int volumeDown() {
		if (channel == MAX_CHANNEL) {
			channel = MIN_CHANNEL;
		} else {
			channel++;
		}
		return channel;
	}
}

class Calc {
	// 5.자료형이 다른 오버로딩된 add 인스턴스 메서드 (+0)
	// 오버로딩 조건:1.메서드 이름이 같아야 한다. 2.메서드의 매개변수의 개수나 자료형이 달라야 한다. (+1)
	int add(int a, int b) {
		return a + b;
	}

	long add(long a, int b) {
		return a + b;
	}

	int minus(int a, int b) {
		return a + b;
	}
}