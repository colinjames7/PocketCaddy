// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package pk.colinjames.pocketcaddie;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.example.pocketcaddies:
//            Memory, SelectPlayers2Activity, PlayerSelectDialog, Player

@SuppressLint("NewApi")
public class PlayerInputDialog extends DialogFragment
{

    private LayoutInflater inflator;
    private LinearLayout line;
    private String text;
    private View view1;
    private View view2;
    Memory memory;

    public PlayerInputDialog()
    {
    }

    private void addPlayer(String s)
    {
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

            final PlayerInputDialog this$0;

            public void onClick(View view)
            {
                String _tmp = SelectPlayers2Activity.Player1_name;
                String s1 = SelectPlayers2Activity.Player2_name;
                String s2 = SelectPlayers2Activity.Player3_name;
                String s3 = SelectPlayers2Activity.Player4_name;
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
                PlayerSelectDialog.counter = -1 + PlayerSelectDialog.counter;
            }

            
            {
                this$0 = PlayerInputDialog.this;
            }
        });
        line.addView(textview);
        line.addView(imagebutton);
        ((LinearLayout)view2.findViewById(R.id.first_players)).addView(line, 0);
    }

    private boolean checkDuplicates(String s)
    {
        ArrayList arraylist = memory.createPlayerNames();
        boolean flag = true;
        Iterator iterator = arraylist.iterator();
        do
        {
            do
            {
                if (!iterator.hasNext())
                {
                    return flag;
                }
            } while (!((String)iterator.next()).equals(s));
            flag = false;
        } while (true);
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

    public Dialog onCreateDialog(Bundle bundle)
    {
        memory = Memory.loadData();
        setCancelable(false);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        inflator = getActivity().getLayoutInflater();
        view1 = inflator.inflate(R.layout.player_dialog_input, null);
        view2 = getActivity().findViewById(android.R.id.content);
        builder.setView(view1).setPositiveButton((R.string.Enter), new DialogInterface.OnClickListener() {

            final PlayerInputDialog this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                String s = ((EditText)view1.findViewById(R.id.player_input)).getText().toString();
                PlayerSelectDialog.counter = 1 + PlayerSelectDialog.counter;
                addPlayer(s);
                if (PlayerSelectDialog.counter >= 1)
                {
                    view2.findViewById(R.id.course2_button).setVisibility(View.INVISIBLE);
                }
                if (PlayerSelectDialog.counter >= 4)
                {
                    view2.findViewById(R.id.add_player).setVisibility(View.INVISIBLE);
                }
            }

            
            {
                this$0 = PlayerInputDialog.this;
            }
        }).setNegativeButton(R.string.Cancel, new DialogInterface.OnClickListener() {

            final PlayerInputDialog this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
            }

            
            {
                this$0 = PlayerInputDialog.this;
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

                final PlayerInputDialog this$0;

                public void onClick(View view)
                {
                    String s = ((EditText)view1.findViewById(R.id.player_input)).getText().toString();
                    if (!s.matches("") && checkDuplicates(s))
                    {
                        Player player = new Player(new ArrayList(), s);
                        Memory.loadData();
                        memory.players.add(player);
                        Memory.saveData(memory);
                        dismiss();
                        PlayerSelectDialog.counter = 1 + PlayerSelectDialog.counter;
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
                        addPlayer(s);
                        if (PlayerSelectDialog.counter >= 1)
                        {
                            view2.findViewById(R.id.course2_button).setVisibility(View.VISIBLE);
                        }
                        if (PlayerSelectDialog.counter >= 4)
                        {
                            view2.findViewById(R.id.add_player).setVisibility(View.INVISIBLE);
                        }
                    }
                }

            
            {
                this$0 = PlayerInputDialog.this;
            }
            });
        }
    }







}
