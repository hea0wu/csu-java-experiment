package experiment3.question2;
public class Graduate implements StudentInterface,TeacherInterface {
    private String name;
    private String sex;
    private int age;
    private int fee;
    private int pay;

    public Graduate(String name) {
        this.name = name;
    }


    @Override
    public void setFee(int fee) {
        this.fee = fee;
    }

    @Override
    public int getFee() {
        return this.fee;
    }

    @Override
    public void setPay(int pay) {
        this.pay = pay;
    }

    @Override
    public int getPay() {
        return this.pay;
    }
}
