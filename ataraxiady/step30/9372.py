import sys

t = int(sys.stdin.readline())
for i in range(t):
    n, m = map(int, sys.stdin.readline().split())
    for j in range(m):
        a, b = map(int, sys.stdin.readline().split())
    # 주어지는 비행 스케쥴은 항상 연결 그래프를 이루기 때문에 비행기 종류의 최소 개수는 국가 수 -1이다. (탐색하여 푸는 방법도 있다.)
    print(n - 1)
