import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class p42888 {
	static class Info{
		public String name;
		public ArrayList<Integer> arrList;
		public Info(String id) {
			this.name = id;
			this.arrList = new ArrayList<>();
		}
		
	}

	public static void main(String[] args) {
		String[] strs = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[] ans = solution(strs);
		
		for(String s : ans) System.out.println(s);
	}
	
	public static String[] solution(String[] record) {
		
        ArrayList<String[]> chatLog = new ArrayList<>();
        HashMap<String, Info> hm = new HashMap<>(record.length);
        int logNum = 0;
        for(int i=0; i<record.length; i++) {
        	StringTokenizer st = new StringTokenizer(record[i]);
        	String cmd = st.nextToken();
        	String id = st.nextToken();
        	
        	String name = "";
        	if(st.hasMoreTokens()) {
        		name = st.nextToken();
        	}
        	
        	if(cmd.equals("Enter")){
        		if(!hm.containsKey(id)) {
            		Info info = new Info(name);
            		info.arrList.add(logNum++);
            		hm.put(id, info);
            	}else {
            		hm.get(id).name = name;
            		ArrayList<Integer> alist = hm.get(id).arrList;
            		for(int j=0; j<alist.size(); j++) {
            			chatLog.get(alist.get(j))[0] = name;
            		}
            		hm.get(id).arrList.add(logNum++);
            	}
        		chatLog.add(new String[] {hm.get(id).name,"님이 들어왔습니다."});
        	}else if(cmd.equals("Leave")) {
        		hm.get(id).arrList.add(logNum++);
        		chatLog.add(new String[] {hm.get(id).name,"님이 나갔습니다."});
        	}else {
        		hm.get(id).name = name;
        		ArrayList<Integer> alist = hm.get(id).arrList;
        		for(int j=0; j<alist.size(); j++) {
        			chatLog.get(alist.get(j))[0] = name;
        		}
        	}
        	
        }
        
        String[] answer = new String[chatLog.size()];
        for(int i=0; i<chatLog.size(); i++) {
        	answer[i] = chatLog.get(i)[0] + chatLog.get(i)[1];
        }
        return answer;
    }
}
