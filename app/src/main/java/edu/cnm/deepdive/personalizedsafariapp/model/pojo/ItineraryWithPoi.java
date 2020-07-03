package edu.cnm.deepdive.personalizedsafariapp.model.pojo;

import androidx.annotation.NonNull;
import androidx.room.Relation;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.Itinerary;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.Poi;

public class ItineraryWithPoi extends Itinerary {


  @Relation(entity = Poi.class, entityColumn = "Poi_id", parentColumn = "Poi_id")
  private Poi poi;

  public Poi getPoi() {
    return poi;
  }

  public void setPoi(Poi poi) { this.poi = poi;
  }

  @NonNull
  @Override
  public String toString() {
    String PoiName = (poi != null ? poi.getName() : "(unknown)");
    return null; // String.format("%s%n\u2014%s", getText(), poiName);
  }

}
