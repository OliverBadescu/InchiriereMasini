package app.User;

public class User {

    private int id;
    private String username;
    private String parola;




    public User(int id, String username, String parola){

        this.id = id;
        this.username = username;
        this.parola= parola;


    }

    public int getId(){return this.id;}
    public void setId(int id){this.id = id;}
    public String getUsername(){return this.username;}
    public void setUsername(String username){this.username = username;}

    public String getParola(){return this.parola;}
    public void setParola(String parola){this.parola = parola;}


    public String descriere(){
        String text = "";

        text += "Id: " + this.id + "\n";
        text+="Username: " +this.username + "\n";
        text+= "Parola: "+this.parola + "\n";

        return text;
    }




}


