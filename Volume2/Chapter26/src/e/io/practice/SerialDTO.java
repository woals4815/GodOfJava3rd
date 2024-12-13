package e.io.practice;

import java.io.Serializable;

public class SerialDTO implements Serializable {
//    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private String gender;
    public SerialDTO(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return this.name + this.age + this.gender;
    }
}
