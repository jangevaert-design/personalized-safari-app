package edu.cnm.deepdive.personalizedsafariapp.controller;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.personalizedsafariapp.R;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.Accommodation;
import edu.cnm.deepdive.personalizedsafariapp.view.AccommodationAdapter;
import edu.cnm.deepdive.personalizedsafariapp.viewmodel.AccommodationViewModel;
import java.util.Date;

public class AccommodationActivity extends AppCompatActivity  {


  private AccommodationViewModel viewModel;
  private RecyclerView accommodationList;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);


    setContentView(R.layout.activity_accommodation);
    accommodationList = findViewById(R.id.accommodation_list);


    viewModel = new ViewModelProvider(this).get(AccommodationViewModel.class);

    viewModel.getAccommodations().observe(this, (accommodations) -> {


      AccommodationAdapter adapter = new AccommodationAdapter(this, accommodations);
      accommodationList.setAdapter(adapter);
    });
    viewModel.getDailyAccommodation().observe(this, (accommodation) -> {

    });
    viewModel.setDate(new Date()); // this is today's date.
  }
}
