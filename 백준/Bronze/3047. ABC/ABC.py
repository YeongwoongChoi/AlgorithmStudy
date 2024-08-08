ans = sorted(map(int, input().split()))
print(' '.join(str(ans[ord(c) - 65]) for c in input()))