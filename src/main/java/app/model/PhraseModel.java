package app.model;

public class PhraseModel {
    private int id;
    private String description;
    
    public PhraseModel(){}

    public PhraseModel(int id, String description){
        this.id = id;
        this.description = description;
    }

    public int getId(){
        return id;
    }

    public String getDescription(){
        return description;
    }

    public int setId(int id){
        return this.id = id;
    }

    public String setDescription(String description){
        return this.description = description;
    }
}