package behavioral_patterns.visitor.visitor;

import behavioral_patterns.visitor.shapes.Circle;
import behavioral_patterns.visitor.shapes.CompoundShape;
import behavioral_patterns.visitor.shapes.Dot;
import behavioral_patterns.visitor.shapes.Rectangle;

public interface Visitor {
    String visitDot(Dot dot);

    String visitCircle(Circle circle);

    String visitRectangle(Rectangle rectangle);

    String visitCompoundGraphic(CompoundShape cg);
}