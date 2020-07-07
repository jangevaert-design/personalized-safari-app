package edu.cnm.deepdive.personalizedsafariapp.model.service;

import android.content.Context;
import edu.cnm.deepdive.personalizedsafariapp.model.dao.AccommodationDao;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.Accommodation;
import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;

public class AccommodationRepository {

  private final Context context;
  private final PersonalizedSafariAppDatabase database;
  private final AccommodationDao accommodationDao;

  public AccommodationRepository(Context context) {
    this.context = context;
    database = PersonalizedSafariAppDatabase.getInstance();
    accommodationDao = database.getAccommodationDao();
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

