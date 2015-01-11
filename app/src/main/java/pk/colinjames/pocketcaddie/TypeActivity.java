// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package pk.colinjames.pocketcaddie;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.io.PrintStream;

// Referenced classes of package com.example.pocketcaddies:
//            Memory, Course, SelectCourseActivity, Scores

@SuppressLint("NewApi")
public class TypeActivity extends Activity
{

    public static final String TYPE_PLAY = "com.example.PocketCaddies.typle_player";
    public static String type_play;
    public final String back_nine = "back_nine";
    public Course course;
    public String course_name;
    public final String eighteen_holes = "eighteen_holes";
    public final String front_nine = "front_nine";
    public Intent intent;
    public String player_four;
    public String player_one;
    public String player_three;
    public String player_two;
    Memory memory;

    public TypeActivity()
    {
    }

    public String findPlayers()
    {
        if (player_four != null)
        {
            return (new StringBuilder(String.valueOf(player_one))).append("  VS  ").append(player_two).append("  VS  ").append(player_three).append("  VS  ").append(player_four).toString();
        }
        if (player_three != null)
        {
            return (new StringBuilder(String.valueOf(player_one))).append("  VS  ").append(player_two).append("  VS  ").append(player_three).toString();
        }
        if (player_two != null)
        {
            return (new StringBuilder(String.valueOf(player_one))).append("  VS  ").append(player_two).toString();
        } else
        {
            return player_one;
        }
    }

    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        memory = Memory.loadData();
        getActionBar().setBackgroundDrawable(null);
        getActionBar().setDisplayShowTitleEnabled(false);
        Button next_button = (Button)findViewById(R.id.next_screem);

        //next_button.setBackgroundColor(0xffcccccc);
        setContentView(R.layout.activity_type);
        intent = getIntent();
        RadioGroup radiogroup;
        final Button nextButton;
        final RadioButton radio_button_front;
        final RadioButton radio_button_back;
        final RadioButton radio_button_eighteen;
        if (intent == null)
        {
            System.out.println("fail");
        } else
        {
            System.out.println("succeed");
        }
        course_name = intent.getStringExtra("com.example.PocketCaddies.Course_Name");
        player_one = intent.getStringExtra("com.examples.PocketCaddies.Player1");
        player_two = intent.getStringExtra("com.examples.PocketCaddies.Player2");
        player_three = intent.getStringExtra("com.examples.PocketCaddies.Player3");
        player_four = intent.getStringExtra("com.examples.PocketCaddies.Player4");


        course = memory.findCourse(course_name);
        ((TextView)findViewById(R.id.type_names)).setText(findPlayers());
        ((TextView)findViewById(R.id.type_course_name)).setText(course_name);
        radiogroup = (RadioGroup)findViewById(R.id.play_style);
        nextButton = (Button)findViewById(R.id.next_screem);
        radio_button_front = (RadioButton)findViewById(R.id.Front_Nine);
        radio_button_back = (RadioButton)findViewById(R.id.Back_Nine);
        radio_button_eighteen = (RadioButton)findViewById(R.id.Eighteen_Holes);
        if (course.getCourseLength() == 9)
        {
            radio_button_eighteen.setVisibility(View.INVISIBLE);
            radio_button_back.setVisibility(View.INVISIBLE);
        }
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

//            final TypeActivity this$0;
//            private final Button val$nextButton;
//            private final RadioButton val$radio_button_back;
//            private final RadioButton val$radio_button_eighteen;
//            private final RadioButton val$radio_button_front;

            public void onCheckedChanged(RadioGroup radiogroup1, int i)
            {
                if (radio_button_front.isChecked() || radio_button_back.isChecked() || radio_button_eighteen.isChecked())
                {
                    nextButton.setEnabled(true);
                }
                if (radio_button_front.isChecked())
                {
                    TypeActivity.type_play = "front_nine";
                }
                if (radio_button_back.isChecked())
                {
                    TypeActivity.type_play = "back_nine";
                }
                if (radio_button_eighteen.isChecked())
                {
                    TypeActivity.type_play = "eighteen_holes";
                }
            }

            
            {
//                this$0 = TypeActivity.this;
//                radio_button_front = radiobutton;
//                radio_button_back = radiobutton1;
//                radio_button_eighteen = radiobutton2;
//                nextButton = button;
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
//        getMenuInflater().inflate(0x7f0c0012, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        Intent intent1;
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 16908332: 
            intent1 = new Intent(this, SelectCourseActivity.class);
            break;
        }
        intent1.putExtra("com.example.PocketCaddies.Course_Name", course_name);
        intent1.putExtra("com.examples.PocketCaddies.Player1", player_one);
        intent1.putExtra("com.examples.PocketCaddies.Player2", player_two);
        intent1.putExtra("com.examples.PocketCaddies.Player3", player_three);
        intent1.putExtra("com.examples.PocketCaddies.Player4", player_four);
        startActivity(intent1);
        return true;
    }

    public void toPlayers(View view)
    {
        Intent intent1 = new Intent(this, Scores.class);
        intent1.putExtra("com.example.PocketCaddies.Course_Name", course_name);
        intent1.putExtra("com.examples.PocketCaddies.Player1", player_one);
        intent1.putExtra("com.examples.PocketCaddies.Player2", player_two);
        intent1.putExtra("com.examples.PocketCaddies.Player3", player_three);
        intent1.putExtra("com.example.PocketCaddies.typle_player", type_play);
        intent1.putExtra("com.examples.PocketCaddies.Player4", player_four);
        startActivity(intent1);
    }
}
