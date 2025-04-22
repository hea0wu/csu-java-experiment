package experiment3.question1;

public class Circle extends Shape{
    private Double r;
    
    public Circle(Double r){
        this.r = r;
    }

    public Double getArea(){
        return Math.PI*r*r;
    }
}
