package edu.cnm.deepdive.personalizedsafariapp.model.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Encapsulates some piece of general information details that are useful for the traveler.
 */
@Entity
public class General {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "general_id")
  private long id;

  @NonNull
  @ColumnInfo(collate = ColumnInfo.NOCASE)
  private String country = "";

  @NonNull
  @ColumnInfo(collate = ColumnInfo.NOCASE)
  private String wildlife = "";

  @NonNull
  @ColumnInfo(name = "packing_list", collate = ColumnInfo.NOCASE)
  private String packingList = "";

  @NonNull
  @ColumnInfo(collate = ColumnInfo.NOCASE)
  private String advice = "";

  /**
   * Returns the Room-assigned primary key identifier for this instance.
   */
  public long getId() {
    return id;
  }

  /**
   * Assigns the primary key identifier to this instance. Normally this method is invoked by the
   * Room library.
   */
  public void setId(long id) {
    this.id = id;
  }

  @NonNull
  public String getCountry() {
    return country;
  }

  public void setCountry(@NonNull String country) {
    this.country = country;
  }

  @NonNull
  public String getWildlife() {
    return wildlife;
  }

  public void setWildlife(@NonNull String wildlife) {
    this.wildlife = wildlife;
  }

  @NonNull
  public String getPackingList() {
    return packingList;
  }

  public void setPackingList(@NonNull String packingList) {
    this.packingList = packingList;
  }

  @NonNull
  public String getAdvice() {
    return advice;
  }

  public void setAdvice(@NonNull String advice) {
    this.advice = advice;
  }
}
