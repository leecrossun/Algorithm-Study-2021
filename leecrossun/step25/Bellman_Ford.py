# 벨만-포드 알고리즘
n , m = map(int, input().split()) # n 노드의 수 / m 간선의 수

graph = []

for i in range(m):
    u, v, w = list(map(int, input().split()))
    graph.append([u, v, w])


def BellmanFord(src):
    # 1. 최단거리 테이블 초기화 ( 출발노드 0 / 나머지 INF )
    dist = [float("inf") for i in range(n+1)]
    dist[src] = 0

    # 2. 1~ n-1개의 노드를 사용한 최단거리 구하기 루프
    for i in range(n-1):
        for u, v, w in graph: # 입력받았던 그래프 돌기 /  u->v = w (비용)
            if dist[u] != float("inf") and dist[u]+w < dist[v]: # 1) dist[u]가 INF가 아니고, 2) dist[u] + w (지금 계산한 최단거리) 가 dist[v] (기존 최단거리) 보다 작으면
                dist[v] = dist[u]+w # 테이블 갱신

    # 3. 음의 사이클 확인
    cycle = 0
    for u, v, w in graph:
        if dist[u] != float("inf") and dist[u] + w < dist[v]:
            print("Graph contains negative weight cycle")
            cycle = 1
            break
    if cycle == 0:
        print('Distance from source vertex',src)
        print('Vertex \t Distance from source')
        for i in range(1, len(dist)):
            print(i,'\t',dist[i])


BellmanFord(1)