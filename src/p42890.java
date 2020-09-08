import java.util.ArrayList;
import java.util.HashSet;

public class p42890 {

	public static void main(String[] args) {
		System.out.println(solution(new String[][]{{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}}));
		System.out.println(solution(new String[][]{{"a","b","c"},{"1","b","c"},{"a","b","4"},{"a","5","c"}}));
		System.out.println(solution(new String[][]{{"a","1","4"},{"2","1","5"},{"a","2","4"}}));
	}
	
	public static int solution(String[][] relation) {
		ArrayList<Integer> arrList = new ArrayList<>();
		HashSet<String> hs = new HashSet<>();
		StringBuilder sb = new StringBuilder("");
		for(int flag=1; flag<=(int)Math.pow(2, relation[0].length); flag++) {
			boolean isOk = true;
			hs.clear();
			for(int i=0; i<arrList.size(); i++) {
				if((flag & arrList.get(i)) == arrList.get(i)) {
					isOk = false;
					break;
				}
			}
			for(int i=0; i<relation.length; i++) {
				sb.delete(0, sb.length());
				for(int j=0; j<relation[i].length; j++) {
					if((flag & 1<<j) != 0) sb.append(relation[i][j]);
				}
				if(!hs.add(sb.toString())) {
					isOk = false;
					break;
				}
			}
			if(isOk) {
				System.out.println(sb.toString());
				arrList.add(flag);
			}
		}
        return arrList.size();
    }
}
