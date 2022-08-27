# 1009 분산처리

t = int(input())
for _ in range(t):
	a,b = map(int,input().split())
	aa=a%10

	if aa == 0: # 패턴 1
		print(10)
	elif aa in [1,5,6]: 
		print(aa)
	elif aa in [4,9]: #패턴 2
		bb=b%2
		if bb == 0:
			print(aa*aa%10)
		else:
			print(aa)
	else: #패턴 4
		bb=b%4  
		if bb ==0:
			print(aa**4%10)
		else:
			print(aa**bb%10)
