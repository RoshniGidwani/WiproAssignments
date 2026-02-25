package seleniumTestNG;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {

    public static Object[][] getCSVData(String path) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;

        List<Object[]> dataList = new ArrayList<>();

        br.readLine();

        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            dataList.add(values);
        }

        br.close();

        Object[][] data = new Object[dataList.size()][];
        return dataList.toArray(data);
    }
}