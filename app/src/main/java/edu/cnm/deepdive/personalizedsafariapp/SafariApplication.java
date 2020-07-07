package edu.cnm.deepdive.personalizedsafariapp;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.personalizedsafariapp.model.service.PersonalizedSafariAppDatabase;
import io.reactivex.schedulers.Schedulers;

public class SafariApplication extends Application {
  @Override
  public void onCreate() {
    super.onCreate();
    PersonalizedSafariAppDatabase.setContext(this);
    PersonalizedSafariAppDatabase database = PersonalizedSafariAppDatabase.getInstance();

    database.getAccommodationDao().delete()
        .subscribeOn(Schedulers.io())
        .subscribe();
    Stetho.initializeWithDefaults(this);
  }

}
