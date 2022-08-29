# 2798 블랙잭 브론즈2

from itertools import combinations

N, M = map(int, input().split())
num = list(map(int, input().split()))
big_sum = 0

for i in combinations(num, 3):
    total = sum(i)
    if big_sum < total <= M:
        big_sum = total

print(big_sum)
