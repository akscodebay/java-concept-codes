import java.util.Scanner;

public class OnesZeros {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int K = sc.nextInt();

        if(L==K)
            System.out.println("0");
        else if (L==0)
            System.out.println("0");
        else if (K==0)
            System.out.println(L);
        else {
            if(K==1)
                System.out.println(L/2);
            else {
                System.out.println((L-K)/K);
            }
        }
        sc.close();
    }

} 