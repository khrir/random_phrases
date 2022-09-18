package app.model;

public class PhraseModel {
    private int id;
    private String title;
    private String phrase;
    
    public PhraseModel(){}

    public PhraseModel(int id, String title, String phrase){
        super();
        this.id = id;
        this.title = title;
        this.phrase = phrase;
    }

    public int getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getPhrase(){
        return phrase;
    }

    public int setId(int id){
        return this.id = id;
    }

    public String setTitle(String title){
        return this.title = title;
    }

    public String setPhrase(String phrase){
        return this.phrase = phrase;
    }
}