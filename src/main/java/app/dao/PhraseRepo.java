package app.dao;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import app.model.PhraseModel;

import java.util.List;

/**
 * Database access for phrases.
 */
@RegisterRowMapper(PhraseModel.Mapper.class)
public interface PhraseRepo {

  @SqlQuery("select * from phrases limit :max offset :start")
  List<PhraseModel> list(int start, int max);

  @SqlQuery("select * from phrases where id=:id")
  PhraseModel findById(int id);

  @SqlUpdate("insert into phrases(title, phrase) values(:title, :phrase)")
  @GetGeneratedKeys
  long insert(@BindBean PhraseModel phrase);

  @SqlUpdate("update phrases set title=:title,phrase=:phrase where id=:id")
  boolean update(@BindBean PhraseModel phrase);

  @SqlUpdate("delete phrases where id=:id")
  boolean delete(int id);
}
