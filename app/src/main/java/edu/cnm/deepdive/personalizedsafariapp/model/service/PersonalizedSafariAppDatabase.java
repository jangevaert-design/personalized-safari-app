package edu.cnm.deepdive.personalizedsafariapp.model.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import edu.cnm.deepdive.personalizedsafariapp.model.dao.AccommodationDao;
import edu.cnm.deepdive.personalizedsafariapp.model.dao.GeneralDao;
import edu.cnm.deepdive.personalizedsafariapp.model.dao.ItineraryDao;
import edu.cnm.deepdive.personalizedsafariapp.model.dao.PoiDao;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.Accommodation;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.General;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.Itinerary;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.Poi;
import edu.cnm.deepdive.personalizedsafariapp.model.service.PersonalizedSafariAppDatabase.Converters;
import java.util.Date;

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
            .build();

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


