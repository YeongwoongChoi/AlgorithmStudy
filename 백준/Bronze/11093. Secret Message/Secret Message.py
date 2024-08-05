from sys import stdin
from math import sqrt, ceil

input = lambda: stdin.readline().rstrip()

N = int(input())
for _ in range(N):
    s = input()
    L = len(s)
    K = ceil(sqrt(L))
    s = s.ljust(K * K, '*')
    M = [[s[j] for j in range(i, i + K)] for i in range(0, K * K, K)]

    res = ""
    for _ in zip(*reversed(M)):
        for c in _:
            if c == '*':
                continue
            res += c
    print(res)