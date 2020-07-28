package edu.cnm.deepdive.personalizedsafariapp.model.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.personalizedsafariapp.model.dao.ItineraryDao;
import edu.cnm.deepdive.personalizedsafariapp.model.dao.PoiDao;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.Poi;
import edu.cnm.deepdive.personalizedsafariapp.model.pojo.PoiWithItinerary;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;


/**
 * The PoiRepository handles the data operations related to the point of interest columns in
 * the datebase
 */
public class PoiRepository {


  private final Context context;
  private final PersonalizedSafariAppDatabase database;
  private final ItineraryDao itineraryDao;
  private final PoiDao poiDao;

  /**
   * The constructor to initialize objects in the PoiRepository class.
   * @param context
   */
  public PoiRepository(Context context) {
    this.context = context;
    database = PersonalizedSafariAppDatabase.getInstance();
    itineraryDao = database.getItineraryDao();
    poiDao = database.getPoiDao();

  }
  /**
   * this method gets all the PoiWithItinerary data from the PoiDao
   */
  public LiveData<List<PoiWithItinerary>> getAll() {
    return poiDao.selectAll();
  }


  /**
   * This method gets PoiWithItinerary data by id from the PoiDao.
   * @param id
   */
  public Single<PoiWithItinerary> get(long id) {
    return poiDao.selectById(id)
        .subscribeOn(Schedulers.io());
  }

  /**
   * This method saves data regarding poi in the database.
   * @param poi
   */
  public Completable save(Poi poi) {
    if (poi.getId() == 0) {
      return Completable.fromSingle(poiDao.insert(poi))
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(poiDao.update(poi))
          .subscribeOn(Schedulers.io());
    }
  }

  /**
   * This method deletes data regarding poi in the database.
   * @param poi
   */
  public Completable delete(Poi poi) {
    if (poi.getId() == 0) {
      return Completable.fromAction(() -> {
      })
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(poiDao.delete(poi))
          .subscribeOn(Schedulers.io());
    }
  }


}
