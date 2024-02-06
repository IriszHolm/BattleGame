package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileUtils {
    // Method that loads file
    public static Object loadObject(String fileName) {

        Object returnObj = null;

        try {

            ObjectInputStream objInputStream = new ObjectInputStream(new FileInputStream(fileName));
            returnObj = objInputStream.readObject();

            objInputStream.close();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return returnObj;
    }

    // Saves file
    public static void saveObject(Object object, String fileName) {
        try {
            FileOutputStream outputStream = new FileOutputStream(fileName);
            ObjectOutputStream objStream = new ObjectOutputStream(outputStream);

            objStream.writeObject(object);
            objStream.close();
            outputStream.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
