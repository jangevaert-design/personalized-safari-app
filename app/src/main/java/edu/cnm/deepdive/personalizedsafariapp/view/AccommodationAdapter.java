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
import edu.cnm.deepdive.personalizedsafariapp.model.entity.Accommodation;
import edu.cnm.deepdive.personalizedsafariapp.view.AccommodationAdapter.Holder;
import java.text.DateFormat;
import java.util.List;

public class AccommodationAdapter extends RecyclerView.Adapter<Holder> {

  private static final String DATETIME_CONCAT = "%s %s";

  private final Context context;
  private final List<Accommodation> accommodations;
  private final DateFormat dateFormat;
  private final DateFormat timeFormat;

  public AccommodationAdapter(Context context,
      List<Accommodation> accommodations) {
    this.context = context;
    this.accommodations = accommodations;
    dateFormat = android.text.format.DateFormat.getDateFormat(context);
    timeFormat = android.text.format.DateFormat.getTimeFormat(context);
  }


  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new Holder(LayoutInflater.from(context).inflate(R.layout.item_accommodation, parent, false));
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
    holder.bind(position);
  }

  @Override
  public int getItemCount() {
    return accommodations.size();
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
      Accommodation accommodation = accommodations.get(position);
      name.setText(accommodation.getName());
      longitude.setText(String.format("%.6f",accommodation.getLongitude()));
      latitude.setText(String.format("%.6f", accommodation.getLatitude()));
      start.setText(String.format(DATETIME_CONCAT, dateFormat.format(accommodation.getStart()), timeFormat.format(accommodation.getStart())));
      end.setText(String.format(DATETIME_CONCAT, dateFormat.format(accommodation.getEnd()), timeFormat.format(accommodation.getEnd())));

    }
  }
}

