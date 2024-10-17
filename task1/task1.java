
import java.util.ArrayList;
import java.util.stream.IntStream;

public class task1 {

    public static void main(String[] args) {

        if (args.length == 2) {
            try {
                int n = Integer.parseInt(args[0]);
                int m = Integer.parseInt(args[1]);
                if( n< 0 || m < 0) {
                    throw new ArithmeticException();
                }

                int[] ring_arr = IntStream.range(1, n + 1).toArray();
                ArrayList<Integer> path_arr = new ArrayList<>();

                int begin_index = 0;
                int end_index = (m - 1) % ring_arr.length;

                while (true) {
                    path_arr.add(ring_arr[begin_index]);
                    if (end_index == 0) {
                        break;
                    }
                    begin_index = end_index;
                    end_index = (begin_index + m - 1) % ring_arr.length;
                }
                //In case if the max value in the ring_arr is more than 9, output will be confusing
                for (int i : path_arr) {
                    System.out.print(i);
                }

            } catch (NumberFormatException|ArithmeticException e) {
                System.out.println("Invalid input." +
                        " The arguments must be positive integer separated by a space.");
            }
        } else {
            System.out.println("The number of arguments should be 2. Get: " + args.length);
        }
    }
}
