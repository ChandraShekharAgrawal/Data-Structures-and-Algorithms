// Print the following pattern for given n

/*

*****
 ****
  ***
   **
    *

*/

// My Solution (Java)

import java.util.Scanner;

public class Pattern7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1; i<=n; i++){
            // print i-1 spaces and n-i+1 *
            for(int j=1; j<= i-1; j++){
                System.out.print(" ");
            }
            for(int j=1; j<= n-i+1; j++){
                System.out.print("*");
            }
            if(i!=n)
                System.out.println();
        }
    }
}
