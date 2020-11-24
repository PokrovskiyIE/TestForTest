import java.io.*;
import java.util.ArrayList;


public class Reader {


    public static ArrayList<String[]> reader(File csv) throws IOException {
        String csvSplit = ",";
        FileReader fr = new FileReader(csv);
        BufferedReader reader = new BufferedReader(fr);
        String line = "";
        ArrayList<String[]> fromCSV = new ArrayList<>();
        while ((line = reader.readLine()) != null) {

            String[] splittedLine = line.split(csvSplit);
            fromCSV.add(splittedLine);
        }
        return fromCSV;
}
}
