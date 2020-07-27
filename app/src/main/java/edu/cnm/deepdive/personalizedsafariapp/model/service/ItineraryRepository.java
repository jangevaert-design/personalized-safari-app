package edu.cnm.deepdive.personalizedsafariapp.model.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.personalizedsafariapp.model.dao.ItineraryDao;
import edu.cnm.deepdive.personalizedsafariapp.model.dao.PoiDao;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.Itinerary;
import edu.cnm.deepdive.personalizedsafariapp.model.pojo.ItineraryWithPoi;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.Date;
import java.util.List;

/**
 * The ItineraryRepository handles the data operations related to the itinerary colums in
 * the datebase
 */
public class ItineraryRepository {

  /**
   * The four fields below keep track of the usernames in this project.
   */
  private final Context context;
  private final PersonalizedSafariAppDatabase database;
  private final PoiDao poiDao;
  private final ItineraryDao itineraryDao;

  /**
   * This is the constructor for the ItineraryRepository.
   * @param context
   */
  public ItineraryRepository(Context context) {
    this.context = context;
    database = PersonalizedSafariAppDatabase.getInstance();
    poiDao = database.getPoiDao();
    itineraryDao = database.getItineraryDao();
  }

  public LiveData<List<ItineraryWithPoi>> getAll() {
    return itineraryDao.selectAll();
  }

  public Single<ItineraryWithPoi> get(long id) {
    return itineraryDao.selectById(id)
        .subscribeOn(Schedulers.io());
  }
  public Maybe<ItineraryWithPoi> get(Date date) {
    return itineraryDao.selectByDate(date)
        .subscribeOn(Schedulers.io());
  }

  public Completable save(Itinerary itinerary) {
    if (itinerary.getId() == 0) {
      return Completable.fromSingle(itineraryDao.insert(itinerary))
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(itineraryDao.update(itinerary))
          .subscribeOn(Schedulers.io());
    }
  }

  public Completable delete(Itinerary itinerary) {
    if (itinerary.getId() == 0) {
      return Completable.fromAction(() -> {
      })
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(itineraryDao.delete(itinerary))
          .subscribeOn(Schedulers.io());
    }
  }


}
