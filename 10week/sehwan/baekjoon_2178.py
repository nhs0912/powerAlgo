from queue import Queue

class Point:
    def __init__(self, x, y, breakNumLeft):
        self.x = x
        self.y = y
        self.breakNumLeft = breakNumLeft

class Main:
    def __init__(self):
        self.moves = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        self.width, self.height = [int(x) for x in input().split()]
        self.maxBreak = 0
        
        self.wallMap = []
        for _ in range(self.width):
            line = input()
            self.wallMap.append([int(digit) for digit in line])

    def getShortestPath(self):
        minDistMap = {}

        q = Queue()
        q.put(Point(0, 0, self.maxBreak))
        minDistMap[(0, 0, self.maxBreak)] = 1

        while not q.empty():
            curr = q.get()
            altDist = minDistMap[(curr.x, curr.y, curr.breakNumLeft)] + 1

            for move in self.moves:
                nX = curr.x + move[0]
                nY = curr.y + move[1]

                if nX < 0 or nY < 0 or nX >= self.width or nY >= self.height:
                    continue

                if self.wallMap[nX][nY] == 1:
                    if (nX, nY, curr.breakNumLeft) not in minDistMap:
                        minDistMap[(nX, nY, curr.breakNumLeft)] = altDist
                        q.put(Point(nX, nY, curr.breakNumLeft))
                elif curr.breakNumLeft > 0:
                    if (nX, nY, curr.breakNumLeft - 1) not in minDistMap:
                        minDistMap[(nX, nY, curr.breakNumLeft - 1)] = altDist
                        q.put(Point(nX, nY, curr.breakNumLeft - 1))

        flag = False
        retval = float('inf')
        for i in range(self.maxBreak + 1):
            if (self.width - 1, self.height - 1, i) in minDistMap:
                retval = min(retval, minDistMap[(self.width - 1, self.height - 1, i)])
                flag = True

        if not flag:
            retval = -1

        return retval

if __name__ == '__main__':
    main = Main()
    print(main.getShortestPath())