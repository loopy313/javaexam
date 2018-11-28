package exercise;

import java.util.*;

public class algorithm {
	static String solution1(String[] participant, String[] completion) {
		HashMap<String,Integer> hashMap=new HashMap<String,Integer>();
		for(String s:participant){
			if(hashMap.containsKey(s))
				hashMap.put(s, hashMap.get(s)+1);
			else
				hashMap.put(s,1);
		}
		for(String s:completion)
			hashMap.put(s,hashMap.get(s)-1);
		for(String a:hashMap.keySet()){
			if(hashMap.get(a)==1)
				return a;
		}
		return null;
	}
	static int[] solution2(int[] arr, int divisor) {
		int[] answer;
		List<Integer> list=new ArrayList<>();
		for(int i=0;i<arr.length;++i){
			if(arr[i]%divisor==0){
				list.add(arr[i]);
			}
		}
		if(list.size()==0){
			answer=new int[]{-1};
			return answer;
		}
		answer=new int[list.size()];

		for(int i=0;i<list.size();++i){
			answer[i]=list.get(i);
		}
		Arrays.sort(answer);

		return answer;
	}
	static String solution3(int a, int b) {
		int leap[]={31,29,31,30,31,30,31,31,30,31,30,31};
		String day[]={"FRI","SAT","SUN","MON","TUE","WED","THU"};
		int sum=0;
		for(int i=0;i<a;++i){
			if(i==(a-1)){
				sum+=(b-1);
				break;
			}
			sum+=leap[i];
		}
		return day[sum%7];
	} 
	static public String solution4(String[] seoul) {

		for(int i=0;i<seoul.length;++i){
			if(seoul[i].equals("Kim"))
				return "김서방은"+i+"에 있다.";
		}
		return null;
	}
	static public String solution5(String s, int n) {
		StringBuilder str=new StringBuilder(s);
		for(int i=0;i<s.length();++i){
			if(s.charAt(i)==' ')
				continue;
			if(s.charAt(i)>='a'&&s.charAt(i)<='z'){
				if(s.charAt(i)+n>'z')
					str.setCharAt(i,(char)((s.charAt(i)+n)%'z'+'a'-1));
				else
					str.setCharAt(i,(char)(s.charAt(i)+n));
			}else{
				if(s.charAt(i)+n>'Z')
					str.setCharAt(i,(char)((s.charAt(i)+n)%'Z'+'A'-1));
				else
					str.setCharAt(i,(char)(s.charAt(i)+n));
			}
		}
		return str.toString();
	}
	static public void main(String args[]) {
		System.out.println(solution5("abz A Z",25));
	}
}
