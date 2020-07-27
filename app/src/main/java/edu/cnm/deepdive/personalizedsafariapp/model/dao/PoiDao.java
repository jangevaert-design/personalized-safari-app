package edu.cnm.deepdive.personalizedsafariapp.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.Poi;
import edu.cnm.deepdive.personalizedsafariapp.model.pojo.PoiWithItinerary;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

/**
 * The PoiDao works as a barrier between the application layer and the low level data by using an
 * abstract API.
 */
@Dao
public interface PoiDao {

  /**
   * The implementation of the insert method will insert its parameters into the database.
   *
   * @param poi
   * @return
   */
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(Poi poi);

  /**
   * The implementation of the insert method will insert its parameters into the database.
   *
   * @param itineraries
   * @return
   */
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<Poi> itineraries);

  /**
   * The implementation of the update method will update its parameters into the database.
   *
   * @param pois
   * @return
   */
  @Update
  Single<Integer> update(Poi... pois);

  /**
   * The implementation of the delete method will delete its parameters into the database.
   *
   * @param pois
   * @return
   */
  @Delete
  Single<Integer> delete(Poi... pois);

  /**
   * This method allows to select the Points of interest by id in this projects' database.
   *
   * @return
   */
  @Query("SELECT * FROM Poi WHERE itinerary_id = :itineraryId")
  LiveData<List<Poi>> selectBYPoiId(Long itineraryId);

  /**
   * This transaction works as a set of operations bundled together and handled as a single unit
   * between the Itinerary and the Poi part of the database.
   *
   * @return
   */
  @Transaction
  @Query("SELECT * FROM Poi ORDER BY name")
  LiveData<List<PoiWithItinerary>> selectAll();

  /**
   * This transaction works as a set of operations bundled together and handled as a single unit
   * between the Itinerary and the Poi part of the database.
   *
   * @return
   */
  @Transaction
  @Query("SELECT * FROM Poi WHERE poi_id = :poiId")
  Single<PoiWithItinerary> selectById(long poiId);
}

