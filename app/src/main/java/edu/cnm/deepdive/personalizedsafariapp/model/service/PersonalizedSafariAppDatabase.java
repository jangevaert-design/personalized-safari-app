package edu.cnm.deepdive.personalizedsafariapp.model.service;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import edu.cnm.deepdive.personalizedsafariapp.R;
import edu.cnm.deepdive.personalizedsafariapp.model.dao.AccommodationDao;
import edu.cnm.deepdive.personalizedsafariapp.model.dao.GeneralDao;
import edu.cnm.deepdive.personalizedsafariapp.model.dao.ItineraryDao;
import edu.cnm.deepdive.personalizedsafariapp.model.dao.PoiDao;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.Accommodation;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.General;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.Itinerary;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.Poi;
import edu.cnm.deepdive.personalizedsafariapp.model.pojo.ItineraryWithPoi;
import edu.cnm.deepdive.personalizedsafariapp.model.service.PersonalizedSafariAppDatabase.Converters;
import io.reactivex.schedulers.Schedulers;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Database(
    entities = {Accommodation.class, General.class, Itinerary.class, Poi.class},
    version = 1,
    exportSchema = true
)
@TypeConverters({Converters.class})

public abstract class PersonalizedSafariAppDatabase extends RoomDatabase {

  private static final String DB_NAME = "personalizedsafariapp_db";

  private static Application context;

  public static void setContext(Application context) {
    PersonalizedSafariAppDatabase.context = context;
  }

  public abstract AccommodationDao getAccommodationDao();

  public abstract GeneralDao getGeneralDao();

  public abstract ItineraryDao getItineraryDao();

  public abstract PoiDao getPoiDao();

  public static PersonalizedSafariAppDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  private static class InstanceHolder {

    private static final PersonalizedSafariAppDatabase INSTANCE =
        Room.databaseBuilder(context, PersonalizedSafariAppDatabase.class, DB_NAME)
            .addCallback(new Callback(context))
            .build();

  }

  private static class Callback extends RoomDatabase.Callback {

    private final Context context;

    private Callback(Context context) {
      this.context = context;
    }

    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
      super.onCreate(db);
      loadItineraries();
      loadAccommodations();
      loadGeneral();


    }

    private void loadGeneral() {

    }

    private void loadAccommodations() {

    }

    private void loadItineraries() {
      try (
          InputStream input = context.getResources().openRawResource(R.raw.itineraries);
          Reader reader = new InputStreamReader(input);
      ) {
//        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ");
        PersonalizedSafariAppDatabase database = PersonalizedSafariAppDatabase.getInstance();
        // Adding URL's where possible?
        AccommodationDao accommodationDao = database.getAccommodationDao();
        GeneralDao generalDao = database.getGeneralDao();
        ItineraryDao itineraryDao = database.getItineraryDao();
        PoiDao poiDao = database.getPoiDao();

        Type listType = new TypeToken<LinkedList<ItineraryWithPoi>>() {}.getType();
        Gson gson = new GsonBuilder()
            // Set any other options as necessary
            .create();
        List<ItineraryWithPoi> itineraries = gson.fromJson(reader, listType);

        itineraryDao.insert(itineraries)
            .subscribeOn(Schedulers.io())
            .flatMap((ids) -> {
              List<Poi> pointsToAdd = new LinkedList<>();
              Iterator<Long> idIterator = ids.iterator();
              Iterator<ItineraryWithPoi> itineraryIterator = itineraries.iterator();
              while (idIterator.hasNext()) {
                long id = idIterator.next();
                ItineraryWithPoi itin = itineraryIterator.next();
                itin.getPoi().forEach((p) -> {
                  p.setItineraryId(id);
                  pointsToAdd.add(p);
                });
              }
              return poiDao.insert(pointsToAdd);
            })
            .subscribe();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }

  public static class Converters {

    @TypeConverter
    public static Long dateToLong(Date value) {
      return (value != null) ? value.getTime() : null;
    }

    @TypeConverter
    public static Date longToDate(Long value) {
      return (value != null) ? new Date(value) : null;
    }
  }
}


