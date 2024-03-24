package com.example.viiko_10;

import android.content.Context;
import java.util.ArrayList;
import java.io.*;
import java.util.Collections;
import java.util.Comparator;

public class UserStorage {
    private static UserStorage instance;
    private ArrayList<User> users;
    private static final String FILE_NAME = "users.data";

    public static UserStorage getInstance() {
        if (instance == null) {
            instance = new UserStorage();
        }
        return instance;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
        saveToFile();
    }
    private void saveToFile(){
        try {
            Context context = null;
            FileOutputStream fos = context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}