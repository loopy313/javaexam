package homework;

public class Test {
	public static void main(String[] args) {
		//3.사람 6명으로 이루어진 배열을 선언 및 생성.
		String[] names={"이승한  ","이종선  ","명노현  ","박찬근  ","정필지  ","김선구  "};
		//4.7개의 과목으로 이루어진 배열을 선언 및 생성,점수 상단에 출력.
		String[] subnames={"국어","영어","수학","사회","화학","물리","한문"};
		//1.6열의 7과목중 저장할 수 있는 변수 score를 선언 및 생성해주세요.
		int[][] score=new int[names.length][subnames.length];
		int[] total=new int[subnames.length];
		double[] avg=new double[subnames.length];

		int[] subscore=new int[subnames.length];
		double[] subavg=new double[subnames.length];

		//2.score의 각방을 0~100점 사이의 랜덤한 정수값을 저장해주세요.
		for(int i=0;i<score.length;++i){
			for(int j=0;j<score[0].length;++j){
				score[i][j]=(int)(Math.random()*101);
			}
		}
		//사람별합계
		for(int i=0;i<score.length;++i){
			for(int j=0;j<score[0].length;++j){
				total[i]+=score[i][j];
			}
		}
		//사람별평균
		for(int i=0;i<score.length;++i){
			for(int j=0;j<score[0].length;++j){
				avg[i]=Math.round((double)total[i]/(score[0].length)*100)/100d;
			}
		}
		//과목별합계
		for(int i=0;i<score[0].length;++i){
			for(int j=0;j<score.length;++j){
				subscore[i]+=score[j][i];
			}
		}
		//과목별평균
		for(int i=0;i<subscore.length;++i){
			subavg[i]=Math.round((double)subscore[i]/names.length*100)/100d;
		}
		//석차
		int[] rank=new int[names.length];

		for(int i=0;i<names.length;++i){
			rank[i]=1;
			for(int j=0;j<names.length;++j){
				if(total[i]<total[j]){
					rank[i]++;
				}	
			}
		}

		//0.아래와 같이 출력해주세요.
		for(String sub:subnames){
			System.out.print("\t"+sub);
		}
		System.out.print("\t합계\t평균\t석차");
		System.out.println();
		for(int i=0;i<score.length;++i){
			System.out.print(names[i]+" : ");
			for(int j=0;j<score[0].length;++j){
				System.out.print(score[i][j]+"\t");
			}
			System.out.print(total[i]+"\t");
			System.out.print(avg[i]+"\t");
			System.out.print(rank[i]+"\t");
			System.out.println();
		}
		System.out.print("과목합계 : ");
		for(int i:subscore){
			System.out.print(i+"\t");
		}
		System.out.println();
		System.out.print("과목평균 : ");
		for(double i:subavg){
			System.out.print(i+"\t");
		}

		System.out.println("");
		System.out.println("========================================================================================");

		String nm_temp;
		int tot_temp,sub_temp,ridx; 
		double avg_temp;

		for(int i=0;i<subnames.length;++i){
			//임시 석차 생성.
			int[] rnk_temp=new int[rank.length];
			for(int t=0;t<rank.length;++t){
				rnk_temp[t]=rank[t];
			}
			//과목별 석차순 정렬
			for(int j=0;j<rank.length;++j){
				for(int k=0;k<rank.length;++k){
					if(rnk_temp[k]-1==j){
						sub_temp=score[j][i];
						score[j][i]=score[k][i];
						score[k][i]=sub_temp;

						ridx=rnk_temp[j];
						rnk_temp[j]=rnk_temp[k];
						rnk_temp[k]=ridx;
					}	
				}
			}
			
		}
		//석차별 이름,합계,평균,석차 정렬
		ridx=0;
		for(int i=0;i<rank.length;++i){
			for(int j=0;j<rank.length;++j){
				if(rank[j]-1==i){
					//석차별 이름 
					nm_temp=names[i];
					names[i]=names[j];
					names[j]=nm_temp;
					//석차별 합계
					tot_temp=total[i];
					total[i]=total[j];
					total[j]=tot_temp;
					//석차별 평균
					avg_temp=avg[i];
					avg[i]=avg[j];
					avg[j]=avg_temp;
					//임시석차
					ridx=rank[i];
					rank[i]=rank[j];
					rank[j]=ridx;
				}
			}
		}
		for(String sub:subnames){
			System.out.print("\t"+sub);
		}
		System.out.print("\t합계\t평균\t석차");
		System.out.println();
		for(int i=0;i<score.length;++i){
			System.out.print(names[i]+" : ");
			for(int j=0;j<score[0].length;++j){
				System.out.print(score[i][j]+"\t");
			}
			System.out.print(total[i]+"\t");
			System.out.print(avg[i]+"\t");
			System.out.print(rank[i]+"\t");
			System.out.println();
		}
		System.out.print("과목합계 : ");
		for(int i:subscore){
			System.out.print(i+"\t");
		}
		System.out.println();
		System.out.print("과목평균 : ");
		for(double i:subavg){
			System.out.print(i+"\t");
		}
	}
}

