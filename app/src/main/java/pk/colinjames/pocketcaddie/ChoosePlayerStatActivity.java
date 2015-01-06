// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package pk.colinjames.pocketcaddie;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

// Referenced classes of package com.example.pocketcaddies:
//            Memory, PlayerStat

@SuppressLint("NewApi")
public class ChoosePlayerStatActivity extends Activity
{

    public static final String PLAYER_STAT_NAME = "com.example.pocketcaddies.player_stat_name";
    String clicked;
    public ArrayList player_names;
    public ArrayAdapter playeradapter;

    public ChoosePlayerStatActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Button _tmp = (Button)findViewById(R.id.button1);
        Button _tmp1 = (Button)findViewById(R.id.button2);
        getActionBar().setDisplayShowTitleEnabled(false);
        getActionBar().setBackgroundDrawable(null);
        setContentView(R.layout.activity_choose_player_stat);
        player_names = Memory.createPlayerNames();
        playeradapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, player_names);
        TextView textview = (TextView)findViewById(R.id.player_empty_message);
        textview.setVisibility(View.INVISIBLE);
        if (player_names.isEmpty())
        {
            textview.setVisibility(View.VISIBLE);
        }
        ((ListView)findViewById(R.id.playerstat_listview)).setAdapter(playeradapter);
        ((ListView)findViewById(R.id.playerstat_listview)).setOnItemClickListener(new AdapterView.OnItemClickListener() {

            final ChoosePlayerStatActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                clicked = (String)adapterview.getItemAtPosition(i);
                toStat(view);
            }

            
            {
                this$0 = ChoosePlayerStatActivity.this;
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        //getMenuInflater().inflate(0x7f0c0006, menu);
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

    public void toStat(View view)
    {
        Intent intent = new Intent(this, PlayerStat.class);
        intent.putExtra("com.example.pocketcaddies.player_stat_name", clicked);
        startActivity(intent);
    }
}
