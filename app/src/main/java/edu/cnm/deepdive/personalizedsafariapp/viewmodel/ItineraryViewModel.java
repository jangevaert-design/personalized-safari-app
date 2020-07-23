package edu.cnm.deepdive.personalizedsafariapp.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import edu.cnm.deepdive.personalizedsafariapp.model.pojo.ItineraryWithPoi;
import edu.cnm.deepdive.personalizedsafariapp.model.service.ItineraryRepository;
import java.util.Date;
import java.util.List;

public class ItineraryViewModel extends AndroidViewModel {

  private final ItineraryRepository itineraryRepository;
  private final MutableLiveData<ItineraryWithPoi> dailyItinerary;
  private final MutableLiveData<Throwable> throwable;

  public ItineraryViewModel(@NonNull Application application) {
    super(application);
    itineraryRepository = new ItineraryRepository(application);
    dailyItinerary = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
  }
  // TODO Add some livedata that holds itinerary data plus methods to observe them.

  public LiveData<List<ItineraryWithPoi>> getItineraries () {
    return itineraryRepository.getAll();
  }

  public LiveData<ItineraryWithPoi> getDailyItinerary() {
    return dailyItinerary;
  }

  public LiveData<Throwable> getThrowable() {
    return throwable;
  }

  public void setDate(Date date) {
    itineraryRepository.get(date)
        .subscribe(
            (itinerary) -> dailyItinerary.postValue(itinerary),
            (throwable) -> this.throwable.postValue(throwable),
            () -> dailyItinerary.postValue(null)
        );
  }
}
