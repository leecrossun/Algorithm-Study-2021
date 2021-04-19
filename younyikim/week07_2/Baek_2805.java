package level21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_2805 {
	static int N;
	static int M;
	
	static int[] arr;
	static int[] find;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
       
        Arrays.sort(arr); 
      
        long left = 1;
        long right = arr[N - 1];
        long mid = 0;
        
        while(left <= right) {
        	long cnt = 0;
        	mid = (left + right) / 2;

        	for (int i = 0; i < N; i++) {
    			long tmp =  arr[i] - mid;
    			if(tmp > 0) {
    				cnt += tmp;
    			}
    		}
        	
        	// ������ ������ ��ǥġ ���� => H�� �����.
        	if(cnt < M) {
        		right = mid - 1;
        	} 
        	// ������ ������ ��ǥġ �̻� => H�� ���δ�.
        	else if(cnt >= M) {
        		left = mid + 1;
        	}
        }
        System.out.println(right);
      }
}
