from sys import stdin
for _ in map(float, stdin.readlines()[:-1]):
    print(f"Objects weighing {_:.2f} on Earth will weigh {_ * 0.167:.2f} on the moon.")