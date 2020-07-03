package edu.cnm.deepdive.personalizedsafariapp;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.personalizedsafariapp.model.service.PersonalizedSafariAppDatabase;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SafariApplication extends Application {
  @Override
  public void onCreate() {
    super.onCreate();
    PersonalizedSafariAppDatabase.setContext(this);
    PersonalizedSafariAppDatabase database = PersonalizedSafariAppDatabase.getInstance();
    // "I recommend invoking one of your DAO delete methods that takes a varargs parameter,
    // but passing no arguments."     Why only one?
    database.getAccommodationDao().delete()
        .subscribeOn(Schedulers.io()) // run on a background I/O thread (with onObserve()??
        .subscribe();
    Stetho.initializeWithDefaults(this);
  }

}
