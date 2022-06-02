package Data;



import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonDataReader {
    public String firstname,lastname,email,password;
    public JsonDataReader() throws IOException, ParseException {
    String path=System.getProperty("user.dir")+"/src/test/java/Data/userdata.json";
    File f=new File(path);
    JSONParser parser=new JSONParser();
    JSONArray jarray=(JSONArray) parser.parse(new FileReader(f));
    for(Object jsonObj: jarray){
        JSONObject person=(JSONObject) jsonObj;
        firstname=(String)person.get("firstname");
        lastname=(String) person.get("lastname");
        email=(String) person.get("email");
        password=(String) person.get("password");
    }


    }
}
