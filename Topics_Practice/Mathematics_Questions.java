import java.sql.SQLOutput;

public class Mathematics_Questions {

    // question was that tell given number is prime or not
    static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        int c = 2; // initialize the first divider is 2
        while (c * c <= number) {
            if (number % c == 0) {
                return false;
            }
            c++;
        }
        return true;
    }

    // question was that find the all prime numbers with given range
    static void printAllPrime(int range) {
        for (int i = 1; i <= range; i++) {
            boolean isPrimebool = true;
            for (int c = 2; c < i; c++) {
                if (i % c == 0) {
                    isPrimebool = false;
                }
            }
            if (isPrimebool) {
                System.out.print(i + " ");
            }
        }
    }

    // question was that find the value of sqrt of given number
    // int n = 40 ;
    // output will be :- 6.32;
    static double findSqrt(int n, int precision) {
        int start = 0;
        int end = n;
        while (start <= end) {


            int mid = start + (end - start) / 2;

            if (mid * mid == n) {
                return mid;
            } else if (mid * mid > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        double root = 0.0;
        double increment = 0.1;

        for (int i = 0; i < precision; i++) {
            while (root * root <= n) {
                root += increment;
            }

            root -= increment;
            increment /= 10;
        }

        return root;
    }

    // question was that find the all factors of given number
    // int n = 20 ;
    // output will be :- 1 , 2, 4 ,5, 10 ,20

    static void findFactors1(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
    }


    static void findFactors2(int n) {
        for (int i = 1; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    System.out.print(i + " ");
                } else {
                    System.out.print(i + " " + n / i + " ");
                }
            }
        }
    }

    // next question is find the GCD of given number , A GCD is a measure of the largest integer that divides both numbers without leaving a remainder.
    static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;

    } // we can use recursive approach also for this , here's recursive approach that we did

    static int recursiveFindGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return recursiveFindGCD(b, a % b);
        }
    }

    // question that find the lcm of given number
    // to achieve this first initialize the maximum value of both numbers into our lcm variable then we continuously check if this lcm is easily divisible by both numbers then it is the answer of our question otherwise increment the value of lcm and then check again
    static void findLCM(int a, int b) {
        int lcm = (a > b) ? a : b;
        while (true) {
            if (lcm % a == 0 && lcm % b == 0) {
                System.out.println("the lcm of this number is " + lcm);
                break;
            }
            lcm++;
        }
    }

    // one more way to find the lcm by formula
    static void findLCMbyFormula(int a, int b) {
        int lcm = a * b / findGCD(a, b);
        System.out.println("the lcm value is " + lcm);
    }


    public static void main(String[] args) {
        int a = 31;
//        System.out.println(isPrime(a));

//        printAllPrime(40);
        double answer = findSqrt(40, 3);
//        System.out.printf("the value of sqrt of the number is : %.3f", answer);
//        findFactors1(20);
//        findFactors2(20);
        int result = findGCD(48, 18);
//        System.out.println(result);
//        System.out.println("the GCD of given number is :- " + recursiveFindGCD(48 , 18));
//        findLCM(9, 18);
//        findLCMbyFormula(9 , 18);
    }



}
