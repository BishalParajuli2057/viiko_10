package com.example.viiko_10;

import android.content.Context;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.io.*;
import java.util.Collections;
import java.util.Comparator;

public class UserStorage {
    private static UserStorage instance;
    private ArrayList<User> users;
    private static final String FILE_NAME = "users.data";
    private Context context;

    private UserStorage(Context context) {
        this.context = context;
        users = new ArrayList<>();
        loadUsers();
    }

    public static UserStorage getInstance(Context context) {
        if (instance == null) {
            instance = new UserStorage(context);
        }
        return instance;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
        saveUsers();
    }


    private void loadUsers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            users = (ArrayList<User>) ois.readObject();
        } catch (FileNotFoundException e) {
            // File not found - this is ok, we'll start with an empty list
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // This method saves the current list of users to a file
    private void saveUsers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<User> getUsersSortedByLastName() {
        ArrayList<User> sortedUsers = new ArrayList<>(users); // Create a copy for sorting
        Collections.sort(sortedUsers, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.getLastName().compareToIgnoreCase(u2.getLastName());
            }
        });
        return sortedUsers;
    }
}
