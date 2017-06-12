package com.winfo.project2.client.basic.data;

import javax.swing.*;
import java.io.*;
import java.util.Properties;

/**
 * Created by patrick on 12.06.17.
 */

//sorry war druff
public class ApplicationPreference {
    private static  String settingsFile = "settings.xml";

    static Properties configFile = new Properties();


    //Writing and Saving Configurations
    public static void setPreference(String Key, String Value) {
        try {
            InputStream f = new FileInputStream(settingsFile);
            configFile.loadFromXML(f);
            f.close();
        }
        catch(IOException e) {
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        configFile.setProperty(Key, Value);
        try {
            OutputStream f = new FileOutputStream(settingsFile);
            configFile.storeToXML(f,"Configuration file for the Profit System");
        }
        catch(Exception e) {
        }
    }

    //Reading Configurations
    public static String getPreference(String Key) {
        Properties configFile = new Properties();
        try {
            InputStream f = new FileInputStream(settingsFile);
            configFile.loadFromXML(f);
            f.close();
        }
        catch(IOException e) {
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return (configFile.getProperty(Key));
    }
}
