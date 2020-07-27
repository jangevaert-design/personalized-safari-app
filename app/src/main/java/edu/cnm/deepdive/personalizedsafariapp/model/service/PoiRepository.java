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

  /**
   * The four fields below keep track of the usernames in this project.
   */
  private final Context context;
  private final PersonalizedSafariAppDatabase database;
  private final ItineraryDao itineraryDao;
  private final PoiDao poiDao;

  /**
   * This is the constructor for the PoiRepository.
   * @param context
   */
  public PoiRepository(Context context) {
    this.context = context;
    database = PersonalizedSafariAppDatabase.getInstance();
    itineraryDao = database.getItineraryDao();
    poiDao = database.getPoiDao();

  }

  public LiveData<List<PoiWithItinerary>> getAll() {
    return poiDao.selectAll();
  }

  public Single<PoiWithItinerary> get(long id) {
    return poiDao.selectById(id)
        .subscribeOn(Schedulers.io());
  }

  public Completable save(Poi poi) {
    if (poi.getId() == 0) {
      return Completable.fromSingle(poiDao.insert(poi))
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(poiDao.update(poi))
          .subscribeOn(Schedulers.io());
    }
  }

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
