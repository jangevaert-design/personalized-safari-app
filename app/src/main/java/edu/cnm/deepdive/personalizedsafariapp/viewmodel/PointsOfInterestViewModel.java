package edu.cnm.deepdive.personalizedsafariapp.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import edu.cnm.deepdive.personalizedsafariapp.model.pojo.PoiWithItinerary;
import edu.cnm.deepdive.personalizedsafariapp.model.service.PoiRepository;
import java.util.List;

/**
 * This PointsOfInterestViewModel class stores and manages UI-related data in a lifecycle
 * conscious way.
 */
public class PointsOfInterestViewModel extends AndroidViewModel {

  private final PoiRepository poiRepository;
  private final MutableLiveData<PoiWithItinerary> dailyPoi;
  private final MutableLiveData<Throwable> throwable;

  /**
   * The constructor to initialize objects in the PointsOfInterestViewModel.
   * @param application
   */
  public PointsOfInterestViewModel(@NonNull Application application) {
    super(application);
    poiRepository = new PoiRepository(application);
    dailyPoi = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
  }


  public LiveData<List<PoiWithItinerary>> getPois () {
    return poiRepository.getAll();
  }

  public LiveData<PoiWithItinerary> getDailyPois() {
    return dailyPoi;
  }

  public LiveData<Throwable> getThrowable() {
    return throwable;
  }

}
