package experiment2;
import java.util.Scanner;

public class Experiment2 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            System.out.print("请输入对象类型(Circle/Sphere/Cylinder)，或输入exit退出:");
            String objString = scanner.next();
            if(objString.equalsIgnoreCase("exit")) {
                System.out.println("程序已退出");
                break;
            }
            try {
                switch (objString) {
                    case "Circle":
                        System.out.print("请输入半径r:");
                        double r1 = scanner.nextDouble();
                        doDisp(new Circle(r1));
                        break;
                    case "Sphere":
                        System.out.print("请输入半径r:");
                        double r2 = scanner.nextDouble();
                        doDisp(new Sphere(r2)); 
                        break;
                    case "Cylinder":
                        System.out.print("请输入半径r和高度h(用空格分隔):");
                        double r3 = scanner.nextDouble();
                        double h = scanner.nextDouble();
                        doDisp(new Cylinder(r3, h));  
                        break;
                    default:
                        System.out.println("对象类型错误，请输入Circle/Sphere/Cylinder或exit");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.nextLine(); // 清除缓冲区
            }
        }
        scanner.close();
    }
    
    public static void doDisp(Circle obj) {
        obj.disp();
    }
}