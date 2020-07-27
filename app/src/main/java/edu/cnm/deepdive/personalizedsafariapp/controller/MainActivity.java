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

/**
 * Creates a window to interact with the user as the start point of this app
 */
public class MainActivity extends AppCompatActivity {

  /**
   * The field below keep track of the usernames in this project.
   */
  private Button button;

  /**
   * the onCreate method is responsible to create the Activity when the Activitity is launched.
   *
   * @param savedInstanceState
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Calendar calendar = Calendar.getInstance();
    String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
    TextView textViewDate = findViewById(R.id.text_view_date);
    textViewDate.setText(currentDate);
    button = findViewById(R.id.lets_go_user);
    button.setText(getString(R.string.lets_go, "Nick"));
    button.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        openNavigationActivity();
      }
    });

  }

  /**
   * The intent below describes the action (go to NavigationActivity which should be performed and
   * provide data upon which such an action should be done.
   */
  public void openNavigationActivity() {
    Intent intent = new Intent(this, NavigationActivity.class);
    startActivity(intent);
  }


}
