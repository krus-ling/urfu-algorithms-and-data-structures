class Main {
    public static int f1(int x) {
        int count = 0;

        for (int i = 1; i <= 1_000_000_000; i++) {
            if (i % x == 0) count++;
        }

        return count;
    }

    public static int f2(int[] a) {
        int count = 0;

        for (int i : a) {
            if (i % 2 == 0) count++;
        }

        return count;
    }

    public static int f3(int x) {
        int count = 0;

        for (int i = 2; i * i <= x; i++) {
            while (x % i == 0) {
                x /= i;
            }
        }

        if (x > 1) {
            x /= x;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {

        int[] f2 = {2, 1, 4, 5, 6, 324, 23543, 435632453, 3452252, 12, 34, 43}; // 7 четных

        System.out.printf("f1 — %d\n", f1(11));
        System.out.printf("f2 — %d\n", f2(f2));
        System.out.printf("f3 — %d", f3(170464213));
    }
}