package dx.com.two;

/**
 * Created by dx on 2017/3/27.
 */
public class Exercise2214 {
    public static void main(String[] args) {
        LinkedQueue<String> linkedQueue1 = new LinkedQueue<String>();
        linkedQueue1.enqueue("1");
        linkedQueue1.enqueue("3");
        linkedQueue1.enqueue("5");
        linkedQueue1.enqueue("7");
        linkedQueue1.enqueue("9");
        linkedQueue1.printQueue();
        LinkedQueue<String> linkedQueue2 = new LinkedQueue<String>();
        linkedQueue2.enqueue("2");
        linkedQueue2.enqueue("4");
        linkedQueue2.enqueue("6");
        linkedQueue2.enqueue("8");
        linkedQueue2.printQueue();
        LinkedQueue<String> linkedQueue = new LinkedQueue<String>();
        sort(linkedQueue1, linkedQueue2, linkedQueue);
        System.out.println("排列好的顺序为：");
        linkedQueue.printQueue();
    }

    /**
     * 将两个有序链表合并为一个有序链表
     *
     * @param linkedQueue1
     * @param linkedQueue2
     * @param linkedQueue  保存有序的链表
     */
    public static void sort(LinkedQueue<String> linkedQueue1, LinkedQueue<String> linkedQueue2, LinkedQueue<String> linkedQueue) {
        LinkedQueue linkedQueue_1 = linkedQueue1;
        LinkedQueue linkedQueue_2 = linkedQueue2;
        String strValue1 = (String) linkedQueue_1.dequeue();
        String strValue2 = (String) linkedQueue_2.dequeue();
        while (linkedQueue_1.size() > 0 && linkedQueue_2.size() > 0) {
            if (strValue1.compareTo(strValue2) >= 0) {
                linkedQueue.enqueue(strValue2);
                strValue2 = (String) linkedQueue_2.dequeue();
            } else {
                linkedQueue.enqueue(strValue1);
                strValue1 = (String) linkedQueue_1.dequeue();
            }
        }

        if (linkedQueue_1.size() > 0) {
            while (linkedQueue_1.size() > 0) {
                if (strValue1.compareTo(strValue2) >= 0) {
                    linkedQueue.enqueue(strValue2);
                    break;
                } else {
                    linkedQueue.enqueue(strValue1);
                    strValue1 = (String) linkedQueue_1.dequeue();
                }
            }
            if (linkedQueue_1.size() == 0) {
                if (strValue1.compareTo(strValue2) >= 0) {
                    linkedQueue.enqueue(strValue2);
                    linkedQueue.enqueue(strValue1);
                }
            } else {
                linkedQueue.enqueue(strValue2);
                while (linkedQueue_1.size() > 0) {
                    linkedQueue.enqueue(strValue1);
                    strValue1 = (String) linkedQueue_1.dequeue();
                }
                linkedQueue.enqueue(strValue1);
            }

        }


        if (linkedQueue_2.size() > 0) {
            while (linkedQueue_2.size() > 0) {
                if (strValue2.compareTo(strValue1) >= 0) {
                    linkedQueue.enqueue(strValue1);
                    break;
                } else {
                    linkedQueue.enqueue(strValue2);
                    strValue2 = (String) linkedQueue_2.dequeue();
                }
            }
            if (linkedQueue_2.size() == 0) {
                if (strValue2.compareTo(strValue1) >= 0) {
                    linkedQueue.enqueue(strValue1);
                    linkedQueue.enqueue(strValue2);
                }
            } else {
                linkedQueue.enqueue(strValue1);
                while (linkedQueue_2.size() > 0) {
                    linkedQueue.enqueue(strValue2);
                    strValue2 = (String) linkedQueue_2.dequeue();
                }
                linkedQueue.enqueue(strValue2);
            }

        }

    }
}
