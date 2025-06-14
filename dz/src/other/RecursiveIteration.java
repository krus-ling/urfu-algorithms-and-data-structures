package other;

/// Рекурсивный перебор
import java.util.Scanner;


public class RecursiveIteration {

    static char[] c;

    /**
     * Перебор. Если x == n выходит из цикла и выводит комбинацию,
     * иначе рекурсивно переходим к следующему элементу
     * @param x Указатель на элемент
     * @param n Размер массива
     */
    public static void gen(int x, int n) {
        if (x == n) {
            System.out.println(c);
            return;
        }
        for (c[x] = 'a'; c[x] <= 'z'; c[x]++) {

            // Дополнительно: чтобы 2 одинаковых элемента не стояли подряд
            if (x > 0) {
                if (c[x] == c[x - 1]) continue;
            }

            gen(x + 1, n);
        }
    }

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите число: ");
            int n = scanner.nextInt();
            c = new char[n];
            gen(0, n);
        }
    }
}
