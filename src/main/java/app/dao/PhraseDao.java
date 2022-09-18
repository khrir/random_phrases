package app.dao;

import app.model.PhraseModel;

public class PhraseDao {
    final PhraseModel phraseModel;

    public PhraseDao(PhraseModel phraseModel) {
        this.phraseModel = phraseModel;
    }

    public PhraseModel getPhraseModel() {
        return phraseModel;
    }
}
