package exercise;

// BEGIN
public class Cottage implements Home, Comparable<Home> {
    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Home another) {
        if (getArea() > another.getArea()) {
            return 1;
        } else if (getArea() < another.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }

    public String toString() {
        String string = floorCount + " этажный коттедж площадью " + getArea() + " метров";
        return string;
    }
}
// END
