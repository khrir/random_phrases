package app;

import java.nio.file.Paths;

// import javax.sql.DataSource;

import org.jooby.jdbc.Jdbc;

import app.Controllers.PhraseController;
import app.dao.PhraseDao;
import app.model.PhraseModel;
import io.jooby.Jooby;

public class App extends Jooby {

  {
    mount(new Jdbc("db"));
    assets("/assets/*", Paths.get("assets"));
    
    // accessing to the data source
    // get("/bd", req -> {
    //   DataSource db = require(DataSource.class);
    //   // do something with datasource
    // }); 

    mvc(new PhraseController());

    post( "/", req -> {
      PhraseModel phraseModel = req.form(PhraseModel.class);
      // phraseDao.inserir(phraseModel);
      System.out.println(phraseModel.getId());
      System.out.println(phraseModel.getTitle());
      System.out.println(phraseModel.getPhrase());
      return true;
    });

  }

  public static void main(final String[] args) {
    runApp(args, App::new);
  }

  private void mount(Jdbc jdbc) {
  }

}
