// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package pk.colinjames.pocketcaddie;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.example.pocketcaddies:
//            Memory, Scores, Round, Player, 
//            Course, MainActivity

@SuppressLint("NewApi")
public class SaveRoundDialog extends DialogFragment
{

    CheckBox check1;
    CheckBox check2;
    CheckBox check3;
    CheckBox check4;
    private LayoutInflater inflator;
    private ArrayList player_names;
    private View view1;
    Memory memory;

    public SaveRoundDialog()
    {
    }

    private boolean checkExists(String s)
    {
        boolean flag;
        if (s == null)
        {
            flag = false;
        } else
        {
            ArrayList arraylist = memory.createPlayerNames();
            flag = false;
            Iterator iterator = arraylist.iterator();
            while (iterator.hasNext()) 
            {
                if (((String)iterator.next()).equals(s))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public static ArrayList getOpponents(int i)
    {
        int j = 0;
        String as[];

        switch( i){
        
        case 0: as = new String[3];
        as[0] = Scores.player_two;
        as[1] = Scores.player_three;
        as[2] = Scores.player_four; 	
        break;
        case 1: as = new String[3];
        as[0] = Scores.player_one;
        as[1] = Scores.player_three;
        as[2] = Scores.player_four;  	
        break;
        case 2: as = new String[3];
        as[0] = Scores.player_one;
        as[1] = Scores.player_two;
        as[2] = Scores.player_four;   	
        break;
        case 3: as = new String[3];
        as[0] = Scores.player_one;
        as[1] = Scores.player_two;
        as[2] = Scores.player_three;	
        break;
        default: 
        as = new String[1];
        as[0] = "error";
        }

        ArrayList arraylist;
        int k;
        arraylist = new ArrayList();
        k = as.length;
        while(j< k){
            String s = as[j];
            if (s != null)
            {
                arraylist.add(s);
            }
            j++;
        }
        return arraylist;
    }

    
          
//          JVM INSTR tableswitch 1 4: default 32
//          //                   1 62
//          //                   2 88
//          //                   3 114
//          //                   4 140;
//                 goto _L1 _L2 _L3 _L4 _L5
//      _L1:
//              String as[];
//              as = new String[1];
//              as[0] = "error";
//      _L6:
//              ArrayList arraylist;
//              int k;
//              arraylist = new ArrayList();
//              k = as.length;
//      _L7:
//              if (j >= k)
//              {
//                  return arraylist;
//              }
//              break MISSING_BLOCK_LABEL_166;
//      _L2:
//              as = new String[3];
//              as[0] = Scores.player_two;
//              as[1] = Scores.player_three;
//              as[2] = Scores.player_four;
//                goto _L6
//      _L3:
//              as = new String[3];
//              as[0] = Scores.player_one;
//              as[1] = Scores.player_three;
//              as[2] = Scores.player_four;
//                goto _L6
//      _L4:
//              as = new String[3];
//              as[0] = Scores.player_one;
//              as[1] = Scores.player_two;
//              as[2] = Scores.player_four;
//                goto _L6
//      _L5:
//              as = new String[3];
//              as[0] = Scores.player_one;
//              as[1] = Scores.player_two;
//              as[2] = Scores.player_three;
//                goto _L6
//              String s = as[j];
//              if (s != null)
//              {
//                  arraylist.add(s);
//              }
//              j++;
//                goto _L7
    

    public Dialog onCreateDialog(Bundle bundle)
    {
        memory = Memory.loadData();
        setCancelable(false);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        inflator = getActivity().getLayoutInflater();
        view1 = inflator.inflate(R.layout.save_round_dialog , null);
        boolean flag = false;
        check1 = (CheckBox)view1.findViewById(R.id.save_1);
        check2 = (CheckBox)view1.findViewById(R.id.save_2);
        check3 = (CheckBox)view1.findViewById(R.id.save_3);
        check4 = (CheckBox)view1.findViewById(R.id.save_4);
        TextView textview = (TextView)view1.findViewById(R.id.no_players);
        if (Scores.player_one == null || !checkExists(Scores.player_one))
        {
            check1.setVisibility(View.GONE);
        } else
        {
            check1.setText(Scores.player_one);
            flag = true;
        }
        if (Scores.player_two == null || !checkExists(Scores.player_two))
        {
            check2.setVisibility(View.GONE);
        } else
        {
            check2.setText(Scores.player_two);
        }
        if (Scores.player_three == null || !checkExists(Scores.player_three))
        {
            check3.setVisibility(View.GONE);
        } else
        {
            check3.setText(Scores.player_three);
            flag = true;
        }
        if (Scores.player_four == null || !checkExists(Scores.player_four))
        {
            check4.setVisibility(View.GONE);
        } else
        {
            check4.setText(Scores.player_four);
            flag = true;
        }
        if (flag)
        {
            textview.setVisibility(View.GONE);
        }
        builder.setView(view1).setPositiveButton(R.string.Enter, new DialogInterface.OnClickListener() {

            final SaveRoundDialog this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                player_names = memory.createPlayerNames();
                Log.d("what", "working");
                Player player = memory.findPlayer(Scores.player_one);
                Player player1 = memory.findPlayer(Scores.player_two);
                Player player2 = memory.findPlayer(Scores.player_three);
                Player player3 = memory.findPlayer(Scores.player_four);
                Course course = Scores.course;
                if (check1.isChecked())
                {
                    Round round = new Round(course, Scores.player1_scores, player, SaveRoundDialog.getOpponents(1), Scores.date_played, Scores.type_play, Scores.playerone_difference);
                    player.addRound(round);
                    course.addRound(round);
                    Memory.saveData(memory);
                }
                if (check2.isChecked())
                {
                    Round round1 = new Round(course, Scores.player2_scores, player1, SaveRoundDialog.getOpponents(2), Scores.date_played, Scores.type_play, Scores.playertwo_difference);
                    player1.addRound(round1);
                    course.addRound(round1);
                    Memory.saveData(memory);
                }
                if (check3.isChecked())
                {
                    Round round2 = new Round(course, Scores.player3_scores, player2, SaveRoundDialog.getOpponents(3), Scores.date_played, Scores.type_play, Scores.playerthree_difference);
                    player2.addRound(round2);
                    course.addRound(round2);
                    Memory.saveData(memory);
                }
                if (check4.isChecked())
                {
                    Round round3 = new Round(course, Scores.player4_scores, player3, SaveRoundDialog.getOpponents(4), Scores.date_played, Scores.type_play, Scores.playerfour_difference);
                    player3.addRound(round3);
                    course.addRound(round3);
                    Memory.saveData(memory);
                }
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                dismiss();
            }

            
            {
                this$0 = SaveRoundDialog.this;
            }
        }).setNegativeButton(R.string.Cancel, new DialogInterface.OnClickListener() {

            final SaveRoundDialog this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
            }

            
            {
                this$0 = SaveRoundDialog.this;
            }
        });
        return builder.create();
    }

    public void onStart()
    {
        super.onStart();
        AlertDialog alertdialog = (AlertDialog)getDialog();
        if (alertdialog != null)
        {
            alertdialog.getButton(-1).setOnClickListener(new View.OnClickListener() {

                final SaveRoundDialog this$0;

                public void onClick(View view)
                {
                    player_names = memory.createPlayerNames();
                    Log.d("what", "confused");
                    Player player = memory.findPlayer(Scores.player_one);
                    Player player1 = memory.findPlayer(Scores.player_two);
                    Player player2 = memory.findPlayer(Scores.player_three);
                    Player player3 = memory.findPlayer(Scores.player_four);
                    Course course = Scores.course;
                    if (check1.isChecked())
                    {
                        Round round = new Round(course, Scores.player1_scores, player, SaveRoundDialog.getOpponents(1), Scores.date_played, Scores.type_play, Scores.playerone_difference);
                        System.out.println(Scores.type_play);
                        player.addRound(round);
                        //Log.d("please", Integer.toString(course.getTimesPlayed()));
                        course.addRound(round);
                       // Log.d("please", Integer.toString(course.getTimesPlayed()));
                        memory.updateCourse(course);
                      //  Log.d("please", Integer.toString(memory.courses.get(0).getTimesPlayed()));
                        Memory.saveData(memory);
                    }
                    if (check2.isChecked())
                    {
                        Round round1 = new Round(course, Scores.player2_scores, player1, SaveRoundDialog.getOpponents(2), Scores.date_played, Scores.type_play, Scores.playertwo_difference);
                        player1.addRound(round1);
                        course.addRound(round1);
                        memory.updateCourse(course);

                        Memory.saveData(memory);
                    }
                    if (check3.isChecked())
                    {
                        Round round2 = new Round(course, Scores.player3_scores, player2, SaveRoundDialog.getOpponents(3), Scores.date_played, Scores.type_play, Scores.playerthree_difference);
                        player2.addRound(round2);
                        course.addRound(round2);
                        memory.updateCourse(course);
                        Memory.saveData(memory);
                    }
                    if (check4.isChecked())
                    {
                        Round round3 = new Round(course, Scores.player4_scores, player3, SaveRoundDialog.getOpponents(4), Scores.date_played, Scores.type_play, Scores.playerfour_difference);
                        player3.addRound(round3);
                        course.addRound(round3);
                        Memory.saveData(memory);
                    }
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                    dismiss();
                }

            
            {
                this$0 = SaveRoundDialog.this;
            }
            });
        }
    }

}
