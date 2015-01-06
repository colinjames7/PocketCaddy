// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package pk.colinjames.pocketcaddie;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

// Referenced classes of package com.example.pocketcaddies:
//            ChooseCourseStatActivity, ChoosePlayerStatActivity

@SuppressLint("NewApi")
public class ChooseStatsActivity extends Activity
{



    public ChooseStatsActivity()
    {
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
//        ((Button) findViewById(R.id.button1)).setBackgroundColor(0xffcccccc);
//        ((Button) findViewById(R.id.button2)).setBackgroundColor(0xffcccccc);

        getActionBar().setDisplayShowTitleEnabled(false);
        getActionBar().setBackgroundDrawable(null);
        setContentView(R.layout.activity_choose_stats);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
//        getMenuInflater().inflate(0x7f0c0008, menu);
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

    public void toCourseStats(View view)
    {
        startActivity(new Intent(this, ChooseCourseStatActivity.class));
    }

    public void toPlayerStats(View view)
    {
        startActivity(new Intent(this, ChoosePlayerStatActivity.class));
    }
}
