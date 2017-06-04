# your code goes here
from math import log

def minHeap(A):
    return all(A[i] >= A[(i - 1) // 2] for i in range(1, len(A)))
def maxHeap(A):
    return all(A[i] <= A[(i - 1) // 2] for i in range(1, len(A)))

n=int(raw_input())
while n!=0:
	data = map(int, raw_input().split(" "))
	if minHeap(data) or maxHeap(data):
		print("Yes")
	else:
		print("No")
	n=int(raw_input())
