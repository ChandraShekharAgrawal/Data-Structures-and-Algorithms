// Print the following pattern for given n

/*

    *
   **
  ***
 ****
*****

*/

// My Solution (Java)

import java.util.Scanner;

public class Pattern6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // in first row, n-i spaces and then * to print
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            if(i!=n)
                System.out.println();
        }
    }
}
