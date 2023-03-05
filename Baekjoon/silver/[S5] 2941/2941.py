# 2941 크로아티아 알파벳
text = input()
list = ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="]

for j in list:
    if text.find(j) != -1:
        text = text.replace(text[text.find(j):text.find(j) + len(j)], '!')

print(len(text))
