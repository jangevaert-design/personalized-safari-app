package edu.cnm.deepdive.personalizedsafariapp.model.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity
public class Itinerary {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "itinerary_id")
  private long id;

  @NonNull
  @ColumnInfo(collate = ColumnInfo.NOCASE)
  private String parkName = "";


  @ColumnInfo
  private Integer numberOfMiles;

  @NonNull
  @ColumnInfo(index = true)
  private Date start;

  @NonNull
  @ColumnInfo(index = true)
  private Date end;

  @NonNull
  @ColumnInfo(collate = ColumnInfo.NOCASE)
  private String location = "";


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @NonNull
  public String getParkName() {
    return parkName;
  }

  public void setParkName(@NonNull String park_name) {
    this.parkName = park_name;
  }


  public Integer getNumberOfMiles() {
    return numberOfMiles;
  }

  public void setNumberOfMiles(Integer number_of_miles) {
    this.numberOfMiles = number_of_miles;
  }

  @NonNull
  public Date getStart() {
    return start;
  }

  public void setStart(@NonNull Date start) {
    this.start = start;
  }

  @NonNull
  public Date getEnd() {
    return end;
  }

  public void setEnd(@NonNull Date end) {
    this.end = end;
  }

  @NonNull
  public String getLocation() {
    return location;
  }

  public void setLocation(@NonNull String location) {
    this.location = location;
  }
}
