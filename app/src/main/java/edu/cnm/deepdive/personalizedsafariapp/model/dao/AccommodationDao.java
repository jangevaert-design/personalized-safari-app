package edu.cnm.deepdive.personalizedsafariapp.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.Accommodation;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * The AccommodationDao works as a barrier between the application layer and the low level data by
 * using an abstract API.
 */
@Dao
public interface AccommodationDao {


  /**
   * The implementation of the insert method will insert its parameters into the database.
   *
   * @param accommodation
   */
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(Accommodation accommodation);

  /**
   * The implementation of the insert method will insert its parameters into the database.
   *
   * @param accommodations
   */
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<Accommodation> accommodations);

  /**
   * The implementation of the update method will update its parameters into the database.
   * @param accommodations
   */
  @Update
  Single<Integer> update(Accommodation... accommodations);

  /**
   * The implementation of the delete method will delete its parameters into the database.
   * @param accommodations
   */
  @Delete
  Single<Integer> delete(Accommodation... accommodations);

  /**
   * This method allows to read the name of all accommodations in this projects' database.
   */
  @Query("SELECT * FROM Accommodation ORDER BY name")
  LiveData<List<Accommodation>> selectAll();

  /**
   * This method allows to select the accommodations by id in this projects' database.
   */
  @Query("SELECT * FROM Accommodation WHERE accommodation_id = :accommodationId")
  Single<Accommodation> selectById(long accommodationId);


  /**
   * This method allows to read the accommodations by start and end date in this projects'
   * database.
   */
  @Query("SELECT * FROM Accommodation WHERE start <= :date AND `end` >= :date")
  Maybe<Accommodation> selectByDate(Date date);


}
