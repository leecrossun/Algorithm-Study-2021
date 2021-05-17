package level25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * dp[i][j] = ���� ���Һ��� i���ױ��� j�� ����� �Һ��Ͽ� �̵��� �ð� �� �ּҽð�
 * ���ͽ�Ʈ�� �˰����� ����Ͽ� dp[n][0]~dp[n][m] �� ���� ���� ���� ���ϸ� �ȴ�.
 */
public class Baek_10217 {
	static List<Airport>[] graph;	
	static int[][] dp;
	static final int INF = Integer.MAX_VALUE / 2;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int tc = Integer.valueOf(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		while(tc --> 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.valueOf(st.nextToken());
			int m = Integer.valueOf(st.nextToken());
			int k = Integer.valueOf(st.nextToken());
			dp = new int[n + 1][m + 1];	// i : i�� ���ױ����� ���, j : ��� j��ŭ �Ҹ���, �� : ���� ���� �ð� (�ִܽð�)   
			graph = new ArrayList[n + 1];
			
			for(int i = 1; i <= n; i++) {
				graph[i] = new ArrayList<Airport>();
				Arrays.fill(dp[i], INF);
			}
			
			// ���� ���� �Է¹��� 
			for(int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.valueOf(st.nextToken());
				int v = Integer.valueOf(st.nextToken());
				int c = Integer.valueOf(st.nextToken()); // ��� 
				int d = Integer.valueOf(st.nextToken()); // �ҿ�ð� 
				graph[u].add(new Airport(v, c, d));
			}
			
			dijkstra(n, m, 1);	
			
			int min = INF;
			for(int i = 0; i <= m; i++) { // �ּ� �ð�
				min = Math.min(min, dp[n][i]);
			}
			
			if(min == INF) { // �������� ������ �� 
				sb.append("Poor KCM");
			}
			else {
				sb.append(min);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static void dijkstra(int n, int m, int start) {
		PriorityQueue<Airport> pq = new PriorityQueue<Airport>();
		pq.offer(new Airport(start, 0, 0));
		dp[start][0] = 0;	// 1�� ���ױ��� 0���� �Ҹ����� ��, �ִܽð��� 0.
		
		while(!pq.isEmpty()) {
			Airport airport = pq.poll();
			int nowAirport = airport.number;
			int nowMoney = airport.money;
			int nowTime = airport.time;
			
			if(nowAirport == n) { // �ִ� �ð��� ������ ����. 
				break;
			}
			
			for(Airport air : graph[nowAirport]) {
				int nextNum = air.number;
				int nextMoney = air.money + nowMoney;
				int nextTime = air.time + nowTime;
				
				if(nextMoney > m) {
					continue;
				}
				
				if(dp[nextNum][nextMoney] <= nextTime) {	// �̹� �ش� �ݾ����� �ش� �� �������� ���� ���� �ּ� �ð����� ũ�� ������Ʈ�� �ǹ̰� ����. 
					continue;
				}
				
				// ���ʿ��� ���� ������ ���� �� �̻��� ��� ���� ���� �ִܽð� ���� �������ش�.
                for(int j = nextMoney; j <= m; j++){
                    if(dp[nextNum][j] > nextTime) {
                    	dp[nextNum][j] = nextTime;
                    }
                }
                
				dp[air.number][nextMoney] = nextTime;
				pq.offer(new Airport(air.number, nextMoney, nextTime));
			}
		}
	}
}

class Airport implements Comparable<Airport> {
	int number;
	int money;
	int time;
	
	
	Airport(int number, int money, int time) {
		this.number = number;
		this.time = time;
		this.money = money;
	}
	
	@Override
	public int compareTo(Airport o) {
		if(this.time < o.time) {
			return -1;
		}
		else if(this.time == o.time) {
			if(this.money < o.money) {
				return -1;
			}
			return 0;
		}
		return 1;
	}
}