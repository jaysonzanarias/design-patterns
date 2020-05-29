package behavioral_patterns.visitor.shapes;

import behavioral_patterns.visitor.visitor.Visitor;

public interface Shape {
    void move(int x, int y);
    void draw();
    String accept(Visitor visitor);
}
