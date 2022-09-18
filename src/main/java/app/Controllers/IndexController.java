package app.Controllers;
// import io.jooby.ModelAndView;
import io.jooby.annotations.*;

@Path("/")
public class IndexController {

  @GET
  public String sayHi() {
    return "Welcome to Jooby!";
  }

  // @GET
  // public ModelAndView loadIndex(){
  //   return new ModelAndView("assets/index.html");
  // }
}