package app.Controllers;

import java.util.List;

import app.dao.PhraseRepo;
import app.model.PhraseModel;
import io.jooby.Context;
import io.jooby.annotations.*;

@Transactional
public class PhraseView{

  @Path("/phrase/all")
  @GET
  public List<PhraseModel> renderAllPhrases(Context context){
    PhraseRepo repo =  context.require(PhraseRepo.class);
    return repo.list(0, 10);
  }

  @Path("/phrase/{id}")
  @GET
  public PhraseModel store(Context context, @PathParam int id){
    PhraseRepo repo =  context.require(PhraseRepo.class);
    PhraseModel phrase = repo.findById(id);
    return phrase;
  }
}

// @Path("/update")
//   @POST
//   public PhraseModel create(Context context){
//     Jdbi jdbi = require(Jdbi.class);
//     PhraseModel result = context.body(PhraseModel.class);

//     jdbi.useHandle(h -> {
//       PhraseRepo repo = h.attach(PhraseRepo.class);
//       repo.update(result);
//     });
//     return StatusCode.OK;
//   };
