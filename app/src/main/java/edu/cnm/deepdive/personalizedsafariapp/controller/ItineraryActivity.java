package edu.cnm.deepdive.personalizedsafariapp.controller;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.personalizedsafariapp.R;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.Itinerary;
import edu.cnm.deepdive.personalizedsafariapp.view.ItineraryAdapter;
import edu.cnm.deepdive.personalizedsafariapp.viewmodel.ItineraryViewModel;
import java.util.Date;

public class ItineraryActivity extends AppCompatActivity  {


  private ItineraryViewModel viewModel;
  private RecyclerView itineraryList;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);


    setContentView(R.layout.activity_itinerary);
    itineraryList = findViewById(R.id.itinerary_list);
    // TODO Use findViewById to wire the UI together.

    viewModel = new ViewModelProvider(this).get(ItineraryViewModel.class);
    // TODO GET livedata from viewmodel and set observers.
    viewModel.getItineraries().observe(this, (itineraries) -> {
      // TODO Create adapter populated with itineraries and set the itineraryList adaptor.

      ItineraryAdapter adapter = new ItineraryAdapter(this, itineraries);
      itineraryList.setAdapter(adapter);
    });
    viewModel.getDailyItinerary().observe(this, (itinerary) -> {
     // TODO populate viewobjects in layout with information from itinerary

    });
    viewModel.setDate(new Date()); // this is today's date.
  }
}
