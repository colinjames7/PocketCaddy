// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package pk.colinjames.pocketcaddie;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebHistoryItem;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

// Referenced classes of package com.example.pocketcaddies:
//            Round, Course, Memory, Player, 
//            ChooseStatsActivity

@SuppressLint("NewApi")
public class PlayerStat extends Activity{

    Player player;
    String player_name;
    LinearLayout view;

    public PlayerStat()
    {
    }

    private void showRound(Round round)
    {
        LinearLayout linearlayout;
        LinearLayout linearlayout2;
        LinearLayout linearlayout3;
        int ai[];
        int j;
        float af[];
        int i1;
        Course course = round.getCourse();
        HorizontalScrollView horizontalscrollview = new HorizontalScrollView(this);
        linearlayout = new LinearLayout(horizontalscrollview.getContext());
        linearlayout.setOrientation(LinearLayout.VERTICAL);
        TextView textview = new TextView(linearlayout.getContext());
        textview.setText(round.getDate().toString());
        linearlayout.addView(textview);
        TextView textview1 = new TextView(linearlayout.getContext());

        textview1.setText(round.getCourse().getName());
        linearlayout.addView(textview1);
        TextView textview2 = new TextView(linearlayout.getContext());
        TextView textview3 = new TextView(linearlayout.getContext());
        textview3.setText((new StringBuilder("Total Score: ")).append(Integer.toString((int)round.getTotal())).toString());
        TextView textview4 = new TextView(linearlayout.getContext());
        textview4.setText((new StringBuilder("To Par: ")).append(Integer.toString((int)round.getScoreToPar())).toString());
        linearlayout.addView(textview2);
        linearlayout.addView(textview3);
        linearlayout.addView(textview4);
        LinearLayout linearlayout1 = new LinearLayout(horizontalscrollview.getContext());
        TextView textview5 = new TextView(linearlayout.getContext());
        TextView textview6 = new TextView(linearlayout.getContext());
        TextView textview7 = new TextView(linearlayout.getContext());
        textview6.setText("Hole:   ");
        textview5.setText("Par:    ");
        textview7.setText("Score: ");
        linearlayout1.addView(textview6);
        TextView textview8 = new TextView(linearlayout.getContext());
        textview8.setText("1");
        TextView textview9 = new TextView(linearlayout.getContext());
        textview9.setText("2");
        TextView textview10 = new TextView(linearlayout.getContext());
        textview10.setText("3");
        TextView textview11 = new TextView(linearlayout.getContext());
        textview11.setText("4");
        TextView textview12 = new TextView(linearlayout.getContext());
        textview12.setText("5");
        TextView textview13 = new TextView(linearlayout.getContext());
        textview13.setText("6");
        TextView textview14 = new TextView(linearlayout.getContext());
        textview14.setText("7");
        TextView textview15 = new TextView(linearlayout.getContext());
        textview15.setText("8");
        TextView textview16 = new TextView(linearlayout.getContext());
        textview16.setText("9");
        TextView textview17 = new TextView(linearlayout.getContext());
        textview17.setText("10");
        TextView textview18 = new TextView(linearlayout.getContext());
        textview18.setText("11");
        TextView textview19 = new TextView(linearlayout.getContext());
        textview19.setText("12");
        TextView textview20 = new TextView(linearlayout.getContext());
        textview20.setText("13");
        TextView textview21 = new TextView(linearlayout.getContext());
        textview21.setText("14");
        TextView textview22 = new TextView(linearlayout.getContext());
        textview22.setText("15");
        TextView textview23 = new TextView(linearlayout.getContext());
        textview23.setText("16");
        TextView textview24 = new TextView(linearlayout.getContext());
        textview24.setText("17");
        TextView textview25 = new TextView(linearlayout.getContext());
        textview25.setText("18");
        linearlayout2 = new LinearLayout(horizontalscrollview.getContext());
        linearlayout2.addView(textview5);
        linearlayout3 = new LinearLayout(horizontalscrollview.getContext());
        linearlayout3.addView(textview7);
        textview.setTextColor(Color.WHITE);
        textview1.setTextColor(Color.WHITE);
        textview2.setTextColor(Color.WHITE);
        textview3.setTextColor(Color.WHITE);
        textview4.setTextColor(Color.WHITE);
        textview5.setTextColor(Color.WHITE);
        textview6.setTextColor(Color.WHITE);
        textview7.setTextColor(Color.WHITE);
        textview8.setTextColor(Color.WHITE);
        textview9.setTextColor(Color.WHITE);
        textview10.setTextColor(Color.WHITE);
        textview11.setTextColor(Color.WHITE);
        textview12.setTextColor(Color.WHITE);
        textview13.setTextColor(Color.WHITE);
        textview14.setTextColor(Color.WHITE);
        textview15.setTextColor(Color.WHITE);
        textview16.setTextColor(Color.WHITE);
        textview17.setTextColor(Color.WHITE);
        textview18.setTextColor(Color.WHITE);
        textview19.setTextColor(Color.WHITE);
        textview20.setTextColor(Color.WHITE);
        textview21.setTextColor(Color.WHITE);
        textview22.setTextColor(Color.WHITE);
        textview23.setTextColor(Color.WHITE);
        textview24.setTextColor(Color.WHITE);
        textview25.setTextColor(Color.WHITE);

        int i;
        int l;
        if (round.getType().equals("eighteen_holes"))
        {
            textview2.setText("Eighteen Holes");
            TextView textview28 = new TextView(linearlayout.getContext());
            TextView textview29 = new TextView(linearlayout.getContext());
            textview28.setText((new StringBuilder("Front: ")).append(Integer.toString((int)round.getFrontTotal())).toString());
            textview29.setText((new StringBuilder("Back: ")).append(Integer.toString((int)round.getBackTotal())).toString());
            linearlayout.addView(textview28);
            linearlayout.addView(textview29);
            linearlayout1.addView(textview8);
            linearlayout1.addView(textview9);
            linearlayout1.addView(textview10);
            linearlayout1.addView(textview11);
            linearlayout1.addView(textview12);
            linearlayout1.addView(textview13);
            linearlayout1.addView(textview14);
            linearlayout1.addView(textview15);
            linearlayout1.addView(textview16);
            linearlayout1.addView(textview17);
            linearlayout1.addView(textview18);
            linearlayout1.addView(textview19);
            linearlayout1.addView(textview20);
            linearlayout1.addView(textview21);
            linearlayout1.addView(textview22);
            linearlayout1.addView(textview23);
            linearlayout1.addView(textview24);
            linearlayout1.addView(textview25);
            linearlayout.addView(linearlayout1);
        } else
        if (round.getType().equals("front_nine"))
        {
            textview2.setText("Front Nine");
            linearlayout1.addView(textview8);
            linearlayout1.addView(textview9);
            linearlayout1.addView(textview10);
            linearlayout1.addView(textview11);
            linearlayout1.addView(textview12);
            linearlayout1.addView(textview13);
            linearlayout1.addView(textview14);
            linearlayout1.addView(textview15);
            linearlayout1.addView(textview16);
            linearlayout.addView(linearlayout1);
        } else
        if (round.getType().equals("back_nine"))
        {
            textview2.setText("Back Nine");
            linearlayout1.addView(textview17);
            linearlayout1.addView(textview18);
            linearlayout1.addView(textview19);
            linearlayout1.addView(textview20);
            linearlayout1.addView(textview21);
            linearlayout1.addView(textview22);
            linearlayout1.addView(textview23);
            linearlayout1.addView(textview24);
            linearlayout1.addView(textview25);
            linearlayout.addView(linearlayout1);
        }
        ai = course.getPars();
        i = ai.length;
        j = 0;
        while (j < i){
 		   int k = ai[j];
 		   TextView textview26 = new TextView(linearlayout.getContext());
 		   textview26.setText(Integer.toString(k) + " ");
 		   linearlayout2.addView(textview26);
            textview26.setTextColor(Color.WHITE);

            j++; }
 	   linearlayout.addView(linearlayout2);
 	   af = round.getScore();
 	   l = af.length;
 	   i1 = 0;

       while (i1 < l){
      float f = af[i1];
      TextView textview27 = new TextView(linearlayout.getContext());
      textview27.setText(Integer.toString((int)f)+ " ");
           textview27.setTextColor(Color.WHITE);
      linearlayout3.addView(textview27);
      i1++;}
      
        linearlayout.addView(linearlayout3);
        horizontalscrollview.addView(linearlayout);
        view.addView(horizontalscrollview);
        return;

    }

