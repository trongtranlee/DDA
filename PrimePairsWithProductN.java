package daa.project;
// Tìm tất cả các cặp số (a, b) sao cho a và b là số nguyên tố
// a*b có độ dài là n cho trước (n là một số nguyên dương)
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimePairsWithProductN {
    // Kiểm tra số nguyên tố
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Tìm tất cả các cặp số nguyên tố có tích có độ dài bằng n
    public static List<int[]> findPrimePairsWithProductN(int n) {
        List<int[]> primePairs = new ArrayList<int[]>();
        // Tính toán giá trị lớn nhất mà tích của hai số nguyên tố có độ dài bằng n
        int maxNumber = Integer.parseInt("9".repeat(n / 2 + n % 2));
        // Duyệt qua tất cả các số nguyên tố để tìm các cặp có tích có độ dài bằng n
        for (int a = 2; a <= maxNumber; a++) {
            if (!isPrime(a)) continue;
            for (int b = 2; b <= maxNumber; b++) {
                if (!isPrime(b)) continue;
                int product = a * b;
                if (String.valueOf(product).length() == n) {
                    primePairs.add(new int[]{a, b});
                }
            }
        }
        return primePairs; // Độ phức tạp O(n^2 log n)
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the product:");
        int n = sc.nextInt();
        // Tìm tất cả các cặp số nguyên tố có tích có độ dài bằng n
        List<int[]> primePairs = findPrimePairsWithProductN(n);
        // Hiển thị kết quả
        System.out.printf("Prime pairs with product of length %d:%n", n);
        if (primePairs.size() == 0) {
            System.out.println("No prime pairs found.");
        } else {
            primePairs.forEach(pair -> {
                System.out.printf("[%d, %d]%n", pair[0], pair[1]);
            });
        }
    }
}
