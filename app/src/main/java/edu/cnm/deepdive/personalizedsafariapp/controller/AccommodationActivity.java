package edu.cnm.deepdive.personalizedsafariapp.controller;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.personalizedsafariapp.R;
import edu.cnm.deepdive.personalizedsafariapp.view.AccommodationAdapter;
import edu.cnm.deepdive.personalizedsafariapp.viewmodel.AccommodationViewModel;
import java.util.Date;

/**
 * Creates a window to interact with the user on the accommodation part of this app.
 */
public class AccommodationActivity extends AppCompatActivity {

  /**
   * The two fields below keep track of the usernames in this project.
   */
  private AccommodationViewModel viewModel;
  private RecyclerView accommodationList;


  /**
   * The onCreate method is responsible to create the Activity when the Activitity is launched.
   *
   * @param savedInstanceState
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

/**
 * The setContentView method helps to render our layout to the screen using accommodationList.
 */
    setContentView(R.layout.activity_accommodation);
    accommodationList = findViewById(R.id.accommodation_list);

    viewModel = new ViewModelProvider(this).get(AccommodationViewModel.class);

    /**
     * A method to get data from AccommodationViewModel and observe them within a given lifecycle.
     */
    viewModel.getAccommodations().observe(this, (accommodations) -> {

      AccommodationAdapter adapter = new AccommodationAdapter(this, accommodations);
      accommodationList.setAdapter(adapter);
    });
    /**
     * A method to get data that changes daily from AccommodationViewModel and observe them within a given lifecycle.
     */

    viewModel.getDailyAccommodation().observe(this, (accommodation) -> {

    });

    /**
     * A method to set the date in AccommodationViewModel.
     */
    viewModel.setDate(new Date()); // this is today's date.
  }
}
