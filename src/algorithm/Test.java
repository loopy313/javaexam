package algorithm;
import java.util.*;

class Test{
	/*
	static public int[] solution(int[] answers) {
		//		1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
		//		2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
		//		3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
		int[][] arr={{1,2,3,4,5,1,2,3,4,5},
				{2,1,2,3,2,4,2,5,2,1},				
				{3,3,1,1,2,2,4,4,5,5}};
		int[] temp=new int[arr.length];
		for(int i=0;i<arr.length;++i){
			for(int j=0;j<answers.length;++j){
				if(answers[j]==arr[i][j]){
					temp[i]++;
				}
				if(arr[0].length<answers.length && arr[i][j]>=arr[i].length){
					j=0;
				}
			}
		}
		int len=0;
		for(int i=0;i<temp.length;++i){
			if(temp[i]>0)
				len++;
		}
		int[] rank=new int[len];

		for(int i=0;i<rank.length;i++){
			rank[i]++;
			for(int j=0;j<temp.length;j++){
				if(temp[j]==0)
					break;
				if(i==j){
					continue;
				}

				if(temp[i] < temp[j]){
					rank[j]++; }
			}
		}
		return rank;
	}*/
	static public String[] solution(String[] strings, int n) {
		String[] answer = new String[strings.length];
		Map<String,ArrayList<String>> treemap=new TreeMap<>();
		for(int i=0;i<strings.length;++i){
			if(treemap.containsKey(strings[i].charAt(n)+"")){
				treemap.get(strings[i].charAt(n)+"").add(strings[i]);
				Collections.sort(treemap.get(strings[i].charAt(n)+""));
				continue;
			}
			ArrayList<String> list=new ArrayList<String>();
			list.add(strings[i]);
			treemap.put(strings[i].charAt(n)+"",list);
		}
		
		Set<String> ketset=treemap.keySet();
		Iterator<String> iter=ketset.iterator();
		
		int ans_len=0;
		while(iter.hasNext()){
			String key=iter.next();
			for(int i=0;i<treemap.get(key).size();++i){
				answer[ans_len++]=treemap.get(key).get(i);
			}
		}

		return answer;
	}
	public static void main(String[] args) {
		String[] str={"abce", "abcd", "cdx"};
		System.out.println(Arrays.toString(solution(str, 1)));
	}
}