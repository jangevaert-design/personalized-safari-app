package edu.cnm.deepdive.personalizedsafariapp.controller;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.personalizedsafariapp.R;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.Itinerary;
import edu.cnm.deepdive.personalizedsafariapp.viewmodel.ItineraryViewModel;

public class ItineraryActivity extends AppCompatActivity  {


  private ItineraryViewModel viewModel;
  private RecyclerView itineraryList;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_navigation);


    setContentView(R.layout.activity_itinerary);
    itineraryList = findViewById(R.id.itinerary_list);
    // TODO Use findViewById to wire the UI together.

    viewModel = new ViewModelProvider(this).get(ItineraryViewModel.class);
    // TODO GET livedata from viewmodel and set observers.
    viewModel.getItineraries().observe(this, (itineraries) -> {
      // TODO Create adapter populated with itineraries and set the itineraryList adaptor.


    });

  }
}
