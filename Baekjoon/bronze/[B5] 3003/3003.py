# 체스 피스, 순서대로 킹 1개, 퀸 1
chess = [1, 1, 2, 2, 2, 8]
nums = list(map(int, input().split()))

for i in range (0,6):
    print(chess[i] - nums[i], end=' ')
