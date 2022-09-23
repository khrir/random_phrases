package app;

import java.nio.file.Paths;

import org.jdbi.v3.core.Jdbi;

import app.Controllers.IndexView;
import app.Controllers.PhraseView;
import app.dao.PhraseRepo;
import app.model.PhraseModel;
import io.jooby.Jooby;
import io.jooby.StatusCode;
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

    onStarted(() -> {
      Jdbi jdbi = require(Jdbi.class);
      jdbi.useHandle(h -> {
        h.createUpdate("create table phrases (id int auto_increment, title varchar(255), phrase varchar(255))")
            .execute();

        PhraseRepo repo = h.attach(PhraseRepo.class);
        repo.insert(new PhraseModel("Lala", " LuLaLa"));
      });
    });

    post( "/create", req -> {
      Jdbi jdbi = require(Jdbi.class);
      PhraseModel result = req.body(PhraseModel.class);
      String title = result.getTitle();
      String phrase = result.getPhrase();

      jdbi.useHandle(h -> {
        PhraseRepo repo = h.attach(PhraseRepo.class);
        repo.insert(new PhraseModel(title, phrase));
      });
      return StatusCode.OK;
    });

    post( "/update", req -> {
      Jdbi jdbi = require(Jdbi.class);
      PhraseModel result = req.body(PhraseModel.class);
      System.out.println(result);
      int id = result.getId();
      String title = result.getTitle();
      String phrase = result.getPhrase();

      jdbi.useHandle(h -> {
        PhraseRepo repo = h.attach(PhraseRepo.class);
        repo.update(new PhraseModel(id, title, phrase));
      });
      return StatusCode.OK;
    });

    post("/delete", req -> {
      Jdbi jdbi = require(Jdbi.class);
      PhraseModel result = req.body(PhraseModel.class);
      int id = result.getId();
      jdbi.useHandle(h -> {
        PhraseRepo repo = h.attach(PhraseRepo.class);
        repo.delete(id);
      });
      return StatusCode.OK;
    });

    mvc(new PhraseView());

  }

  public static void main(final String[] args) {
    runApp(args, App::new);
  }

}
