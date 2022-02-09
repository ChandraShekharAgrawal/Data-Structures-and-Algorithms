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

public class Pattern3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            for(int j = n-i-1; j>=0; j--){
                System.out.print('*');
            }
            if(i!=n-1)
                System.out.println();
        }
    }
}
