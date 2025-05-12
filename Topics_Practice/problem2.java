

public class problem2 {

    static int maximumWealth(int[][] num) {
        int result = 0;
      for (int row=0;row<num.length;row++){
          int sum = 0;
          for(int col=0;col<num[row].length;col++){
              sum += num[row][col];
          }
          if (sum > result){
              result = sum;
          }
      }
      return result;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 20, 3},
                {3, 2, 8}
        };

        System.out.println(maximumWealth(arr));


    }
}
