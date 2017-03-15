package dx.com.one.three;

/**
 * Created by dx on 2017/3/15.
 */
public class FixedCapacityStackOfStrings {
    private String []  stringArrays;
    private int N;

    public FixedCapacityStackOfStrings(int cap) {
        stringArrays = new String[cap];
        N = 0;
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public boolean isFull(){
        return N == stringArrays.length;
    }

    public String pop(){
        if(N==0) {
            System.out.println("栈中没有元素");
            return "";
        }
        String value = stringArrays[--N];
        System.out.println("元素出栈"+"==="+value);
        return value;
    }

    public void  push(String value){
        if(N > stringArrays.length-1) {
            System.out.println("栈中元素已满");
            return;
        }
        System.out.println("将元素压入栈"+"==="+value);
        stringArrays[N++] = value;
    }

}
