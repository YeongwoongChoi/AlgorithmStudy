N = int(input())
K, t = 1, 0

while N:
    if N < K:
        K = 1
    N -= K
    K += 1
    t += 1

print(t)