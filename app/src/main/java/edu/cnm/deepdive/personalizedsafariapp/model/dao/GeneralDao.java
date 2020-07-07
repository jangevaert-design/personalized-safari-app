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


@Dao
public interface GeneralDao {


  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(General general);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<General> generals);

  @Update
  Single<Integer> update(General... generals);

  @Delete
  Single<Integer> delete(General... generals);

  @Query("SELECT * FROM General")
  LiveData<List<General>> selectAll();

  @Query("SELECT * FROM General WHERE general_id = :generalId")
  Single<General> selectById(long generalId);


}


