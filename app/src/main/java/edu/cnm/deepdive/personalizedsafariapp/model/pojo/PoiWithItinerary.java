package edu.cnm.deepdive.personalizedsafariapp.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.Itinerary;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.Poi;
import java.util.List;

public class PoiWithItinerary extends Poi {

  @Relation(entity = Itinerary.class, entityColumn = "itinerary_id", parentColumn = "itinerary_id")
  private Itinerary itinerary;

  public Itinerary getItinerary() {
    return itinerary;
  }

  public void setItinerary(Itinerary itinerary) {
    this.itinerary = itinerary;
  }
}
