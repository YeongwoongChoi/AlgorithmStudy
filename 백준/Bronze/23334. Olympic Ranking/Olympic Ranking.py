from sys import stdin
input = lambda: stdin.readline().rstrip()

N = int(input())
print(max(((int(g), int(s), int(b), ' '.join(_)) for g, s, b, *_ in (input().split() for _ in range(N))),
          key=lambda t: (t[0], t[1], t[2]))[-1])