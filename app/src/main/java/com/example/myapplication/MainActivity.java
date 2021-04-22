package com.example.myapplication;

import android.os.Bundle;

import com.example.myapplication.ui.friends.Friend;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    public HashMap<String, Friend> friendHashMap;
    public void initFakeUserData(){
        friendHashMap = new HashMap<String, Friend>();
        friendHashMap.put("Ned Stark", new Friend("Ned Stark",5, true));
        friendHashMap.put("Robert Baratheon", new Friend("Robert Baratheon",5, true));
        friendHashMap.put("Jaime Lannister", new Friend("Jaime Lannister",4, true));
        friendHashMap.put("Daenerys Targaryen", new Friend("Daenerys Targaryen",4, true));
        friendHashMap.put("Jon Snow", new Friend("Jon Snow",3, true));
        friendHashMap.put("Arya Stark", new Friend("Arya Stark",3, true));
        friendHashMap.put("Sansa Stark", new Friend("Sansa Stark",2, true));
        friendHashMap.put("Tyrion Lannister", new Friend("Tyrion Lannister",2, true));
        friendHashMap.put("Robb Stark", new Friend("Robb Stark",1, true));
        friendHashMap.put("Night King", new Friend("Night King",1, true));

         friendHashMap.put("Eren Yeager", new Friend("Eren Yeager",5, false));
         friendHashMap.put("Mikasa Ackerman",new Friend("Mikasa Ackerman",5, false));
         friendHashMap.put("Armin Arlert",new Friend("Armin Arlert",4, false));
         friendHashMap.put("Reiner Braun",new Friend("Reiner Braun",4, false));
         friendHashMap.put("Bertholdt Hoover",new Friend("Bertholdt Hoover",3, false));
         friendHashMap.put("Annie Leonhart",new Friend("Annie Leonhart",3, false));
         friendHashMap.put("Sasha Blouse",new Friend("Sasha Blouse",2, false));
         friendHashMap.put("Levi Ackerman",new Friend("Levi Ackerman",2, false));
         friendHashMap.put("Zeke Jaeger",new Friend("Zeke Jaeger",1, false));
         friendHashMap.put("Pieck Finger",new Friend("Pieck Finger",1, false));
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_log, R.id.navigation_goals, R.id.navigation_friends, R.id.navigation_settings)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        initFakeUserData();
    }

}