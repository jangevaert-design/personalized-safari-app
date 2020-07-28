package edu.cnm.deepdive.personalizedsafariapp.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.General;
import edu.cnm.deepdive.personalizedsafariapp.model.service.GeneralRepository;
import java.util.List;

/**
 * This GeneralViewModel class stores and manages UI-related data in a lifecycle
 * conscious way.
 */
public class GeneralViewModel extends AndroidViewModel {

  private final GeneralRepository generalRepository;
  private final MutableLiveData<General> general;
  private final MutableLiveData<Throwable> throwable;

  /**
   * The constructor to initialize objects in the GeneralViewModel.
   * @param application
   */
  public GeneralViewModel(@NonNull Application application) {
    super(application);
    generalRepository = new GeneralRepository(application);
    general = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
  }


  public LiveData<List<General>> getGenerals () {
    return generalRepository.getAll();
  }

  public LiveData<General> getGeneral() {
    return general;
  }

  public LiveData<Throwable> getThrowable() {
    return throwable;
  }


}
