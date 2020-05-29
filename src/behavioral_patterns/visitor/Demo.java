package behavioral_patterns.visitor;

import behavioral_patterns.visitor.shapes.Circle;
import behavioral_patterns.visitor.shapes.CompoundShape;
import behavioral_patterns.visitor.shapes.Dot;
import behavioral_patterns.visitor.shapes.Rectangle;
import behavioral_patterns.visitor.shapes.Shape;
import behavioral_patterns.visitor.visitor.XMLExportVisitor;

/**
 * https://refactoring.guru/design-patterns/visitor/java/example
 * Output:
 * <?xml version="1.0" encoding="utf-8"?>
 * <circle>
 *     <id>2</id>
 *     <x>23</x>
 *     <y>15</y>
 *     <radius>10</radius>
 * </circle>
 *
 * <?xml version="1.0" encoding="utf-8"?>
 * <compound_graphic>
 *    <id>4</id>
 *     <dot>
 *         <id>1</id>
 *         <x>10</x>
 *         <y>55</y>
 *     </dot>
 *     <circle>
 *         <id>2</id>
 *         <x>23</x>
 *         <y>15</y>
 *         <radius>10</radius>
 *     </circle>
 *     <rectangle>
 *         <id>3</id>
 *         <x>10</x>
 *         <y>17</y>
 *         <width>20</width>
 *         <height>30</height>
 *     </rectangle>
 *     <compound_graphic>
 *        <id>5</id>
 *         <dot>
 *             <id>1</id>
 *             <x>10</x>
 *             <y>55</y>
 *         </dot>
 *     </compound_graphic>
 * </compound_graphic>
 */
public class Demo {
    public static void main(String[] args) {
        Dot dot = new Dot(1, 10, 55);
        Circle circle = new Circle(2, 23, 15, 10);
        Rectangle rectangle = new Rectangle(3, 10, 17, 20, 30);

        CompoundShape compoundShape = new CompoundShape(4);
        compoundShape.add(dot);
        compoundShape.add(circle);
        compoundShape.add(rectangle);

        CompoundShape c = new CompoundShape(5);
        c.add(dot);
        compoundShape.add(c);

        export(circle, compoundShape);
    }

    private static void export(Shape... shapes) {
        XMLExportVisitor exportVisitor = new XMLExportVisitor();
        System.out.println(exportVisitor.export(shapes));
    }
}