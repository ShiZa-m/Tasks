
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class task2 {

    public static void main(String[] args) throws IOException {
        if (args.length == 2) {
            try (FileReader fr = new FileReader(args[0]);
                    FileReader fr2 = new FileReader(args[1])) {

                BufferedReader br = new BufferedReader(fr);
                String[] circle = br.readLine().split(" ");
                double circle_x = Double.parseDouble(circle[0]);
                double circle_y = Double.parseDouble(circle[1]);
                double circle_r = Double.parseDouble(br.readLine());
                br.close();

                BufferedReader br2 = new BufferedReader(fr2);
                String line = br2.readLine();
                while (line != null) {
                    String[] point = line.split(" ");
                    double x = Double.parseDouble(point[0]);
                    double y = Double.parseDouble(point[1]);
                    double condition = (x - circle_x) * (x - circle_x) + (y - circle_y) * (y - circle_y);
                    int check;
                    if (condition == circle_r * circle_r) {
                        check = 0;
                        System.out.println(check);
                        line = br2.readLine();
                        continue;
                    }
                    check = condition < circle_r * circle_r ? 1 : 2;
                    System.out.println(check);
                    line = br2.readLine();
                }
                br2.close();
            } catch (IOException e) {
                System.out.println("File not found");
            } catch (NumberFormatException e) {
                System.out.println("Wrong input. Files should contain only numbers.");
            }
        } else {
            System.out.println("Wrong input. Two files paths are expected.");
        }
    }
}
