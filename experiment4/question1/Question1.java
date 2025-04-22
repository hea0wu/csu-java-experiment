package experiment4.question1;

public class Question1 {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person();
        person1.setAge(18);
        System.out.println("person1's age is " + person1.getAge());
        person2.setAge(180);
        System.out.println("person2's age is " + person2.getAge());
    }
}
