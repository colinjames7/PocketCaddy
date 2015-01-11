// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package pk.colinjames.pocketcaddie;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import java.io.PrintStream;

// Referenced classes of package com.example.pocketcaddies:
//            Memory, SelectPlayers2Activity, ChooseStatsActivity

@SuppressLint("NewApi")
public class MainActivity extends Activity
{

    public MainActivity()
    {
    }

    public boolean isExternalStorageWritable()
    {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
//        getActionBar().hide();
        if(Memory.loadData() == null){
            Log.d("yp", "af");
            Memory memory = new Memory();
            Memory.saveData(memory);
        }
        if(Memory.loadData() == null){ Log.d("what", "what");}


           // Log.d("yo", "yo");

        setContentView(R.layout.activity_main);
        ((Button)findViewById(R.id.plumtree)).setBackgroundColor(0xffcccccc);
        ((Button)findViewById(R.id.button1)).setBackgroundColor(0xffcccccc);
    }

//    public boolean onCreateOptionsMenu(Menu menu)
//    {
//        //getMenuInflater().inflate(0x7f0c000c, menu);
//        return true;
//    }

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

    public void toCourse(View view)
    {
        startActivity(new Intent(this, SelectPlayers2Activity.class));
        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
    }

    public void toStats(View view)
    {
        startActivity(new Intent(this, ChooseStatsActivity.class));
        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
    }
}
