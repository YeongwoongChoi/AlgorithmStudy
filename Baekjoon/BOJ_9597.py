from bisect import bisect_left
from collections import Counter
from sys import stdin

_PARAGRAPH = ('<text>', '</text>')
_QUERY = '<top'

paragraphStart = []     # inclusive
paragraphEnd = []       # exclusive
queryLine = []          # (line #, N)
lines = []

for i, _ in enumerate(map(str.rstrip, stdin.readlines())):
    if _.startswith(_QUERY):
        queryLine.append((i, int(_.split()[1])))
    line = [w for w in _.split() if len(w) >= 4]
    if line:
        if line[0] == _PARAGRAPH[0]:
            paragraphStart.append(i + 1)
        elif line[0] == _PARAGRAPH[1]:
            paragraphEnd.append(i)
    lines.append(line)

for q in queryLine:
    count = Counter()
    day = bisect_left(paragraphStart, q[0])
    for d in range(max(0, day - 7), day):
        for _ in range(paragraphStart[d], paragraphEnd[d]):
            for w in lines[_]:
                count[w] += 1
    topN = count.most_common(q[1]).pop()[-1]
    print(f"{lines[q[0]][0]} {q[1]}>")
    for k, v in sorted(count.items(), key=lambda x: (-x[1], x[0])):
        if v >= topN:
            print(f"{k} {v}")
    print("</top>")
