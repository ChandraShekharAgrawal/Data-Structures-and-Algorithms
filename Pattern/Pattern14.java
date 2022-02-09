// Print the following pattern for given n

/*

14.  *********
      *     *
       *   *
        * *
         *

 */
 
 // My Solution (Java)
 
import java.util.Scanner;

public class Pattern14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1; i<= 2*n-1; i++){
            System.out.print("*");
        }
        if(n>1){
            System.out.println();
        }

        for(int i=1; i<=n-1; i++){
            // print space
            for(int j =1; j<=i; j++){
                System.out.print(" ");
            }
            // print *
            System.out.print("*");
            // print space
            for(int j=1; j<= 2*(n-i-1)-1; j++){
                System.out.print(" ");
            }
            // print *
            if(i!=n-1)
                System.out.print("*");
            // print space

            for(int j=1; j<=i-1; j++){
                System.out.print(" ");
            }
            if(i!=n-1)
                System.out.println();
        }
    }

}
