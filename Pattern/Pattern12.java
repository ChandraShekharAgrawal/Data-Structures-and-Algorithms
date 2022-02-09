// Print the following pattern for given n

/*

12.  * * * * *
      * * * *
       * * *
        * *
         *
         *
        * *
       * * *
      * * * *
     * * * * *

 */

// My Solution (Java)

import java.util.Scanner;

public class Pattern12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // print upper half first
        for(int i=1; i<=n; i++){
            // first print space
            for(int j =1; j<=i-1; j++){
                System.out.print(" ");
            }
            // print *
            for(int j=0; j<=n-i; j++){
                if(j!= n-i)
                    System.out.print("* ");
                else
                    System.out.print("*");
            }
            // print space
            for(int j=1; j<=i-1; j++){
                System.out.print(" ");
            }
            //if(i!=n)
            System.out.println();
        }

        // print lower half
        for(int i=1; i<=n; i++){
            // break solution into 3 parts - space, *, space
            // first print space
            for(int j = n-i; j>0; j--){
                System.out.print(" ");
            }
            // print *
            for(int j=1; j<=i; j++){
                if(j!=i)
                    System.out.print('*'+ " ");
                else
                    System.out.print('*');
            }
            // print space
            for(int j = n-i; j>0; j--){
                System.out.print(" ");
            }
            if(i!=n)
                System.out.println();
        }
    }
}
