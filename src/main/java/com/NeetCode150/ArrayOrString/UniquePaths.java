/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.ArrayOrString;

/**
 *
 * @author ssingh There is a robot on an m x n grid. The robot is initially
 * located at the top-left corner (i.e., grid[0][0]). The robot tries to move to
 * the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move
 * either down or right at any point in time.
 *
 * Given the two integers m and n, return the number of possible unique paths
 * that the robot can take to reach the bottom-right corner.
 *
 * The test cases are generated so that the answer will be less than or equal to
 * 2 * 109.
 */
public class UniquePaths {

    // Failing solution 
    public static int uniquePaths(int m, int n, int sr, int ec) {
        if (sr == m - 1 && ec == n - 1) {
            return 1;
        } else if (sr == m || ec == n) {
            return 0;
        } else {
            return uniquePaths(m, n, sr, ec + 1) + uniquePaths(m, n, sr + 1, ec);
        }

    }

    public static int uniquePaths1(int m, int n) {
        return uniquePaths(m, n, 0, 0);

    }

    public static int uniquePaths(int m, int n) {
        int [][]dp=new int[m][n];
        
        for( int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0|| j==0){
                    dp[i][j]=1;
                }else{
                    // ya toh upar se neeche aaya ho koi 
                    // ya left wali position se right 
                    // ex: 1,1 pr aane ke 2 raste hai ek 0,1 se neeche aur dusra 1,0 se right
                    dp[i][j]=dp[i][j-1]+dp[i-1][j];
                }
            }
        }
        return dp[m-1][n-1];

    }

    public static void main(String[] args) {
        System.out.println(uniquePaths1(3, 7));
    }
}
