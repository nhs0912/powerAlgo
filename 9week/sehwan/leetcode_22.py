class Solution(object):
	def helper(self, currOpen, numToClose, soFar):
		if numToClose == 0:
			if currOpen != 0:
				return
			self.answerList.append(soFar)
			return

		if currOpen < self.maxOpen:
			self.helper(currOpen + 1, numToClose, soFar + '(')
		if currOpen > 0:
			self.helper(currOpen - 1, numToClose - 1, soFar + ')')

	def generateParenthesis(self, n):
		"""
		:type n: int
		:rtype: List[str]
		"""
		self.answerList = []
		self.maxOpen = n
		self.helper(0, n, '')
		return self.answerList
