package dx.com.one.three;

import com.algs4.stdlib.StdIn;

import java.util.LinkedList;

/**
 * Created by dx on 2017/3/17.
 */
public class Exercise1326 {

    public static void main(String[] args) {
        LinkedList<String>   linkedList = new LinkedList<String>();
        while(!StdIn.isEmpty()){
            String value = StdIn.readString();
            if("-".equals(value))
                break;
            linkedList.push(value);
        }
        remove(linkedList,"123");
        System.out.println(linkedList.size());
    }

    public static void remove(LinkedList<String>  linkedList,String  value){
        while(linkedList.contains("123")){
            linkedList.remove("123");
        }
    }
}
