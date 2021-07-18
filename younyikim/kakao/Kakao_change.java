package kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Kakao_change {

	public static int pos = 0;
	
	public static void main(String[] args) throws Exception, IOException {
		String p = "()))((()";
		
		String ans = solution(p);
		
		System.out.println(ans);
	}
	
	public static String solution(String p) {
        
		// �� ���ڿ��� ���, �״�� ��ȯ
        if(p.isEmpty()) {
        	return p;
        }
        
        // �ùٸ� ��ȣ ���ڿ����� Ȯ��
        boolean check = isCorrect(p);
        
        String u = p.substring(0, pos);
        String v = p.substring(pos, p.length());
        
        
     // �ùٸ� ��ȣ ���ڿ��� ���
        if(check) {
        	return u + solution(v);
        }
        
     // �ùٸ� ��ȣ ���ڿ��� �ƴ� ���
        String answer = "(" + solution(v) + ")";
        
        for(int i = 1; i < u.length() - 1; i++) {
        	if(u.charAt(i) == '(') {
        		answer += ")";
        	} else {
        		answer += "(";
        	}
        }
        
        return answer;
    }

//	�ùٸ� ���ڿ��� ���� ���� ���ڿ� Ȯ��
	public static boolean isCorrect(String str) {
		
		boolean ret = true; // true �� ���, '�������� ��ȣ ���ڿ�'
		int left = 0, right = 0; // left�� right�� ������ ��� '�ùٸ� ��ȣ ���ڿ�'
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(') {
				left++;
				stack.push('(');
			} else {
				right++;
				
				if(stack.isEmpty()) {
					ret = false;
				} else {
					stack.pop();
				}
			}
			
			if(left == right) {
				pos = i + 1;
				return ret;
			}
		}
		
		return ret;
	}
}
