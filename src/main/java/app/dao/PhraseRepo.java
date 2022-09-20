package app.dao;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import app.model.PhraseModel;

import java.util.List;

/**
 * Database access for pets.
 */
@RegisterRowMapper(PhraseModel.Mapper.class)
public interface PhraseRepo {
  /**
   * List pets using start/max limits.
   *
   * @param start Start offset.
   * @param max Max number of rows.
   * @return Available pets.
   */
  @SqlQuery("select * from phrases limit :max offset :start")
  List<PhraseModel> list(int start, int max);

  /**
   * Find a pet by ID.
   *
   * @param id Pet ID.
   * @return Pet or null.
   */
  @SqlQuery("select * from phrases where id=:id")
  PhraseModel findById(long id);

  /**
   * Insert a pet and returns the generated PK.
   *
   * @param pet Pet to insert.
   * @return Primary key.
   */
  @SqlUpdate("insert into phrases(title, phrase) values(:title, :phrase)")
  @GetGeneratedKeys
  long insert(@BindBean PhraseModel pet);

  /**
   * Update a pet and returns true if the pets was updated.
   *
   * @param pet Pet to update.
   * @return True if the pet was updated.
   */
  @SqlUpdate("update phrases set title=:title,phrase=:phrase where id=:id")
  boolean update(@BindBean PhraseModel pet);

  /**
   * Delete a pet by ID.
   *
   * @param id Pet ID.
   * @return True if the pet was deleted.
   */
  @SqlUpdate("delete phrases where id=:id")
  boolean delete(long id);
}
