package edu.cnm.deepdive.personalizedsafariapp.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.Accommodation;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface AccommodationDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(Accommodation accommodation);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<Accommodation> accommodations);

  @Update
  Single<Integer> update(Accommodation... accommodations);

  @Delete
  Single<Integer> delete(Accommodation... accommodations);


  @Query("SELECT * FROM Accommodation ORDER BY name")
  LiveData<List<Accommodation>> selectAll();


  @Query("SELECT * FROM Accommodation WHERE accommodation_id = :accommodationId")
  Single<Accommodation> selectById(long accommodationId);


}
