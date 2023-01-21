package com.example.s25662Bank;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class BankService {
    private final UserStorage userStorage;

    public BankService(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public void addUser(float balance){
        int rand = new Random().nextInt(900000) + 100000;
        userStorage.addUser(new User(rand, balance));
        System.out.println("User added. ID:" + rand);
    }

    public TransferInfo transfer(int id, float value){
        for (User user: userStorage.getUserList()) {
            if(id == user.getId()){
                float userBalance = user.getBalance();
                if(userBalance>= value){
                    float diff = userBalance-value;
                    user.setBalance(diff);
                    return new TransferInfo("ACCEPTED", diff);
                }
            }
        }
        return new TransferInfo("DECLINED", 0f);
    }


    public TransferInfo addMoney(int id, float value){
        for (User user: userStorage.getUserList()) {
            if(id == user.getId()){
                float added = user.getBalance() + value;
                user.setBalance(added);
                return new TransferInfo("ACCEPTED", added);
            }
        }
        return new TransferInfo("DECLINED", 0f);
    }

    public void getUserInfo(int id){
        for (User user: userStorage.getUserList()) {
            if(id == user.getId()){
                System.out.println("id:" + id + " balance:"+user.getBalance());
                return;
            }
        }
        System.out.println("Nie ma takiego uzytkownika");
    }


}
