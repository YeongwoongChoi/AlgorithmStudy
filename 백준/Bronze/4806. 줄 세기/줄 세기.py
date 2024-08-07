from sys import stdin
print(sum(1 for _ in map(str.rstrip, stdin.readlines())))