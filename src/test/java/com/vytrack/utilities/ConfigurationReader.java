package com.vytrack.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties configFile;

    static {
        try {
            //path to our .properties file
            String path = "configuration.properties";
            //we create object of input stream to access file
            System.out.println(path);
            //Java cannot read the files directly, it needs inputStream to read files
            //input stream takes the location of the file as a constructor
            //provides access to file
            FileInputStream input = new FileInputStream(path);
            //Properties class is used to read properties files(files with key value pairs)
            //initialize configFile
            configFile = new Properties();
            //load properties file-->file content are load to properties from teh inputstream
            configFile.load(input);
            //close input stream-->all input streams must be closed
            input.close();
            //both load method and FileInputStream class throw exception so we handle it with catch
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    //we need getter because configFile defined as private,
// static so there is no way to access it but getter
//returns a specific value of a specific property
    public static String getProperty(String key) {

        return configFile.getProperty(key);
    }

//If I want to read the properties files content:

//public static void main(String[] args) {
//        Enumeration KeyValues = configFile.keys();
//        while (KeyValues.hasMoreElements()) {
//            String key = (String) KeyValues.nextElement();
//            String value = configFile.getProperty(key);
//            System.out.println(key + ":- " + value);
//        }
//   }
//
}