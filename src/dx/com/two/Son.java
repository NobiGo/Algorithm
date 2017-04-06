package dx.com.two;

/**
 * Created by dx on 2017/4/4.
 */
public class Son extends Father {

    public Son(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Son{" +
                "name='" + super.getName() + '\'' +
                ", age=" + super.getAge() +
                '}';
    }
}
