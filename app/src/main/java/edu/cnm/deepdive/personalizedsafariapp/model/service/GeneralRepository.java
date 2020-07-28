package edu.cnm.deepdive.personalizedsafariapp.model.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.personalizedsafariapp.model.dao.GeneralDao;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.General;
import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;


/**
 * The GeneralRepository handles the data operations related to the general columns in
 * the datebase
 */
public class GeneralRepository {


  private final Context context;
  private final PersonalizedSafariAppDatabase database;
  private final GeneralDao generalDao;

  /**
   * The constructor to initialize objects in the GeneralRepository class.
   * @param context
   */
  public GeneralRepository(Context context) {
    this.context = context;
    database = PersonalizedSafariAppDatabase.getInstance();
    generalDao = database.getGeneralDao();
  }
  /**
   * this method gets all the General data from the GeneralDao
   * @return
   */
  public LiveData<List<General>> getAll() {
    return generalDao.selectAll();
  }

  /**
   * This method saves data regarding general in the database.
   * @param general
   */
  public Completable save(General general) {
    if (general.getId() == 0) {
      return Completable.fromSingle(generalDao.insert(general))
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(generalDao.update(general))
          .subscribeOn(Schedulers.io());
    }
  }

  /**
   * This method deletes data regarding general in the database.
   * @param general
   */
  public Completable delete(General general) {
    if (general.getId() == 0) {
      return Completable.fromAction(() -> {
      })
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(generalDao.delete(general))
          .subscribeOn(Schedulers.io());
    }
  }


}

