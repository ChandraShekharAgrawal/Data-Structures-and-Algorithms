// Print the following pattern for given n

/*

13.      *
        * *
       *   *
      *     *
     *********

 */

// My Solution (Java)

import java.util.Scanner;

public class Pattern13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1; i<=n-1; i++){
            // print space
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }
            System.out.print("*");
            // print middle spaces
            for(int j=1; j<= 2*(i-1)-1; j++){
                System.out.print(" ");
            }
            //print next *
            if(i!=1){
                System.out.print("*");
            }
            // print spaces
            for(int j=1; j<= n-i; j++){
                System.out.print(" ");
            }
            System.out.println();
        }
        for(int i=1; i<= 2*n-1; i++){
            System.out.print("*");
        }
    }
}
