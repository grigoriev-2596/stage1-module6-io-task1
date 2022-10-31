package com.epam.mjc.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {

    public Profile getDataFromFile(File file) {
        String[] data = getStringFromFile(file).split("\\r\\n|[\\r\\n ]");
        Profile profile = new Profile();
        for (int i = 0; i < data.length; i++) {
            switch (data[i]) {
                case "Name:":
                    profile.setName(data[++i]);
                    break;
                case "Age:":
                    profile.setAge(Integer.parseInt(data[++i]));
                    break;
                case "Email:":
                    profile.setEmail(data[++i]);
                    break;
                case "Phone:":
                    profile.setPhone(Long.parseLong(data[++i]));
                    break;
                default:
                    throw new IllegalArgumentException("This file cannot be used to read a Profile");
            }
        }
        return profile;
    }

    private String getStringFromFile(File file) {
        StringBuilder data = new StringBuilder();
        try (java.io.FileReader reader = new java.io.FileReader(file)) {
            int c;
            while ((c = reader.read()) != -1) {
                data.append((char) c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.toString();
    }
}
