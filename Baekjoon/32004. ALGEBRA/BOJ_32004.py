from sys import stdin
input = lambda: stdin.readline().rstrip()

N = int(input())
A, B = map(int, input().split())

arrays = []
arrayLength = []
totalElements = 0
for _ in range(N):
    M, *arr = map(int, input().split())
    totalElements += M
    arrayLength.append(M)
    arrays.append(arr)

sumOfElements = sum({*arrays[A - 1]} & {*arrays[B - 1]})
maxLength = max(arrayLength)
for i in range(N):
    for _ in range(arrayLength[i], maxLength):
        arrays[i].append(0)

res = [max(*_) for _ in zip(*arrays)]

print(totalElements)
print(sumOfElements)
print(*res)
