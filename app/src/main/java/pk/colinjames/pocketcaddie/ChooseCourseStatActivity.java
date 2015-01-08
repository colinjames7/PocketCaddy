// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package pk.colinjames.pocketcaddie;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

// Referenced classes of package com.example.pocketcaddies:
//            Memory, CourseStat

@SuppressLint("NewApi")
public class ChooseCourseStatActivity extends Activity{

    //super();

    public static final String COURSE_STAT_NAME = "com.example.pocketcaddies.course_stat_name";
    public static ArrayList course_names;
    public static ArrayAdapter courseadapter;
    String clicked;

    public ChooseCourseStatActivity(){
    }

	protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        getActionBar().setBackgroundDrawable(null);
        getActionBar().setDisplayShowTitleEnabled(false);
        setContentView(R.layout.activity_choose_course_stat);
        course_names = Memory.createCourseNames();
        System.out.println(course_names);
        courseadapter = new ArrayAdapter(this, R.layout.list_custom, course_names);
        TextView textview = (TextView)findViewById(R.id.course_empty_message);
        textview.setVisibility(View.GONE);
        if (course_names.isEmpty())
        {
            textview.setVisibility(View.VISIBLE);
        }
        ((ListView)findViewById(R.id.coursestat_listview)).setAdapter(courseadapter);
        ((ListView)findViewById(R.id.coursestat_listview)).setOnItemClickListener(new AdapterView.OnItemClickListener() {

            final ChooseCourseStatActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                clicked = (String)adapterview.getItemAtPosition(i);
                toStat(view);
            }

            
            {
                this$0 = ChooseCourseStatActivity.this;
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        //getMenuInflater().inflate(0x7f0c0004, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == R.id.action_settings)
        {
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    public void toStat(View view){
        Intent intent = new Intent(this, CourseStat.class);
        intent.putExtra("com.example.pocketcaddies.course_stat_name", clicked);
        startActivity(intent);
    }
}
