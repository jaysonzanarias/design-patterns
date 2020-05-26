package behavioral_patterns.strategy;

import behavioral_patterns.strategy.order.Order;
import behavioral_patterns.strategy.strategies.PayByCreditCard;
import behavioral_patterns.strategy.strategies.PayByPayPal;
import behavioral_patterns.strategy.strategies.PayStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * World first console e-commerce application.
 * https://refactoring.guru/design-patterns/strategy/java/example
 * Output:
 * Please, select a product:
 * 1 - Mother board
 * 2 - CPU
 * 3 - HDD
 * 4 - Memory
 * 1
 * Count: 2
 * Do you wish to continue selecting products? Y/N: y
 * Please, select a product:
 * 1 - Mother board
 * 2 - CPU
 * 3 - HDD
 * 4 - Memory
 * 2
 * Count: 1
 * Do you wish to continue selecting products? Y/N: n
 * Please, select a payment method:
 * 1 - PalPay
 * 2 - Credit Card
 * 1
 * Enter the user's email: user@example.com
 * Enter the password: qwerty
 * Wrong email or password!
 * Enter the user's email: amanda@ya.com
 * Enter the password: amanda1985
 * Data verification has been successful.
 * Pay 6250 units or Continue shopping? P/C: p
 * Paying 6250 using PayPal.
 * Payment has been successful.
 *
 * Process finished with exit code 0
 */
public class Demo {
    private static Map<Integer, Integer> priceOnProducts = new HashMap<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Order order = new Order();
    private static PayStrategy strategy;

    static {
        priceOnProducts.put(1, 2200);
        priceOnProducts.put(2, 1850);
        priceOnProducts.put(3, 1100);
        priceOnProducts.put(4, 890);
    }

    public static void main(String[] args) throws IOException {
        while (!order.isClosed()) {
            int cost;

            String continueChoice;
            do {
                System.out.print("Please, select a product:" + "\n" +
                                 "1 - Mother board" + "\n" +
                                 "2 - CPU" + "\n" +
                                 "3 - HDD" + "\n" +
                                 "4 - Memory" + "\n");
                int choice = Integer.parseInt(reader.readLine());
                cost = priceOnProducts.get(choice);
                System.out.print("Count: ");
                int count = Integer.parseInt(reader.readLine());
                order.setTotalCost(cost * count);
                System.out.print("Do you wish to continue selecting products? Y/N: ");
                continueChoice = reader.readLine();
            } while (continueChoice.equalsIgnoreCase("Y"));

            if (strategy == null) {
                System.out.println("Please, select a payment method:" + "\n" +
                                   "1 - PalPay" + "\n" +
                                   "2 - Credit Card");
                String paymentMethod = reader.readLine();

                // Client creates different strategies based on input from user,
                // application configuration, etc.
                if (paymentMethod.equals("1")) {
                    strategy = new PayByPayPal();
                } else {
                    strategy = new PayByCreditCard();
                }

                // Order object delegates gathering payment data to strategy
                // object, since only strategies know what data they need to
                // process a payment.
                order.processOrder(strategy);

                System.out.print("Pay " + order.getTotalCost() + " units or Continue shopping? P/C: ");
                String proceed = reader.readLine();
                if (proceed.equalsIgnoreCase("P")) {
                    // Finally, strategy handles the payment.
                    if (strategy.pay(order.getTotalCost())) {
                        System.out.println("Payment has been successful.");
                    } else {
                        System.out.println("FAIL! Please, check your data.");
                    }
                    order.setClosed();
                }
            }
        }
    }
}