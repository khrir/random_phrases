package app;

import java.nio.file.Paths;

import io.jooby.Jooby;

public class App extends Jooby {

  {
    // install(new MyTemplateEngineModule());
    assets("/assets/*", Paths.get("assets"));
    get("/", ctx -> Paths.get("assets/index.html"));

    // get("/card", ctx -> Paths.get("assets/card.html"));
    // get("/cadastrar", ctx -> Paths.get("assets/form.html"));
    // post("/cadastrar", ctx -> new InsertController());
  }

  public static void main(final String[] args) {
    runApp(args, App::new);
  }

}
