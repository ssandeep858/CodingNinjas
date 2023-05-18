import java.util.*;

public class SpecialPattern2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int numOfRows=sc.nextInt();
        int row=1;
        while(row<=numOfRows){
            int col=1;
            int p=1;
            while(col<=numOfRows){
                if(col>numOfRows-row){
                    System.out.print(p);
                    p++;
                }else
                System.out.print(" ");
                col++;
            }
            System.out.println("");
            row++;
        }
    }
    
}
