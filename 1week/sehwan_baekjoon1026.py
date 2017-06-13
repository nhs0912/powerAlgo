n = input()
n = int(n)
A = input().split(' ')
A = [int(x) for x in A]
B = input().split(' ')
B = [int(x) for x in B]
C = [x for x in B]

A.sort()
C.sort(reverse=True)

product = [A[x]*C[x] for x in range(n)]
print (sum(product))