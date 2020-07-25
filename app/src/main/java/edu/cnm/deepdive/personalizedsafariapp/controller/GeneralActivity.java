package edu.cnm.deepdive.personalizedsafariapp.controller;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.personalizedsafariapp.R;
import edu.cnm.deepdive.personalizedsafariapp.view.GeneralAdapter;
import edu.cnm.deepdive.personalizedsafariapp.viewmodel.GeneralViewModel;


public class GeneralActivity extends AppCompatActivity {


  private GeneralViewModel viewModel;
  private RecyclerView generalList;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_general);
    generalList = findViewById(R.id.general_list);

    viewModel = new ViewModelProvider(this).get(GeneralViewModel.class);

    viewModel.getGenerals().observe(this, (generals) -> {

      GeneralAdapter adapter = new GeneralAdapter(this, generals);
      generalList.setAdapter(adapter);
    });


  }
}
