// Print the following pattern for given n

/*

    *
   ***
  *****
 *******
*********

*/

// My Solution (Java)

import java.util.Scanner;

public class Pattern8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // break in four parts - space, *, *, space

        for(int i=1; i<=n; i++){
            //print space in first half
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }
            // print first half of *
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            // print second half of *
            for(int j=0; j<i-1; j++){
                System.out.print("*");
            }
            // print second half of space
            for(int j= n-i; j>0; j--){
                System.out.print(" ");
            }
            if(i!=n)
                System.out.println();
        }

    }
}
