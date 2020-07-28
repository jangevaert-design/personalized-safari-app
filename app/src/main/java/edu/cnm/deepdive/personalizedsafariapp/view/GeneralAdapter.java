package edu.cnm.deepdive.personalizedsafariapp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.personalizedsafariapp.R;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.General;
import edu.cnm.deepdive.personalizedsafariapp.view.GeneralAdapter.Holder;
import java.util.List;

/**
 * This Adapter class acts as a bridge between the its underlying data and the
 * GneralViewModel class and is responsible for making a View for each item in the data set.
 */
public class GeneralAdapter extends RecyclerView.Adapter<Holder> {



  private final Context context;
  private final List<General> generals;

  /**
   * The constructor to initialize objects in the GeneralAdapter class.
   * @param context
   */
  public GeneralAdapter(Context context,
      List<General> generals) {
    this.context = context;
    this.generals = generals;

  }

  /**
   * This method creates a new ViewHolder object from item_general whenever the
   * RecyclerViewModel needs a new one
   * @param parent
   * @param viewType
   */
  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new Holder(LayoutInflater.from(context).inflate(R.layout.item_general, parent, false));
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
   * This method gets the length of the generals list.
   */
  @Override
  public int getItemCount() {
    return generals.size();
  }

  class Holder extends RecyclerView.ViewHolder {

    private final TextView country;
    private final TextView wildlife;
    private final TextView packingList;
    private final TextView advice;




    /**
     * This method holds the item's view.
     * @param itemView
     */
    public Holder(@NonNull View itemView) {
      super(itemView);
      country = itemView.findViewById(R.id.country);
      wildlife = itemView.findViewById(R.id.wildlife);
      packingList = itemView.findViewById(R.id.packing_list);
      advice = itemView.findViewById(R.id.advice);

    }
    /**
     * This bind method is setting a property value for calling the setText method.
     * @param position
     */
    private void bind(int position) {
      General general = generals.get(position);
      country.setText(general.getCountry());
      wildlife.setText(general.getWildlife());
      packingList.setText(general.getPackingList());
      advice.setText(general.getAdvice());

    }
  }
}
