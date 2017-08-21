if __name__ == '__main__':
	value_dict = {}
	nums = []
	num_count = int(input())
	for i in range(num_count):
		nums.append(input())

	for num in nums:
		l = len(num) - 1
		for char in num:
			if char in value_dict:
				value_dict[char] += 10**l
			else:
				value_dict[char] = 10**l
			l -= 1

	sorted_value = sorted(value_dict.items(), key=lambda x: x[1])
	sorted_value.reverse()

	answer = 0
	multiplier = 9
	for value in sorted_value:
		answer += value[1] * multiplier
		multiplier -= 1

	print(answer)