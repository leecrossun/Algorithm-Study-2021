package level22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baek_1655 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());	
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
		
		while (N --> 0) {
			int X = Integer.parseInt(br.readLine());
			
			 if(minHeap.size() == maxHeap.size()) {
				 maxHeap.offer(X);
			 } else {
				 minHeap.offer(X);
			 }
			
			 if(!minHeap.isEmpty() && !maxHeap.isEmpty()) {
				 /*
				  * maxHeap�� ��� ���Ҵ� minHeap�� ��� ���Һ��� �۰ų� ����.
				  */	              
				 if(minHeap.peek() < maxHeap.peek()){
					 /*���� ��ȯ */
	                    int tmp = minHeap.poll();
	                    minHeap.offer(maxHeap.poll());
	                    maxHeap.offer(tmp);
	              }
			 }
			 /*
			  * maHeap�� root��尡 �߾Ӱ��� �ȴ�.
			  */
	        sb.append(maxHeap.peek() + "\n");
	            
		}
		System.out.println(sb);
	}
}
