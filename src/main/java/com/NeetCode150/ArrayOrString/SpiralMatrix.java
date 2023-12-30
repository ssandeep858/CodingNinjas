/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.ArrayOrString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ssingh
 */
public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        int rowStart = 0;
        int rowEnd = matrix.length-1;
        int colStart=0;
        int colEnd=matrix[0].length-1;
        int count=0;
        while(count<matrix[0].length*matrix.length){
            
            for(int i=colStart;i<=colEnd;i++){
                res.add(matrix[rowStart][i]);
                count++;
            }
            rowStart++;
            
            if(count>=matrix[0].length*matrix.length){
                break;
            }
            for(int i=rowStart;i<=rowEnd;i++){
                res.add(matrix[i][colEnd]);
                count++;
            }
            colEnd--;
            if(count>=matrix[0].length*matrix.length){
                break;
            }
            
            for(int i=colEnd;i>=colStart;i--){
                res.add(matrix[rowEnd][i]);
                count++;
            }
            rowEnd--;
            if(count>=matrix[0].length*matrix.length){
                break;
            }
            
            for(int i=rowEnd;i>=rowStart;i--){
                res.add(matrix[i][colStart]);
                count++;
            }
            colStart++;
            if(count>=matrix[0].length*matrix.length){
                break;
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[][] input={{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> res=spiralOrder(input);
        for( Integer i:res){
            System.out.println(i);
        }
    }

}
