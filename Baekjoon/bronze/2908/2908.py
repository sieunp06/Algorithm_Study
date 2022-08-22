# 2908 상수
num1, num2 = input().split()

num1 = num1[::-1]
num2 = num2[::-1]

if num1 < num2:
    print(num2)
else:
    print(num1)