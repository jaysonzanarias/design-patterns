package creational_patterns.singleton.non_thread_safe.single_threaded;

/**
 * https://refactoring.guru/design-patterns/singleton/java/example
 * Output:
 * If you see the same value, then singleton was reused (yay!)
 * If you see different values, then 2 singletons were created (booo!!)
 *
 * RESULT:
 *
 * FOO
 * FOO
 */
public class DemoSingleThreaded {
    public static void main(String[] args) {
        System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
                           "If you see different values, then 2 singletons were created (booo!!)" +
                           "\n\n" + "RESULT:" + "\n");
        Singleton singleton = Singleton.getInstance("FOO");
        Singleton anotherSingleton = Singleton.getInstance("BAR");
        System.out.println(singleton.value);
        System.out.println(anotherSingleton.value);
    }
}
