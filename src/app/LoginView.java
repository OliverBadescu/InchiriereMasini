package app;

import app.User.UserService;

import java.util.Scanner;

public class LoginView {

    private UserService userService;
    private Scanner scanner;

    public LoginView(){
        this.userService = new UserService();
        this.scanner = new Scanner(System.in);

    }

    private void meniu(){

        System.out.println("Apasati tasta 1 pentru a va inregistra");
        System.out.println("Apasati tasta 2 pentru a va loga");
        System.out.println("Apasati tasta 3 pentru a iesi din cont");

    }

    private void play(){

        boolean running = true;

        while(running ){
            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere){
                case 1:

            }
        }

    }


}
