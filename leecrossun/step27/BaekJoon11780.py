#  플로이드2
import sys
import math

def trace(TraceArr, start, end):
    if start == end:
        return []
    now = TraceArr[start][end]
    if now is None:
        return [start, end]
    return trace(TraceArr, start, now)[:-1] + trace(TraceArr, now, end)

def printResult(n, Arr, TraceArr):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            print(0 if Arr[i][j] == INF else Arr[i][j], end=" ")
        print()

    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if Arr[i][j] == INF:
                print(0)
                continue
            else:
                res = trace(TraceArr, i, j)
                print(len(res), *res)

def floyd(n, Arr, TraceArr):
    for k in range(1, n + 1):
        for i in range(1, n + 1):
            for j in range(1, n + 1):
                if i == j:
                    continue
                cost = Arr[i][k] + Arr[k][j]
                if Arr[i][j] > cost:
                    Arr[i][j] = cost
                    TraceArr[i][j] = k

def main():
    global INF; INF = math.inf
    I = sys.stdin.readline
    n, m = int(I()), int(I())
    DP = [[INF] * (n + 1) for _ in range(n + 1)]
    DPTrace = [[None] * (n + 1) for _ in range(n + 1)]
    for _ in range(m):
        a, b, c = map(int,I().split())
        if DP[a][b] > c:
            DP[a][b] = c
    floyd(n, DP, DPTrace)
    printResult(n, DP, DPTrace)

if __name__ == "__main__":
    main()