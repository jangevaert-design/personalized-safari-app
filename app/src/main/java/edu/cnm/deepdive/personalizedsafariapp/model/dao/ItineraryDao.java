package edu.cnm.deepdive.personalizedsafariapp.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.Itinerary;
import edu.cnm.deepdive.personalizedsafariapp.model.pojo.ItineraryWithPoi;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * The ItineraryDao works as a barrier between the application layer and the low level data by using
 * an abstract API.
 */
@Dao
public interface ItineraryDao {

  /**
   * The implementation of the insert method will insert its parameters into the database.
   */
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(Itinerary itinerary);

  /**
   * The implementation of the insert method will insert its parameters into the database.
   * @param itineraries
   */
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<? extends Itinerary> itineraries);

  /**
   * The implementation of the update method will update its parameters into the database.
   * @param itineraries
   */
  @Update
  Single<Integer> update(Itinerary... itineraries);

  /**
   * The implementation of the delete method will delete its parameters into the database.
   * @param itineraries
   */
  @Delete
  Single<Integer> delete(Itinerary... itineraries);

  /**
   * This method allows to select the itineraries by id in this projects' database.
   */
  @Query("SELECT * FROM Itinerary WHERE itinerary_id = :itineraryId")
  LiveData<List<Itinerary>> selectBYItineraryId(long itineraryId);

  /**
   * This transaction works as a set of operations bundled together and handled as a single unit
   * between the Itinerary and the Poi part of the database and handles the parkName.
   */
  @Transaction
  @Query("SELECT * FROM Itinerary ORDER BY parkName")
  LiveData<List<ItineraryWithPoi>> selectAll();

  /**
   * This transaction works as a set of operations bundled together and handled as a single unit
   * between the Itinerary and the Poi part of the database and handles the itineraryId.
   */
  @Transaction
  @Query("SELECT * FROM Itinerary WHERE itinerary_id = :itineraryId")
  Single<ItineraryWithPoi> selectById(long itineraryId);

  /**
   * This transaction works as a set of operations bundled together and handled as a single unit
   * between the Itinerary and the Poi part of the database and handles the start and end date.
   */
  @Transaction
  @Query("SELECT * FROM Itinerary WHERE start <= :date AND `end` >= :date")
  Maybe<ItineraryWithPoi> selectByDate(Date date);


}