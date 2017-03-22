package dx.com.one.JavaExercixe;

/**
 * Created by dx on 2017/3/17.
 */

class Person implements Cloneable {
    String name;
    int age;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Person(String name, int age) {
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
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class CloneTest {
    public static void main(String[] args) throws Exception {
//        //复制引用
//        System.out.println("====================复制引用==========================");
        Person p1 = new Person("dx", 12);
//        System.out.println(p1.toString());
//        Person p2 = p1;
//        System.out.println(p2.toString());
//        p2.setName("wwj");
//        System.out.println("p2改变姓名");
//        System.out.println(p1.toString());
        //克隆对象
        System.out.println("=====================克隆引用============================");
        Person p3 = (Person) p1.clone();
        System.out.println(p3.toString());
        p3.setName("wwj");
        System.out.println(p3.toString());
        System.out.println(p1.toString());
    }
}
