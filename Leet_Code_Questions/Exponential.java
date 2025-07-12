package Leet_Code_Questions;

// Question - 50 ( Pow(x, n) )
public class Exponential {

    public static double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double result = 1;
        while (N > 0) {
            if ((N % 2) == 1) {
                result *= x;
            }
            x *= x;
            N = N / 2;
        }
        return result;
    }


    public static void main(String[] args) {
        double x = 2;
        System.out.println(myPow(x, 3));
    }

}
