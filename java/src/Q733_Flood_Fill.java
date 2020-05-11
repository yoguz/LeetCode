public class Q733_Flood_Fill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        helper(image, sr, sc, image[sr][sc],-1);
        image[sr][sc] = -1;
        helper(image, sr, sc, -1, newColor);
        image[sr][sc] = newColor;

        return image;
    }

    private void helper(int[][] image, int x, int y, int oldColor, int newColor) {
        if (x > 0 && oldColor == image[x-1][y]) {
            image[x-1][y] = newColor;
            helper(image, x-1, y, oldColor, newColor);
        }
        if (y > 0 && oldColor == image[x][y-1]) {
            image[x][y-1] = newColor;
            helper(image, x, y-1, oldColor, newColor);
        }
        if (x < image.length-1 && oldColor == image[x+1][y]) {
            image[x+1][y] = newColor;
            helper(image, x+1, y, oldColor, newColor);
        }
        if (y < image[0].length-1 && oldColor == image[x][y+1]) {
            image[x][y+1] = newColor;
            helper(image, x, y+1, oldColor, newColor);
        }
    }

    public static void main(String[] args) {
        Q733_Flood_Fill obj = new Q733_Flood_Fill();
        int[][] mtx = new int[][] {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };

        int[][] mtxNew = obj.floodFill(mtx, 1, 1, 2);
        for (int i = 0; i < mtxNew.length; ++i) {
            for (int j = 0; j < mtxNew[i].length; ++j) {
                System.out.print(mtxNew[i][j] + " ");
            }
            System.out.println();
        }
    }
}
