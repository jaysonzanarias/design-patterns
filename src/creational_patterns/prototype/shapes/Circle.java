package creational_patterns.prototype.shapes;

import java.util.Objects;

public class Circle extends Shape {
    public int radius;

    public Circle() {
    }

    public Circle(Circle target) {
        super(target);

        if(target != null) {
            this.radius = target.radius;
        }
    }

    @Override
    public Shape clone() {
        return new Circle(this);
    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Circle) || !super.equals(object2))
            return false;

        Circle shape2 = (Circle) object2;
        System.out.println("CIRCLE");
        return shape2. radius == radius;
    }
}
