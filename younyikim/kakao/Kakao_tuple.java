package kakao;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Kakao_tuple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		
		int[] arr = solution(str);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	 public static int[] solution(String s) {
	
	    	Map<String, Integer> map = new HashMap();
	        
	        s = s.replace("{", "");
	        s = s.replace("}", "");
	       
	        String [] arr = s.split(",");
	        
	        /*
	         * Ʃ���� ù ���Ҵ� ��� �迭�� �����ϰ�, �� ���� ���Ҵ� �ϳ� ����, ������ ���Ҵ� �� ���� �����Ѵ�.
	         * �� Ƚ���� key�� value�� �����Ѵ�.
	         */
	        for(int i = 0 ; i < arr.length; i++) {
	        	int count = map.containsKey(arr[i]) ? map.get(arr[i]) + 1 : 1;
	        	map.put(arr[i], count);
	        }
	        
	        List<String> list = new ArrayList<>(map.keySet());
	        
	        // ����Ƚ���� ���� ������ �����Ѵ�.
	        Collections.sort(list, (o1, o2) -> 
	        		(map.get(o2).compareTo(map.get(o1))));
	        
	        int[] answer = new int[map.size()];
	        
	        int i = 0;
	        for(String key : list) {
	        	answer[i++] = Integer.parseInt(key);
	        }
	        
	        return answer;
	    }

}
