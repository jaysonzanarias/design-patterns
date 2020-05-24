package behavioral_patterns.observer;

import behavioral_patterns.observer.editor.Editor;
import behavioral_patterns.observer.listeners.EmailNotificationListener;
import behavioral_patterns.observer.listeners.LogOpenListener;

/**
 * https://refactoring.guru/design-patterns/observer/java/example
 * Output:
 * Save to log \path\to\log\file2.txt: Someone has performed open operation with the following file: test.txt
 * Email to admin2@example.com: someone has performed open operation with the following file: test.txt
 * Save to log \path\to\log\file1.txt: Someone has performed save operation with the following file: test.txt
 * Email to admin1@example.com: someone has performed save operation with the following file: test.txt
 */
public class Demo {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe("save", new LogOpenListener("/path/to/log/file1.txt"));
        editor.events.subscribe("open", new LogOpenListener("/path/to/log/file2.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("admin1@example.com"));
        editor.events.subscribe("open", new EmailNotificationListener("admin2@example.com"));

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}