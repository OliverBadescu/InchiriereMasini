package app;

import app.User.User;
import app.User.UserService;

import java.util.Scanner;

public class LoginView {

    private UserService userService;
    private Scanner scanner;

    public LoginView(){
        this.userService = new UserService();
        this.scanner = new Scanner(System.in);

        this.play();

    }

    private void meniu(){
        System.out.println("Apasati tasta 1 pentru a va loga");
        System.out.println("Apasati tasta 2 pentru a va inregistra");
        System.out.println("Apasati tasta 3 pentru a iesi din aplicatie");


    }

    private void play(){

        boolean running = true;

        while(running ){
            meniu();
            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere){
                case 1:
                    logare();
                    break;
                case 2:
                    inregistrare();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Tasta incorecta");
            }
        }

    }

    private void logare(){

        System.out.println("Introduceti numele si parola");
        System.out.println("Nume: ");
        String username = scanner.nextLine();
        System.out.println("Parola: ");
        String parola = scanner.nextLine();

        User logare = userService.logare(username, parola);
        if(logare != null){
            UserView userView = new UserView(logare);
        }else{
            System.out.println("Date incorecte");
        }

    }

    private void inregistrare(){
        System.out.println("Introduceti numele si parola");
        System.out.println("Nume: ");
        String username = scanner.nextLine();
        System.out.println("Parola: ");
        String parola = scanner.nextLine();
        int id = userService.generareId();

        User user = new User(id, username, parola);

        if(userService.inregistrare(user)){
            System.out.println("V-ati inregistrat cu succes, logati-va pentru a continua");
        }else{
            System.out.println("Numele este deja folosit");
        }


    }


}
