package dx.com;

import dx.com.two.Father;
import dx.com.two.Son;

import java.lang.reflect.*;

/**
 * Created by dx on 2017/4/1.
 */
public class Test {

    private final static String STR = "100";

    public static void main(String[] args) throws Exception {
        String string = "str";
        System.out.println(string.toUpperCase());
        System.out.println(string);
    }

    private static void method50() throws NoSuchFieldException, IllegalAccessException {
        Class class1 = Test.class;
        Field field = class1.getDeclaredField("STR");
        field.setAccessible(true);
        Field modifiedField = Field.class.getDeclaredField("modifiers");
        modifiedField.setAccessible(true);
        modifiedField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
        field.set(null, "299");
        System.out.println(Test.STR);
    }


    private static void method5() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class fatherClass = Class.forName("dx.com.two.Father");
        Father father = (Father) fatherClass.newInstance();
        Field field = fatherClass.getDeclaredField("name");
    }

    private static void method3() throws ClassNotFoundException {
        Class fatherClass = Class.forName("dx.com.two.Father");
        Method[] methods = fatherClass.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println("方法名为：" + methods[i].getName());
            System.out.println("方法的返回值类型为：" + methods[i].getReturnType().getName());
            int temp = methods[i].getModifiers();
            System.out.println("方法的修饰符为：" + Modifier.toString(temp));
            System.out.println("方法的参数为：");
            Class[] parameters = methods[i].getParameterTypes();
            for (int j = 0; j < parameters.length; j++) {
                System.out.println(parameters[j].getName());
            }
        }
    }

    private static void method2() throws ClassNotFoundException {
        Class fatherClass = Class.forName("dx.com.two.Father");
        Constructor[] constructors = fatherClass.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            System.out.println("第" + i + "个构造方法的参数为：");
            Class[] paramrters = constructors[i].getParameterTypes();
            for (int j = 0; j < paramrters.length; j++) {
                System.out.println(paramrters[j].getName());
            }
        }
    }

    private static void method1() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, java.lang.reflect.InvocationTargetException {
        Class sonClass = null;
        sonClass = Class.forName("dx.com.two.Son");
        Constructor constructor = sonClass.getConstructor(String.class, int.class);
        Son son = (Son) constructor.newInstance("dx", 12);
        System.out.println(son.toString());
        //根据子类获得的父类名构造父类对象
        System.out.println(son.getClass().getSuperclass().getName());
        Class fatherClass = son.getClass().getSuperclass();
        Constructor constructorFather = fatherClass.getConstructor(String.class, int.class);
        Father father = (Father) constructorFather.newInstance("wwj", 11);
        System.out.println(father.toString());
        //子类的超类
        AnnotatedType annotatedType = son.getClass().getAnnotatedSuperclass();
        System.out.println(annotatedType.getType());
        //父类的超类
        AnnotatedType annotatedTypeFather = father.getClass().getAnnotatedSuperclass();
        System.out.println(annotatedTypeFather.getType());
    }
}