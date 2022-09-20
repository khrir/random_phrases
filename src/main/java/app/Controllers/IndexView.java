package app.Controllers;

import java.nio.file.Paths;

import io.jooby.Context;
import io.jooby.annotations.GET;
import io.jooby.annotations.Path;

@Path("/")
public class IndexView {
    @GET
    public java.nio.file.Path loadHTML(Context ctx) {
      return Paths.get("assets/index.html");
    }
}
