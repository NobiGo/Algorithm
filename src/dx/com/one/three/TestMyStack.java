package dx.com.one.three;

import com.algs4.stdlib.StdIn;

import java.util.Iterator;

/**
 * Created by dx on 2017/3/15.
 */
public class TestMyStack {
    public static void main(String[] args) {
//        Stats();
//        methodLinkStats();

        LinkedQueue<String> linkedQueue = new LinkedQueue<String>();
        while (!StdIn.isEmpty()) {
            String string = StdIn.readString();
            if ("-".equals(string))
                System.out.println(linkedQueue.dequeue());
            else
                linkedQueue.enqueue(string);
        }
        Iterator<String> iterator = linkedQueue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static void methodLinkStats() {
        LinkStats<String> linkStats = new LinkStats<String>();
        while (!StdIn.isEmpty()) {
            String value = StdIn.readString();
            if ("-".equals(value))
                System.out.println(linkStats.pop());
            else
                linkStats.push(value);
        }
        Iterator<String> itemIterator = linkStats.iterator();
        while (itemIterator.hasNext()) {
            System.out.println(itemIterator.next());
        }
    }

    private static void Stats() {
        ResizingArrayStack<String> resizingArrayStack = new ResizingArrayStack<String>();
        while (!StdIn.isEmpty()) {
            String value = StdIn.readString();
            resizingArrayStack.push(value);
        }

        Iterator<String> interator = resizingArrayStack.iterator();
        while (interator.hasNext()) {
            System.out.println(interator.next());
        }
    }

}