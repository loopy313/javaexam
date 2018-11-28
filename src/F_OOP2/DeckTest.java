package F_OOP2;

class Card{
	private final static int SPADE=1;
	private final static int DIAMOND=1;
	private final static int HEART=1;
	private final static int CLOVER=1;
	
	static final int KIND_MAX=4;
	static final int NUM_MAX=13;
	
	int num;
	int kind;
	public Card(int num, int kind) {
		this.num = num;
		this.kind = kind;
	}
	public Card() {
		this(1,1);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return kind+" , "+num;
	}
	
	
}
class Deck{
	//1.카드의 수량을 저장할 수 있는 변수 CARD_NUM 선언 및 초기화해주세요.
	//단,초기화시 Card클래스의 상수를 이용
	final int CARD_NUM=Card.KIND_MAX*Card.NUM_MAX;
	//2.카드 52장을 저장할 수 있는 변수 c를 선언 및 생성
	//단, CARD_NUM을 이용
	Card[] c=new Card[CARD_NUM];
	//3.기본생성자를 만들어주세요.
	//c의 각방을 카드로 채워주세요
	public Deck() {
		int temp=0;
		for(int i=1;i<Card.KIND_MAX+1;++i){
			for(int j=1;j<Card.NUM_MAX+1;++j){
				c[temp]=new Card(i,j);
				temp++;
			}
		}
	}
	//4.입력받은 방번호의 카드를 반환하는 메서드를 만드세요.pick
	Card pick(int room){
		return c[room];
	}
	//5.랜덤한 방의 카드 한장을 반환하는 메서드를 만드세요 pick
	//4번에서 만든 것 이용.
	Card pick(){
		return pick((int)(Math.random()*53));
	}
	//6.카드를 섞어주세요 shuffle
	void shuffle(){
		int rand=(int)(Math.random()*53);
		for(int i=0;i<CARD_NUM;++i){
			Card temp=c[i];
			c[i]=c[rand];
			c[rand]=temp;
		}
	}
	//7.카드를 섞어주세요 shuffle
	//단 랜덤방 두개를 교환하는 방식으로 사용자로부터 입력받은 수만큼 반복.
	void shuffle(int num){
		int rand1=(int)(Math.random()*53);
		int rand2=(int)(Math.random()*53);
		for(int i=0;i<num;++i){
			Card temp=c[rand1];
			c[rand1]=c[rand2];
			c[rand2]=temp;
		}
	}
}
public class DeckTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deck d=new Deck();
		d.shuffle();
		d.shuffle(20);
	}

}
