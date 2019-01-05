package com.example.alfurquan.mymusicproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {

    private static final int ACTIVITY_NUM = 0;
    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    private DrawerLayout drawerLayout;
    private List<Album> albumList;
    private List<Album> albumList1;
    private AlbumAdapter albumAdapter;
    private AlbumAdapterOne albumAdapterOne;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    BottomNavigationView bottomNavigationView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        recyclerView1 = (RecyclerView) findViewById(R.id.recycle1);
        recyclerView2 = (RecyclerView) findViewById(R.id.recycle2);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomnavigation);
        disableShiftMode(bottomNavigationView);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Menu");
        albumList = new ArrayList<>();
        albumList1 = new ArrayList<>();
        prepareAlbums();
        prepareAlbums1();
        albumAdapterOne = new AlbumAdapterOne(this, albumList1);
        albumAdapter = new AlbumAdapter(this, albumList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView1.setLayoutManager(mLayoutManager);
        recyclerView1.setAdapter(albumAdapter);
        LinearLayoutManager mLayoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(mLayoutManager1);
        recyclerView2.setAdapter(albumAdapterOne);
        //   prepareAlbums();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        break;
                    case R.id.bins:
                        intent = new Intent(MainActivity.this, RadioActivity.class);
                        startActivity(intent);
                    case R.id.location:
                        break;
                    case R.id.location1:
                        break;
                }
                return true;
            }
        });
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_actions,menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.album1,
                R.drawable.album2,
                R.drawable.album3,
                R.drawable.album4,
                R.drawable.album5,
                R.drawable.album6,
                R.drawable.album7,
                R.drawable.album8,
                R.drawable.album9,
                R.drawable.album10,
                R.drawable.album11};

        Album a = new Album("True Romance", "English", covers[0]);
        albumList.add(a);

        a = new Album("Xscpae", "English", covers[1]);
        albumList.add(a);

        a = new Album("Maroon 5", "English", covers[2]);
        albumList.add(a);

        a = new Album("Born to Die", "English", covers[3]);
        albumList.add(a);

        a = new Album("Honeymoon", "English", covers[4]);
        albumList.add(a);

        a = new Album("I Need a Doctor", "English", covers[5]);
        albumList.add(a);

        a = new Album("Loud", "English", covers[6]);
        albumList.add(a);

        a = new Album("Legend", "English", covers[7]);
        albumList.add(a);

        a = new Album("Hello", "English", covers[8]);
        albumList.add(a);

        a = new Album("Greatest Hits", "English", covers[9]);
        albumList.add(a);

    }

    private void prepareAlbums1() {
        int[] covers = new int[]{
                R.drawable.album6,
                R.drawable.album7,
                R.drawable.album8,
                R.drawable.album9,
                R.drawable.album10,
                R.drawable.album11};

        Album a = new Album("True Romance", "13", covers[0]);
        albumList1.add(a);

        a = new Album("Xscpae", "8", covers[1]);
        albumList1.add(a);

        a = new Album("Maroon 5", "11", covers[2]);
        albumList1.add(a);

        a = new Album("Born to Die", "12", covers[3]);
        albumList1.add(a);

        a = new Album("Honeymoon", "14", covers[4]);
        albumList1.add(a);

        a = new Album("I Need a Doctor", "1", covers[5]);
        albumList1.add(a);
    }

    @SuppressLint("RestrictedApi")
    private void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            Log.e("BNVHelper", "Unable to get shift mode field", e);
        } catch (IllegalAccessException e) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e);
        }
    }
}
