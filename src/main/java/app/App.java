package app;

import java.nio.file.Paths;
import io.jooby.Jooby;

public class App extends Jooby {

  {

    // get("/", ctx -> "Welcome to Jooby!");
    assets("/assets/*", Paths.get("assets"));
    get("/", ctx -> Paths.get("assets/index.html"));
    get("/card", ctx -> Paths.get("assets/card.html"));
  }

  public static void main(final String[] args) {
    runApp(args, App::new);
  }

}
