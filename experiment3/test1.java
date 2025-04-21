package experiment3;

public class test1 {
    public static void main(String args[]){
        Circle circle = new Circle(10d);
        Rectangle rectangle = new Rectangle(3d,4d);
        System.out.println("Circle Area = " + circle.getArea());
        System.out.println("Rectangle Area = " + rectangle.getArea());
    }
}