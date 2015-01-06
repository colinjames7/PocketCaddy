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
//import android.support.v7.app.ActionBarActivity;
import android.util.Log;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

// Referenced classes of package com.example.pocketcaddies:
//            PlayerSelectDialog, SelectCourseActivity

@SuppressLint("NewApi")
public class SelectPlayers2Activity extends Activity
{

    public static final String PLAYER_1 = "com.examples.PocketCaddies.Player1";
    public static final String PLAYER_2 = "com.examples.PocketCaddies.Player2";
    public static final String PLAYER_3 = "com.examples.PocketCaddies.Player3";
    public static final String PLAYER_4 = "com.examples.PocketCaddies.Player4";
    public static String Player1_name;
    public static String Player2_name;
    public static String Player3_name;
    public static String Player4_name;
    private Button add_button;
    private int location;
    private Button play_button;
    private int player_counter;
    private LinearLayout selection_layout;
    private LinearLayout top_layout;

    public SelectPlayers2Activity()
    {
    }

    public void createNewTextView()
    {
        setContentView(R.layout.activity_select_players2);
    }

    public void onClick(View view)
    {
        select_players();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getActionBar().setDisplayShowTitleEnabled(false);
        getActionBar().setBackgroundDrawable(null);
        Player1_name = null;
        Player2_name = null;
        Player3_name = null;
        Player4_name = null;
        setContentView(R.layout.activity_select_players2);
        selection_layout = (LinearLayout)findViewById(R.id.first_players);
        add_button = (Button)findViewById(R.id.add_player);
        add_button.setBackgroundColor(0xffcccccc);
        play_button = (Button)findViewById(R.id.course2_button);
        play_button.setBackgroundColor(0xffcccccc);
        (new TextView(this)).setText("");
        play_button.setVisibility(View.INVISIBLE);
        player_counter = 0;
        location = 0;
    }

//    public boolean onCreateOptionsMenu(Menu menu)
//    {
//        //getMenuInflater().inflate(find, menu);
//        return true;
//    }
//
//    public boolean onOptionsItemSelected(MenuItem menuitem)
//    {
//        if (menuitem.getItemId() == 0x7f050133)
//        {
//            return true;
//        } else
//        {
//            return super.onOptionsItemSelected(menuitem);
//        }
//    }

    public void onStop()
    {
        super.onStop();
        PlayerSelectDialog.counter = 0;
       }

    public void select_players()
    {
         PlayerSelectDialog playerselectdialog = new PlayerSelectDialog();
        playerselectdialog.show(getFragmentManager(), "player_selection");
//        if (playerselectdialog.getView() == null)
//        {
//            Log.d("Somewhere", "Somehow");
//        }
    }

    public void toCourse(View view)
    {
        Intent intent = new Intent(this, SelectCourseActivity.class);
        intent.putExtra("com.examples.PocketCaddies.Player1", Player1_name);
        intent.putExtra("com.examples.PocketCaddies.Player2", Player2_name);
        intent.putExtra("com.examples.PocketCaddies.Player3", Player3_name);
        intent.putExtra("com.examples.PocketCaddies.Player4", Player4_name);
        startActivity(intent);
    }
}
