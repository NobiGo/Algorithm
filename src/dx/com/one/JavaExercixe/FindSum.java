package dx.com.one.JavaExercixe;

/**
 * Created by dx on 2017/3/13.
 * 求数组中两两之和为20的个数
 */
public class FindSum {
    public static void main(String[] args) {
//        method1();
        method2();
    }

    private static  void method2(){
        int[] arrays = {10,7,17,2,6,3,14,10,90};

        for(int i = 0 ;i<arrays.length-1;i++){
            for(int j = i+1;j<arrays.length;j++){
                if(arrays[i]+arrays[j]==20){
                    System.out.println(i + "    " + arrays[i]+ "----"+ j + "    " + arrays[j]);
                }
            }
        }
    }






    private static void method1() {
        int[] arrays = {1,7,17,2,6,3,14};
        quickSort(arrays,0,arrays.length-1);
        for(int i : arrays){
            System.out.print("=========="+i);
        }
        System.out.println();
        int i = 0;
        int j = arrays.length-1;
        while(i<j){
            if(arrays[i]+arrays[j]<20)
                i++;
            else if(arrays[i]+arrays[j]>20)
                j--;
            else {
                System.out.println(i + "    " + arrays[i]+ "----"+ j + "    " + arrays[j]);
                i++;
                j--;
            }
        }
    }

    //将数组排序（快速排序法）
    public static void quickSort(int []arrays,int lo,int hi){
        if(lo>hi)
            return;
        int i,j;
        i = lo;
        j = hi;
        int index = arrays[i];
        while(i<j){
            while(i<j&&arrays[j]>=index)
                j--;
            if(i<j)
                arrays[i++] = arrays[j];
            while (i<j&&arrays[i]<index)
                i++;
            if(i<j)
                arrays[j--] = arrays[i];
        }
        arrays[i] = index;
        quickSort(arrays,lo,i-1);
        quickSort(arrays,i+1,hi);
    }

}
