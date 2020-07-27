package edu.cnm.deepdive.personalizedsafariapp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.personalizedsafariapp.R;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.Poi;
import edu.cnm.deepdive.personalizedsafariapp.model.pojo.PoiWithItinerary;
import edu.cnm.deepdive.personalizedsafariapp.view.PointsOfInterestAdapter.Holder;
import java.text.DateFormat;
import java.util.List;

public class PointsOfInterestAdapter extends RecyclerView.Adapter<Holder> {

  private static final String DATETIME_CONCAT = "%s %s";

  private final Context context;
  private final List<PoiWithItinerary> pois;
  private final DateFormat dateFormat;
  private final DateFormat timeFormat;

  public PointsOfInterestAdapter(Context context,
      List<PoiWithItinerary> pois) {
    this.context = context;
    this.pois = pois;
    dateFormat = android.text.format.DateFormat.getDateFormat(context);
    timeFormat = android.text.format.DateFormat.getTimeFormat(context);
  }


  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new Holder(LayoutInflater.from(context).inflate(R.layout.item_points_of_interest, parent, false));
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
    holder.bind(position);
  }

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




    public Holder(@NonNull View itemView) {
      super(itemView);
      name = itemView.findViewById(R.id.name);
      longitude = itemView.findViewById(R.id.longitude);
      latitude = itemView.findViewById(R.id.latitude);
      start = itemView.findViewById(R.id.start);
      end = itemView.findViewById(R.id.end);
    }

    private void bind(int position) {
      Poi poi = pois.get(position);
      name.setText(poi.getName());
      longitude.setText(String.format("%.6f", poi.getLongitude()));
      latitude.setText(String.format("%.6f", poi.getLatitude()));
//      start.setText(String.format(DATETIME_CONCAT, dateFormat.format(poi.getStart()), timeFormat.format(poi.getStart())));
//      end.setText(String.format(DATETIME_CONCAT, dateFormat.format(poi.getEnd()), timeFormat.format(poi.getEnd())));
      // TODO is the date linked to Itinerary or through the pojos?

    }
  }
}
