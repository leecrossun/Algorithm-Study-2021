package level21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baek_10816_HashMap {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        HashMap<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
        	int key = Integer.parseInt(st.nextToken());
        	if (map.containsKey(key)) {
        		map.put(key, map.get(key) + 1);
        	} else {
        		map.put(key, 1);
        	}
        }
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++) {
        	int key = Integer.parseInt(st.nextToken());
        	if (map.containsKey(key)) {
        		sb.append(map.get(key)).append(' ');
        	} else {
        		sb.append(0).append(' ');
        	}
        }
        System.out.println(sb);
	}
}
