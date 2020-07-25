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
import edu.cnm.deepdive.personalizedsafariapp.model.entity.General;
import edu.cnm.deepdive.personalizedsafariapp.view.GeneralAdapter.Holder;

import java.util.List;

public class GeneralAdapter extends RecyclerView.Adapter<Holder> {



  private final Context context;
  private final List<General> generals;


  public GeneralAdapter(Context context,
      List<General> generals) {
    this.context = context;
    this.generals = generals;

  }


  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new Holder(LayoutInflater.from(context).inflate(R.layout.item_general, parent, false));
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
    holder.bind(position);
  }

  @Override
  public int getItemCount() {
    return generals.size();
  }

  class Holder extends RecyclerView.ViewHolder {

    private final TextView country;
    private final TextView wildlife;
    private final TextView packingList;
    private final TextView advice;





    public Holder(@NonNull View itemView) {
      super(itemView);
      country = itemView.findViewById(R.id.country);
      wildlife = itemView.findViewById(R.id.wildlife);
      packingList = itemView.findViewById(R.id.packing_list);
      advice = itemView.findViewById(R.id.advice);

    }

    private void bind(int position) {
      General general = generals.get(position);
      country.setText(general.getCountry());
      wildlife.setText(general.getWildlife());
      packingList.setText(general.getPackingList());
      advice.setText(general.getAdvice());

    }
  }
}
