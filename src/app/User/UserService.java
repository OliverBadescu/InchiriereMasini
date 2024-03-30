package app.User;

import java.util.ArrayList;


public class UserService {

    private ArrayList<User> users;



    public UserService(){
        this.users = new ArrayList<>();

        this.loadData();
    }

    private void loadData(){

        User u1 = new User(20, "john_doe", "123456");
        User u2 = new User(21, "alice_smith", "password123");
        User u3 = new User(22, "super_user", "admin@2022");
        User u4 = new User(23, "test_account", "test_password");
        User u5 = new User(24, "test", "9222");

        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);
        users.add(u5);


    }

    public void afisareUser(){

        for (int i =0 ; i < users.size(); i++){
            System.out.println(users.get(i).descriere());
        }

    }


}
