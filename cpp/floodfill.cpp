#include<vector>
using namespace std;
class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
         if(image.size() && image[sr][sc]!=newColor)
         {
             color(image, sr, sc, newColor, image[sr][sc]);
         }
        
        return image;
    }
    
    void color(vector<vector<int>>&image, int sr, int sc, int newColor, int originalColor){
                
        if( sr < 0 || sc < 0 || sr >= image.size() || sc >= image[0].size())
        {
            return;
        }        
        if(image[sr][sc] != originalColor){
            return;
        }

        image[sr][sc] = newColor;
        
        color(image, sr + 1, sc, newColor, originalColor);
        color(image, sr - 1, sc, newColor, originalColor);
        color(image, sr, sc + 1, newColor, originalColor);
        color(image, sr, sc - 1, newColor, originalColor);
        
    }
};