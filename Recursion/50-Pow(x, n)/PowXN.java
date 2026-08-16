class Solution {
    public double myPow(double x, int n) {
        
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return helper(x, N);
    }

    private double helper(double x, long n) {

        // Base case
        if (n == 0) {
            return 1;
        }

        // Recursive call
        double half = helper(x, n / 2);

        // Even power
        if (n % 2 == 0) {
            return half * half;
        }

        // Odd power
        else {
            return half * half * x;
        }
    }
}
//     if(n==0){
//         return 1;
//     }
//     int xnm1 =mypow(x ,n-1);
//     int xn = x * xnm1;
//     return xn;
//     }
// }