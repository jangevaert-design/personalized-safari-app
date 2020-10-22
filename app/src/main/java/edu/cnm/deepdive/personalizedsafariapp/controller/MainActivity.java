package edu.cnm.deepdive.personalizedsafariapp.controller;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.FragmentActivity;
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import com.google.android.gms.maps.SupportMapFragment;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.MarkerOptions;
import edu.cnm.deepdive.personalizedsafariapp.R;
import java.text.DateFormat;
import java.util.Calendar;

/**
 * Creates a window to interact with the user as the start point of this app
 */
 public class MainActivity extends AppCompatActivity {
//  public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

  private Button button;
//  GoogleMap map;

  /**
   * the onCreate method is responsible to create the Activity when the Activitity is launched.
   *
   * @param savedInstanceState
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

//    SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//        .findFragmentById(R.id.map);
//    mapFragment.getMapAsync(this);


    ImageView imageView = findViewById(R.id.rotating_main_image);
    AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
    animationDrawable.start();

    Calendar calendar = Calendar.getInstance();
    String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
    TextView textViewDate = findViewById(R.id.text_view_date);
    textViewDate.setText(currentDate);
    button = findViewById(R.id.lets_go_user);
    button.setText(getString(R.string.lets_go, "Katjoe"));
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


//  @Override
//  public void onMapReady(GoogleMap googleMap) {
//    map = googleMap;
//
//    LatLng Arusha = new LatLng(	-3.386925, 36.682995);
//    map.addMarker(new MarkerOptions().position(Arusha).title("Arusha"));
//    map.moveCamera(CameraUpdateFactory.newLatLng(Arusha));
//  }
}
