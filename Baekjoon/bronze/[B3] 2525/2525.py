hour, min = input().split()
time = int(input())

hour = int(hour)
min = int(min)

min += time

if min >= 60:
    while(min >= 60):
        hour += 1
        min -= 60
        if hour >= 24:
           hour -= 24

print(hour, min)
