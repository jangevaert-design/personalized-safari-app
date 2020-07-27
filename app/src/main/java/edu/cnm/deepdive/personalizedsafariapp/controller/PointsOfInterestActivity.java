package edu.cnm.deepdive.personalizedsafariapp.controller;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.personalizedsafariapp.R;
import edu.cnm.deepdive.personalizedsafariapp.view.PointsOfInterestAdapter;
import edu.cnm.deepdive.personalizedsafariapp.viewmodel.PointsOfInterestViewModel;

/**
 * Creates a window to interact with the user on the points-of-interest part of this app.
 */
public class PointsOfInterestActivity extends AppCompatActivity {

  /**
   * The two fields below keep track of the usernames in this project.
   */
  private PointsOfInterestViewModel viewModel;
  private RecyclerView pointsOfInterestList;


  /**
   * The onCreate method is responsible to create the Activity when the Activitity is launched.
   *
   * @param savedInstanceState
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

/**
 * The setContentView method helps to render our layout to the screen using PointsOfInterestList.
 */
    setContentView(R.layout.activity_points_of_interest);
    pointsOfInterestList = findViewById(R.id.points_of_interest_list);

    viewModel = new ViewModelProvider(this).get(PointsOfInterestViewModel.class);
    /**
     * A method to get data from PointsOfInterestViewModel and observe them within a given lifecycle.
     */
    viewModel.getPois().observe(this, (pointsOfInterest) -> {

      PointsOfInterestAdapter adapter = new PointsOfInterestAdapter(this, pointsOfInterest);
      pointsOfInterestList.setAdapter(adapter);
    });

    /**
     * A method to get data that changes daily from PointsOfInterestViewModel and observe them
     * within a given lifecycle.
     */
    viewModel.getDailyPois().observe(this, (pointOfInterest) -> {

    });
    /**
     * A method to set the date in PointsOfInterestViewModel.
     */
//    viewModel.setDate(new Date()); // this is today's date.
  }
}

