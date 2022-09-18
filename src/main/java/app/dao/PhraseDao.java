package app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.model.PhraseModel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhraseDao {
    private Connection connection;
    
    public PhraseDao() {
        try {
            String url = "jdbc:sqlite:DriverBD/banco_sqlite.db";
            this.connection = DriverManager.getConnection(url);
        } catch(SQLException e){
            System.err.println("\nNao foi possivel conectar ao banco.\n" + e.getMessage());
        }
    }

    public List<PhraseModel> consultar(Integer id) {
        String sql = "SELECT FROM phrases WHERE id=?";
        List<PhraseModel> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                PhraseModel phrase = new PhraseModel();
                phrase.setId(resultado.getInt("id"));
                phrase.setTitle(resultado.getString("title"));
                phrase.setPhrase(resultado.getString("phrase"));
                retorno.add(phrase);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhraseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public boolean inserir(PhraseModel phrase) {
        String sql = "INSERT INTO phrases(id, title, phrase) VALUES(?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, phrase.getId());
            stmt.setString(2, phrase.getTitle());
            stmt.setString(3, phrase.getPhrase());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PhraseDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean remover(Integer id) {
        String sql = "DELETE FROM phrases WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PhraseDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
