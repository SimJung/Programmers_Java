import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class c1_1 {

	public static void main(String[] args) {
		System.out.println( Arrays.toString(solution(new int[] {2, 1, 3, 4, 1})));
		System.out.println( Arrays.toString(solution(new int[] {5, 0, 2, 7})));

	}
	
	public static int[] solution(int[] numbers) {
		ArrayList<Integer> ans = new ArrayList<>();
        HashSet<Integer> list = new HashSet<>();
        for(int i=0; i<numbers.length-1; i++) {
        	for(int j=i+1; j<numbers.length; j++) {
        		list.add(numbers[i]+numbers[j]);
        	}
        }
        for(Integer i : list) ans.add(i);
        Collections.sort(ans);
        return ans.stream().mapToInt(i->i).toArray();
    }
}
