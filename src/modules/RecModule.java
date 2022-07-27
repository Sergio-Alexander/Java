package modules;

public class RecModule {
    public static int fac(int n) {
        if (n == 0){
            return 1;
        }
        return n * fac(n - 1);
    }

    public static boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        return isPalindromeRec(s.toCharArray(), 0, s.length() - 1);
    }

    public static boolean isPalindromeRec(char[] s, int l, int r){
        if(s[l] != s[r]){
            return false;
        }
        if(l > r){
            return true;
        }
        return isPalindromeRec(s, l + 1, r - 1);
    }

    public static double pow(double x, int n) {
        if (n == 0){
            return 1;
        }
        return x * pow(x, n - 1);
    }

    public static int sum(int n) {
        if (n <= 1){
            return n;
        }
        return n + sum(n - 1);
    }
}
