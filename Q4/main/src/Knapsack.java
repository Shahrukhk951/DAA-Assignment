import java.util.Scanner;

public class Knapsack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of items
        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        // Input maximum weight capacity
        System.out.print("Enter the maximum weight capacity: ");
        int W = scanner.nextInt();

        int[] weights = new int[n];
        int[] values = new int[n];

        // Input weights and values
        System.out.println("Enter the weight and value for each item:");
        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + " weight: ");
            weights[i] = scanner.nextInt();
            System.out.print("Item " + (i + 1) + " value: ");
            values[i] = scanner.nextInt();
        }

        int result = knapSack(W, weights, values, n);
        System.out.println("Maximum value in Knapsack = " + result);
    }

    static int knapSack(int W, int[] wt, int[] val, int n) {
        int[][] K = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        // Print the table for better understanding
        System.out.println("Dynamic Programming Table:");
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                System.out.print(K[i][w] + " ");
            }
            System.out.println();
        }

        // Print selected items
        int res = K[n][W];
        System.out.println("Selected items:");
        int w = W;
        for (int i = n; i > 0 && res > 0; i--) {
            if (res == K[i - 1][w])
                continue;
            else {
                System.out.print("Item " + i + " (weight: " + wt[i - 1] + ", value: " + val[i - 1] + ") ");
                res -= val[i - 1];
                w -= wt[i - 1];
            }
        }
        System.out.println();

        return K[n][W];
    }
}
