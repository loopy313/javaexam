package F_OOP2;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class PolyTest {
	static void method1() throws Exception {
		try {
			method2();
			System.out.println(1);
		} catch(NullPointerException e) {
			System.out.println(2);
			throw e;
		} catch(Exception e) {
			System.out.println(3);
		} finally {
			System.out.println(4);
		}
		System.out.println(5);
	}
	
	static void method2() {
		throw new NullPointerException();
	}

	public static void main(String[] args) {
		try {
			method1();
			System.out.println(6);
		} catch(Exception e) {
			System.out.println(7);
		}
	}
}




