package edu.cnm.deepdive.personalizedsafariapp.model.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.personalizedsafariapp.model.dao.AccommodationDao;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.Accommodation;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.Date;
import java.util.List;

/**
 * The AccommodationRepository handles the data operations related to the accommodation columns in
 * the datebase
 */
public class AccommodationRepository {


  /**
   * The three fields below keep track of the usernames in this project.
   */
  private final Context context;
  private final PersonalizedSafariAppDatabase database;
  private final AccommodationDao accommodationDao;

  /**
   * This is the constructor for the AccommodationRepository.
   * @param context
   */
  public AccommodationRepository(Context context) {
    this.context = context;
    database = PersonalizedSafariAppDatabase.getInstance();
    accommodationDao = database.getAccommodationDao();
  }

  public LiveData<List<Accommodation>> getAll() {
    return accommodationDao.selectAll();
  }

  public Single<Accommodation> get(long id) {
    return accommodationDao.selectById(id)
        .subscribeOn(Schedulers.io());
  }
  public Maybe<Accommodation> get(Date date) {
    return accommodationDao.selectByDate(date)
        .subscribeOn(Schedulers.io());
  }


  public Completable save(Accommodation accommodation) {
    if (accommodation.getId() == 0) {
      return Completable.fromSingle(accommodationDao.insert(accommodation))
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(accommodationDao.update(accommodation))
          .subscribeOn(Schedulers.io());
    }
  }

  public Completable delete(Accommodation accommodation) {
    if (accommodation.getId() == 0) {
      return Completable.fromAction(() -> {
      })
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(accommodationDao.delete(accommodation))
          .subscribeOn(Schedulers.io());
    }
  }


}

