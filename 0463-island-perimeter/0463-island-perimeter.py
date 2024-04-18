class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        ans = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==1:
                    p = 4
                    # if we have a land above we have to subtract two edges
                    # 1st will be of above's land and second will be of curr land
                    if 0<=i-1 and grid[i-1][j]==1:
                        p -= 2
                    # if we have a land to left we have to subtact 2edges
                    # 1st is left connected edge and 2nd wwill be cuur land connectd with left land
                    if j-1>=0 and grid[i][j-1]==1:
                        p -= 2
                    ans += p
        return ans