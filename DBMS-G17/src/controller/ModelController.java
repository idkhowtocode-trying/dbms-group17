package controller;
//strings are all set to int for development purposes
public class ModelController {
    private int username;
    private int password;

    public void setUsername(String u) { //ask for username
        this.username = Integer.parseInt(u);
    }
    public void setPassword(String p){
        this.password = Integer.parseInt(p);
    }
    //public List<Item> getCatalogue(){
    //    List<Item> items = new ArrayList<>();
    //    items.addAll()
    //}

}