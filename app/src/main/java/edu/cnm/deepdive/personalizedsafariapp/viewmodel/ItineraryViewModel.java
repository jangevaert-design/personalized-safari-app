package edu.cnm.deepdive.personalizedsafariapp.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.personalizedsafariapp.model.pojo.ItineraryWithPoi;
import edu.cnm.deepdive.personalizedsafariapp.model.service.ItineraryRepository;
import java.util.List;

public class ItineraryViewModel extends AndroidViewModel {

  private final ItineraryRepository itineraryRepository;

  public ItineraryViewModel(@NonNull Application application) {
    super(application);
    itineraryRepository = new ItineraryRepository(application);
  }
  // TODO Add some livedata that holds itinerary data plus methods to observe them.

  public LiveData<List<ItineraryWithPoi>> getItineraries () {
    return itineraryRepository.getAll();
  }
}
