package dx.com.two;

/**
 * Created by dx on 2017/4/1.
 */
public class InitOrder {

    static {
        System.out.println("dsafdsafda");
    }
    public static void main(String[] args) {
        System.out.println("主方法");
        Son son = new Son();
    }
}


class Father {
    static {
        System.out.println("father");
    }
}

class Son extends Father {
    static {
        System.out.println("Son");
    }
}