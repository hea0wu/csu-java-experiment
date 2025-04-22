package experiment3.question2;

import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Graduate zhangsan = new Graduate("zhangsan");
        Scanner scanner = new Scanner(System.in);
        System.out.println("zhangsan's fee is ?");
        zhangsan.setFee(scanner.nextInt());
        System.out.println("zhangsan's pay is ?");
        zhangsan.setPay(scanner.nextInt());
        if ((zhangsan.getFee() - zhangsan.getPay()) < 2000) {
            System.out.println("You need a loan!");
        }else {
            System.out.println("Your income is enough!");
        }
    }
}