    public void deleteButtonHandler()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle("Are Your Sure You Want To Delete?");
        builder.setMessage("Player Data Cannot Be Recovered");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            final PlayerStat this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                Memory.players.remove(player);
                Memory.saveData(Memory.getInstance());
                Intent intent = new Intent(PlayerStat.this, ChooseStatsActivity.class);
                startActivity(intent);
            }

            
            {
                this$0 = PlayerStat.this;
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            final PlayerStat this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
            }

            
            {
                this$0 = PlayerStat.this;
            }
        });
        builder.show();
    }

    public void deletePlayer(View view1)
    {
        deleteButtonHandler();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getActionBar().setBackgroundDrawable(null);
        getActionBar().setDisplayShowTitleEnabled(false);
        player_name = getIntent().getStringExtra("com.example.pocketcaddies.player_stat_name");
        setContentView(R.layout.activity_player_stat);
        ((TextView)findViewById(R.id.player_stat_name)).setText(player_name);
        player = Memory.findPlayer(player_name);
        View view1 = findViewById(R.id.rounds_text);
        TextView textview = (TextView)findViewById(R.id.player_stat_average);
        TextView textview1 = (TextView)findViewById(R.id.player_stat_times);
        view = (LinearLayout)findViewById(R.id.player_stat_view);
        Button button;
        if ((double)player.getTimesPlayed() == 0.0D)
        {
            textview.setText("Never Played");
            view1.setVisibility(View.GONE);
        } else
        {
            textview.setText((new StringBuilder("Average to Par:")).append(Float.toString(player.getAverage())).toString());
            textview1.setText((new StringBuilder("Times Played")).append((Integer.toString(player.getTimesPlayed()))).toString());
            Iterator iterator = player.getRounds().iterator();
            while (iterator.hasNext()) 
            {
                showRound((Round)iterator.next());
            }
        }
        button = new Button(this);
        button.setText("Delete Player");
        button.setOnClickListener(new View.OnClickListener() {

            final PlayerStat this$0;

            public void onClick(View view2)
            {
                deletePlayer(view2);
            }

            
            {
                this$0 = PlayerStat.this;
            }
        });
        view.addView(button);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
       // getMenuInflater().inflate(0x7f0c0009, menu);
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
