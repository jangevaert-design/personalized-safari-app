package edu.cnm.deepdive.personalizedsafariapp.model.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

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
  @ColumnInfo(collate = ColumnInfo.NOCASE)
  private String packingList = "";

  @NonNull
  @ColumnInfo(collate = ColumnInfo.NOCASE)
  private String advice = "";

  public long getId() {
    return id;
  }

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

  public void setPackingList(@NonNull String packing_list) {
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
