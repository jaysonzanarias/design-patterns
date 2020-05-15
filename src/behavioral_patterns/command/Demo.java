package behavioral_patterns.command;

import behavioral_patterns.command.editor.Editor;

/**
 * https://refactoring.guru/design-patterns/command/java/example
 */
public class Demo {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.init();
    }
}
