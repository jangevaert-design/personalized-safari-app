package edu.cnm.deepdive.personalizedsafariapp.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.General;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

/**
 * The GeneralDao works as a barrier between the application layer and the low level data by using
 * an abstract API.
 */
@Dao
public interface GeneralDao {

  /**
   * The implementation of the insert method will insert its parameters into the database.
   * @param general
   */
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(General general);

  /**
   * The implementation of the insert method will insert its parameters into the database.
   * @param generals
   */
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<General> generals);

  /**
   * The implementation of the update method will update its parameters into the database.
   * @param generals
   */
  @Update
  Single<Integer> update(General... generals);

  /**
   * The implementation of the delete method will delete its parameters into the database.
   * @param generals
   */
  @Delete
  Single<Integer> delete(General... generals);

  /**
   * This method allows to read the name of all general topics in this projects' database.
   * @return
   */
  @Query("SELECT * FROM General")
  LiveData<List<General>> selectAll();


  /**
   * This method allows to select the general topics by id in this projects' database.
   * @return
   */
  @Query("SELECT * FROM General WHERE general_id = :generalId")
  Single<General> selectById(long generalId);


}


