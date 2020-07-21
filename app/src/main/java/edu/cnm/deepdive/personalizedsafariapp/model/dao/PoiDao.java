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


@Dao
public interface PoiDao {


  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(Poi poi);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<Poi> itineraries);

  @Update
  Single<Integer> update(Poi... pois);

  @Delete
  Single<Integer> delete(Poi... pois);

  @Query("SELECT * FROM Poi WHERE itinerary_id = :itineraryId")
  LiveData<List<Poi>> selectBYPoiId(Long itineraryId);

  @Transaction
  @Query("SELECT * FROM Poi ORDER BY name")
  LiveData<List<PoiWithItinerary>> selectAll();

  @Transaction
  @Query("SELECT * FROM Poi WHERE poi_id = :poiId")
  Single<PoiWithItinerary> selectById(long poiId);
}

