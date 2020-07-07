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
import edu.cnm.deepdive.personalizedsafariapp.model.entity.Poi;
import edu.cnm.deepdive.personalizedsafariapp.model.pojo.ItineraryWithPoi;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;


@Dao
public interface ItineraryDao {


  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(Itinerary itinerary);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<Itinerary> itineraries);

  @Update
  Single<Integer> update(Itinerary... itineraries);

  @Delete
  Single<Integer> delete(Itinerary... itineraries);

  @Query("SELECT * FROM Itinerary WHERE itinerary_id = :itineraryId")
  LiveData<List<Itinerary>> selectBYItineraryId(long itineraryId);


  @Transaction
  @Query("SELECT * FROM Itinerary ORDER BY parkName")
  LiveData<List<ItineraryWithPoi>> selectAll();


  @Transaction
  @Query("SELECT * FROM Itinerary WHERE itinerary_id = :itineraryId")
  Single<ItineraryWithPoi> selectById(long itineraryId);


}