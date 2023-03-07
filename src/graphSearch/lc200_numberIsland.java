package graphSearch;

/*
* implement dfs method
* time:O(n)
* space:O(n)
*
* base case: check for boundary, and check if has been visited, and check if the current node if is '0'
* sup - problem: check for 4 direction to see if the number is 1
* */
public class lc200_numberIsland {
    public int numIslands(char[][] grid) {
        //coner case
        if (grid == null || grid.length == 0){
            return 0;
        }
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1' && !visited[i][j]){ //the current node is equal to "1", and never been visited
                    helper(grid, i, j, visited); //if this is true，then count as 1 island
                    count++;
                }
            }
        }
        return count;
    }
    private void helper(char[][] grid, int row, int col, boolean[][] visited){
        //base case, check for boundary, and check if has been visited, and check if the current node if is '0'
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] || grid[row][col] == '0'){
            return;
        }
        visited[row][col] = true;
        helper(grid, row + 1, col, visited);
        helper(grid, row - 1, col, visited);
        helper(grid, row, col + 1, visited);
        helper(grid, row, col - 1, visited);
    }
}

/**
 this grid consider as a map, each vertex is a node as "1" or "0", and the edges is the neighboard,
 traverse every vertex in this map, if the current node connect with it neighboard "1", count as island, until
 the 4 direction sorrounded with water(0)

 if see "1", keep look up the 4 direction
 if see "0" invalid
 */
