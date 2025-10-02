package inputoutputstreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOTest {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try{
             inputStream = new FileInputStream("D:\\AdvJavaNotes\\zero_to_hero\\src\\inputoutputstreams\\source.txt");
             outputStream = new FileOutputStream("D:\\AdvJavaNotes\\zero_to_hero\\src\\inputoutputstreams\\target.txt");

             int temp;
             while((temp = inputStream.read()) != -1){
                 outputStream.write((byte) temp);
             }
        }finally {
            if (inputStream != null)
                inputStream.close();
            if (outputStream != null)
                outputStream.close();
        }
    }
}
