package app.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class PhraseModel {
    private int id;
    private String title;
    private String phrase;

    public static class Mapper implements RowMapper<PhraseModel> {
        @Override
        public PhraseModel map(ResultSet rs, StatementContext ctx) throws SQLException {
            return new PhraseModel(rs.getInt("id"), rs.getString("title"), rs.getString("phrase"));
        }
    }

    public PhraseModel() {
    }

    public PhraseModel(String title, String phrase) {
        super();
        this.title = title;
        this.phrase = phrase;
    }

    public PhraseModel(int id, String title, String phrase) {
        super();
        this.id = id;
        this.title = title;
        this.phrase = phrase;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPhrase() {
        return phrase;
    }

    public int setId(int id) {
        return this.id = id;
    }

    public String setTitle(String title) {
        return this.title = title;
    }

    public String setPhrase(String phrase) {
        return this.phrase = phrase;
    }
}