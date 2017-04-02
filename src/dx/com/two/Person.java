package dx.com.two;

/**
 * Created by dx on 2017/4/1.
 */
public class Person {
    private String name;
    private int age;

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

    public static void printPerson() {
        System.out.println("I am a person ");
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("掉用equals方法");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        if (age != person.age) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        System.out.println("调用hashCode方法");
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}
