package com.epam.mjc.io;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        Profile profileFromFile = fileReader.getDataFromFile(new File("src/main/resources/Profile.txt"));
        System.out.println(profileFromFile);
    }
}
