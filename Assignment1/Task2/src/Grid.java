import java.util.Random;

public class Grid {
    public static void main(String[] args) {

        Grid grid = new Grid();
        int[][] gridWithPath = {
                {2, 1, 2},
                {3, 1, 1},
                {1, 2, 1}
        };
        int[][] gridWithPath2 = {
                {2, 1, 1, 1},
                {3, 1, 1, 2},
                {1, 2, 1, 2},
                {1, 3, 1, 2}
        };

        int[][] gridWithoutPath = {
                {2, 1, 3},
                {3, 1, 1},
                {3, 1, 1}
        };
        int[][] gridWithoutPath2 = {
                {3, 1, 3, 4},
                {3, 1, 1,3},
                {3, 1, 1,2},
                {4, 1, 1,2}
        };


        System.out.println("\nMy examples:");
        System.out.println("\nGrid with Path:");
        grid.testGrid(gridWithPath);
        System.out.println("\nGrid 2 with Path:");
        grid.testGrid(gridWithPath2);

        System.out.println("\nGrid without Path:");
        grid.testGrid(gridWithoutPath);
        System.out.println("\nGrid without Path 2:");
        grid.testGrid(gridWithoutPath2);

        // Test the traverseGrid method with randomly generated grids
        for (int i = 0; i < 3; i++) {
            int n = new Random().nextInt(7) + 3; // Random grid size between 3 and 9
            int[][] randomGrid = grid.generateGrid(n);
            System.out.println("\nRandom Grid " + (i + 1) + ":");
            grid.testGrid(randomGrid);
        }

    }

    public Grid()
    {

    }
    public void testGrid(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid.length];
        boolean pathExists = traverseGrid(grid, visited, 0, 0,-1,-1);
        if (pathExists) {
            System.out.println("Path exists!");
            printGridWithDirection(grid, visited);
        } else {
            System.out.println("No path exists.");
            printGrid(grid);
        }
    }

    public boolean traverseGrid(int[][] grid, boolean[][] visited, int row, int col, int prevRow, int prevCol) {
        int n = grid.length;


        if (row < 0 || row >= n || col < 0 || col >= n || visited[row][col]) {
            return false;
        }

        if (row == n - 1 && col == n - 1) {
            visited[row][col] = true;
            return true;
        }

        // Mark current cell as visited
        visited[row][col] = true;


        int steps = grid[row][col];

        // Explore the right direction first if it's not the previous cell
        if (!(row == prevRow && col + steps == prevCol) && traverseGrid(grid, visited, row, col + steps, row, col)) { // Right
            return true;
        }

        // Explore other directions if right direction doesn't lead to the destination
        if (!(row - steps == prevRow && col == prevCol) && traverseGrid(grid, visited, row - steps, col, row, col)) { // Up
            return true;
        }
        if (!(row + steps == prevRow && col == prevCol) && traverseGrid(grid, visited, row + steps, col, row, col)) { // Down
            return true;
        }
        if (!(row == prevRow && col - steps == prevCol) && traverseGrid(grid, visited, row, col - steps, row, col)) { // Left
            return true;
        }

        // If no valid path found,mark current cell as not visited
        visited[row][col] = false;
        return false;
    }



    public void printGrid(int[][] grid) {
        for (int[] row : grid) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }




    public void printGridWithDirection(int[][] grid, boolean[][] visited) {
        int n = grid.length;
        char[][] directions = new char[n][n];

        int pathLength = 0;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    int steps = grid[i][j];
                    if (i - steps >= 0 && visited[i - steps][j]) {
                        directions[i][j] = 'U'; // Up
                    } else if (i + steps < n && visited[i + steps][j]) {
                        directions[i][j] = 'D'; // Down
                    } else if (j - steps >= 0 && visited[i][j - steps]) {
                        directions[i][j] = 'L'; // Left
                    } else if (j + steps < n && visited[i][j + steps]) {
                        directions[i][j] = 'R'; // Right
                    }
                    // Check if it's the bottom-right corner and mark it with a star
                    if (i == n - 1 && j == n - 1) {
                        directions[i][j] = '*'; // Star
                    }
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] && directions[i][j] != '*') {
                    pathLength += grid[i][j];
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    if (directions[i][j] == '*') {
                        System.out.print(grid[i][j] + "* ");
                    } else if (directions[i][j] == 'U') {
                        System.out.print(grid[i][j] + "U ");
                    } else if (directions[i][j] == 'D') {
                        System.out.print(grid[i][j] + "D ");
                    } else if (directions[i][j] == 'L') {
                        System.out.print(grid[i][j] + "L ");
                    } else if (directions[i][j] == 'R') {
                        System.out.print(grid[i][j] + "R ");
                    }
                } else {
                    System.out.print(grid[i][j] + " ");
                }
            }
            System.out.println();
        }


        System.out.println("Path Length: " + pathLength);
    }






    public int[][] generateGrid(int n) {
        int[][] grid = new int[n][n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = random.nextInt(n - 1) + 1;
            }
        }
        return grid;
    }
}
