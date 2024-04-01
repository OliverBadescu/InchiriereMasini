package app.User;

import app.Inchiriere.Inchiriere;

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

    public User logare(String username, String parola){

        for (int i =0 ; i < users.size(); i++){
            if(users.get(i).getUsername().equals(username) && users.get(i).getParola().equals(parola)){
                return users.get(i);
            }
        }
        return null;
    }

    private User findUserById(int id){
        for (int i =0; i < users.size();i++){
            if(users.get(i).getId() == id){
                return users.get(i);
            }
        }
        return null;
    }
    public int generareId(){

        int id=(int) Math.round(Math.random()*1000+1);

        while (findUserById(id)!=null){
            id=(int) Math.round(Math.random()*1000+1);
        }

        return id;
    }
    public boolean inregistrare(User user){

        for (int i =0 ; i < users.size();i++){
            if(users.get(i).getUsername().equals(user.getUsername())){
                return false;
            }
        }
        users.add(user);
        return true;
    }



}
