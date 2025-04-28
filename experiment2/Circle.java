package experiment2;

public class Circle {
    protected Double radius;
    public Circle(){
        this.radius = 0d;
    }
    public Circle(double r){
        this.radius = r;
    }
    public double getRadius(){
        return this.radius;
    }
    public double getPerimeter(){
        return this.radius*Math.PI*2;
    }
    public double getArea(){
        return Math.PI*Math.pow(radius,2d);
    }
    public void disp(){
        System.out.println("Radius:" + this.radius + "\tPerimeter:" + this.getPerimeter() + "\tArea:" + this.getArea());
    }
}
