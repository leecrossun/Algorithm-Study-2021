# 사회망 서비스(SNS)
from sys import setrecursionlimit, stdin
setrecursionlimit(1000000)
input = stdin.readline
n = int(input().rstrip())
tree = [[] for _ in range(n+1)]
for _ in range(n-1):
    n1, n2 = [int(x) for x in input().rstrip().split()]
    tree[n1].append(n2)
    tree[n2].append(n1)

early = set()
visited = set()
def dfs(n):
    global tree, early, visited
    visited.add(n)
    if len(tree[n]) <= 1:
        return True 
    for i in tree[n]:
        if not i in visited:
            if dfs(i):
                early.add(n)
            elif not i in early:
                early.add(n)
    return False 

for i, start in enumerate(tree):
    if len(start) > 1:
        dfs(i)
        break

if n==2:
    print(1)
else:
    print(len(early))