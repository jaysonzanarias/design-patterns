package creational_patterns.singleton.non_thread_safe.multithreaded;

/**
 * https://refactoring.guru/design-patterns/singleton/java/example
 * Output:
 * If you see the same value, then singleton was reused (yay!)
 * If you see different values, then 2 singletons were created (booo!!)
 *
 * RESULT:
 *
 * FOO (not guaranteed because it is not thread safe)
 * BAR (not guaranteed because it is not thread safe)
 */
public class DemoMultiThread {
    public static void main(String[] args) {
        System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
                           "If you see different values, then 2 singletons were created (booo!!)" +
                           "\n\n" + "RESULT:" + "\n");
        Thread threadFoo = new Thread(new ThreadFoo());
        Thread threadBar = new Thread(new ThreadBar());
        threadFoo.start();
        threadBar.start();
    }

    static class ThreadFoo implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("FOO");
            System.out.println(singleton.value);
        }
    }

    static class ThreadBar implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("BAR");
            System.out.println(singleton.value);
        }
    }
}