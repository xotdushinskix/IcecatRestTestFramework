package com.rest.icecat.helpers;

import com.rest.icecat.super_user.SuperUserData;
import org.json.simple.JSONObject;

import java.io.*;

/**
 * Created by nikita on 07.12.16.
 */
public class TextWorker {


    public JSONObject textWriter(String requiredString) {
        SuperUserData superUserData = new SuperUserData();
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(superUserData.TEXT_FILE_NAME), "utf-8"));
            writer.write(requiredString);
        } catch (IOException ex) {
            System.out.println("Cannot close writer stream");
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {
                System.out.println("Cannot close writer stream");
            }
        }
        return null;
    }




    public String accessKeyReader() throws IOException {
        SuperUserData superUserData = new SuperUserData();
        String content = null;
        File file = new File(superUserData.TEXT_FILE_HOME);
        FileReader reader = null;
        try {
            reader = new FileReader(file);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            content = new String(chars);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader !=null){reader.close();}
        }
        return content;

    }




}
