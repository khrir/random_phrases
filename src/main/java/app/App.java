package app;

import java.nio.file.Paths;

import org.jdbi.v3.core.Jdbi;

import app.Controllers.IndexView;

// import javax.sql.DataSource;

import app.Controllers.PhraseView;
import app.dao.PhraseRepo;
// import app.dao.PhraseDao;
import app.model.PhraseModel;
import io.jooby.Jooby;
import io.jooby.hikari.HikariModule;
import io.jooby.jdbi.JdbiModule;
import io.jooby.jdbi.TransactionalRequest;
import io.jooby.json.JacksonModule;

public class App extends Jooby {

  {
    assets("/assets/*", Paths.get("assets"));
    mvc(new IndexView());
    
    install(new JacksonModule());
    install(new HikariModule());
    install(new JdbiModule().sqlObjects(PhraseRepo.class));
    decorator(new TransactionalRequest());

    // accessing to the data source
    // get("/bd", req -> {
    //   DataSource db = require(DataSource.class);
    //   // do something with datasource
    // }); 

    mvc(new PhraseView());

    post( "/", req -> {
      PhraseModel phraseModel = req.form(PhraseModel.class);
      // phraseDao.inserir(phraseModel);
      System.out.println(phraseModel.getId());
      System.out.println(phraseModel.getTitle());
      System.out.println(phraseModel.getPhrase());

      return true;
    });
    
    onStarting(() -> {
      Jdbi jdbi = require(Jdbi.class);
      jdbi.useHandle(h -> {
        h.createUpdate("create table phrases (id int auto_increment, title varchar(255), phrase varchar(255))")
            .execute();

        PhraseRepo repo = h.attach(PhraseRepo.class);
        repo.insert(new PhraseModel("Lala", " LuLaLa"));
      });
    });
  }

  public static void main(final String[] args) {
    runApp(args, App::new);
  }

}
