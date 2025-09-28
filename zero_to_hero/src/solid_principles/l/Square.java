package solid_principles.l;

public class Square extends Shape {
    protected int side;

    public Square(){}
    public Square(int side) {
        if (side <= 0) {
            throw new IllegalArgumentException();
        }
        this.side = side;
    }

    @Override
    public void setHeight(int height) {
        this.side = height;
    }

    @Override
    public void setWidth(int width) {
        this.side = width;
    }

    @Override
    public int calculateArea() {
        return side * side;
    }
}
