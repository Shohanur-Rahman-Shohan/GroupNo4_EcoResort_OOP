package org.example.groupno4_ecoresort_oop.utils;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    // it will return an array list of objects
    // return a generic array of objects
    public static <T> ArrayList<T> readObjectsFromFile(String fileName) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        ArrayList<T> list = new ArrayList<>();
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                return list;
            }

            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            while (true) {
                try {
                    list.add((T) ois.readObject());
                } catch (EOFException e) {
                    break;
                }
            }

            ois.close();
            return list;
        } catch (Exception e) {
            if (ois != null) {
                try {
                    ois.close();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }

            e.printStackTrace();
            return list;
        }
    }

    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            return false;
        }

        return file.delete();
    }

    // it will replace the file with the new list
    // return a boolean value
    public static <T> boolean replaceFile(ArrayList<T> list, String fileName) {
        try {
            File file = new File(fileName);
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (T object : list) {
                oos.writeObject(object);
            }

            oos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // it will write an object to a file
    public static <T> boolean writeObjectToFile(T object, String fileName) {
        try {
            File file = new File(fileName);
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;
            if (!file.exists()) {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(file, true);
                // this is to avoid the stream header
                oos = new AppendableObjectOutputStream(fos);
            }

            oos.writeObject(object);
            oos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
