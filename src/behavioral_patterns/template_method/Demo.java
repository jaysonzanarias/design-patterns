package behavioral_patterns.template_method;

import behavioral_patterns.template_method.networks.Facebook;
import behavioral_patterns.template_method.networks.Network;
import behavioral_patterns.template_method.networks.Twitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Demo class. Everything comes together here.
 * https://refactoring.guru/design-patterns/template-method/java/example
 * Output:
 * Input user name: J
 * Input password: Z
 * Input message: Hello, JZ!
 *
 * Choose social network for posting message.
 * 1 - Facebook
 * 2 - Twitter
 * 1
 *
 * Checking user's parameters
 * Name: J
 * Password: *
 * ..........
 *
 * LogIn success on Facebook
 * Message: 'Hello, JZ!' was posted on Facebook
 * User: 'J' was logged out from Facebook
 *
 * Process finished with exit code 0
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Network network = null;
        System.out.print("Input user name: ");
        String userName = reader.readLine();
        System.out.print("Input password: ");
        String password = reader.readLine();

        // Enter the message.
        System.out.print("Input message: ");
        String message = reader.readLine();

        System.out.println("\nChoose social network for posting message.\n" +
                           "1 - Facebook\n" +
                           "2 - Twitter");
        int choice = Integer.parseInt(reader.readLine());

        // Create proper network object and send the message.
        if (choice == 1) {
            network = new Facebook(userName, password);
        } else if (choice == 2) {
            network = new Twitter(userName, password);
        }
        network.post(message);
    }
}