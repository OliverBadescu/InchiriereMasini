package app.Masina;

import app.Inchiriere.Inchiriere;

import java.util.ArrayList;
import java.util.Scanner;

public class MasinaService {

    private ArrayList<Masina> masini;

    public MasinaService(){
        this.masini = new ArrayList<>();
        this.loadData();
    }

    private void loadData(){

        Masina m1 = new Masina(10,"Dacia", "Logan", 2018, 12000, true, true);
        Masina m2 = new Masina(11, "Ford", "Focus", 2019, 15000, false, true);
        Masina m3 = new Masina(12, "Volkswagen", "Golf", 2020, 18000, false, true);
        Masina m4 = new Masina(13, "Toyota", "Corolla", 2017, 14000, true, false);
        Masina m5 = new Masina(14, "BMW", "Series 3", 2021, 30000, false, true);

        masini.add(m1);
        masini.add(m2);
        masini.add(m3);
        masini.add(m4);
        masini.add(m5);
    }

    public void afisareMasini(){
        for (int i =0 ; i < masini.size();i++){
            System.out.println(masini.get(i).descriere());
        }
    }

    public void afisareMasiniDisponibile(){

        for (int i =0 ; i < masini.size();i++){
            if(masini.get(i).getStatus()){
                System.out.println(masini.get(i).descriere());
            }
        }

    }
    public Masina findByMarcaSiModel(String marca, String model){

        for (int i =0 ; i < masini.size();i++){
            if(masini.get(i).getMarca().equals(marca) && masini.get(i).getModel().equals(model)){
                return masini.get(i);
            }
        }
        return null;
    }
    public Masina findById(int id){
        for (int i =0 ; i < masini.size();i++){
            if(masini.get(i).getId() == id){
                return masini.get(i);
            }
        }
        return null;
    }
    public boolean adaugareMasina(Masina masina){

        if(this.findByMarcaSiModel(masina.getMarca(), masina.getModel()) != null){
            return false;
        }
        this.masini.add(masina);
        return true;
    }
    public boolean stergereMasina(String marca, String model){

        for(int i =0 ; i < masini.size();i++){
            if(masini.get(i).getMarca().equals(marca) && masini.get(i).getModel().equals(model)){
                this.masini.remove(masini.get(i));
                return true;
            }
        }
        return false;
    }
    public boolean editareMasina(String marca, String model){
        for (int i =0; i < masini.size();i++){
            if(masini.get(i).getMarca().equals(marca) && masini.get(i).getModel().equals(model)){
                return true;
            }
        }
        return false;
    }
    public ArrayList<Masina> listaMasini(ArrayList<Integer> masiniIds){

        ArrayList<Masina> masiniLista = new ArrayList<>();

        for (int i =0 ; i <masini.size();i++){
            if(masiniIds.contains(masini.get(i).getId())){
                masiniLista.add(masini.get(i));
            }

        }
        return masiniLista;

    }
    public boolean inchiriareMasina(String marca, String model){

        Masina masina = findByMarcaSiModel(marca, model);
        if(masina.getStatus()){
            masina.setStatus(false);
            return true;
        }
        else{
            return false;
        }

    }

    public boolean returnareMasina(String marca, String model){

        Masina masina = findByMarcaSiModel(marca, model);
        if(!masina.getStatus()){
            masina.setStatus(true);
            return true;
        }
        return false;

    }

}
