// Print the following pattern for given n

/*

*
**
***
****
*****
****
***
**
*

*/

// My Solution (Java)

import java.util.Scanner;

public class Pattern5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // first print upper half
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                if(j!=i)
                    System.out.print('*'+ " ");
                else
                    System.out.print('*');
            }
            //if(i!=n)
            System.out.println();
        }

        // now print remaining part n-1 decreasing
        for(int i=1; i<=n-1; i++){
            for(int j = n-i; j>=1; j--){
                if(j!= 1)
                    System.out.print('*'+ " ");
                else
                    System.out.print('*');
            }
            if(i!= n-1)
                System.out.println();
        }
    }
}
