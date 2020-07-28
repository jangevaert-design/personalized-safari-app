package edu.cnm.deepdive.personalizedsafariapp.controller;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.personalizedsafariapp.R;
import edu.cnm.deepdive.personalizedsafariapp.view.GeneralAdapter;
import edu.cnm.deepdive.personalizedsafariapp.viewmodel.GeneralViewModel;

/**
 * Creates a window to interact with the user on the general information part of this app.
 */
public class GeneralActivity extends AppCompatActivity {


  private GeneralViewModel viewModel;
  private RecyclerView generalList;

  /**
   * The onCreate method is responsible to create the Activity when the Activitity is launched.
   *
   * @param savedInstanceState
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    /**
     * The setContentView method helps to render our layout to the screen using generalList.
     */
    setContentView(R.layout.activity_general);
    generalList = findViewById(R.id.general_list);

    viewModel = new ViewModelProvider(this).get(GeneralViewModel.class);
    /**
     * A method to get data from GeneralViewModel and observe them within a given lifecycle.
     */
    viewModel.getGenerals().observe(this, (generals) -> {

      GeneralAdapter adapter = new GeneralAdapter(this, generals);
      generalList.setAdapter(adapter);
    });


  }
}
