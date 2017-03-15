package dx.com.one.JavaExercixe;

/**
 * Created by dx on 2017/3/14.
 */
public class QuickSort2 {

    public static void main(String[] args) {
        int []  arrays = {12,45,67,89,12,45,56};
        quickSort(arrays,0,arrays.length-1);
        for(int i:arrays){
            System.out.println(i);
        }
    }

    public static void quickSort(int [] arrays,int lo,int hi){
        //首先判断符合的条件
        if(lo>hi)
            return ;
        int i,j;
        i = lo;
        j = hi;
        //将首个元素设置为哨兵
        int index =arrays[lo];
        while(i<j){
        while(i<j&&arrays[j]>index)
            j--;
            if(i<j)
                arrays[i++] = arrays[j];
            while (i<j&&arrays[i]<index)
                i++;
            if(i<j)
                arrays[j--] = arrays[i];
        }
        //将哨兵放在他自己的位置上
        arrays[i] = index;
        //进行递归排序
        quickSort(arrays,i+1,hi);
        quickSort(arrays,lo,i-1);
    }
}
