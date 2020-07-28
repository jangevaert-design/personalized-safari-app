package edu.cnm.deepdive.personalizedsafariapp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.personalizedsafariapp.R;
import edu.cnm.deepdive.personalizedsafariapp.model.pojo.ItineraryWithPoi;
import edu.cnm.deepdive.personalizedsafariapp.view.ItineraryAdapter.Holder;
import java.text.DateFormat;
import java.util.List;

/**
 * This Adapter class acts as a bridge between the its underlying data and the
 * ItineraryViewModel class and is responsible for making a View for each item in the data set.
 */
public class ItineraryAdapter extends RecyclerView.Adapter<Holder> {

  private static final String DATETIME_CONCAT = "%s %s";

  private final Context context;
  private final List<ItineraryWithPoi> itineraries;
  private final DateFormat dateFormat;
  private final DateFormat timeFormat;

  /**
   * The constructor to initialize objects in the ItineraryAdapter class.
   * @param context
   */
  public ItineraryAdapter(Context context,
      List<ItineraryWithPoi> itineraries) {
    this.context = context;
    this.itineraries = itineraries;
    dateFormat = android.text.format.DateFormat.getDateFormat(context);
    timeFormat = android.text.format.DateFormat.getTimeFormat(context);
  }

  /**
   * This method creates a new ViewHolder object from item_itinerary whenever the
   * RecyclerViewModel needs a new one
   * @param parent
   * @param viewType
   */
  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new Holder(LayoutInflater.from(context).inflate(R.layout.item_itinerary, parent, false));
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
   * This method gets the length of the itineraries list.
   */
  @Override
  public int getItemCount() {
    return itineraries.size();
  }

  class Holder extends RecyclerView.ViewHolder {

    private final TextView parkName;
    private final TextView location;
    private final TextView start;
    private final TextView end;



    /**
     * This method holds the item's view.
     * @param itemView
     */
    public Holder(@NonNull View itemView) {
      super(itemView);
      parkName = itemView.findViewById(R.id.park_name);
      location = itemView.findViewById(R.id.location);
      start = itemView.findViewById(R.id.start);
      end = itemView.findViewById(R.id.end);
    }
    /**
     * This bind method is setting a property value for calling the setText method.
     * @param position
     */
    private void bind(int position) {
      ItineraryWithPoi itinerary = itineraries.get(position);
      parkName.setText(itinerary.getParkName());
      location.setText(itinerary.getLocation());
      start.setText(String.format(DATETIME_CONCAT, dateFormat.format(itinerary.getStart()), timeFormat.format(itinerary.getStart())));
      end.setText(String.format(DATETIME_CONCAT, dateFormat.format(itinerary.getEnd()), timeFormat.format(itinerary.getEnd())));

    }
  }
}
