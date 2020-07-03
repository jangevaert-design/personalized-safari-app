package edu.cnm.deepdive.personalizedsafariapp.model.service;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;
import edu.cnm.deepdive.personalizedsafariapp.model.dao.AccommodationDao;
import edu.cnm.deepdive.personalizedsafariapp.model.dao.GeneralDao;
import edu.cnm.deepdive.personalizedsafariapp.model.dao.ItineraryDao;
import edu.cnm.deepdive.personalizedsafariapp.model.dao.PoiDao;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.Accommodation;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.General;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.Itinerary;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.Poi;
import edu.cnm.deepdive.personalizedsafariapp.model.service.PersonalizedSafariAppDatabase.Converters;
import io.reactivex.schedulers.Schedulers;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Database(
    entities = {Accommodation.class, General.class, Itinerary.class, Poi.class},
    version = 1,
    exportSchema = true
)
@TypeConverters({Converters.class})
//keep right after @Database annotation

public class PersonalizedSafariAppDatabase extends RoomDatabase {

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
            .addCallback(new PersonalizedSafariAppCallback())
            .build();

  }

  private static class PersonalizedSafariAppCallback extends Callback {
// What happens here?
    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
      super.onCreate(db);
      try {
        Map<Source, List<Quote>> map = parseFile(R.raw.quotes);
        persist(map);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    private Map<Source, List<Quote>> parseFile(int resourceId) throws IOException {
      try (
          InputStream input = PersonalizedSafariAppDatabase.context.getResources().openRawResource(resourceId);
          Reader reader = new InputStreamReader(input);
          CSVParser parser = CSVParser.parse(
              reader, CSVFormat.EXCEL.withIgnoreSurroundingSpaces().withIgnoreEmptyLines());
      ) {
        Map<Source, List<Quote>> map = new HashMap<>();
        for (CSVRecord record : parser) {
          Source source = null;
          String sourceName = record.get(0).trim();
          if (!sourceName.isEmpty()) {
            source = new Source();
            source.setName(sourceName);
          }
          List<Quote> quotes = map.computeIfAbsent(source, (s) -> new LinkedList<>());
          Quote quote = new Quote();
          quote.setText(record.get(1).trim());
          quotes.add(quote);
        }
        return map;
      }
    }

    @SuppressLint("CheckResult")
    private void persist(Map<Source, List<Quote>> map) {
      PersonalizedSafariAppDatabase database = PersonalizedSafariAppDatabase.getInstance();
      AccommodationDao accommodationDaoDao = database.getAccommodationDao();
      GeneralDao generalDao = database.getGeneralDao();
      ItineraryDao itineraryDao = database.getItineraryDao();
      PoiDao poiDao = database.getPoiDao();
      List<Source> sources = new LinkedList<>(map.keySet());
      List<Quote> unattributed = map.getOrDefault(null, Collections.emptyList());
      sources.remove(null);
      sourceDao.insert(sources)
          .subscribeOn(Schedulers.io())
          .flatMap((sourceIds) -> {
            List<Quote> quotes = new LinkedList<>();
            Iterator<Long> idIterator = sourceIds.iterator();
            Iterator<Source> sourceIterator = sources.iterator();
            while (idIterator.hasNext()) {
              long sourceId = idIterator.next();
              for (Quote quote : map.getOrDefault(sourceIterator.next(), Collections.emptyList())) {
                quote.setSourceId(sourceId);
                quotes.add(quote);
              }
            }
            quotes.addAll(unattributed);
            return quoteDao.insert(quotes);
          })
          .subscribe(
              (quoteIds) -> {},
              (throwable) -> {throw new RuntimeException(throwable);}
          );
    }

  }








  //keep all the way below after all methods and fields
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

