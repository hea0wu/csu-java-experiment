package experiment1;

import java.util.Arrays;

public class Experiment1 {
    public static void main(String args[]){
        Student stu1 = new Student("8208230101","小张","男",18,100);
        Student stu2 = new Student("8208230102","小美","女",18,60);
        System.out.println("stu1:\t" + stu1);
        System.out.println("stu2:\t" + stu2);
        Double avg = (double)((stu1.getJava() + stu2.getJava()) / 2);
        System.out.println("两个学生Java语言成绩的平均值为:" + avg);
        Student stu3 = new Student("8208230103","小三","男",18,70);
        Student stu4 = new Student("8208230104","小四","女",18,80);
        Student stu5 = new Student("8208230105","小五","女",18,90);
        int[] numbers = {stu1.getJava(),stu2.getJava(),stu3.getJava(),stu4.getJava(),stu5.getJava()};
        int max = Arrays.stream(numbers).max().getAsInt();
        int min = Arrays.stream(numbers).min().getAsInt();
        System.out.println("最大值: " + max + "，最小值：" + min);
    }
}
