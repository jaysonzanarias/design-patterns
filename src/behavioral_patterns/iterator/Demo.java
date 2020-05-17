package behavioral_patterns.iterator;

import behavioral_patterns.iterator.profile.Profile;
import behavioral_patterns.iterator.social_networks.Facebook;
import behavioral_patterns.iterator.social_networks.LinkedIn;
import behavioral_patterns.iterator.social_networks.SocialNetwork;
import behavioral_patterns.iterator.spammer.SocialSpammer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Demo class. Everything comes together here.
 *
 * https://refactoring.guru/design-patterns/iterator/java/example
 *
 * Output:
 * Please specify social network to target spam tool (default:Facebook):
 * 1. Facebook
 * 2. LinkedIn
 * 2
 *
 * Iterating over friends...
 *
 * LinkedIn: Loading 'friends' list of 'anna.smith@bing.com' over the network...
 * LinkedIn: Loading profile 'mad_max@ya.com' over the network...
 * Sent message to: 'mad_max@ya.com'. Message body: 'Hey! This is Anna's friend Josh. Can you do me a favor and like this post [link]?'
 * LinkedIn: Loading profile 'catwoman@yahoo.com' over the network...
 * Sent message to: 'catwoman@yahoo.com'. Message body: 'Hey! This is Anna's friend Josh. Can you do me a favor and like this post [link]?'
 *
 * Iterating over coworkers...
 *
 * LinkedIn: Loading 'coworkers' list of 'anna.smith@bing.com' over the network...
 * LinkedIn: Loading profile 'sam@amazon.com' over the network...
 * Sent message to: 'sam@amazon.com'. Message body: 'Hey! This is Anna's boss Jason. Anna told me you would be interested in [link].'
 */
public class Demo {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Please specify social network to target spam tool (default:Facebook):");
        System.out.println("1. Facebook");
        System.out.println("2. LinkedIn");
        String choice = scanner.nextLine();

        SocialNetwork network;
        if (choice.equals("2")) {
            network = new LinkedIn(createTestProfiles());
        }
        else {
            network = new Facebook(createTestProfiles());
        }

        SocialSpammer spammer = new SocialSpammer(network);
        spammer.sendSpamToFriends("anna.smith@bing.com",
                                  "Hey! This is Anna's friend Josh. Can you do me a favor and like this post [link]?");
        spammer.sendSpamToCoworkers("anna.smith@bing.com",
                                    "Hey! This is Anna's boss Jason. Anna told me you would be interested in [link].");
    }

    public static List<Profile> createTestProfiles() {
        List<Profile> data = new ArrayList<Profile>();
        data.add(new Profile("anna.smith@bing.com", "Anna Smith", "friends:mad_max@ya.com", "friends:catwoman@yahoo.com", "coworkers:sam@amazon.com"));
        data.add(new Profile("mad_max@ya.com", "Maximilian", "friends:anna.smith@bing.com", "coworkers:sam@amazon.com"));
        data.add(new Profile("bill@microsoft.eu", "Billie", "coworkers:avanger@ukr.net"));
        data.add(new Profile("avanger@ukr.net", "John Day", "coworkers:bill@microsoft.eu"));
        data.add(new Profile("sam@amazon.com", "Sam Kitting", "coworkers:anna.smith@bing.com", "coworkers:mad_max@ya.com", "friends:catwoman@yahoo.com"));
        data.add(new Profile("catwoman@yahoo.com", "Liza", "friends:anna.smith@bing.com", "friends:sam@amazon.com"));
        return data;
    }
}