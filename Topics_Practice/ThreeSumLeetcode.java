
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;


    public class ThreeSumLeetcode {
        public static ArrayList<Integer[]> threeSum(int[] arr) {
            ArrayList<Integer[]> triplets = new ArrayList<>();

            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    for (int k = j + 1; k < arr.length; k++) {
                        if (arr[i] + arr[j] + arr[k] == 0) {
                            triplets.add(new Integer[]{arr[i] , arr[j] , arr[k]});
                        }
                    }
                }
            }
            return triplets;
        }

        public static void main(String[] args){
            int[] num = {-1,0,1,2,-1,-4};
            ArrayList<Integer[]> result = threeSum(num);
             for(Integer[] data : result){
                 System.out.println(Arrays.toString(data));
            }
        }
    }



