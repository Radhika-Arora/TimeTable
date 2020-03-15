package com.example.timetable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class FacultyDetails extends AppCompatActivity {
    private CircleImageView facultyImage;
    private Toolbar toolbar;
    private TextView facultyName;
    private TextView phoneNumber;
    private TextView email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_details);
        setupUIViews();
        initToolbar();
        setupDetails();
    }
    private void setupUIViews(){

       toolbar=(Toolbar)findViewById(R.id.ToolbarFacultyDetails);
       facultyImage=(CircleImageView)findViewById(R.id.ivFaculty);
       facultyName=(TextView)findViewById(R.id.tvFacultySelName);
       phoneNumber=(TextView)findViewById(R.id.tvPhoneNumber);
       email=(TextView)findViewById(R.id.tvEmail);
    }
    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Faculty Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupDetails()
    {    //FacultyAdapter adapter = new FacultyAdapter(this, R.layout.faculty_single_item,facultyName);
        int faculty_pos=FacultyActivity.preferences.getInt(FacultyActivity.SEL_FACULTY,0);
        String[] facultyNames=getResources().getStringArray(R.array.faculty_name);
        int[] facultyImages=new int[]{R.drawable.pic,R.drawable.pic4,R.drawable.pic3,R.drawable.pic2,R.drawable.pic1};
        int[] facultyArray=new int[]{R.array.MauleinPathak,R.array.RichaGupta,R.array.RashmeetKaur,R.array.Arpana,R.array.RakeshKumar};
        String[] facultyDetails=getResources().getStringArray(facultyArray[faculty_pos]);
        phoneNumber.setText(facultyDetails[0]);
        email.setText(facultyDetails[1]);
        facultyImage.setImageResource(facultyImages[faculty_pos]);
        facultyName.setText(facultyNames[faculty_pos]);
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
