import java.util.Arrays;

public class p42889 {
	static class Fail implements Comparable<Fail>{
		public int stage;
		public int nowNum;
		public int cameHere;
		public double failure;
		public Fail(int stage) {
			super();
			this.stage = stage;
			nowNum = 0;
			cameHere = 0;
			this.failure = 0;
		}
		
		@Override
		public int compareTo(Fail f) {
			if(failure > f.failure) return -1;
			else if(failure < f.failure) return 1;
			else {
				return stage - f.stage;
			}
		}
	}
	
	static Fail[] fails;
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
	}
	
	public static int[] solution(int N, int[] stages) {
		fails = new Fail[N];
		for(int i=0; i<N; i++)
			fails[i] = new Fail(i+1);
		
		for(int i=0; i<stages.length; i++) {
			for(int j=0; j<fails.length; j++) {
				fails[j].cameHere++;
				if(j == stages[i]-1) {
					fails[j].nowNum++;
					break;
				}
			}
		}
		
		for(int i=0; i<N; i++) 
			fails[i].failure = (double)fails[i].nowNum / fails[i].cameHere;
		
		Arrays.sort(fails);
		
        int[] answer = new int[N];
        for(int i=0; i<N; i++) answer[i] = fails[i].stage;
        return answer;
    }
}
