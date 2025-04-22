package experiment4.question1;

public class IllegalAgeException extends RuntimeException {
    private final int invalidAge;

    public IllegalAgeException() {
        super("年龄不合法");
        this.invalidAge = -1;
    }
}
