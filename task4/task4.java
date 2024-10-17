import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class task4 {
    public static void main(String[] args) {
        if (args.length == 1) {
            try (FileReader fr = new FileReader(args[0])) {
                BufferedReader br = new BufferedReader(fr);
                ArrayList<Integer> list = new ArrayList<>();
                String line = br.readLine();
                int sum = 0;
                while (line != null) {
                    sum += Integer.parseInt(line);
                    list.add(Integer.valueOf(line));
                    line = br.readLine();
                }
                br.close();

                int avg = sum / list.size();
                int mid_number = list.get(0);
                int dif = Math.abs(avg - mid_number);
                for (int number : list) {
                    int temp = Math.abs(avg - number);
                    if (temp < dif) {
                        dif = temp;
                        mid_number = number;
                    }
                }

                int moves_count = 0;
                for (int number : list) {
                    moves_count += Math.abs(mid_number - number);
                }
                System.out.println(moves_count);

            } catch (IOException e) {
                System.out.println("File not found");
            } catch (NumberFormatException e) {
                System.out.println("Wrong input. File should contain only numbers.");
            }
        } else {
            System.out.println("Wrong input. One file path is expected.");
        }
    }
    
}
