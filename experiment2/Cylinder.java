package experiment2;

public class Cylinder extends Circle{
    private Double height;
    public Cylinder(double r,double h){
        this.radius = r;
        this.height = h;
    }
    public double getHeight(){
        return this.height;
    }
    public double getVol(){
        return this.getArea()*this.height;
    }
    public double getArea(){
        return this.getPerimeter() * this.height + super.getArea()*2d;
    }
    public void disp(){
        System.out.println("Radius:" + this.radius + "\tHeight:" + this.getHeight() + "\tArea:" + this.getArea() + "\tVol:" + this.getVol());
    }
}
