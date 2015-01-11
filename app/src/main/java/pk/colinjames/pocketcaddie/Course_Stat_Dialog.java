// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package pk.colinjames.pocketcaddie;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

// Referenced classes of package com.example.pocketcaddies:
//            Scores, Memory, Course

@SuppressLint("NewApi")
public class Course_Stat_Dialog extends DialogFragment
{

    Course course;
    String course_name;
    private LayoutInflater inflator;
    private View view1;
    Memory memory;

    public Course_Stat_Dialog()
    {
    }

    public void deleteCourse(View view)
    {
    }

    public void exitDialog()
    {
        dismiss();
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        memory = Memory.loadData();
        AlertDialog.Builder builder;
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
        builder = new AlertDialog.Builder(getActivity());
        inflator = getActivity().getLayoutInflater();
        view1 = inflator.inflate(R.layout.activity_course_stat, null);
        super.onCreate(bundle);
        course_name = Scores.course_name;
        setCancelable(true);
        ((TextView)view1.findViewById(R.id.course_stat_name)).setText(course_name);
        course = memory.findCourse(course_name);
        textview = (TextView)view1.findViewById(R.id.course_stat_average);
        textview1 = (TextView)view1.findViewById(R.id.course_stat_times);
        textview2 = (TextView)view1.findViewById(R.id.course_avg1);
        textview3 = (TextView)view1.findViewById(R.id.course_avg2);
        textview4 = (TextView)view1.findViewById(R.id.course_avg3);
        textview5 = (TextView)view1.findViewById(R.id.course_avg4);
        textview6 = (TextView)view1.findViewById(R.id.course_avg5);
        textview7 = (TextView)view1.findViewById(R.id.course_avg6);
        textview8 = (TextView)view1.findViewById(R.id.course_avg7);
        textview9 = (TextView)view1.findViewById(R.id.course_avg8);
        textview10 = (TextView)view1.findViewById(R.id.course_avg9);
        textview11 = (TextView)view1.findViewById(R.id.course_avg10);
        textview12 = (TextView)view1.findViewById(R.id.course_avg11);
        textview13 = (TextView)view1.findViewById(R.id.course_avg12);
        textview14 = (TextView)view1.findViewById(R.id.course_avg13);
        textview15 = (TextView)view1.findViewById(R.id.course_avg14);
        textview16 = (TextView)view1.findViewById(R.id.course_avg15);
        textview17 = (TextView)view1.findViewById(R.id.course_avg16);
        textview18 = (TextView)view1.findViewById(R.id.course_avg17);
        textview19 = (TextView)view1.findViewById(R.id.course_avg18);
        textview20 = (TextView)view1.findViewById(R.id.course_front_best);
        textview21 = (TextView)view1.findViewById(R.id.course_back_best);
        textview22 = (TextView)view1.findViewById(R.id.course_total_best);

        
        if((double)course.getTimesPlayed() == 0.0D) {
            textview.setText("Course Never Played");
            textview20.setVisibility(View.GONE);
            textview2.setVisibility(View.GONE);
            textview3.setVisibility(View.GONE);
            textview4.setVisibility(View.GONE);
            textview5.setVisibility(View.GONE);
            textview6.setVisibility(View.GONE);
            textview7.setVisibility(View.GONE);
            textview8.setVisibility(View.GONE);
            textview9.setVisibility(View.GONE);
            textview21.setVisibility(View.GONE);
            textview12.setVisibility(View.GONE);
            textview13.setVisibility(View.GONE);
            textview14.setVisibility(View.GONE);
            textview15.setVisibility(View.GONE);
            textview16.setVisibility(View.GONE);
            textview17.setVisibility(View.GONE);
            textview18.setVisibility(View.GONE);
            textview19.setVisibility(View.GONE); }
        else {

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
            textview22.setText((new StringBuilder("Course Record: ")).append(Float.toString(course.getTotalBest())).toString());
        }

            if (course.getCourseLength() == 9)
            {
                textview11.setVisibility(View.INVISIBLE);
            }}
            LinearLayout linearlayout = (LinearLayout)view1.findViewById(R.id.course_stat_view );
            ((Button)view1.findViewById(R.id.course_delete_button)).setVisibility(View.GONE);
            Button button = new Button(view1.getContext());
            button.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -2));
            button.setText("Exit");
            View.OnClickListener onclicklistener = new View.OnClickListener() {

                final Course_Stat_Dialog this$0;

                public void onClick(View view)
                {
                    exitDialog();
                }

                
                {
                    this$0 = Course_Stat_Dialog.this;
                }
            };
            button.setOnClickListener(onclicklistener);
            linearlayout.addView(button);
            linearlayout.setPadding(0, 0, 0, 0);
            builder.setView(view1);
            return builder.create();}

    

    public void onStart()
    {
        super.onStart();
        AlertDialog _tmp = (AlertDialog)getDialog();
    }
}
