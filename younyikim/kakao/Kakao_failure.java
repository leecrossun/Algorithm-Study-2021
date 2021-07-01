package kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Kakao_failure {
	private static class Rate{
		int num;
		double rate;
		
		public Rate(int num, double rate) {
			this.num = num;
			this.rate = rate;
		}
	}
	public static void main(String[] args)  throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int stages[] = {2, 1, 2, 6, 2, 4, 3, 3};
		
		int result[] = new int[N];
		result = solution(N, stages);
	}
	
	public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];       
        int [] failure = new int[N];
        int user = stages.length;
        
        for(int i = 0; i < stages.length; i++) {
        	if(stages[i] > N) continue;
        	failure[stages[i] - 1]++;
        }
       
        // �켱 ���� ť�� �������� ��ȣ - �������� ������������ ����
        PriorityQueue<Rate> pq = new PriorityQueue<Rate>(new Comparator<Rate>() {

            @Override
            public int compare(Rate o1, Rate o2) {

                if (o1.rate - o2.rate < 0) return 1;
                else if (o1.rate - o2.rate == 0) {

                    if (o1.num < o2.num) return -1;
                    else return 1;
                }
                else return -1;
            }
        });

        for(int i = 0; i < failure.length; i++) {
        	// ������ ���
        	Rate r = new Rate(i, (double)(failure[i] * 100) /user);
        	pq.add(r);
        	// ���� ���������� �����ϴ� ������ �� ���
        	user = (user - failure[i] == 0) ? 1 : user - failure[i];
        }
        
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = pq.poll().num + 1;
        	System.out.print(answer[i]);
        }
        
        return answer;
    }
}
