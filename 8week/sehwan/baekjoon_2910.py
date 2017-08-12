class Solution:
	def __init__(self):
		self.nums = [int(x) for x in input().split()]

	def sort(self):
		mydict = {}
		i = 0
		for num in self.nums:
			if num in mydict:
				mydict[num][0] += 1
			else:
				mydict[num] = [1, i]
				i += 1
		mydict = sorted(mydict.items(), key=lambda x: (-x[1][0], x[1][1]))
		answer = ''
		for num, occurence in mydict:
			for _ in range(occurence[0]):
				answer += str(num) + ' '

		return answer

if __name__ == '__main__':
	_, _ = [int(x) for x in input().split()]
	sol = Solution()
	print(sol.sort())
