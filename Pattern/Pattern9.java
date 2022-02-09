// Print the following pattern for given n

/*

  *********
   *******
    *****
     ***
      *

*/

// My Solution (Java)

import java.util.Scanner;

public class Pattern9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // break in 4 parts
        for(int i=1; i<=n; i++){
            //print first half of space
            for(int j=1; j<=i-1; j++){
                System.out.print(" ");
            }
            // print first half of *
            for(int j = 0; j<=n-i; j++){
                System.out.print("*");
            }
            // print second half of *
            for(int j=1; j<=n-i; j++){
                System.out.print("*");
            }
            // print second half of space
            for(int j = 1; j<i; j++){
                System.out.print(" ");
            }
            if(i!=n)
                System.out.println();
        }
    }
}
