package edu.cnm.deepdive.personalizedsafariapp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.personalizedsafariapp.R;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.Itinerary;
import edu.cnm.deepdive.personalizedsafariapp.model.pojo.PoiWithItinerary;
import edu.cnm.deepdive.personalizedsafariapp.view.PointsOfInterestAdapter.Holder;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

/**
 * This Adapter class acts as a bridge between the its underlying data and the
 * PointsOfInterestViewModel class and is responsible for making a View for each item in the data
 * set.
 */
public class PointsOfInterestAdapter extends RecyclerView.Adapter<Holder> {

  private static final String DATETIME_CONCAT = "%s %s";

  private final Context context;
  private final List<PoiWithItinerary> pois;
  private final DateFormat dateFormat;
  private final DateFormat timeFormat;

  /**
   * The constructor to initialize objects in the PointsOfInterestAdapter class.
   * @param context
   */
  public PointsOfInterestAdapter(Context context,
      List<PoiWithItinerary> pois) {
    this.context = context;
    this.pois = pois;
    dateFormat = android.text.format.DateFormat.getDateFormat(context);
    timeFormat = android.text.format.DateFormat.getTimeFormat(context);
  }

  /**
   * This method creates a new ViewHolder object from item_ppints_of_interest whenever the
   * RecyclerViewModel needs a new one
   * @param parent
   * @param viewType
   */
  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new Holder(LayoutInflater.from(context).inflate(R.layout.item_points_of_interest, parent, false));
  }

  /**
   * This method takes the ViewHolder object and sets the proper list data for the particular row.
   * @param holder
   * @param position
   */
  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
    holder.bind(position);
  }


  /**
   * This method gets the length of the pois list.
   */
  @Override
  public int getItemCount() {
    return pois.size();
  }

  class Holder extends RecyclerView.ViewHolder {

    private final TextView name;
    private final TextView longitude;
    private final TextView latitude;
    private final TextView start;
    private final TextView end;



    /**
     * This method holds the item's view.
     * @param itemView
     */
    public Holder(@NonNull View itemView) {
      super(itemView);
      name = itemView.findViewById(R.id.name);
      longitude = itemView.findViewById(R.id.longitude);
      latitude = itemView.findViewById(R.id.latitude);
      start = itemView.findViewById(R.id.start);
      end = itemView.findViewById(R.id.end);
    }
    /**
     * This bind method is setting a property value for calling the setText method.
     * @param position
     */
    private void bind(int position) {
      PoiWithItinerary poi = pois.get(position);
      name.setText(poi.getName());
      longitude.setText(String.format("%.6f", poi.getLongitude()));
      latitude.setText(String.format("%.6f", poi.getLatitude()));
      Itinerary itinerary = poi.getItinerary();
      Date start = itinerary.getStart();
      this.start.setText(String.format(DATETIME_CONCAT, dateFormat.format(start), timeFormat.format(
          start)));
      Date end = itinerary.getEnd();
      this.end.setText(String.format(DATETIME_CONCAT, dateFormat.format(end), timeFormat.format(
          end)));


    }
  }
}
