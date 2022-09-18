package app.Controllers;
import java.nio.file.Paths;

import ch.qos.logback.core.Context;
import io.jooby.annotations.*;

@Path("/")
public class PhraseController {

  @GET
  public java.nio.file.Path loadHTML(Context ctx) {
    return Paths.get("assets/index.html");
  }

  @POST
  public String store(){
    return "POST";
  }
}