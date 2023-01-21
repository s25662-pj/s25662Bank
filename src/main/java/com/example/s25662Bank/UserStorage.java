package com.example.s25662Bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserStorage {

    private final List<User> userList = new ArrayList<>();
    public UserStorage(){
        userList.add(new User(123456, 12.34f));
        userList.add(new User(125662, 213.23f));
        userList.add(new User(182634, 35454.00f));
        userList.add(new User(194743, 3123.32f));
    }

    public void addUser(User user){
        userList.add(user);
    }

    public List<User> getUserList() {
        return userList;
    }
}
