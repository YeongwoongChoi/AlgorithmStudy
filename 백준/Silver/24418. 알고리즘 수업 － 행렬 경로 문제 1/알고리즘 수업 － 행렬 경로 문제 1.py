from sys import stdin
from math import comb
input = stdin.readline
n = int(input())
for _ in range(n):
    input()

print(comb(2 * n, n), n * n)