T = int(input())
total_text = ""

for i in range(T):
    count, text = input().split()
    for j in range(len(text)):
        total_text += text[j] * int(count)
    print(total_text)
    total_text = ""