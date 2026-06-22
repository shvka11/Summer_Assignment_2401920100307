
import java.util.ArrayList;
import java.util.List;


public class Day_4 {
  //Question 1
  public int diagonalSum(int[][] mat) {
        int sum =0;
        for(int i=0; i<mat.length; i++){
            if(i != mat.length-i-1){
                sum += mat[i][mat.length-i-1];
            }
            sum+= mat[i][i];
        }
        return sum;
    }
  //Question 2
  public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if(m*n != r*c){
            return mat;
        }
        int res[][] = new int[r][c];
        int u=0, v=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(v == c){
                    v=0;
                    u++;
                }
                if(u == r){
                    return res;
                }
                res[u][v] = mat[i][j];
                v++;
            }
        }
        return res;
    }
// Question 3
   public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int rs =0, re = matrix.length-1 , cs = 0 , ce = matrix[0].length-1;
        while(rs <= re && cs <= ce){
            for(int i=cs; i<=ce; i++){
                res.add(matrix[rs][i]);
            }
            rs++;
            if(rs > re) return res;

            for(int i =rs; i<= re; i++){
                res.add(matrix[i][ce]);
            }
            ce--;
            if(cs > ce) return res;
            for(int i = ce; i>=cs; i--){
                res.add(matrix[re][i]);
            }
            re--;
            if(rs > re) return res;

            for(int i = re; i>= rs; i--){
                res.add(matrix[i][cs]);
            }
            cs++;
            if(cs > ce) return res;
        }
        return res;
    }
}
