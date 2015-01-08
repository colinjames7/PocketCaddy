// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package pk.colinjames.pocketcaddie;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

// Referenced classes of package com.example.pocketcaddies:
//            Memory, Course, ChooseStatsActivity

@SuppressLint("NewApi")
public class CourseStat extends Activity
{

    Course course;
    String course_name;

    public CourseStat()
    {
    }

    public void deleteButtonHandler()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle("Are Your Sure You Want To Delete?");
        builder.setMessage("Course Data Cannot Be Recovered");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            final CourseStat this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                Memory.courses.remove(course);
                Memory.saveData(Memory.getInstance());
                Intent intent = new Intent(CourseStat.this, ChooseStatsActivity.class);
                startActivity(intent);
            }

            
            {
                this$0 = CourseStat.this;
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            final CourseStat this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
            }

            
            {
                this$0 = CourseStat.this;
            }
        });
        builder.show();
    }

    public void deleteCourse(View view)
    {
        deleteButtonHandler();
    }

    protected void onCreate(Bundle bundle)
    {
        TextView textview;
        TextView textview1;
        TextView textview2;
        TextView textview3;
        TextView textview4;
        TextView textview5;
        TextView textview6;
        TextView textview7;
        TextView textview8;
        TextView textview9;
        TextView textview10;
        TextView textview11;
        TextView textview12;
        TextView textview13;
        TextView textview14;
        TextView textview15;
        TextView textview16;
        TextView textview17;
        TextView textview18;
        TextView textview19;
        TextView textview20;
        TextView textview21;
        TextView textview22;
        super.onCreate(bundle);
        getActionBar().setBackgroundDrawable(null);
        getActionBar().setDisplayShowTitleEnabled(false);
        Intent intent = getIntent();
        //(Button) findViewById(0x7f05005c);
        course_name = intent.getStringExtra("com.example.pocketcaddies.course_stat_name");
        setContentView(R.layout.activity_course_stat);
        ((TextView)findViewById(R.id.course_stat_name)).setText(course_name);
        course = Memory.findCourse(course_name);
        textview = (TextView)findViewById(R.id.course_stat_average);
        textview1 = (TextView)findViewById(R.id.course_stat_times);
        textview2 = (TextView)findViewById(R.id.course_avg1);
        textview3 = (TextView)findViewById(R.id.course_avg2);
        textview4 = (TextView)findViewById(R.id.course_avg3);
        textview5 = (TextView)findViewById(R.id.course_avg4);
        textview6 = (TextView)findViewById(R.id.course_avg5);
        textview7 = (TextView)findViewById(R.id.course_avg6);
        textview8 = (TextView)findViewById(R.id.course_avg7);
        textview9 = (TextView)findViewById(R.id.course_avg8);
        textview10 = (TextView)findViewById(R.id.course_avg9);
        textview11 = (TextView)findViewById(R.id.course_avg10);
        textview12 = (TextView)findViewById(R.id.course_avg11);
        textview13 = (TextView)findViewById(R.id.course_avg12);
        textview14 = (TextView)findViewById(R.id.course_avg13);
        textview15 = (TextView)findViewById(R.id.course_avg14);
        textview16 = (TextView)findViewById(R.id.course_avg15);
        textview17 = (TextView)findViewById(R.id.course_avg16);
        textview18 = (TextView)findViewById(R.id.course_avg17);
        textview19 = (TextView)findViewById(R.id.course_avg18);
        textview20 = (TextView)findViewById(R.id.course_front_best);
        textview21 = (TextView)findViewById(R.id.course_back_best);
        textview22 = (TextView)findViewById(R.id.course_total_best);
        if ((double)course.getTimesPlayed() == 0.0D){
        textview.setText("Course Never Played");
        textview20.setVisibility(View.INVISIBLE);
        textview2.setVisibility(View.INVISIBLE);
        textview3.setVisibility(View.INVISIBLE);
        textview4.setVisibility(View.INVISIBLE);
        textview5.setVisibility(View.INVISIBLE);
        textview6.setVisibility(View.INVISIBLE);
        textview7.setVisibility(View.INVISIBLE);
        textview8.setVisibility(View.INVISIBLE);
        textview9.setVisibility(View.INVISIBLE);
        textview21.setVisibility(View.INVISIBLE);
        textview12.setVisibility(View.INVISIBLE);
        textview13.setVisibility(View.INVISIBLE);
        textview14.setVisibility(View.INVISIBLE);
        textview15.setVisibility(View.INVISIBLE);
        textview16.setVisibility(View.INVISIBLE);
        textview17.setVisibility(View.INVISIBLE);
        textview18.setVisibility(View.INVISIBLE);
        textview19.setVisibility(View.INVISIBLE);}
        
        else{
        textview.setText((new StringBuilder("Average to Par:")).append(Float.toString(course.getAverage())).toString());
        textview1.setText((new StringBuilder("Times Played: ")).append(Integer.toString(course.getTimesPlayed())).toString());
        if (course.getFrontBest() != 1000F)
        {
            textview20.setText((new StringBuilder("Front Record: ")).append(Float.toString(course.getFrontBest())).toString());
            textview2.setText((new StringBuilder("Hole 1 Average: ")).append(Float.toString(course.getHoleAverage(1))).toString());
            textview3.setText((new StringBuilder("Hole 2 Average: ")).append(Float.toString(course.getHoleAverage(2))).toString());
            textview4.setText((new StringBuilder("Hole 3 Average: ")).append(Float.toString(course.getHoleAverage(3))).toString());
            textview5.setText((new StringBuilder("Hole 4 Average: ")).append(Float.toString(course.getHoleAverage(4))).toString());
            textview6.setText((new StringBuilder("Hole 5 Average: ")).append(Float.toString(course.getHoleAverage(5))).toString());
            textview7.setText((new StringBuilder("Hole 6 Average: ")).append(Float.toString(course.getHoleAverage(6))).toString());
            textview8.setText((new StringBuilder("Hole 7 Average: ")).append(Float.toString(course.getHoleAverage(7))).toString());
            textview9.setText((new StringBuilder("Hole 8 Average: ")).append(Float.toString(course.getHoleAverage(8))).toString());
            textview10.setText((new StringBuilder("Hole 9 Average: ")).append(Float.toString(course.getHoleAverage(9))).toString());
        } else
        {
            textview20.setVisibility(View.GONE);
            textview2.setText("Front Nine Never Played");
            textview3.setVisibility(View.GONE);
            textview4.setVisibility(View.GONE);
            textview5.setVisibility(View.GONE);
            textview6.setVisibility(View.GONE);
            textview7.setVisibility(View.GONE);
            textview8.setVisibility(View.GONE);
            textview9.setVisibility(View.GONE);
        }
        if (course.getBackBest() != 1000F)
        {
            textview21.setText((new StringBuilder("Back Record: ")).append(Float.toString(course.getBackBest())).toString());
            textview11.setText((new StringBuilder("Hole 10 Average: ")).append(Float.toString(course.getHoleAverage(10))).toString());
            textview12.setText((new StringBuilder("Hole 11 Average: ")).append(Float.toString(course.getHoleAverage(11))).toString());
            textview13.setText((new StringBuilder("Hole 12 Average: ")).append(Float.toString(course.getHoleAverage(12))).toString());
            textview14.setText((new StringBuilder("Hole 13 Average: ")).append(Float.toString(course.getHoleAverage(13))).toString());
            textview15.setText((new StringBuilder("Hole 14 Average: ")).append(Float.toString(course.getHoleAverage(14))).toString());
            textview16.setText((new StringBuilder("Hole 15 Average: ")).append(Float.toString(course.getHoleAverage(15))).toString());
            textview17.setText((new StringBuilder("Hole 16 Average: ")).append(Float.toString(course.getHoleAverage(16))).toString());
            textview18.setText((new StringBuilder("Hole 17 Average: ")).append(Float.toString(course.getHoleAverage(17))).toString());
            textview19.setText((new StringBuilder("Hole 18 Average: ")).append(Float.toString(course.getHoleAverage(18))).toString());
        } else
        {
            textview11.setText("Back Nine Never Played");
            textview21.setVisibility(View.GONE);
            textview12.setVisibility(View.GONE);
            textview13.setVisibility(View.GONE);
            textview14.setVisibility(View.GONE);
            textview15.setVisibility(View.GONE);
            textview16.setVisibility(View.GONE);
            textview17.setVisibility(View.GONE);
            textview18.setVisibility(View.GONE);
            textview19.setVisibility(View.GONE);
        }
        if (course.getTotalBest() != 1000F)
        {
            textview22.setText((new StringBuilder("Course Record")).append(Float.toString(course.getTotalBest())).toString());
        }
        
        if (course.getCourseLength() == 9)
        {
            textview11.setVisibility(View.GONE);
        }
        return;    }}

    public boolean onCreateOptionsMenu(Menu menu)
    {
        //getMenuInflater().inflate(0x7f0c0009, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x7f050133)
        {
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }
}
