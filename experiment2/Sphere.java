package experiment2;

public class Sphere extends Circle{
    public Sphere(){
        this.radius = 0d;
    }
    public Sphere(double r){
        this.radius = r;
    }
    public double getVol(){
        return (4.0/3.0)*Math.PI*Math.pow(this.radius, 3d);
    }
    public double getArea(){
        return 4d*Math.PI*Math.pow(this.radius,2d);
    }
    public void disp(){
        System.out.println("Radius:" + this.radius + "\tArea:" + this.getArea() + "\tVol:" + this.getVol());
    }
}
