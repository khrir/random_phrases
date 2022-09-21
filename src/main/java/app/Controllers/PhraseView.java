package app.Controllers;

import app.dao.PhraseRepo;
import app.model.PhraseModel;
import io.jooby.Context;
import io.jooby.annotations.*;

@Path("/phrase")
@Transactional
public class PhraseView {

  @GET
  public String render(){
    return "OPa";
  }

  @Path("/{id}")
  @GET
  public PhraseModel store(Context context, @PathParam int id){
    PhraseRepo repo =  context.require(PhraseRepo.class);
    PhraseModel phrase = repo.findById(id);
    return phrase;
  }
}

// public class Controller {

//   @POST
//   @Path("/save")
//   public Result submit(Contact contact) {
//     ...
//   }
// }
