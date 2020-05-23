package behavioral_patterns.memento;

import behavioral_patterns.memento.editor.Editor;
import behavioral_patterns.memento.shapes.Circle;
import behavioral_patterns.memento.shapes.CompoundShape;
import behavioral_patterns.memento.shapes.Dot;
import behavioral_patterns.memento.shapes.Rectangle;

import java.awt.*;

/**
 * https://refactoring.guru/design-patterns/memento/java/example#example-0--history-History-java
 */
public class Demo {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.loadShapes(new Circle(10, 10, 10, Color.BLUE),

                          new CompoundShape(new Circle(110, 110, 50, Color.RED),
                                            new Dot(160, 160, Color.RED)),

                          new CompoundShape(new Rectangle(250, 250, 100, 100, Color.GREEN),
                                            new Dot(240, 240, Color.GREEN),
                                            new Dot(240, 360, Color.GREEN),
                                            new Dot(360, 360, Color.GREEN),
                                            new Dot(360, 240, Color.GREEN)));
    }
}