package com.example.timetable;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.timetable.Utils.LetterImageView;

public class FacultyActivity extends AppCompatActivity {
    private ListView listView;
    private Toolbar toolbar;
    public static SharedPreferences preferences;
    public static String SEL_FACULTY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);
        setupUIViews();
        initToolbar();
        setupListView();
    }

    private void setupUIViews() {

        toolbar = (Toolbar) findViewById(R.id.ToolbarFaculty);
        listView = (ListView) findViewById(R.id.lvFaculty);
        preferences = getSharedPreferences("myFaculty", MODE_PRIVATE);
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Faculty");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupListView() {
        String[] faculty_name = getResources().getStringArray(R.array.faculty_name);
        FacultyAdapter adapter = new FacultyAdapter(this, R.layout.faculty_single_item, faculty_name);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {

                    case 0: { preferences.edit().putInt(SEL_FACULTY, 0).apply();
                        Intent intent = new Intent(FacultyActivity.this, FacultyDetails.class);
                        startActivity(intent);

                        break;
                    }
                    case 1: {  preferences.edit().putInt(SEL_FACULTY, 1).apply();
                        Intent intent = new Intent(FacultyActivity.this, FacultyDetails.class);
                        startActivity(intent);

                        break;
                    }
                    case 2: {  preferences.edit().putInt(SEL_FACULTY, 2).apply();
                        Intent intent = new Intent(FacultyActivity.this, FacultyDetails.class);
                        startActivity(intent);

                        break;
                    }
                    case 3: { preferences.edit().putInt(SEL_FACULTY, 3).apply();
                        Intent intent = new Intent(FacultyActivity.this, FacultyDetails.class);
                        startActivity(intent);

                        break;
                    }
                    case 4: {preferences.edit().putInt(SEL_FACULTY, 4).apply();
                        Intent intent = new Intent(FacultyActivity.this, FacultyDetails.class);
                        startActivity(intent);

                        break;
                    }

                    default:
                        break;
                }
            }
        });
    }

    public class FacultyAdapter extends ArrayAdapter {

        private int resource;
        private LayoutInflater layoutInflater;
        private String[] faculty = new String[]{};

        public FacultyAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
            this.resource = resource;
            this.faculty = objects;
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = layoutInflater.inflate(resource, null);
                holder.ivLogo = (LetterImageView) convertView.findViewById(R.id.ivLetterFaculty);
                holder.tvFaculty = (TextView) convertView.findViewById(R.id.tvFacultyName);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.ivLogo.setOval(true);
            holder.ivLogo.setLetter(faculty[position].charAt(0));
            holder.tvFaculty.setText(faculty[position]);
            return convertView;
        }

        class ViewHolder {
           public TextView tvFaculty;
            private LetterImageView ivLogo;


        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home : {
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}