package app.Inchiriere;

public class Inchiriere {

    private int idMasina;
    private int idUser;
    private int id;

    public Inchiriere(int idMasina, int idUser, int id){
        this.idMasina = idMasina;
        this.idUser= idUser;
        this.id = id;
    }

    public Inchiriere(int idMasina, int idUser){
        this.idMasina = idMasina;
        this.idUser= idUser;

    }

    public int getIdMasina(){return this.idMasina;}
    public void setIdMasina(int idMasina){this.idMasina = idMasina;}

    public int getIdUser(){return this.idUser;}
    public void setIdUser(int idUser){this.idUser = idUser;}

    public int getId(){return this.id;}
    public void setId(int id){this.id = id;}

    public String descriere(){

        String text = "";

        text += "Id Masina: " + this.idMasina + "\n";
        text+= "Id User: " + this.idUser + "\n";
        text+= "Id: " + this.id + "\n";

        return text;

    }



}
