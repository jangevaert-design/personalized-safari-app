package edu.cnm.deepdive.personalizedsafariapp.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.Itinerary;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.Poi;

public class ItineraryWithPoi extends Itinerary {


  @Relation(entity = Poi.class, entityColumn = "itinerary_id", parentColumn = "itinerary_id")
  private Poi poi;

  public Poi getPoi() {
    return poi;
  }

  public void setPoi(Poi poi) {
    this.poi = poi;
  }


}
