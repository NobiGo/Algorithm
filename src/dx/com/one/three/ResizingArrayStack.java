package dx.com.one.three;

import java.util.Iterator;

/**
 * Created by dx on 2017/3/15.
 */
public class ResizingArrayStack<Intem> implements  Iterable<Intem> {

    //栈中元素的大小
    int  N;
    //保存栈元素的数组
    Intem []  intems = (Intem[]) new Object[1];

    //出栈
    public Intem pop(){
        Intem value =  intems[--N];
        intems[N] = null;
        if(N>0&&N==intems.length/4)
            resize(intems.length/2);
        return value;
    }
    //压栈
    public void push(Intem intem){
        if(N==intems.length)
            resize(2*intems.length);
         intems[N++] = intem;
    }
    //重新分配空间
    private void resize(int cap){
        Intem [] intems = (Intem[]) new Object[cap];

        for(int i = 0;i<this.intems.length;i++){
            intems[i]=this.intems[i];
        }
        this.intems = intems;
    }

    @Override
    public Iterator<Intem> iterator() {
        return new ResizingArrayIterator();
    }

    private class ResizingArrayIterator implements  Iterator<Intem>{

        int  i = N;

        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public Intem next() {
            return intems[--i];
        }
    }

}
