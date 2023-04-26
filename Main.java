import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] data = new int[100];
        int db = 0;
        String line = null;

        line = scanner.nextLine();
        String[] parts = line.split(",");
        db= parts.length;
        for (int j = 0; j < db; j++) {
            data[j] = Integer.parseInt(parts[j]);
        }

        for (int i = 0; i < db; i++) {
            //System.out.println(data[i]);
            if(data[i]<0){
                data[i]=-data[i];
            }
        }

        Csere cs=new Csere();
        cs.fun(data, db);

    }
}