package app.Masina;

public class Masina {

    private int id;
    private String marca;
    private String model;
    private int anFabricatie;
    private int kilometraj;
    private boolean uzata;
    private boolean status;



    public Masina(int id, String marca, String model, int anFabricatie, int kilometraj, boolean uzata, boolean status){

        this.id = id;
        this.marca = marca;
        this.model = model;
        this.anFabricatie = anFabricatie;
        this.kilometraj= kilometraj;
        this.uzata = uzata;
        this.status= status;

    }
    public int getId(){return this.id;}
    public void setId(int id){this.id = id;}

    public String getMarca(){
        return this.marca;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }

    public String getModel(){
        return this.model;
    }
    public void setModel(String model){this.model = model;}

    public int getAnFabricatie(){return this.anFabricatie;}
    public void setAnFabricatie(int anFabricatie){this.anFabricatie = anFabricatie;}

    public int getKilometraj(){return this.kilometraj;}
    public void setKilometraj(int kilometraj){this.kilometraj = kilometraj;}

    public boolean getUzata(){return this.uzata;}
    public void setUzata(boolean uzata){this.uzata = uzata;}

    public boolean getStatus(){return this.status;}
    public void setStatus(boolean status){this.status = status;}

    public String descriere(){

        String text = "";

        text+= "Id: " + this.id + "\n";
        text += "Marca: " + this.marca + "\n";
        text+= "Model: " + this.model + "\n";
        text+= "Kilometraj: " + this.kilometraj + "km" + "\n";
        text += "An fabricatie: " + this.anFabricatie + "\n";
        text+="Uzata: " + this.uzata + "\n";
        text+= "Status: " + this.status + "\n";

        return text;

    }

}
