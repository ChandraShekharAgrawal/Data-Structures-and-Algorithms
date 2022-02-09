// Print the following pattern for given n

/*

1
1 2
1 2 3
1 2 3 4
1 2 3 4 5

*/

// My Solution (Java)

import java.util.Scanner;

public class Pattern4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                if(j!=i){
                    System.out.print(j + " ");
                }
                else
                    System.out.print(j);
            }
            if(i!=n)
                System.out.println();
        }
    }
}
