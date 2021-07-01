package kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kakao_newId {

	public static void main(String[] args)  throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String userId = br.readLine();
		System.out.println(solution(userId));
	}
	
	public static String solution(String new_id) {
		String answer = "";
		
		// step 1. ��� �빮�ڸ� �����Ǵ� �ҹ��ڷ� ġȯ
		new_id = new_id.toLowerCase();
		
		/*
		 * ���� ǥ���� ���
		 *  answer = answer.replaceAll("[^-_.a-z0-9]", ""); // 2�ܰ�
        	answer = answer.replaceAll("[.]{2,}", "."); // 3�ܰ�
        	answer = answer.replaceAll("^[.]|[.]$", "");    // 4�ܰ�
		 * */
		
		// step 2. ���ĺ� �ҹ���, ����, ����(-), ����(_), ��ħǥ(.)�� ������ ��� ���ڸ� ����
		String id = "";
		for(int i = 0; i < new_id.length(); i++) {
			char c = new_id.charAt(i);
			
			if(c >= 'a' && c <= 'z') { // ���ĺ� �ҹ����� ���
				id += String.valueOf(c);
			} else if(c >= '0' && c <= '9') { // ������ ���
				id += String.valueOf(c);
			} else if(c == '-' || c == '_' || c == '.') {
				id += String.valueOf(c);
			}
		}
		new_id = id;
		
		// step 3. ��ħǥ(.)�� 2�� �̻� ���ӵ� �κ��� �ϳ��� ��ħǥ(.)�� ġȯ
		String step3 = new_id.replace("..", ".");
		while(step3.contains("..")) {
			step3 = step3.replace("..", ".");
		}
		new_id = step3;
		
		//step 4. ��ħǥ(.)�� ó���̳� ���� ��ġ�Ѵٸ� ����
		if(new_id.startsWith(".") ){
			new_id = new_id.substring(1, new_id.length());
		} 
		if(new_id.endsWith(".")) {
			new_id = new_id.substring(0, new_id.length() - 1);
		}
		
		//step 5. new_id�� �� ���ڿ��̶��, new_id�� "a"�� ����
		if(new_id.equals("")) {
			new_id = "a";
		}
		
		//step 6. new_id�� ���̰� 16�� �̻��̸�, new_id�� ù 15���� ���ڸ� ������ ������ ���ڵ��� ��� ����
	    //���� ���� �� ��ħǥ(.)�� new_id�� ���� ��ġ�Ѵٸ� ���� ��ġ�� ��ħǥ(.) ���ڸ� ����
		
		if(new_id.length() >= 16) {
			new_id = new_id.substring(0, 15);
			
			if(new_id.charAt(new_id.length() - 1) == '.') {
				new_id = new_id.substring(0, new_id.length() - 1);
			}
		}
		
		// step 7. new_id�� ���̰� 2�� ���϶��, new_id�� ������ ���ڸ� new_id�� ���̰� 3�� �� ������ �ݺ��ؼ� ���� ���δ�.
		if(new_id.length() <= 2) {
			char last = new_id.charAt(new_id.length() - 1);
			
			while(new_id.length() < 3) {
				new_id += last;
			}
		}

		answer = new_id;
		return answer;
	}

}
