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


  private final Context context;
  private final PersonalizedSafariAppDatabase database;
  private final AccommodationDao accommodationDao;

  /**
   * The constructor to initialize objects in the AccommodationRepository class.
   * @param context
   */
  public AccommodationRepository(Context context) {
    this.context = context;
    database = PersonalizedSafariAppDatabase.getInstance();
    accommodationDao = database.getAccommodationDao();
  }

  /**
   * this method gets all the Accommodation data from the AccommodationDao
   */
  public LiveData<List<Accommodation>> getAll() {
    return accommodationDao.selectAll();
  }

  /**
   * This method gets Accommodation data by id from the AccommodationDao.
   * @param id
   */
  public Single<Accommodation> get(long id) {
    return accommodationDao.selectById(id)
        .subscribeOn(Schedulers.io());
  }

  /**
   * This method gets Accommodation data by date from the AccommodationDao.
   * @param date
   */
  public Maybe<Accommodation> get(Date date) {
    return accommodationDao.selectByDate(date)
        .subscribeOn(Schedulers.io());
  }

  /**
   * This method saves data regarding accommodation in the database.
   * @param accommodation
   */
  public Completable save(Accommodation accommodation) {
    if (accommodation.getId() == 0) {
      return Completable.fromSingle(accommodationDao.insert(accommodation))
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(accommodationDao.update(accommodation))
          .subscribeOn(Schedulers.io());
    }
  }

  /**
   * This method deletes data regarding accommodation in the database.
   * @param accommodation
   */
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

