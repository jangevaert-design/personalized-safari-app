package edu.cnm.deepdive.personalizedsafariapp.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
    foreignKeys = @ForeignKey(
        entity = Itinerary.class,
        parentColumns = "itinerary_id",
        childColumns = "itinerary_id",
        onDelete = ForeignKey.SET_NULL
    )
)
public class Poi {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "poi_id")
  private long id;

  @ColumnInfo(name = "itinerary_id", index = true)
  private long itineraryId;

  @NonNull
  @ColumnInfo(collate = ColumnInfo.NOCASE)
  private String name = "";


  @ColumnInfo
  private Double longitude;


  @ColumnInfo
  private Double latitude;


  public long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getItineraryId() {
    return itineraryId;
  }

  public void setItineraryId(Long itineraryId) {
    this.itineraryId = itineraryId;
  }

  @NonNull
  public String getName() {
    return name;
  }

  public void setName(@NonNull String name) {
    this.name = name;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }


}
