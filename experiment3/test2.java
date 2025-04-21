package experiment3;

import java.util.Scanner;

public class test2 {
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
