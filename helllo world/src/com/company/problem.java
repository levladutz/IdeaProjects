package com.company;

public class problem {
    public static int sum(int n) {
        int s = 0;
        while (n > 0) {
            s += n % 10;
            n /= 10;
        }
        return s;
    }

    public static int rec(int n, int i) {
        if (n < 0 || n == 1 || n % sum(n) != 0 || sum(n) == 1)
            return i;
        return rec(n / sum(n), i + 1);
    }
}
