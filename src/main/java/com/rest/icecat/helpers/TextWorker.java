package com.rest.icecat.helpers;

import org.json.simple.JSONObject;

import java.io.*;

/**
 * Created by nikita on 07.12.16.
 */
public class TextWorker {


    public JSONObject textWriter(String requiredString) {

        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("access_key.txt"), "utf-8"));
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

        String content = null;
        File file = new File("/home/nikita/HomeJava/IcecatRestTestFramework/access_key.txt");
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
