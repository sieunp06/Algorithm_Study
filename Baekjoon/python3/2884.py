hour, min = input().split()

hour = int(hour)
min = int(min)

min -= 45

if min < 0:
    hour -= 1
    min += 60
    if hour < 0:
        hour += 24

print(hour, min)