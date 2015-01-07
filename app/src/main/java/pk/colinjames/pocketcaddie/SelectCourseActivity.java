// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package pk.colinjames.pocketcaddie;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;

// Referenced classes of package com.example.pocketcaddies:
//            CourseDialog, Memory, TypeActivity

@SuppressLint("NewApi")
public class SelectCourseActivity extends Activity
{

    public static final String COURSE_NAME = "com.example.PocketCaddies.Course_Name";
    public static ArrayList player_names;
    public static ArrayAdapter playeradapter;
    String clicked;
    String player1_name;
    String player2_name;
    String player3_name;
    String player4_name;

    public SelectCourseActivity()
    {
    }

	public void enterCourse(View view)
    {
        (new CourseDialog()).show(getFragmentManager(), "course_selection");
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getActionBar().setDisplayShowTitleEnabled(false);
        getActionBar().setBackgroundDrawable(null);
        setContentView(R.layout.activity_select_course);
        Intent intent = getIntent();
        player_names = Memory.createCourseNames();
        ((Button)findViewById(R.id.add_course_button)).setBackgroundColor(0xffcccccc);
        String s = intent.getStringExtra("com.examples.PocketCaddies.Player1");
        String s1 = intent.getStringExtra("com.examples.PocketCaddies.Player2");
        String s2 = intent.getStringExtra("com.examples.PocketCaddies.Player3");
        String s3 = intent.getStringExtra("com.examples.PocketCaddies.Player4");
        if (s != null)
        {
            player1_name = s;
        }
        if (s1 != null)
        {
            player2_name = s1;
        }
        if (s1 != null)
        {
            player3_name = s2;
        }
        if (s2 != null)
        {
            player4_name = s3;
        }
        //playeradapter = new ArrayAdapter(this, R.id.course_list, android.R.layout.simple_list_item_1, player_names);

        playeradapter = new ArrayAdapter(this, R.layout.list_custom, player_names);
        ((ListView)findViewById(R.id.course_listview)).setAdapter(playeradapter);
        ((ListView)findViewById(R.id.course_listview)).setOnItemClickListener(new AdapterView.OnItemClickListener() {

            final SelectCourseActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                clicked = (String)adapterview.getItemAtPosition(i);
                toType(view);
            }

            
            {
                this$0 = SelectCourseActivity.this;
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
//        getMenuInflater().inflate(R.id.s, menu);
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

    public void toType(View view)
    {
        Intent intent = new Intent(this, TypeActivity.class);
        intent.putExtra("com.example.PocketCaddies.Course_Name", clicked);
        intent.putExtra("com.examples.PocketCaddies.Player1", player1_name);
        intent.putExtra("com.examples.PocketCaddies.Player2", player2_name);
        intent.putExtra("com.examples.PocketCaddies.Player3", player3_name);
        intent.putExtra("com.examples.PocketCaddies.Player4", player4_name);
        startActivity(intent);
    }
}
