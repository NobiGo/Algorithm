package dx.com.one.JavaExercixe;

/**
 * Created by dx on 2017/3/17.
 */
public class CloneTest2 {

    public static void main(String[] args) {

        Son son = new Son("dx", 12);
        Father father = new Father("dxb", 12, son);
        Father cloneFather = null;
        try {
            cloneFather = (Father) father.clone();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        System.out.println(father.toString());
        System.out.println(cloneFather.toString());

        System.out.println(father.getSon().toString());
        System.out.println(cloneFather.getSon().toString());

        cloneFather.getSon().setName("wwj");
        System.out.println(father.getSon().getName());


    }

}

class Father implements Cloneable {

    private String name;
    private int age;
    private Son son;

    public Father(String name, int age, Son son) {
        this.age = age;
        this.name = name;
        this.son = son;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Father father = (Father) super.clone();
        father.setSon((Son) father.getSon().clone());
        return father;
    }

    public Son getSon() {
        return son;
    }

    public void setSon(Son son) {
        this.son = son;
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
}

class Son implements Cloneable {

    private String name;
    private int age;

    public Son(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
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
}
