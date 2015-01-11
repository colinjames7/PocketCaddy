// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package pk.colinjames.pocketcaddie;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

// Referenced classes of package com.example.pocketcaddies:
//            SelectPlayers2Activity, GuestInputDialog, PlayerInputDialog, Memory

@SuppressLint("NewApi")
public class PlayerSelectDialog extends DialogFragment
{

    public static int counter = 0;
    public static ArrayList player_names;
    private android.app.AlertDialog.Builder builder;
    private LayoutInflater inflator;
    private LinearLayout line;
    private String text;
    private View view1;
    private View view2;
    Memory memory;

    public PlayerSelectDialog()
    {
    }

    private void addPlayer(String s)
    {
        inflator = getActivity().getLayoutInflater();
        text = s;
        view1 = inflator.inflate(R.layout.guestinputdialog, null);
        view2 = getActivity().findViewById(android.R.id.content);
        LinearLayout.LayoutParams layoutparams = new LinearLayout.LayoutParams(-2, -2);
        layoutparams.gravity = 16;
        line = new LinearLayout(view2.getContext());
        line.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -2));
        line.setOrientation(LinearLayout.HORIZONTAL);
        text = s;
        TextView textview = new TextView(view2.getContext());
        textview.setText((new StringBuilder(String.valueOf(text))).append("      ").toString());
        textview.setTextSize(25F);
        textview.setTextColor(-1);
        textview.setLayoutParams(layoutparams);
        ImageButton imagebutton = new ImageButton(view2.getContext());
        imagebutton.setBackgroundColor(0);
        imagebutton.setImageResource(R.drawable.ic_delete_button);
        (new LinearLayout.LayoutParams(-2, -2)).gravity = 16;
        imagebutton.setLayoutParams(layoutparams);
        imagebutton.setOnClickListener(new View.OnClickListener() {

            final PlayerSelectDialog this$0;

            public void onClick(View view)
            {
                String _tmp = SelectPlayers2Activity.Player1_name;
                String s1 = SelectPlayers2Activity.Player2_name;
                String s2 = SelectPlayers2Activity.Player3_name;
                String s3 = SelectPlayers2Activity.Player4_name;
                Log.d("output", findNames());
                LinearLayout linearlayout = (LinearLayout)view2.findViewById(R.id.first_players);
                if (PlayerSelectDialog.counter <= 4)
                {
                    view2.findViewById(R.id.add_player).setVisibility(View.VISIBLE);
                }
                if (PlayerSelectDialog.counter <= 1)
                {
                    view2.findViewById(R.id.course2_button).setVisibility(View.INVISIBLE);
                }
                linearlayout.removeView(line);
                if (text.equals(SelectPlayers2Activity.Player1_name))
                {
                    SelectPlayers2Activity.Player3_name = s3;
                    SelectPlayers2Activity.Player2_name = s2;
                    SelectPlayers2Activity.Player1_name = s1;
                    SelectPlayers2Activity.Player4_name = null;
                }
                if (text.equals(SelectPlayers2Activity.Player2_name))
                {
                    SelectPlayers2Activity.Player3_name = s3;
                    SelectPlayers2Activity.Player2_name = s2;
                    SelectPlayers2Activity.Player4_name = null;
                }
                if (text.equals(SelectPlayers2Activity.Player3_name))
                {
                    SelectPlayers2Activity.Player3_name = s3;
                    SelectPlayers2Activity.Player4_name = null;
                }
                if (text.equals(SelectPlayers2Activity.Player4_name))
                {
                    SelectPlayers2Activity.Player4_name = null;
                }
                Log.d("output2", findNames());
                PlayerSelectDialog.counter = -1 + PlayerSelectDialog.counter;
            }

            
            {
                this$0 = PlayerSelectDialog.this;
            }
        });
        line.addView(textview);
        line.addView(imagebutton);
        ((LinearLayout)view2.findViewById(R.id.first_players)).addView(line, 0);
    }

    public static int dpToPixels(Context context, float f)
    {
        return (int)(0.5F + f * context.getResources().getDisplayMetrics().density);
    }

    private String findNames()
    {
        if (SelectPlayers2Activity.Player4_name != null)
        {
            return (new StringBuilder("player_one:")).append(SelectPlayers2Activity.Player1_name).append("   player_two:").append(SelectPlayers2Activity.Player2_name).append("player_three:  ").append(SelectPlayers2Activity.Player3_name).append("   player_four").append(SelectPlayers2Activity.Player4_name).toString();
        }
        if (SelectPlayers2Activity.Player3_name != null)
        {
            return (new StringBuilder("player_one:")).append(SelectPlayers2Activity.Player1_name).append("   player_two:").append(SelectPlayers2Activity.Player2_name).append("player_three:  ").append(SelectPlayers2Activity.Player3_name).toString();
        }
        if (SelectPlayers2Activity.Player2_name != null)
        {
            return (new StringBuilder("player_one:")).append(SelectPlayers2Activity.Player1_name).append("   player_two:").append(SelectPlayers2Activity.Player2_name).toString();
        }
        if (SelectPlayers2Activity.Player1_name != null)
        {
            return (new StringBuilder("player_one:")).append(SelectPlayers2Activity.Player1_name).toString();
        } else
        {
            return "all empty";
        }
    }

    public void goBack()
    {
        dismiss();
    }

    public void input_guest_players()
    {
        dismiss();
        (new GuestInputDialog()).show(getFragmentManager(), "player_selection");
    }

    public void input_players()
    {
        dismiss();
        (new PlayerInputDialog()).show(getFragmentManager(), "player_selection");
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        memory = Memory.loadData();
        player_names = memory.createPlayerNames();
        player_names.add("New Player");
        player_names.add("Guest Player");
        builder = new android.app.AlertDialog.Builder(getActivity());
        View view = getActivity().getLayoutInflater().inflate(R.layout.player_dialog, null);
            ArrayAdapter arrayadapter = new ArrayAdapter(view.getContext(), android.R.layout.simple_list_item_1, player_names);
           ((ListView)view.findViewById(R.id.player_listview)).setAdapter(arrayadapter);
        ((ListView)view.findViewById(R.id.player_listview)).setOnItemClickListener(new AdapterView.OnItemClickListener() {

            final PlayerSelectDialog this$0;

            public void onItemClick(AdapterView adapterview, View view3, int i, long l)
            {
                String s = (String)adapterview.getItemAtPosition(i);
                if (s == "New Player")
                {
                    input_players();
                } else
                {
                    if (s == "Guest Player")
                    {
                        input_guest_players();
                        return;
                    }
                    PlayerSelectDialog.counter = 1 + PlayerSelectDialog.counter;
                    dismiss();
                    addPlayer(s);
                    if (PlayerSelectDialog.counter == 1)
                    {
                        SelectPlayers2Activity.Player1_name = s;
                    }
                    if (PlayerSelectDialog.counter == 2)
                    {
                        SelectPlayers2Activity.Player2_name = s;
                    }
                    if (PlayerSelectDialog.counter == 3)
                    {
                        SelectPlayers2Activity.Player3_name = s;
                    }
                    if (PlayerSelectDialog.counter == 4)
                    {
                        SelectPlayers2Activity.Player4_name = s;
                    }
                    if (PlayerSelectDialog.counter >= 1)
                    {
                        view2.findViewById(R.id.course2_button).setVisibility(View.VISIBLE);
                    }
                    if (PlayerSelectDialog.counter >= 4)
                    {
                        view2.findViewById(R.id.add_player).setVisibility(View.INVISIBLE);
                        return;
                    }
                }
            }

            
            {
                this$0 = PlayerSelectDialog.this;
            }
        });
        builder.setView(view);
        return builder.create();
    }






}
