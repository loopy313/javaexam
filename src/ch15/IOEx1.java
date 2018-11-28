package ch15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

class ThreadEx1_1 extends Thread{
	public void run(){
		for(int i=0;i<500000;++i){
			System.out.println("						ThreadEx1_1 running...."+i);
		}
	}
}
class ThreadEx1_2 implements Runnable{
	public void run(){
		for(int i=0;i<5000000;++i){
			System.out.println("ThreadEx1_2 running...."+i);
		}
	}
}
public class IOEx1 {

	public static void main(String[] args) throws IOException{
		Runnable r=new ThreadEx1_2();
		Thread t1=new ThreadEx1_1();
		Thread t2=new Thread(r);
		t2.setPriority(10);
		t1.start();
		t2.start();
	}
}
