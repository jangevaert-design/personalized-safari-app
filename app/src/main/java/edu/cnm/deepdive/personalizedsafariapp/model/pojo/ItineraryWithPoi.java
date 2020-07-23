package edu.cnm.deepdive.personalizedsafariapp.model.pojo;

import androidx.room.Relation;
import com.google.gson.annotations.SerializedName;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.Itinerary;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.Poi;
import java.util.List;

public class ItineraryWithPoi extends Itinerary {

  @SerializedName("pointsOfInterest")
  @Relation(entity = Poi.class, entityColumn = "itinerary_id", parentColumn = "itinerary_id")
  private List<Poi> poi;

  public List<Poi> getPoi() {
    return poi;
  }

  public void setPoi(List<Poi> poi) {
    this.poi = poi;
  }
}
