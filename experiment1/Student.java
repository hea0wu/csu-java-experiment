package experiment1;

public class Student{
    private String sNO;
    private String sName;
    private String sSex;
    private Integer sAge;
    private Integer sJava;
    public Student(String sNO,String sName,String sSex,Integer sAge,Integer sJava){
        this.sNO = sNO;
        this.sName = sName;
        this.sSex = sSex;
        this.sAge = sAge;
        this.sJava = sJava;

    }
    public String toString(){
        return "sNO:" + this.sNO + ",sName:" + this.sName+ ",sSex:" +this.sSex+ ",sAge:" +this.sAge+ ",sJava:" +this.sJava;
    }
    public String getNo(){
        return this.sNO;
    }
    public String getName(){
        return this.sName;
    }
    public String getSex(){
        return this.sSex;
    }
    public Integer getAge(){
        return this.sAge;
    }
    public Integer getJava(){
        return this.sJava;
    }
}