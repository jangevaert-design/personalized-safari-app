package model.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Date;


@Entity
public class Accomodation {


  @PrimaryKey
  private Long Id;

  @NonNull
  @ColumnInfo(length = 100, nullable = false)
  private String name;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false, updatable = false)
  private Date startDate;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false)
  private Date endDate;

  @NonNull
  @ColumnInfo(length = 100, nullable = false)
  private String longitude;

  @NonNull
  @ColumnInfo(length = 100, nullable = false)
  private String latitude;

  public Long getId() {
    return Id;
  }

  @NonNull
  public String getName() {
    return name;
  }

  public void setName(@NonNull String name) {
    this.name = name;
  }

  @NonNull
  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(@NonNull String longitude) {
    this.longitude = longitude;
  }

  @NonNull
  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(@NonNull String latitude) {
    this.latitude = latitude;
  }
}
