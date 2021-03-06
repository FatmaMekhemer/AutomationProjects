package Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
    public static Properties userData=
            loadProperties(System.getProperty(("user.dir")+"\\src\\main\\java\\Properties\\userdata.properties"));
    private static Properties loadProperties(String path){
        Properties prop= new Properties();
        try {
            FileInputStream stream=new FileInputStream(path);
            try {
                prop.load(stream);
            } catch (IOException e) {
                System.out.println("Error occurred "+e.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error occurred "+e.getMessage());
        }
        catch (NullPointerException e) {
            System.out.println("Error occurred "+e.getMessage());
        }
        return prop;
    }
}
