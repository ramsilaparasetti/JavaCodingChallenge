
//Create a method to srot elements in array

import java.util.ArrayList;

public class Binarysearch {


    public int addNumbers(int a, int b){
        return a+b;
    }
    public void arraySorting(ArrayList<Integer> arr){
        int temp;
        for(int i=0; i<arr.size(); i++){
            for(int j=i+1; j<arr.size(); j++){
                if(arr.get(i) > arr.get(j)){
                    temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }
        System.out.println(arr);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(2);
        arr.add(3);
        arr.add(1);
        arr.add(4);
        Binarysearch bs = new Binarysearch();
        //bs.arraySorting(arr);
        int a = 100000000;
        int b = 600000000;
        System.out.println("Addition of " + a + " and " + b + " is: "+ bs.addNumbers(a, b));
    }
}
