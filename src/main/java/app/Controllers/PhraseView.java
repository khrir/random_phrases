package app.Controllers;

import java.util.List;

import app.dao.PhraseRepo;
import app.model.PhraseModel;
import io.jooby.Context;
import io.jooby.annotations.*;

@Path("/phrase")
@Transactional
public class PhraseView {

  @Path("/all")
  @GET
  public List<PhraseModel> renderAllPhrases(Context context){
    PhraseRepo repo =  context.require(PhraseRepo.class);
    return repo.list(0, 10);
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
