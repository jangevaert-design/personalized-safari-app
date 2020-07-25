package edu.cnm.deepdive.personalizedsafariapp.controller;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import edu.cnm.deepdive.personalizedsafariapp.R;

public class NavigationActivity extends AppCompatActivity implements View.OnClickListener {

  private Button button;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_navigation);

    ImageView imageView = findViewById(R.id.rotating_image);
    AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
    animationDrawable.start();



    Button button1 = findViewById(R.id.itinerary);
    Button button2 = findViewById(R.id.accommodation);
    Button button3 = findViewById(R.id.points_of_interest);
    Button button4 = findViewById(R.id.general);

    button1.setOnClickListener(this);
    button2.setOnClickListener(this);
    button3.setOnClickListener(this);
    button4.setOnClickListener(this);

  }

  @Override
  public void onClick(View v) {
    Intent intent;
    switch (v.getId()) {
      case R.id.itinerary:
        intent = new Intent(this, ItineraryActivity.class);
        break;
      case R.id.accommodation:
        intent = new Intent(this, AccommodationActivity.class);
        break;
      case R.id.points_of_interest :
        intent = new Intent(this, PointsOfInterestActivity.class);
        break;
      default:  //case R.id.general:
        intent = new Intent(this, GeneralActivity.class);
        break;

    }
    startActivity(intent);
  }
}
