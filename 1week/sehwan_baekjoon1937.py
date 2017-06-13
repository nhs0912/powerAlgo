
def getPossiblePaths(bambooMap, n, x, y):

    possiblePaths = []
    if x-1 >= 0:
        if bambooMap[x-1][y] > bambooMap[x][y]:
            possiblePaths.append([x-1, y])

    if x+1 < n:
        if bambooMap[x+1][y] > bambooMap[x][y]:
            possiblePaths.append([x+1, y])

    if y-1 >= 0:
        if bambooMap[x][y-1] > bambooMap[x][y]:
            possiblePaths.append([x, y-1])

    if y+1 < n:
        if bambooMap[x][y+1] > bambooMap[x][y]:
            possiblePaths.append([x, y+1])

    return possiblePaths


def getMaxDays(bambooMap, maxDayMap, n, x, y):

    possiblePaths = getPossiblePaths(bambooMap, n, x, y)

    # base case
    if not possiblePaths:
        maxDayMap[x][y] = 1
        return maxDayMap

    possibleDays = []
    # recursive case
    for ax, ay in possiblePaths:
        if maxDayMap[ax][ay] == 0:
            maxDayMap = getMaxDays(bambooMap, maxDayMap, n, ax, ay)
        possibleDays.append(maxDayMap[ax][ay])

    maxDayMap[x][y] = max(possibleDays) + 1
    return maxDayMap

if __name__ == '__main__':

    # Read n
    n = input()
    # Change datatype from string to int
    n = int(n)

    bambooMap = []

    for i in range(n):
        # read one row of bamboo map at a time
        temp = input().split(' ')

        # exception handlers
        if '' in temp:
            temp.remove('')
        temp = [int(x) for x in temp]

        # add this row to the map
        bambooMap.append(temp)

    # initiate 0 2D matrix of size n x n
    maxDayMap = [[0 for i in range(n)] for j in range(n)]

    # A (x,y) tile of maxDayMap tells the max number of days a panda can stay alive
    # when it starts the adventure at (x,y) position.
    # calculate the whole map of 'maxDayMap'
    for i in range(n):
        for j in range(n):
            if maxDayMap[i][j] == 0:
                maxDayMap = getMaxDays(bambooMap, maxDayMap, n, i, j)

    # print the max value of maxDayMap
    print(max([max(foo) for foo in maxDayMap]))