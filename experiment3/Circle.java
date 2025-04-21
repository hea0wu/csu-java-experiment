package experiment3;

public class Circle extends Shape{
    private Double r;
    
    public Circle(Double r){
        this.r = r;
    }

    public Double getArea(){
        return Math.PI*r*r;
    }
}
