package app.Inchiriere;

import app.Masina.MasinaService;

import java.util.ArrayList;
public class InchiriereService {

    private ArrayList<Inchiriere> inchirieri;

    public InchiriereService(){




        this.inchirieri = new ArrayList<>();
        this.loadData();

    }


    private Inchiriere findInchiriereById(int id){
        for (int i =0; i < inchirieri.size();i++){
            if(inchirieri.get(i).getId() == id){
                return inchirieri.get(i);
            }
        }
        return null;
    }


    private void loadData(){

        Inchiriere i1 = new Inchiriere(10, 20, 1);
        Inchiriere i2 = new Inchiriere(11, 20, 2);
        Inchiriere i3 = new Inchiriere(12, 20, 3);
        Inchiriere i4 = new Inchiriere(13, 23, 4);
        Inchiriere i5 = new Inchiriere(14, 24, 5);

        inchirieri.add(i1);
        inchirieri.add(i2);
        inchirieri.add(i3);
        inchirieri.add(i4);
        inchirieri.add(i5);
    }

    public void afisareInchirieri(){
        for(int i =0 ; i < inchirieri.size();i++){
            System.out.println(inchirieri.get(i).descriere());
        }
    }
    public ArrayList<Integer> inchirieriUser(int id){

        ArrayList<Integer> inchirieriUser = new ArrayList<>();

        for(int i =0 ; i < inchirieri.size();i++){
            if(inchirieri.get(i).getIdUser() == id){
                inchirieriUser.add(inchirieri.get(i).getIdMasina());
            }
        }
        return inchirieriUser;


    }

    public int generareId(){



         int id=(int) Math.round(Math.random()*1000+1);


         while (findInchiriereById(id)!=null){

             id=(int) Math.round(Math.random()*1000+1);
         }

         return id;


    }

    public void adaugareInchiriere(Inchiriere inchiriere){

        this.inchirieri.add(inchiriere);

    }


}
