package homework;

public class TimeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Time t=new Time();
		t.setHour(100);
		int hour=t.getHour();
		System.out.print(hour);

		t.setMinute(150);
		int minute=t.getMinute();
		System.out.print(" : "+minute);//6:30

		t.setSecond(10000);
		int seconds=t.getSecond();//9:36:40
		System.out.println(" : "+seconds);
	}

}

class Time{
	private int hour;
	private int minute;
	private int second;

	public int getHour(){
		return hour;
	}

	public void setHour(int hour){
		this.hour+=hour%24;
	}

	public int getMinute() {
		System.out.print("\n"+hour);
		return minute;
	}

	public void setMinute(int minute) {
		setHour(minute/60);
		this.minute+=(minute%60);
		if(this.minute>59){
			setHour(this.minute/60);
			this.minute%=60;
		}
	}
	public int getSecond() {		
		System.out.print("\n"+hour+" : "+minute);
		return second;
	}

	public void setSecond(int second) {
		setMinute(second/60);
		this.second+=(second%60);
		if(this.second>59){
			setMinute(this.second/60);
			this.second%=60;
		}
	}
}