from sys import stdin
input = lambda: stdin.readline().rstrip()

N = int(input())
res = list(filter(lambda t: t[0] <= t[1], ((A, B) for A, B in (map(int, input().split()) for _ in range(N)))))
print(-1 if not res else min(res, key=lambda x: x[1])[1])