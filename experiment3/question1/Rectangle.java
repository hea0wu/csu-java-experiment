package experiment3.question1;

public class Rectangle extends Shape{
    private Double length;
    private Double width;
    
    public Rectangle(Double length ,Double width){
        this.length = length;
        this.width = width; 
    }

    public Double getArea(){
        return length * width;
    }
}
