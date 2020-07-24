package edu.cnm.deepdive.personalizedsafariapp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import edu.cnm.deepdive.personalizedsafariapp.R;
import edu.cnm.deepdive.personalizedsafariapp.model.pojo.ItineraryWithPoi;
import edu.cnm.deepdive.personalizedsafariapp.view.ItineraryAdapter.Holder;
import java.text.DateFormat;
import java.util.List;

public class ItineraryAdapter extends RecyclerView.Adapter<Holder> {

  private static final String DATETIME_CONCAT = "%s %s";

  private final Context context;
  private final List<ItineraryWithPoi> itineraries;
  private final DateFormat dateFormat;
  private final DateFormat timeFormat;

  public ItineraryAdapter(Context context,
      List<ItineraryWithPoi> itineraries) {
    this.context = context;
    this.itineraries = itineraries;
    dateFormat = android.text.format.DateFormat.getDateFormat(context);
    timeFormat = android.text.format.DateFormat.getTimeFormat(context);
  }


  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new Holder(LayoutInflater.from(context).inflate(R.layout.item_itinerary, parent, false));
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
    holder.bind(position);
  }

  @Override
  public int getItemCount() {
    return itineraries.size();
  }

  class Holder extends RecyclerView.ViewHolder {

    private final TextView parkName;
    private final TextView location;
    private final TextView start;
    private final TextView end;




    public Holder(@NonNull View itemView) {
      super(itemView);
      parkName = itemView.findViewById(R.id.park_name);
      location = itemView.findViewById(R.id.location);
      start = itemView.findViewById(R.id.start);
      end = itemView.findViewById(R.id.end);
    }

    private void bind(int position) {
      ItineraryWithPoi itinerary = itineraries.get(position);
      parkName.setText(itinerary.getParkName());
      location.setText(itinerary.getLocation());
      start.setText(String.format(DATETIME_CONCAT, dateFormat.format(itinerary.getStart()), timeFormat.format(itinerary.getStart())));
      end.setText(String.format(DATETIME_CONCAT, dateFormat.format(itinerary.getEnd()), timeFormat.format(itinerary.getEnd())));

    }
  }
}
