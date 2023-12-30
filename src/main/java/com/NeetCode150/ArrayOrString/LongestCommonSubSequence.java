/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.ArrayOrString;

/**
 *
 * @author ssingh
 */
public class LongestCommonSubSequence {

    public static int longestCommonSubsequence(String text1, String text2) {
        
        // first row and column 0 hoga as empty string ka no LCS
        //    a b c d e f   
        //  0 0 0 0 0 0 0 
        //a 0 1 1 1 1 1 1
        //c 0 1 1 2 2 2 2 
        //e 0 1 2 2 2 3 3 
        int [][]dp=new int[text1.length()+1][text2.length()+1];
        
        for( int i = 1; i<=text1.length();i++ ){
            for(int j =1;j<= text2.length();j++){
                // minus 1 as starting from ahead in matrix case
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=1+ dp[i-1][j-1];  // 1 and peche ka diagonal element add
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
    
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }
}
