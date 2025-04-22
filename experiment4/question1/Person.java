package experiment4.question1;
//包含年龄，姓名，性别等属性，
//编写属性设置和读取函数，在设置年龄函数中，判断参数是否符合要求（1~150），
//如果不符合则抛出异常，编写main函数进行测试
public class Person {
    private int age;
    private String name;
    private String sex;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >=1 && age <=150) {
            this.age = age;
        } else {
            throw new IllegalAgeException();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

