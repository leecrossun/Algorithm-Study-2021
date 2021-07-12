package kakao;

import java.io.IOException;
import java.util.ArrayList;

public class Kakao_experssion {
	public static long ans = Long.MIN_VALUE;
	
	public static ArrayList<Long> numberList = new ArrayList<>();
	public static ArrayList<String> operatorList = new ArrayList<>();
	
	public static String[] operator = {"+", "-", "*"};
	public static String[] output = new String[3];
	public static boolean[] visited = new boolean[3];
	
	public static void main(String[] args) throws Exception, IOException {
		String expression = "100-200*300-500+20";	
		
		System.out.println(solution(expression));
	}
	
	public static long solution(String expression) {
		String n = "";
		for(int i = 0; i < expression.length(); i++) {
			char exp = expression.charAt(i);
			
			if(exp == '+' || exp == '-' || exp == '*') {
				operatorList.add(exp + "");
				numberList.add(Long.parseLong(n));
				n = "";
			} else {
				n += exp;
			}
		}
		
		numberList.add(Long.parseLong(n));
		
		permutation(0, operator.length);
		
		return ans;
	}
	
	/*
	 * �������� �켱���� ������ ����
	 * ������ 2�� : 2 != 2��, 3�� : 3! = 6��
	 */
	public static void permutation(int depth, int r) {
		if (depth == r) {
			// ����
			solve();
			return;
		}
		
		for(int i = 0; i < operator.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[depth] = operator[i];
				permutation(depth + 1, r);
				visited[i] = false;
			}
		}
	}
	
	public static void solve() {
		
//		������ �켱 ������ ���� ���� ��� ���� List�� ����
		ArrayList<String> oper = new ArrayList<String>();
		oper.addAll(operatorList);
		
		ArrayList<Long> num = new ArrayList<Long>();
		num.addAll(numberList);
	
		for(int i = 0; i < output.length; i++) {
			String curOper = output[i];
			for(int j = 0; j < oper.size(); j++) {
				
				if(oper.get(j).equals(curOper)) { // ���� �켱������ �´� �������� ���
					
					long n1 = num.get(j);
					long n2 = num.get(j + 1);
					long result = calc(n1, n2, curOper);
					
					num.remove(j + 1);
					num.remove(j);
					oper.remove(j);
					
					num.add(j, result); // ���� ��� �ֱ�
					j --;
				}
			}
		}
		
		ans = Math.max(ans, Math.abs(num.get(0))); 
	}
	
	public static long calc(long n1, long n2, String o) {
		long res = 0;
		
		switch(o) {
			case "+" : 
				res = n1 + n2;
				break;
			case "-" :
				res = n1 - n2;
				break;
			case "*" :
				res = n1 * n2;
				break;
		}
		
		return res;
	}
}
