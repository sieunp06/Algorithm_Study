C = int(input())

for i in range(C):
    total = 0
    num = 0
    nums = list(map(int, input().split()))
    N = nums[0]
    for j in range (1, len(nums)):
        total += nums[j]
    avg = total / N
    for k in range(1, len(nums)):
        if nums[k] > avg:
            num += 1
    print("{:.3f}%".format(num / N * 100))