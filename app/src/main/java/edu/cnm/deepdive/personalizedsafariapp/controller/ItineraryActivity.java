package edu.cnm.deepdive.personalizedsafariapp.controller;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.personalizedsafariapp.R;
import edu.cnm.deepdive.personalizedsafariapp.view.ItineraryAdapter;
import edu.cnm.deepdive.personalizedsafariapp.viewmodel.ItineraryViewModel;
import java.util.Date;

/**
 * Creates a window to interact with the user on the itinerary part of this app.
 */
public class ItineraryActivity extends AppCompatActivity {


  private ItineraryViewModel viewModel;
  private RecyclerView itineraryList;


  /**
   * The onCreate method is responsible to create the Activity when the Activitity is launched.
   *
   * @param savedInstanceState
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

/**
 * The setContentView method helps to render our layout to the screen using itineraryList.
 */
    setContentView(R.layout.activity_itinerary);
    itineraryList = findViewById(R.id.itinerary_list);

    viewModel = new ViewModelProvider(this).get(ItineraryViewModel.class);

    /**
     * A method to get data from ItineraryViewModel and observe them within a given lifecycle.
     */
    viewModel.getItineraries().observe(this, (itineraries) -> {

      ItineraryAdapter adapter = new ItineraryAdapter(this, itineraries);
      itineraryList.setAdapter(adapter);
    });

    /**
     * A method to get data that changes daily from ItineraryViewModel and observe them within
     * a given lifecycle.
     */
    viewModel.getDailyItinerary().observe(this, (itinerary) -> {

    });

    /**
     * A method to set the date in ItineraryViewModel.
     */
    viewModel.setDate(new Date()); // this is today's date.
  }
}
