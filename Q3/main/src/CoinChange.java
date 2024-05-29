import java.util.HashMap;
import java.util.Map;

public class CoinChange {

    public static void main(String[] args) {
        int amount = 1988;
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 1000}; // Pakistani Rupee denominations
        Map<Integer, Integer> result = coinChange(coins, amount);
        System.out.println("Coin change for " + amount + " is:");
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " x " + entry.getValue());
        }
    }

    public static Map<Integer, Integer> coinChange(int[] coins, int amount) {
        Map<Integer, Integer> coinCount = new HashMap<>();
        for (int i = coins.length - 1; i >= 0; i--) {
            if (amount >= coins[i]) {
                int count = amount / coins[i];
                coinCount.put(coins[i], count);
                amount -= count * coins[i];
            }
        }
        return coinCount;
    }
}
