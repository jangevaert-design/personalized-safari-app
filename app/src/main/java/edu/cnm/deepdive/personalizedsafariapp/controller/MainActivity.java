package edu.cnm.deepdive.personalizedsafariapp.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import edu.cnm.deepdive.personalizedsafariapp.R;
import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


  private Button button;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Calendar calendar = Calendar.getInstance();
    String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
    TextView textViewDate = findViewById(R.id.text_view_date);
    textViewDate.setText(currentDate);
    button = findViewById(R.id.lets_go_user);
    button.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        openNavigationActivity();
      }
    });

  }

  public void openNavigationActivity() {
    Intent intent = new Intent(this, NavigationActivity.class);
    startActivity(intent);
  }


}
