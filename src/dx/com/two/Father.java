package dx.com.two;

/**
 * Created by dx on 2017/4/4.
 */
public class Father {
    private String name;
    private int age;

    public Father() {

    }

    public Father(String name) {
        this.name = name;
    }

    public Father(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("姓名设置为：" + name);
    }

    public static void printPerson() {
        System.out.println("I am a person ");
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("掉用equals方法");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Father father = (Father) o;
        if (age != father.age) return false;
        return name != null ? name.equals(father.name) : father.name == null;
    }

    @Override
    public int hashCode() {
        System.out.println("调用hashCode方法");
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Father{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
