package level24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_1707 {
	static ArrayList<ArrayList<Integer>> arrayLists;
	
	static final int RED = 1;
	static final int BLACK = -1;
	
	static int V, E;
	static int[] colors;
	static boolean checkBipartite;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st; 
		for(int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			arrayLists = new ArrayList<>();
			colors = new int[V + 1];
			checkBipartite = true; // �̺� �׷������� Ȯ��
			
			for (int j = 0; j < V + 1; j++) {
				arrayLists.add(new ArrayList<Integer>());
				colors[j] = 0; // �湮���� ���� ������ 0���� �ʱ�ȭ 
			}
			for (int k = 0; k < E; k++) {
				st = new StringTokenizer(br.readLine(), " ");
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				
				arrayLists.get(v1).add(v2);
				arrayLists.get(v2).add(v1);
			}
			
			for (int v = 1; v < V + 1; v++) {
				if(!checkBipartite) {
					break;
				}
				
				// ���� �湮���� ���� �����鿡 ���� Ž�� 
				if(colors[v] == 0) {
					bfs(v, RED);
				}
			}
			System.out.println(checkBipartite ? "YES" : "NO");
		}
		
	}
	
	static void bfs(int v, int color) {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(v);
		colors[v] = color;
		
		while(!q.isEmpty() && checkBipartite) {
			int tmpV = q.poll();
			
			// �ش� ������ ����� ��� ���� ������ �湮 
			for (int adjV : arrayLists.get(tmpV)) {
				
				if(colors[adjV] == 0) {
					q.offer(adjV);
					// ������ ������ �ٸ� ������ ĥ�� 
					colors[adjV] = colors[tmpV] * -1;
				} 
				
				else if(colors[tmpV] + colors[adjV] != 0) {
					checkBipartite = false;
					return;
				}
			}
		}
	}
}
