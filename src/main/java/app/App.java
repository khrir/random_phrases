package app;

import java.nio.file.Paths;

import javax.sql.DataSource;

import org.jooby.jdbc.Jdbc;

import app.Controllers.PhraseController;
import app.model.PhraseModel;
import io.jooby.Jooby;

public class App extends Jooby {

  {
    // // install(new MyTemplateEngineModule());
    assets("/assets/*", Paths.get("assets"));
    // get("/", ctx -> Paths.get("assets/index.html"));
    
    
    // get("/my-api", req -> {DataSource ds = require(DataSource.class);}); 
    mvc(new PhraseController());

    // post( "/", req -> {
    //   PhraseModel phraseModel = req.form(PhraseModel.class);
    //   System.out.println(phraseModel.getId());
    //   System.out.println(phraseModel.getTitle());
    //   System.out.println(phraseModel.getPhrase());
    //   return true;
    // });

  }

  public static void main(final String[] args) {
    runApp(args, App::new);
  }

}
