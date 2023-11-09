n, x = map(int, input().split())
while n:
    x -= int(input())
    n -= 1

print("Jebb" if x >= 0 else "Neibb")
