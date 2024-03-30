package app;

import app.Inchiriere.Inchiriere;
import app.Inchiriere.InchiriereService;
import app.Masina.Masina;
import app.Masina.MasinaService;
import app.User.User;
import app.User.UserService;

import java.util.ArrayList;
import java.util.Scanner;

public class UserView {

    private UserService userService;
    private MasinaService masinaService;
    private InchiriereService inchiriereService;

    private User user;
    private Scanner scanner;


    public UserView(){
        user=  new User(20, "john_doe", "123456");
        this.userService= new UserService();
        this.masinaService = new MasinaService();
        this.inchiriereService = new InchiriereService();
        this.scanner = new Scanner(System.in);

        this.play();
    }

    //meniu
    //-->afisare masini disponbile

    private void meniu(){

        System.out.println("Apasati tasta 1 pentru a afisa masinile");
        System.out.println("Apasati tasta 2 pentru a afisa masinile disponibile");
        System.out.println("Apasati tasta 3 pentru a afisa masinile inchiriate");
        System.out.println("Apasati tasta 4 pentru a inchiria o masina");
        System.out.println("Apasati tasta 5 pentru a returna o masina");
        System.out.println("Apasati tasta 6 pentru a adauga o masina in lista");
        System.out.println("Apasati tasta 7 pentru a sterge o masina din lista");
        System.out.println("Apasati tasta 8 pentru a edita o masina din lista");


    }

    private void play(){

        boolean running = true;

        while (running) {
            meniu();
            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere) {

                case 1:
                    masinaService.afisareMasini();
                    break;
                case 2:
                    masinaService.afisareMasiniDisponibile();
                    break;
                case 3:
                    afisareMasiniInchiriate();
                    break;
                case 4:
                    inchiriareMasina();
                    break;
                case 5:
                    returnareMasina();
                    break;
                case 6:
                    adaugareMasina();
                    break;
                case 7:
                    stergereMasina();
                    break;
                case 8:
                    editareMasina();
                    break;
                default:
                    System.out.println("Tasta incorecta");

            }
        }

    }


    private void afisareMasiniInchiriate(){


        ArrayList<Integer> lista = new ArrayList(inchiriereService.inchirieriUser(this.user.getId()));
        ArrayList<Masina> listaMasini = new ArrayList<>(masinaService.listaMasini(lista));

        for (int i =0 ; i < listaMasini.size();i++){
            System.out.println(listaMasini.get(i).descriere());
        }

    }
    private void inchiriareMasina(){

        System.out.println("Introduceti marca si modelul masini care doriti sa o inchiriati: ");
        System.out.println("Marca: ");
        String marca = scanner.nextLine();
        System.out.println("Model: " );
        String model = scanner.nextLine();
        Masina masina = masinaService.findByMarcaSiModel(marca, model);

        if(masina != null) {
            if (masinaService.inchiriareMasina(marca, model)) {
                System.out.println("Masina a fost inchiriata");
                Inchiriere nou = new Inchiriere(masina.getId(), this.user.getId(), inchiriereService.generareId());
                inchiriereService.adaugareInchiriere(nou);
            } else {
                System.out.println("Masina este deja inchiriata");
            }
        }else{
            System.out.println("Masina nu se afla in lista");
        }

    }
    private void returnareMasina(){

        System.out.println("Introduceti marca si modelul masinii care doriti sa o returnati: ");
        System.out.println("Marca: ");
        String marca = scanner.nextLine();
        System.out.println("Model: " );
        String model = scanner.nextLine();
        Masina masina = masinaService.findByMarcaSiModel(marca, model);

        if(masina != null){
            if(masinaService.returnareMasina(marca, model)){
                System.out.println("Masina a fost returnata");
            }else{
                System.out.println("Masina nu este inchiriata");
            }
        }else{
            System.out.println("Masina nu se afla in lista");
        }


    }
    private void adaugareMasina(){

        System.out.println("Introduceti datele masinii: ");
        System.out.println("Id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Marca: ");
        String marca = scanner.nextLine();
        System.out.println("Model: ");
        String model = scanner.nextLine();
        System.out.println("Anul de fabricatie: ");
        int anFabricatie = Integer.parseInt(scanner.nextLine());
        System.out.println("Kilometraj: ");
        int kilometraj = Integer.parseInt(scanner.nextLine());
        System.out.println("Este uzata? (true/false)");
        boolean uzata = Boolean.parseBoolean(scanner.nextLine());


        Masina masina = new Masina(id, marca, model, anFabricatie, kilometraj, uzata, false);

        if(masinaService.adaugareMasina(masina)){
            System.out.println("Masina a fost adaugata");
        }else{
            System.out.println("Masina se afla deja in lista");
        }



    }
    private void stergereMasina(){
        System.out.println("Ce masina doriti sa stergeti din lista?");
        System.out.println("Marca: ");
        String marca = scanner.nextLine();
        System.out.println("Model: ");
        String model = scanner.nextLine();

        if(masinaService.stergereMasina(marca,model)){
            System.out.println("Masina a fost stearsa din lista");
        }else{
            System.out.println("Masina nu se afla in lista");
        }
    }
    private void editareMasina(){
        System.out.println("Ce masina doriti sa editati din lista?");
        System.out.println("Marca: ");
        String marca = scanner.nextLine();
        System.out.println("Model: ");
        String model = scanner.nextLine();
        Masina masina = masinaService.findByMarcaSiModel(marca, model);

        if(masinaService.editareMasina(marca, model)){
            System.out.println("Ce doriti sa editati: ");
            System.out.println("1. An fabricatie");
            System.out.println("2. Kilometraj");
            System.out.println("3. Uzata");

            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere){
                case 1:
                    System.out.println("Introduceti noul an de fabricatie: ");
                    int anFabricatie = Integer.parseInt(scanner.nextLine());
                    masina.setAnFabricatie(anFabricatie);
                    break;
                case 2:
                    System.out.println("Introduceti noul kilometraj");
                    int kilometraj = Integer.parseInt(scanner.nextLine());
                    masina.setKilometraj(kilometraj);
                    break;
                case 3:
                    System.out.println("Introduceti daca este uzata: ");
                    boolean uzata = Boolean.parseBoolean(scanner.nextLine());
                    masina.setUzata(uzata);
                    break;
                default:
                    System.out.println("Tasta incorecta");
            }

        }


    }
}
