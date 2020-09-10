import java.util.ArrayList;
import java.util.HashSet;

public class p42890 {

	public static void main(String[] args) {
		System.out.println(solution(new String[][]{{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}}));
		System.out.println(solution(new String[][]{{"a","b","c"},{"1","b","c"},{"a","b","4"},{"a","5","c"}}));
		System.out.println(solution(new String[][]{{"a","1","4"},{"2","1","5"},{"a","2","4"}}));
	}
	
	public static int solution(String[][] relation) {
		// 후보 키의 플래그를 저장하는 리스트
		ArrayList<Integer> arrList = new ArrayList<>();
		
		// 유일성을 확인하기 위한 Set
		HashSet<String> hs = new HashSet<>();
		
		// 유일성 확인을 저장하기 위한 key가 될 StringBuilder
		StringBuilder sb = new StringBuilder("");
	
		
		// 모든 부분집합을 구해야 하니 0001 부터 1111까지 (길이 4의 경우)
		for(int flag=1; flag< (1<<relation[0].length); flag++) {
			
			// 이번 플래그를 사용할 수 있는가 체크하기 위한 boolean 변수
			boolean isOk = true;
			
			// Set 초기화
			hs.clear();
			
			// 최소성을 확인하기 위한 for문, 후보키 리스트를 돌며 이미 사용된 후보키인지 확인.
			for(int i=0; i<arrList.size(); i++) {
				if((flag & arrList.get(i)) == arrList.get(i)) {
					isOk = false;
					break;
				}
			}	
			
			// 유일성을 확인하기 위한 for문, flag에 맞는 요소만 쓰며 sb에 더함. sb의 값을 key로 set에 넣음.
			// 이미 set에 존재한다면 중복이므로 유일성 조건에 맞지 않음.
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
			
			// 이번 플래그를 사용할 수 있다면 arrList에 추가
			if(isOk) {
				System.out.println(sb.toString());
				arrList.add(flag);
			}
		}
		
		// 후보 키 의 개수를 리턴.
        return arrList.size();
    }
}
