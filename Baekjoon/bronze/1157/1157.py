# 1157 단어 공부
text = input().upper()
text_1 = list(set(text))
counts = []

for i in text_1:
    count = text.count(i)
    counts.append(count)
    
if counts.count(max(counts)) >= 2:
    print('?')
else:
    print(text_1[(counts.index(max(counts)))])
