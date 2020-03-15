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

public class WeekActivity extends AppCompatActivity {
   // private android.support.v7.widget.Toolbar toolbar;
    private Toolbar toolbar;
    private ListView listView;
    private String[]week;
  public static SharedPreferences sharedPreferences;
    public static String SEL_DAY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week);
        setupUIViews();
        initToolbar();
        setupListView();
    }
    private void setupUIViews(){

        toolbar=(Toolbar)findViewById(R.id.ToolbarWeek);
        listView=(ListView)findViewById(R.id.lvWeek);
        sharedPreferences = getSharedPreferences("MY_DAY", MODE_PRIVATE);
    }
    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Week");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void setupListView(){
        week=getResources().getStringArray(R.array.Week);
         WeekAdapter Adapter= new WeekAdapter(this,R.layout.activity_week_single_item,week);
         listView.setAdapter(Adapter);
         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){

                    case 0: { sharedPreferences.edit().putString(SEL_DAY, "Monday").apply();
                        Intent intent=new Intent(WeekActivity.this, DayDetail.class);
                        startActivity(intent);

                        break;
                    }
                    case 1: { sharedPreferences.edit().putString(SEL_DAY, "Tuesday").apply();
                        Intent intent=new Intent(WeekActivity.this, DayDetail.class);
                        startActivity(intent);

                        break;
                    }
                    case 2: {sharedPreferences.edit().putString(SEL_DAY, "Wednesday").apply();
                        Intent intent=new Intent(WeekActivity.this, DayDetail.class);
                        startActivity(intent);

                        break;
                    }
                    case 3:{sharedPreferences.edit().putString(SEL_DAY, "Thursday").apply();
                        Intent intent=new Intent(WeekActivity.this, DayDetail.class);
                        startActivity(intent);
                        break;
                    }
                    case 4: {sharedPreferences.edit().putString(SEL_DAY, "Friday").apply();
                        Intent intent=new Intent(WeekActivity.this, DayDetail.class);
                        startActivity(intent);

                        break;
                    }

                    default:break;
                }
            }
        });
    }
    public class WeekAdapter extends ArrayAdapter{

        private int resource;
        private LayoutInflater layoutInflater;
        private String[] week= new  String[]{};

        public WeekAdapter(Context context, int resource,String[] objects) {
            super(context, resource,objects);
            this.resource=resource;
            this.week=objects;
            layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder holder;
            if(convertView==null){
                holder= new ViewHolder();
                convertView= layoutInflater.inflate(resource,null);
                holder.ivLogo=(LetterImageView)convertView.findViewById(R.id.ivLetter);
                holder.tvWeek= (TextView)convertView.findViewById(R.id.tvMain);
                convertView.setTag(holder);
            }else{
                holder=(ViewHolder)convertView.getTag();
            }

            holder.ivLogo.setOval(true);
            holder.ivLogo.setLetter(week[position].charAt(0));
            holder.tvWeek.setText(week[position]);
            return convertView;
        }

        class ViewHolder{
            private LetterImageView ivLogo;
            private TextView tvWeek;

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


