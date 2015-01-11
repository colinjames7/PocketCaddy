// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package pk.colinjames.pocketcaddie;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Date;

// Referenced classes of package com.example.pocketcaddies:
//            Memory, Course, Player, SaveRoundDialog, 
//            Course_Stat_Dialog, Player_Stat_Dialog, TypeActivity

@SuppressLint("NewApi")
public class Scores extends Activity{

    Memory memory;
    public static Course course;
    public static String course_name;
    public static Date date_played;
    public static float player1_scores[];
    public static float player2_scores[];
    public static float player3_scores[];
    public static float player4_scores[];
    public static String player_four;
    public static String player_one;
    public static String player_three;
    public static String player_two;
    public static float playerfour_difference;
    public static float playerone_difference;
    public static float playerthree_difference;
    public static float playertwo_difference;
    public static String type_play;
    TextView course_name_view;
    EditText four_1;
    EditText four_10;
    EditText four_11;
    EditText four_12;
    EditText four_13;
    EditText four_14;
    EditText four_15;
    EditText four_16;
    EditText four_17;
    EditText four_18;
    EditText four_2;
    EditText four_3;
    EditText four_4;
    EditText four_5;
    EditText four_6;
    EditText four_7;
    EditText four_8;
    EditText four_9;
    int holes_played;
    public int number_players;
    EditText one_1;
    EditText one_10;
    EditText one_11;
    EditText one_12;
    EditText one_13;
    EditText one_14;
    EditText one_15;
    EditText one_16;
    EditText one_17;
    EditText one_18;
    EditText one_2;
    EditText one_3;
    EditText one_4;
    EditText one_5;
    EditText one_6;
    EditText one_7;
    EditText one_8;
    EditText one_9;
    int par10_value;
    TextView par10_view;
    int par11_value;
    TextView par11_view;
    int par12_value;
    TextView par12_view;
    int par13_value;
    TextView par13_view;
    int par14_value;
    TextView par14_view;
    int par15_value;
    TextView par15_view;
    int par16_value;
    TextView par16_view;
    int par17_value;
    TextView par17_view;
    int par18_value;
    TextView par18_view;
    int par1_value;
    TextView par1_view;
    int par2_value;
    TextView par2_view;
    int par3_value;
    TextView par3_view;
    int par4_value;
    TextView par4_view;
    int par5_value;
    TextView par5_view;
    int par6_value;
    TextView par6_view;
    int par7_value;
    TextView par7_view;
    int par8_value;
    TextView par8_view;
    int par9_value;
    TextView par9_view;
    TextView par_back;
    TextView par_front;
    int par_list[];
    TextView par_total;
    TextView player1_backtotal;
    TextView player1_fronttotal;
    TextView player1_previousaverage;
    TextView player1_view;
    TextView player2_backtotal;
    TextView player2_fronttotal;
    TextView player2_previousaverage;
    TextView player2_view;
    TextView player3_backtotal;
    TextView player3_fronttotal;
    TextView player3_previousaverage;
    TextView player3_view;
    TextView player4_backtotal;
    TextView player4_fronttotal;
    TextView player4_previousaverage;
    TextView player4_view;
    private String player_button_pressed;
    TextView playerfour_average;
    TextView playerfour_topar;
    TextView playerfour_total;
    TextView playerone_average;
    TextView playerone_topar;
    TextView playerone_total;
    TextView playerthree_average;
    TextView playerthree_topar;
    TextView playerthree_total;
    TextView playertwo_average;
    TextView playertwo_topar;
    TextView playertwo_total;
    Button save_button;
    EditText three_1;
    EditText three_10;
    EditText three_11;
    EditText three_12;
    EditText three_13;
    EditText three_14;
    EditText three_15;
    EditText three_16;
    EditText three_17;
    EditText three_18;
    EditText three_2;
    EditText three_3;
    EditText three_4;
    EditText three_5;
    EditText three_6;
    EditText three_7;
    EditText three_8;
    EditText three_9;
    TextView total_scorecard_1;
    TextView total_scorecard_2;
    TextView total_scorecard_3;
    TextView total_scorecard_4;
    EditText two_1;
    EditText two_10;
    EditText two_11;
    EditText two_12;
    EditText two_13;
    EditText two_14;
    EditText two_15;
    EditText two_16;
    EditText two_17;
    EditText two_18;
    EditText two_2;
    EditText two_3;
    EditText two_4;
    EditText two_5;
    EditText two_6;
    EditText two_7;
    EditText two_8;
    EditText two_9;

    public Scores()
    {
    }

    private TextWatcher createWatcher(final int player, final int hole)
    {
        return new TextWatcher() {

            //   final Scores this$0;
//            private final int val$hole;
//            private final int val$player;

            public void afterTextChanged(Editable editable)
            {
                if (editable.toString().equals(""))
                {
                    updateScores(player, 0, hole);
                    return;
                } else
                {
                    updateScores(player, Integer.parseInt(editable.toString()), hole);
                    return;
                }
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }


            {
                // this$0 = Scores.this;
//                player = i;
//                hole = j;
            }
        };
    }

    private void setPars()
    {
        int i;
        int j;
        int k;
        i = 0;
        j = 0;
        k = 0;

        while(k<9){
            i += par_list[k];
            k++; }

        int l = 9;

        while (l < 18){
            j += par_list[l];
            l++;}

        par_back.setText(Integer.toString(j));
        par_front.setText(Integer.toString(i));
        return; }



    private void setParsFront()
    {
        int i = 0;
        int j = 0;
        do
        {
            if (j >= 9)
            {
                par_front.setText(Integer.toString(i));
                return;
            }
            i += par_list[j];
            j++;
        } while (true);
    }

    private void updateNines(int i){
        if (!type_play.equals("eighteen_holes")) {return;};

        int j;
        int k;
        j = 0;
        k = 0;
        int l = 0;


        switch(i){
            case(0):{
                int j2 = 0;
                int k2;
                while (j2 < 9) {
                    j = (int)((float)j + player1_scores[j2]);
                    j2++; }
                k2 = 9;

                while (k2 < 18)
                {
                    player1_fronttotal.setText(Integer.toString(Math.round(j)));
                    player1_backtotal.setText(Integer.toString(Math.round(k)));
                    return;
                }
                k = (int)((float)k + player1_scores[k2]);
                k2++;
            }

            break;
            case(1):{
                int l1 = 0;
                int i2;
                while (l1 < 9) {
                    j = (int)((float)j + player2_scores[l1]);
                    l1++; }
                i2 = 9;
                while (i2 < 18)
                {
                    player2_fronttotal.setText(Integer.toString(Math.round(j)));
                    player2_backtotal.setText(Integer.toString(Math.round(k)));
                    return;
                }
                k = (int)((float)k + player2_scores[i2]);
                i2++;}
            break;
            case(2):{
                int j1 = 0;
                int k1;
                while (j1 < 9) {
                    j = (int)((float)j + player3_scores[j1]);
                    j1++;}
                k1 = 9;

                while (k1 < 18)
                {
                    player3_fronttotal.setText(Integer.toString(Math.round(j)));
                    player3_backtotal.setText(Integer.toString(Math.round(k)));
                    return;
                }
                k = (int)((float)k + player3_scores[k1]);
                k1++;
            }
            break;
            case(3):{
                int i1;
                while (l < 9)
                {
                    j = (int)((float)j + player3_scores[l]);
                    l++;
                }
                i1 = 9;

                while (i1 < 18)
                {
                    player4_fronttotal.setText(Integer.toString(Math.round(j)));
                    player4_backtotal.setText(Integer.toString(Math.round(k)));
                    return;
                }
                k = (int)((float)k + player3_scores[i1]);
                i1++; }
            break;}



    }
//    private void updateNines(int i)
//    {
//        if (!type_play.equals("eighteen_holes")) goto _L2; else goto _L1
//_L1:
//        int j;
//        int k;
//        j = 0;
//        k = 0;
//        i;
//        JVM INSTR tableswitch 1 4: default 48
//    //                   1 49
//    //                   2 135
//    //                   3 221
//    //                   4 307;
//           goto _L2 _L3 _L4 _L5 _L6
//_L2:
//        return;
//_L3:
//        int j2 = 0;
//        int k2;
//        while (j2 < 9) 
//        {
//            j = (int)((float)j + player1_scores[j2]);
//            j2++;
//        }
//        k2 = 9;
//        do
//        {
//            if (k2 >= 18)
//            {
//                player1_fronttotal.setText(Integer.toString(Math.round(j)));
//                player1_backtotal.setText(Integer.toString(Math.round(k)));
//                return;
//            }
//            k = (int)((float)k + player1_scores[k2]);
//            k2++;
//        } while (true);
//_L4:
//        int l1 = 0;
//        int i2;
//        while (l1 < 9) 
//        {
//            j = (int)((float)j + player2_scores[l1]);
//            l1++;
//        }
//        i2 = 9;
//        do
//        {
//            if (i2 >= 18)
//            {
//                player2_fronttotal.setText(Integer.toString(Math.round(j)));
//                player2_backtotal.setText(Integer.toString(Math.round(k)));
//                return;
//            }
//            k = (int)((float)k + player2_scores[i2]);
//            i2++;
//        } while (true);
//_L5:
//        int j1 = 0;
//        int k1;
//        while (j1 < 9) 
//        {
//            j = (int)((float)j + player3_scores[j1]);
//            j1++;
//        }
//        k1 = 9;
//        do
//        {
//            if (k1 >= 18)
//            {
//                player3_fronttotal.setText(Integer.toString(Math.round(j)));
//                player3_backtotal.setText(Integer.toString(Math.round(k)));
//                return;
//            }
//            k = (int)((float)k + player3_scores[k1]);
//            k1++;
//        } while (true);
//_L6:
//        int l = 0;
//_L8:
//        int i1;
//        while (l < 9) 
//        {
//            j = (int)((float)j + player3_scores[l]);
//            l++;
//        }
//        i1 = 9;
//        do
//        {
//            if (i1 >= 18)
//            {
//                player4_fronttotal.setText(Integer.toString(Math.round(j)));
//                player4_backtotal.setText(Integer.toString(Math.round(k)));
//                return;
//            }
//            k = (int)((float)k + player3_scores[i1]);
//            i1++;
//        } while (true);
//        if (true) goto _L8; else goto _L7
//_L7:
//    }

    public boolean checkFilled()
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        boolean flag6;
        boolean flag7;
        boolean flag8;
        boolean flag9;
        boolean flag10;
        boolean flag11;
        boolean flag12;
        boolean flag13;
        boolean flag14;
        boolean flag15;
        boolean flag16;
        boolean flag17;
        boolean flag18;
        boolean flag19;
        boolean flag20;
        boolean flag21;
        boolean flag22;
        boolean flag23;
        boolean flag24;
        boolean flag25;
        boolean flag26;
        boolean flag27;
        boolean flag28;
        boolean flag29;
        boolean flag30;
        boolean flag31;
        boolean flag32;
        boolean flag33;
        boolean flag34;
        boolean flag35;
        boolean flag36;
        boolean flag37;
        boolean flag38;
        boolean flag39;
        boolean flag40;
        boolean flag41;
        boolean flag42;
        boolean flag43;
        boolean flag44;
        boolean flag45;
        boolean flag46;
        boolean flag47;
        boolean flag48;
        boolean flag49;
        boolean flag50;
        boolean flag51;
        boolean flag52;
        boolean flag53;
        boolean flag54;
        boolean flag55;
        boolean flag56;
        boolean flag57;
        boolean flag58;
        boolean flag59;
        boolean flag60;
        boolean flag61;
        boolean flag62;
        boolean flag63;
        boolean flag64;
        boolean flag65;
        boolean flag66;
        boolean flag67;
        boolean flag68;
        boolean flag69;
        boolean flag70;
        boolean flag71;
        if (one_1.getText().toString().matches(""))
        {
            flag = false;
        } else
        {
            flag = true;
        }
        if (one_2.getText().toString().matches(""))
        {
            flag1 = false;
        } else
        {
            flag1 = true;
        }
        if (one_3.getText().toString().matches(""))
        {
            flag2 = false;
        } else
        {
            flag2 = true;
        }
        if (one_4.getText().toString().matches(""))
        {
            flag3 = false;
        } else
        {
            flag3 = true;
        }
        if (one_5.getText().toString().matches(""))
        {
            flag4 = false;
        } else
        {
            flag4 = true;
        }
        if (one_6.getText().toString().matches(""))
        {
            flag5 = false;
        } else
        {
            flag5 = true;
        }
        if (one_7.getText().toString().matches(""))
        {
            flag6 = false;
        } else
        {
            flag6 = true;
        }
        if (one_8.getText().toString().matches(""))
        {
            flag7 = false;
        } else
        {
            flag7 = true;
        }
        if (one_9.getText().toString().matches(""))
        {
            flag8 = false;
        } else
        {
            flag8 = true;
        }
        if (one_10.getText().toString().matches(""))
        {
            flag9 = false;
        } else
        {
            flag9 = true;
        }
        if (one_11.getText().toString().matches(""))
        {
            flag10 = false;
        } else
        {
            flag10 = true;
        }
        if (one_12.getText().toString().matches(""))
        {
            flag11 = false;
        } else
        {
            flag11 = true;
        }
        if (one_13.getText().toString().matches(""))
        {
            flag12 = false;
        } else
        {
            flag12 = true;
        }
        if (one_14.getText().toString().matches(""))
        {
            flag13 = false;
        } else
        {
            flag13 = true;
        }
        if (one_15.getText().toString().matches(""))
        {
            flag14 = false;
        } else
        {
            flag14 = true;
        }
        if (one_16.getText().toString().matches(""))
        {
            flag15 = false;
        } else
        {
            flag15 = true;
        }
        if (one_17.getText().toString().matches(""))
        {
            flag16 = false;
        } else
        {
            flag16 = true;
        }
        if (one_18.getText().toString().matches(""))
        {
            flag17 = false;
        } else
        {
            flag17 = true;
        }
        if (two_1.getText().toString().matches(""))
        {
            flag18 = false;
        } else
        {
            flag18 = true;
        }
        if (two_2.getText().toString().matches(""))
        {
            flag19 = false;
        } else
        {
            flag19 = true;
        }
        if (two_3.getText().toString().matches(""))
        {
            flag20 = false;
        } else
        {
            flag20 = true;
        }
        if (two_4.getText().toString().matches(""))
        {
            flag21 = false;
        } else
        {
            flag21 = true;
        }
        if (two_5.getText().toString().matches(""))
        {
            flag22 = false;
        } else
        {
            flag22 = true;
        }
        if (two_6.getText().toString().matches(""))
        {
            flag23 = false;
        } else
        {
            flag23 = true;
        }
        if (two_7.getText().toString().matches(""))
        {
            flag24 = false;
        } else
        {
            flag24 = true;
        }
        if (two_8.getText().toString().matches(""))
        {
            flag25 = false;
        } else
        {
            flag25 = true;
        }
        if (two_9.getText().toString().matches(""))
        {
            flag26 = false;
        } else
        {
            flag26 = true;
        }
        if (two_11.getText().toString().matches(""))
        {
            flag27 = false;
        } else
        {
            flag27 = true;
        }
        if (two_11.getText().toString().matches(""))
        {
            flag28 = false;
        } else
        {
            flag28 = true;
        }
        if (two_12.getText().toString().matches(""))
        {
            flag29 = false;
        } else
        {
            flag29 = true;
        }
        if (two_13.getText().toString().matches(""))
        {
            flag30 = false;
        } else
        {
            flag30 = true;
        }
        if (two_14.getText().toString().matches(""))
        {
            flag31 = false;
        } else
        {
            flag31 = true;
        }
        if (two_15.getText().toString().matches(""))
        {
            flag32 = false;
        } else
        {
            flag32 = true;
        }
        if (two_16.getText().toString().matches(""))
        {
            flag33 = false;
        } else
        {
            flag33 = true;
        }
        if (two_17.getText().toString().matches(""))
        {
            flag34 = false;
        } else
        {
            flag34 = true;
        }
        if (two_18.getText().toString().matches(""))
        {
            flag35 = false;
        } else
        {
            flag35 = true;
        }
        if (three_1.getText().toString().matches(""))
        {
            flag36 = false;
        } else
        {
            flag36 = true;
        }
        if (three_2.getText().toString().matches(""))
        {
            flag37 = false;
        } else
        {
            flag37 = true;
        }
        if (three_3.getText().toString().matches(""))
        {
            flag38 = false;
        } else
        {
            flag38 = true;
        }
        if (three_4.getText().toString().matches(""))
        {
            flag39 = false;
        } else
        {
            flag39 = true;
        }
        if (three_5.getText().toString().matches(""))
        {
            flag40 = false;
        } else
        {
            flag40 = true;
        }
        if (three_6.getText().toString().matches(""))
        {
            flag41 = false;
        } else
        {
            flag41 = true;
        }
        if (three_7.getText().toString().matches(""))
        {
            flag42 = false;
        } else
        {
            flag42 = true;
        }
        if (three_8.getText().toString().matches(""))
        {
            flag43 = false;
        } else
        {
            flag43 = true;
        }
        if (three_9.getText().toString().matches(""))
        {
            flag44 = false;
        } else
        {
            flag44 = true;
        }
        if (three_10.getText().toString().matches(""))
        {
            flag45 = false;
        } else
        {
            flag45 = true;
        }
        if (three_11.getText().toString().matches(""))
        {
            flag46 = false;
        } else
        {
            flag46 = true;
        }
        if (three_12.getText().toString().matches(""))
        {
            flag47 = false;
        } else
        {
            flag47 = true;
        }
        if (three_13.getText().toString().matches(""))
        {
            flag48 = false;
        } else
        {
            flag48 = true;
        }
        if (three_14.getText().toString().matches(""))
        {
            flag49 = false;
        } else
        {
            flag49 = true;
        }
        if (three_15.getText().toString().matches(""))
        {
            flag50 = false;
        } else
        {
            flag50 = true;
        }
        if (three_16.getText().toString().matches(""))
        {
            flag51 = false;
        } else
        {
            flag51 = true;
        }
        if (three_17.getText().toString().matches(""))
        {
            flag52 = false;
        } else
        {
            flag52 = true;
        }
        if (three_18.getText().toString().matches(""))
        {
            flag53 = false;
        } else
        {
            flag53 = true;
        }
        if (four_1.getText().toString().matches(""))
        {
            flag54 = false;
        } else
        {
            flag54 = true;
        }
        if (four_2.getText().toString().matches(""))
        {
            flag55 = false;
        } else
        {
            flag55 = true;
        }
        if (four_3.getText().toString().matches(""))
        {
            flag56 = false;
        } else
        {
            flag56 = true;
        }
        if (four_4.getText().toString().matches(""))
        {
            flag57 = false;
        } else
        {
            flag57 = true;
        }
        if (four_5.getText().toString().matches(""))
        {
            flag58 = false;
        } else
        {
            flag58 = true;
        }
        if (four_6.getText().toString().matches(""))
        {
            flag59 = false;
        } else
        {
            flag59 = true;
        }
        if (four_7.getText().toString().matches(""))
        {
            flag60 = false;
        } else
        {
            flag60 = true;
        }
        if (four_8.getText().toString().matches(""))
        {
            flag61 = false;
        } else
        {
            flag61 = true;
        }
        if (four_9.getText().toString().matches(""))
        {
            flag62 = false;
        } else
        {
            flag62 = true;
        }
        if (four_10.getText().toString().matches(""))
        {
            flag63 = false;
        } else
        {
            flag63 = true;
        }
        if (four_11.getText().toString().matches(""))
        {
            flag64 = false;
        } else
        {
            flag64 = true;
        }
        if (four_12.getText().toString().matches(""))
        {
            flag65 = false;
        } else
        {
            flag65 = true;
        }
        if (four_13.getText().toString().matches(""))
        {
            flag66 = false;
        } else
        {
            flag66 = true;
        }
        if (four_14.getText().toString().matches(""))
        {
            flag67 = false;
        } else
        {
            flag67 = true;
        }
        if (four_15.getText().toString().matches(""))
        {
            flag68 = false;
        } else
        {
            flag68 = true;
        }
        if (four_16.getText().toString().matches(""))
        {
            flag69 = false;
        } else
        {
            flag69 = true;
        }
        if (four_17.getText().toString().matches(""))
        {
            flag70 = false;
        } else
        {
            flag70 = true;
        }
        if (four_18.getText().toString().matches(""))
        {
            flag71 = false;
        } else
        {
            flag71 = true;
        }
        // number_players;

        switch(number_players){


            case(1):
                if (type_play.equals("eighteen_holes"))
                {
                    return flag && flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7 && flag8 && flag9 && flag10 && flag11 && flag12 && flag13 && flag14 && flag15 && flag16 && flag17;
                }
                if (type_play.equals("front_nine"))
                {
                    return flag && flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7 && flag8;
                }
                if (type_play.equals("back_nine"))
                {
                    return flag9 && flag10 && flag11 && flag12 && flag13 && flag14 && flag15 && flag16 && flag17;
                }
                break;
            case(2):

                if (type_play.equals("eighteen_holes"))
                {
                    return flag && flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7 && flag8 && flag9 && flag10 && flag11 && flag12 && flag13 && flag14 && flag15 && flag16 && flag17 && flag18 && flag19 && flag20 && flag21 && flag22 && flag23 && flag24 && flag25 && flag26 && flag27 && flag28 && flag29 && flag30 && flag31 && flag32 && flag33 && flag34 && flag35;
                }
                if (type_play.equals("front_nine"))
                {
                    return flag && flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7 && flag8 && flag18 && flag19 && flag20 && flag21 && flag22 && flag23 && flag24 && flag25 && flag26;
                }
                if (type_play.equals("back_nine"))
                {
                    return flag9 && flag10 && flag11 && flag12 && flag13 && flag14 && flag15 && flag16 && flag17 && flag27 && flag28 && flag29 && flag30 && flag31 && flag32 && flag33 && flag34 && flag35;
                }
                // if (true) return false; else return true;

            case(3):
                if (type_play.equals("eighteen_holes"))
                {
                    return flag && flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7 && flag8 && flag9 && flag10 && flag11 && flag12 && flag13 && flag14 && flag15 && flag16 && flag17 && flag18 && flag19 && flag20 && flag21 && flag22 && flag23 && flag24 && flag25 && flag26 && flag27 && flag28 && flag29 && flag30 && flag31 && flag32 && flag33 && flag34 && flag35 && flag36 && flag37 && flag38 && flag39 && flag40 && flag41 && flag42 && flag43 && flag44 && flag45 && flag46 && flag47 && flag48 && flag49 && flag50 && flag51 && flag52 && flag53;
                }
                if (type_play.equals("front_nine"))
                {
                    return flag && flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7 && flag8 && flag18 && flag19 && flag20 && flag21 && flag22 && flag23 && flag24 && flag25 && flag26 && flag36 && flag37 && flag38 && flag39 && flag40 && flag41 && flag42 && flag43 && flag44;
                }
                if (type_play.equals("back_nine"))
                {
                    return flag9 && flag10 && flag11 && flag12 && flag13 && flag14 && flag15 && flag16 && flag17 && flag27 && flag28 && flag29 && flag30 && flag31 && flag32 && flag33 && flag34 && flag35 && flag45 && flag46 && flag47 && flag48 && flag49 && flag50 && flag51 && flag52 && flag53;
                }
                //if (true) return false; else return true;

            case(4):
                if (type_play.equals("eighteen_holes"))
                {
                    return flag && flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7 && flag8 && flag9 && flag10 && flag11 && flag12 && flag13 && flag14 && flag15 && flag16 && flag17 && flag18 && flag19 && flag20 && flag21 && flag22 && flag23 && flag24 && flag25 && flag26 && flag27 && flag28 && flag29 && flag30 && flag31 && flag32 && flag33 && flag34 && flag35 && flag36 && flag37 && flag38 && flag39 && flag40 && flag41 && flag42 && flag43 && flag44 && flag45 && flag46 && flag47 && flag48 && flag49 && flag50 && flag51 && flag52 && flag53 && flag54 && flag55 && flag56 && flag57 && flag58 && flag59 && flag60 && flag61 && flag62 && flag63 && flag64 && flag65 && flag66 && flag67 && flag68 && flag69 && flag70 && flag71;
                }
                if (type_play.equals("front_nine"))
                {
                    return flag && flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7 && flag8 && flag18 && flag19 && flag20 && flag21 && flag22 && flag23 && flag24 && flag25 && flag26 && flag36 && flag37 && flag38 && flag39 && flag40 && flag41 && flag42 && flag43 && flag44 && flag54 && flag55 && flag56 && flag57 && flag58 && flag59 && flag60 && flag61 && flag62;
                }
                if (type_play.equals("back_nine"))
                {
                    return flag9 && flag10 && flag11 && flag12 && flag13 && flag14 && flag15 && flag16 && flag17 && flag27 && flag28 && flag29 && flag30 && flag31 && flag32 && flag33 && flag34 && flag35 && flag45 && flag46 && flag47 && flag48 && flag49 && flag50 && flag51 && flag52 && flag53 && flag64 && flag65 && flag66 && flag67 && flag68 && flag69 && flag70 && flag71;
                }
                // if (true) return false; else return true;

        }
        return false;

    }

    public int getPar(int i)
    {
        switch (i)
        {
            default:
                return -100;

            case 1: // '\001'
                return par1_value;

            case 2: // '\002'
                return par2_value;

            case 3: // '\003'
                return par3_value;

            case 4: // '\004'
                return par4_value;

            case 5: // '\005'
                return par5_value;

            case 6: // '\006'
                return par6_value;

            case 7: // '\007'
                return par7_value;

            case 8: // '\b'
                return par8_value;

            case 9: // '\t'
                return par9_value;

            case 10: // '\n'
                return par10_value;

            case 11: // '\013'
                return par11_value;

            case 12: // '\f'
                return par12_value;

            case 13: // '\r'
                return par13_value;

            case 14: // '\016'
                return par14_value;

            case 15: // '\017'
                return par15_value;

            case 16: // '\020'
                return par16_value;

            case 17: // '\021'
                return par17_value;

            case 18: // '\022'
                return par18_value;
        }
    }

    public float getTotal(int i)
    {
        int j = 0;
        int k = 0;
        float af[];
        int l;
        switch (i)
        {
            default:
                return -1F;

            case 1: // '\001'
                float af3[] = player1_scores;
                int k1 = af3.length;
                do
                {
                    if (j >= k1)
                    {
                        return (float)k;
                    }
                    k = (int)(af3[j] + (float)k);
                    j++;
                } while (true);

            case 2: // '\002'
                float af2[] = player2_scores;
                int j1 = af2.length;
                do
                {
                    if (j >= j1)
                    {
                        return (float)k;
                    }
                    k = (int)(af2[j] + (float)k);
                    j++;
                } while (true);

            case 3: // '\003'
                float af1[] = player3_scores;
                int i1 = af1.length;
                do
                {
                    if (j >= i1)
                    {
                        return (float)k;
                    }
                    k = (int)(af1[j] + (float)k);
                    j++;
                } while (true);

            case 4: // '\004'
                af = player4_scores;
                l = af.length;
                break;
        }
        do
        {
            if (j >= l)
            {
                return (float)k;
            }
            k = (int)(af[j] + (float)k);
            j++;
        } while (true);
    }

    public void onBackPressed()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle("Are Your Sure?");
        builder.setMessage("Data Will Be Lost");
        builder.setPositiveButton("YES", new android.content.DialogInterface.OnClickListener() {

            // final Scores this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                onBackPressed();
            }


            {
                // this$0 = Scores.this;
            }
        });
        builder.setNegativeButton("NO", new android.content.DialogInterface.OnClickListener() {

            //final Scores this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
            }


            {
                // this$0 = Scores.this;
            }
        });
        builder.show();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        memory = Memory.loadData();
        getActionBar().setDisplayShowTitleEnabled(false);
        getActionBar().setBackgroundDrawable(null);
        setContentView(R.layout.activity_scores);
        Intent intent = getIntent();
        course_name = intent.getStringExtra("com.example.PocketCaddies.Course_Name");
        type_play = intent.getStringExtra("com.example.PocketCaddies.typle_player");
        course = memory.findCourse(course_name);
        par_list = course.getPars();
        Button button = (Button)findViewById(R.id.Score_p1_stat_button);
        android.view.View.OnClickListener onclicklistener = new android.view.View.OnClickListener() {

            // final Scores this$0;

            public void onClick(View view11)
            {
                viewPlayerStat(Scores.player_one);
            }


            {
                //this$0 = Scores.this;
            }
        };
        button.setOnClickListener(onclicklistener);
        Button button1 = (Button)findViewById(R.id.Score_p2_stat_button);
        android.view.View.OnClickListener onclicklistener1 = new android.view.View.OnClickListener() {

            //final Scores this$0;

            public void onClick(View view11)
            {
                viewPlayerStat(Scores.player_two);
            }


            {
                //this$0 = Scores.this;
            }
        };
        button1.setOnClickListener(onclicklistener1);
        Button button2 = (Button)findViewById(R.id.Score_p3_stat_button);
        android.view.View.OnClickListener onclicklistener2 = new android.view.View.OnClickListener() {


            public void onClick(View view11)
            {
                viewPlayerStat(Scores.player_three);
            }


            {
                //  super();
            }
        };
        button2.setOnClickListener(onclicklistener2);
        Button button3 = (Button)findViewById(R.id.Score_p4_stat_button);
        android.view.View.OnClickListener onclicklistener3 = new android.view.View.OnClickListener() {


            public void onClick(View view11)
            {
                viewPlayerStat(Scores.player_four);
            }


            {
            }
        };
        button3.setOnClickListener(onclicklistener3);
        player1_scores = new float[18];
        player2_scores = new float[18];
        player3_scores = new float[18];
        player4_scores = new float[18];
        playerone_total = (TextView)findViewById(R.id.Score_Player1_total);
        playertwo_total = (TextView)findViewById(R.id.Score_Player2_total);
        playerthree_total = (TextView)findViewById(R.id.Score_Player3_total);
        playerfour_total = (TextView)findViewById(R.id.Score_Player4_total);
        player1_fronttotal = (TextView)findViewById(R.id.front_nine_1);
        player2_fronttotal = (TextView)findViewById(R.id.front_nine_2);
        player3_fronttotal = (TextView)findViewById(R.id.front_nine_3);
        player4_fronttotal = (TextView)findViewById(R.id.front_nine_4);
        player1_backtotal = (TextView)findViewById(R.id.back_nine_1);
        player2_backtotal = (TextView)findViewById(R.id.back_nine_2);
        player3_backtotal = (TextView)findViewById(R.id.back_nine_3);
        player4_backtotal = (TextView)findViewById(R.id.back_nine_4);
        playerone_topar = (TextView)findViewById(R.id.Score_Player1_topar);
        playertwo_topar = (TextView)findViewById(R.id.Score_Player2_topar);
        playerthree_topar = (TextView)findViewById(R.id.Score_Player3_topar);
        playerfour_topar = (TextView)findViewById(R.id.Score_Player4_topar);
        playerone_average = (TextView)findViewById(R.id.Score_Player1_average);
        playertwo_average = (TextView)findViewById(R.id.Score_Player2_average);
        playerthree_average = (TextView)findViewById(R.id.Score_Player3_average);
        playerfour_average = (TextView)findViewById(R.id.Score_Player4_average);
        total_scorecard_1 = (TextView)findViewById(R.id.total_1);
        total_scorecard_2 = (TextView)findViewById(R.id.total_2);
        total_scorecard_3 = (TextView)findViewById(R.id.total_3);
        total_scorecard_4 = (TextView)findViewById(R.id.total_4);
        save_button = (Button)findViewById(R.id.Scores_save_round);
        save_button.setEnabled(false);
        player_one = intent.getStringExtra("com.examples.PocketCaddies.Player1");
        player_two = intent.getStringExtra("com.examples.PocketCaddies.Player2");
        player_three = intent.getStringExtra("com.examples.PocketCaddies.Player3");
        player_four = intent.getStringExtra("com.examples.PocketCaddies.Player4");
        Player player = memory.findPlayer(player_one);
        Player player1 = memory.findPlayer(player_two);
        Player player2 = memory.findPlayer(player_three);
        Player player3 = memory.findPlayer(player_four);
        player1_previousaverage = (TextView)findViewById(R.id.Score_Player1_difference);
        player2_previousaverage = (TextView)findViewById(R.id.Score_Player2_difference);
        player3_previousaverage = (TextView)findViewById(R.id.Score_Player3_difference);
        player4_previousaverage = (TextView)findViewById(R.id.Score_Player4_difference);
        View view = findViewById(R.id.player1_front);
        View view1 = findViewById(R.id.player2_front);
        View view2 = findViewById(R.id.player3_front);
        View view3 = findViewById(R.id.player4_front);
        View view4 = findViewById(R.id.player1_back);
        View view5 = findViewById(R.id.player2_back);
        View view6 = findViewById(R.id.player3_back);
        View view7 = findViewById(R.id.player4_back);
        one_1 = (EditText)findViewById(R.id.player1_first);
        one_1.addTextChangedListener(createWatcher(1, 1));
        one_2 = (EditText)findViewById(R.id.player1_second);
        one_2.addTextChangedListener(createWatcher(1, 2));
        one_3 = (EditText)findViewById(R.id.player1_third);
        one_3.addTextChangedListener(createWatcher(1, 3));
        one_4 = (EditText)findViewById(R.id.player1_fourth);
        one_4.addTextChangedListener(createWatcher(1, 4));
        one_5 = (EditText)findViewById(R.id.player1_fifth);
        one_5.addTextChangedListener(createWatcher(1, 5));
        one_6 = (EditText)findViewById(R.id.player1_sixth);
        one_6.addTextChangedListener(createWatcher(1, 6));
        one_7 = (EditText)findViewById(R.id.player1_seventh);
        one_7.addTextChangedListener(createWatcher(1, 7));
        one_8 = (EditText)findViewById(R.id.player1_eighth);
        one_8.addTextChangedListener(createWatcher(1, 8));
        one_9 = (EditText)findViewById(R.id.player1_ninth);
        one_9.addTextChangedListener(createWatcher(1, 9));
        one_10 = (EditText)findViewById(R.id.player1_tenth);
        one_10.addTextChangedListener(createWatcher(1, 10));
        one_11 = (EditText)findViewById(R.id.player1_eleventh);
        one_11.addTextChangedListener(createWatcher(1, 11));
        one_12 = (EditText)findViewById(R.id.player1_twelfth);
        one_12.addTextChangedListener(createWatcher(1, 12));
        one_13 = (EditText)findViewById(R.id.player1_thirteenth);
        one_13.addTextChangedListener(createWatcher(1, 13));
        one_14 = (EditText)findViewById(R.id.player1_fourteenth);
        one_14.addTextChangedListener(createWatcher(1, 14));
        one_15 = (EditText)findViewById(R.id.player1_fifteenth);
        one_15.addTextChangedListener(createWatcher(1, 15));
        one_16 = (EditText)findViewById(R.id.player1_sixteenth);
        one_16.addTextChangedListener(createWatcher(1, 16));
        one_17 = (EditText)findViewById(R.id.player1_seventeenth);
        one_17.addTextChangedListener(createWatcher(1, 17));
        one_18 = (EditText)findViewById(R.id.player1_eighteenth);
        one_18.addTextChangedListener(createWatcher(1, 18));
        two_1 = (EditText)findViewById(R.id.player2_first);
        two_1.addTextChangedListener(createWatcher(2, 1));
        two_2 = (EditText)findViewById(R.id.player2_second);
        two_2.addTextChangedListener(createWatcher(2, 2));
        two_3 = (EditText)findViewById(R.id.player2_third);
        two_3.addTextChangedListener(createWatcher(2, 3));
        two_4 = (EditText)findViewById(R.id.player2_fourth);
        two_4.addTextChangedListener(createWatcher(2, 4));
        two_5 = (EditText)findViewById(R.id.player2_fifth);
        two_5.addTextChangedListener(createWatcher(2, 5));
        two_6 = (EditText)findViewById(R.id.player2_sixth);
        two_6.addTextChangedListener(createWatcher(2, 6));
        two_7 = (EditText)findViewById(R.id.player2_seventh);
        two_7.addTextChangedListener(createWatcher(2, 7));
        two_8 = (EditText)findViewById(R.id.player2_eighth);
        two_8.addTextChangedListener(createWatcher(2, 8));
        two_9 = (EditText)findViewById(R.id.player2_ninth);
        two_9.addTextChangedListener(createWatcher(2, 9));
        two_10 = (EditText)findViewById(R.id.player2_tenth);
        two_10.addTextChangedListener(createWatcher(2, 10));
        two_11 = (EditText)findViewById(R.id.player2_eleventh);
        two_11.addTextChangedListener(createWatcher(2, 11));
        two_12 = (EditText)findViewById(R.id.player2_twelfth);
        two_12.addTextChangedListener(createWatcher(2, 12));
        two_13 = (EditText)findViewById(R.id.player2_thirteenth);
        two_13.addTextChangedListener(createWatcher(2, 13));
        two_14 = (EditText)findViewById(R.id.player2_fourteenth);
        two_14.addTextChangedListener(createWatcher(2, 14));
        two_15 = (EditText)findViewById(R.id.player2_fifteenth);
        two_15.addTextChangedListener(createWatcher(2, 15));
        two_16 = (EditText)findViewById(R.id.player2_sixteenth);
        two_16.addTextChangedListener(createWatcher(2, 16));
        two_17 = (EditText)findViewById(R.id.player2_seventeenth);
        two_17.addTextChangedListener(createWatcher(2, 17));
        two_18 = (EditText)findViewById(R.id.player2_eighteenth);
        two_18.addTextChangedListener(createWatcher(2, 18));
        three_1 = (EditText)findViewById(R.id.player3_first);
        three_1.addTextChangedListener(createWatcher(3, 1));
        three_2 = (EditText)findViewById(R.id.player3_second);
        three_2.addTextChangedListener(createWatcher(3, 2));
        three_3 = (EditText)findViewById(R.id.player3_third);
        three_3.addTextChangedListener(createWatcher(3, 3));
        three_4 = (EditText)findViewById(R.id.player3_fourth);
        three_4.addTextChangedListener(createWatcher(3, 4));
        three_5 = (EditText)findViewById(R.id.player3_fifth);
        three_5.addTextChangedListener(createWatcher(3, 5));
        three_6 = (EditText)findViewById(R.id.player3_sixth);
        three_6.addTextChangedListener(createWatcher(3, 6));
        three_7 = (EditText)findViewById(R.id.player3_seventh);
        three_7.addTextChangedListener(createWatcher(3, 7));
        three_8 = (EditText)findViewById(R.id.player3_eighth);
        three_8.addTextChangedListener(createWatcher(3, 8));
        three_9 = (EditText)findViewById(R.id.player3_ninth);
        three_9.addTextChangedListener(createWatcher(3, 9));
        three_10 = (EditText)findViewById(R.id.player3_tenth);
        three_10.addTextChangedListener(createWatcher(3, 10));
        three_11 = (EditText)findViewById(R.id.player3_eleventh);
        three_11.addTextChangedListener(createWatcher(3, 11));
        three_12 = (EditText)findViewById(R.id.player3_twelfth);
        three_12.addTextChangedListener(createWatcher(3, 12));
        three_13 = (EditText)findViewById(R.id.player3_thirteenth);
        three_13.addTextChangedListener(createWatcher(3, 13));
        three_14 = (EditText)findViewById(R.id.player3_fourteenth);
        three_14.addTextChangedListener(createWatcher(3, 14));
        three_15 = (EditText)findViewById(R.id.player3_fifteenth);
        three_15.addTextChangedListener(createWatcher(3, 15));
        three_16 = (EditText)findViewById(R.id.player3_sixteenth);
        three_16.addTextChangedListener(createWatcher(3, 16));
        three_17 = (EditText)findViewById(R.id.player3_seventeenth);
        three_17.addTextChangedListener(createWatcher(3, 17));
        three_18 = (EditText)findViewById(R.id.player3_eighteenth);
        three_18.addTextChangedListener(createWatcher(3, 18));
        four_1 = (EditText)findViewById(R.id.player4_first);
        four_1.addTextChangedListener(createWatcher(4, 1));
        four_2 = (EditText)findViewById(R.id.player4_second);
        four_2.addTextChangedListener(createWatcher(4, 2));
        four_3 = (EditText)findViewById(R.id.player4_third);
        four_3.addTextChangedListener(createWatcher(4, 3));
        four_4 = (EditText)findViewById(R.id.player4_fourth);
        four_4.addTextChangedListener(createWatcher(4, 4));
        four_5 = (EditText)findViewById(R.id.player4_fifth);
        four_5.addTextChangedListener(createWatcher(4, 5));
        four_6 = (EditText)findViewById(R.id.player4_sixth);
        four_6.addTextChangedListener(createWatcher(4, 6));
        four_7 = (EditText)findViewById(R.id.player4_seventh);
        four_7.addTextChangedListener(createWatcher(4, 7));
        four_8 = (EditText)findViewById(R.id.player4_eighth);
        four_8.addTextChangedListener(createWatcher(4, 8));
        four_9 = (EditText)findViewById(R.id.player4_ninth);
        four_9.addTextChangedListener(createWatcher(4, 9));
        four_10 = (EditText)findViewById(R.id.player4_tenth);
        four_10.addTextChangedListener(createWatcher(4, 10));
        four_11 = (EditText)findViewById(R.id.player4_eleventh);
        four_11.addTextChangedListener(createWatcher(4, 11));
        four_12 = (EditText)findViewById(R.id.player4_twelfth);
        four_12.addTextChangedListener(createWatcher(4, 12));
        four_13 = (EditText)findViewById(R.id.player4_thirteenth);
        four_13.addTextChangedListener(createWatcher(4, 13));
        four_14 = (EditText)findViewById(R.id.player4_fourteenth);
        four_14.addTextChangedListener(createWatcher(4, 14));
        four_15 = (EditText)findViewById(R.id.player4_fifteenth);
        four_15.addTextChangedListener(createWatcher(4, 15));
        four_16 = (EditText)findViewById(R.id.player4_sixteenth);
        four_16.addTextChangedListener(createWatcher(4, 16));
        four_17 = (EditText)findViewById(R.id.player4_seventeenth);
        four_17.addTextChangedListener(createWatcher(4, 17));
        four_18 = (EditText)findViewById(R.id.player4_eighteenth);
        four_18.addTextChangedListener(createWatcher(4, 18));
        par_total = (TextView)findViewById(R.id.score_par_total);
        par_front = (TextView)findViewById(R.id.score_par_front);
        par_back = (TextView)findViewById(R.id.score_par_back);
        par_total.setText(Integer.toString(course.getTotalPar()));
        //findViewById(0x7f0500e2);
        TextView textview = (TextView)findViewById(R.id.Score_Player1_title);
        View view8 = findViewById(R.id.Score_Player2_stat);
        TextView textview1 = (TextView)findViewById(R.id.Score_Player2_title);
        View view9 = findViewById(R.id.Score_Player3_stat);
        TextView textview2 = (TextView)findViewById(R.id.Score_Player3_title);
        View view10 = findViewById(R.id.Score_Player4_stat);
        TextView textview3 = (TextView)findViewById(R.id.Score_Player4_title);
        course_name_view = (TextView)findViewById(R.id.score_course_name);
        course_name_view.setText(course_name);
        TextView textview4;
        CharSequence charsequence;
        if (memory.findPlayer(player_one) != null)
        {
            if (player.getTimesPlayed() == 0)
            {
                player1_previousaverage.setText("No Previous Rounds");
            } else
            {
                player1_previousaverage.setText((new StringBuilder("Previous Rounds Average: ")).append(Float.toString(player.getAverage())).toString());
            }
        } else
        {
            player1_previousaverage.setText("Guest Profile");
        }
        player1_view = (TextView)findViewById(R.id.score_player1);
        if (player_one != null)
        {
            player1_view.setText(player_one);
            button.setText((new StringBuilder(String.valueOf(player_one))).append("'s stats").toString());
            textview.setText((new StringBuilder(String.valueOf(player_one))).append("'s Stats").toString());
            number_players = 1;
        }
        player2_view = (TextView)findViewById(R.id.score_player2);
        if (player_two != null)
        {
            player2_view.setText(player_two);
            button1.setText((new StringBuilder(String.valueOf(player_two))).append("'s stats").toString());
            textview1.setText((new StringBuilder(String.valueOf(player_two))).append("'s Stats").toString());
            number_players = 2;

            if (memory.findPlayer(player_two) != null)
            {
                if (player1.getTimesPlayed() == 0)
                {
                    player2_previousaverage.setText("No Previous Rounds");
                } else
                {
                    player2_previousaverage.setText((new StringBuilder("Previous Rounds Average: ")).append(Float.toString(player1.getAverage())).toString());
                }
            } else
            {
                player2_previousaverage.setText("Guest Profile");
            }
        } else
        {
            view1.setVisibility(View.GONE);
            number_players = 1;
            view5.setVisibility(View.GONE);
            view8.setVisibility(View.GONE);
            findViewById(R.id.total_2).setVisibility(View.GONE);
        }
        player3_view = (TextView)findViewById(R.id.score_player3);
        if (player_three != null)
        {
            player3_view.setText(player_three);
            button2.setText((new StringBuilder(String.valueOf(player_three))).append("'s stats").toString());
            number_players = 3;
            textview2.setText((new StringBuilder(String.valueOf(player_three))).append("'s Stats").toString());
            if (memory.findPlayer(player_two) != null)
            {
                if (player2.getTimesPlayed() == 0)
                {
                    player3_previousaverage.setText("No Previous Rounds");
                } else
                {
                    player3_previousaverage.setText((new StringBuilder("Previous Rounds Average: ")).append(Float.toString(player2.getAverage())).toString());
                }
            } else
            {
                player3_previousaverage.setText("Guest Profile");
            }
        } else
        {
            view2.setVisibility(View.GONE);
            view6.setVisibility(View.GONE);
            view9.setVisibility(View.GONE);
            findViewById(R.id.total_3).setVisibility(View.GONE);
        }
        player4_view = (TextView)findViewById(R.id.score_player4);
        if (player_four != null)
        {
            player4_view.setText(player_four);
            button3.setText((new StringBuilder(String.valueOf(player_four))).append("'s stats").toString());
            number_players = 4;
            textview3.setText((new StringBuilder(String.valueOf(player_four))).append("'s Stats").toString());
            if (memory.findPlayer(player_three) != null)
            {
                if (player3.getTimesPlayed() == 0)
                {
                    player4_previousaverage.setText("No Previous Rounds");
                } else
                {
                    player4_previousaverage.setText((new StringBuilder("Previous Rounds Average: ")).append(Float.toString(player3.getAverage())).toString());
                }
            } else
            {
                player4_previousaverage.setText("Guest Profile");
            }
        } else
        {
            view3.setVisibility(View.GONE);
            view7.setVisibility(View.GONE);
            view10.setVisibility(View.GONE);
            findViewById(R.id.total_4).setVisibility(View.GONE);
        }
        if (type_play.equals("eighteen_holes") || type_play.equals("front_nine"))
        {
            par1_view = (TextView)findViewById(R.id.score_first_hole);
            par1_value = par_list[0];
            par1_view.setText(String.valueOf(par1_value));
            par2_view = (TextView)findViewById(R.id.score_second_hole);
            par2_value = par_list[1];
            par2_view.setText(String.valueOf(par2_value));
            par3_view = (TextView)findViewById(R.id.score_third_hole);
            par3_value = par_list[2];
            par3_view.setText(String.valueOf(par3_value));
            par4_view = (TextView)findViewById(R.id.score_fourth_hole);
            par4_value = par_list[3];
            par4_view.setText(String.valueOf(par4_value));
            par5_view = (TextView)findViewById(R.id.score_fifth_hole);
            par5_value = par_list[4];
            par5_view.setText(String.valueOf(par5_value));
            par6_view = (TextView)findViewById(R.id.score_sixth_hole);
            par6_value = par_list[5];
            par6_view.setText(String.valueOf(par6_value));
            par7_view = (TextView)findViewById(R.id.score_seventh_hole);
            par7_value = par_list[6];
            par7_view.setText(String.valueOf(par7_value));
            par8_view = (TextView)findViewById(R.id.score_eighth_hole);
            par8_value = par_list[7];
            par8_view.setText(String.valueOf(par8_value));
            par9_view = (TextView)findViewById(R.id.score_ninth_hole);
            par9_value = par_list[8];
            par9_view.setText(String.valueOf(par9_value));
        } else
        {
            findViewById(R.id.score_front_nine).setVisibility(View.GONE);
            findViewById(R.id.bumper_holes).setVisibility(View.GONE);
            findViewById(R.id.score_front_numbers).setVisibility(View.GONE);
            view.setVisibility(View.GONE);
            view1.setVisibility(View.GONE);
            view2.setVisibility(View.GONE);
            view3.setVisibility(View.GONE);
            findViewById(R.id.score_par_front).setVisibility(View.GONE);
            findViewById(R.id.score_par_total).setVisibility(View.GONE);
            findViewById(R.id.front_nine_1 ).setVisibility(View.GONE);
            findViewById(R.id.front_nine_2).setVisibility(View.GONE);
            findViewById(R.id.front_nine_3).setVisibility(View.GONE);
            findViewById(R.id.front_nine_4).setVisibility(View.GONE);
            findViewById(R.id.back_nine_1).setVisibility(View.GONE);
            findViewById(R.id.back_nine_2).setVisibility(View.GONE);
            findViewById(R.id.back_nine_3).setVisibility(View.GONE);
            findViewById(R.id.back_nine_4).setVisibility(View.GONE);
        }
        if (type_play.equals("eighteen_holes") || type_play.equals("back_nine"))
        {
            setPars();
            par10_view = (TextView)findViewById(R.id.score_tenth_hole);
            par10_value = par_list[9];
            par10_view.setText(String.valueOf(par10_value));
            par11_view = (TextView)findViewById(R.id.score_eleventh_hole);
            par11_value = par_list[10];
            par11_view.setText(String.valueOf(par11_value));
            par12_view = (TextView)findViewById(R.id.score_twelfth_hole);
            par12_value = par_list[11];
            par12_view.setText(String.valueOf(par12_value));
            par13_view = (TextView)findViewById(R.id.score_thirteenth_hole);
            par13_value = par_list[12];
            par13_view.setText(String.valueOf(par13_value));
            par14_view = (TextView)findViewById(R.id.score_fourteenth_hole);
            par14_value = par_list[13];
            par14_view.setText(String.valueOf(par14_value));
            par15_view = (TextView)findViewById(R.id.score_fifteenth_hole);
            par15_value = par_list[14];
            par15_view.setText(String.valueOf(par15_value));
            par16_view = (TextView)findViewById(R.id.score_sixteenth_hole);
            par16_value = par_list[15];
            par16_view.setText(String.valueOf(par16_value));
            par17_view = (TextView)findViewById(R.id.score_seventeenth_hole);
            par17_value = par_list[16];
            par17_view.setText(String.valueOf(par17_value));
            par18_view = (TextView)findViewById(R.id.score_eighteenth_hole);
            par18_value = par_list[17];
            par18_view.setText(String.valueOf(par18_value));
        } else{
            setParsFront();
            findViewById(R.id.score_back_numbers).setVisibility(View.GONE);
            findViewById(R.id.score_par_back).setVisibility(View.GONE);
            findViewById(R.id.score_par_total).setVisibility(View.GONE);
            findViewById(R.id.score_back_nine).setVisibility(View.GONE);
            view4.setVisibility(View.GONE);
            view5.setVisibility(View.GONE);
            view6.setVisibility(View.GONE);
            view7.setVisibility(View.GONE);}
        date_played = new Date();
        date_played.getTime();
        textview4 = (TextView)findViewById(R.id.score_start_time);
        charsequence = DateFormat.format("hh:mm", (new Date()).getTime());
        textview4.setText((new StringBuilder("  Start Time: ")).append(charsequence).toString());
        setTimes();
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        //getMenuInflater().inflate(R.menu.scores, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        android.app.AlertDialog.Builder builder;
        switch (menuitem.getItemId())
        {
            default:
                return super.onOptionsItemSelected(menuitem);

            case 16908332:
                builder = new android.app.AlertDialog.Builder(this);
                break;
        }
        builder.setTitle("Are Your Sure?");
        builder.setMessage("Data Will Be Lost");
        builder.setPositiveButton("YES", new android.content.DialogInterface.OnClickListener() {

            final Scores this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                Intent intent = new Intent(Scores.this, TypeActivity.class);
                intent.putExtra("com.example.PocketCaddies.Course_Name", Scores.course_name);
                intent.putExtra("com.examples.PocketCaddies.Player1", Scores.player_one);
                intent.putExtra("com.examples.PocketCaddies.Player2", Scores.player_two);
                intent.putExtra("com.examples.PocketCaddies.Player3", Scores.player_three);
                intent.putExtra("com.examples.PocketCaddies.Player4", Scores.player_four);
                startActivity(intent);
            }


            {
                this$0 = Scores.this;
            }
        });
        builder.setNegativeButton("NO", new android.content.DialogInterface.OnClickListener() {

            final Scores this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
            }


            {
                this$0 = Scores.this;
            }
        });
        builder.show();
        return true;
    }

    public void saveRound(View view)
    {
        (new SaveRoundDialog()).show(getFragmentManager(), "save_player");
    }

    public void setTimes()
    {
        ((TextView)findViewById(R.id.score_average_time)).setText("Time Per Hole: N/A");
    }

    public float toPar(int i)
    {
        int j = 0;
        int k = 0;
        int l = 1;
        float af[];
        int i1;
        switch (i)
        {
            default:
                return -1F;

            case 1: // '\001'
                float af3[] = player1_scores;
                int l1 = af3.length;
                do
                {
                    if (j >= l1)
                    {
                        playerone_difference = k;
                        return (float)k;
                    }
                    float f3 = af3[j];
                    if (f3 != 0.0F)
                    {
                        k = (int)((float)k + (f3 - (float)getPar(l)));
                        l++;
                    } else
                    {
                        l++;
                    }
                    j++;
                } while (true);

            case 2: // '\002'
                float af2[] = player2_scores;
                int k1 = af2.length;
                do
                {
                    if (j >= k1)
                    {
                        playertwo_difference = k;
                        return (float)k;
                    }
                    float f2 = af2[j];
                    if (f2 != 0.0F)
                    {
                        k = (int)((float)k + (f2 - (float)getPar(l)));
                        l++;
                    } else
                    {
                        l++;
                    }
                    j++;
                } while (true);

            case 3: // '\003'
                float af1[] = player3_scores;
                int j1 = af1.length;
                do
                {
                    if (j >= j1)
                    {
                        playerthree_difference = k;
                        return (float)k;
                    }
                    float f1 = af1[j];
                    if (f1 != 0.0F)
                    {
                        k = (int)((float)k + (f1 - (float)getPar(l)));
                        l++;
                    } else
                    {
                        l++;
                    }
                    j++;
                } while (true);

            case 4: // '\004'
                af = player4_scores;
                i1 = af.length;
                break;
        }
        do
        {
            if (j >= i1)
            {
                playerfour_difference = k;
                return (float)k;
            }
            float f = af[j];
            if (f != 0.0F)
            {
                k = (int)((float)k + (f - (float)getPar(l)));
                l++;
            } else
            {
                l++;
            }
            j++;
        } while (true);
    }

    public float toParAverage(int i)
    {
        int j;
        float f;
        float f1;
        int k;
        j = 0;
        f = 0.0F;
        f1 = 0.0F;
        k = 1;

        switch(i){
            case(1):
                float af3[] = player1_scores;
                int l1 = af3.length;
                while( j < l1)
                {
//                    if (f1 != 0.0F)
//                    {
//                        return f / f1;
//                    }

                float f5 = af3[j];
                if (f5 != 0.0F)
                {
                    f += f5 - (float)getPar(k);
                    k++;
                    f1 = (float)(1.0D + (double)f1);
                } else
                {
                    k++;
                }
                j++;}
              if (f1 != 0.0F){return f / f1;} else return -100f;

            case(2):
                float af2[] = player2_scores;
                int k1 = af2.length;

                while (j< k1)
                {

                float f4 = af2[j];
                if (f4 != 0.0F)
                {
                    f += f4 - (float)getPar(k);
                    k++;
                    f1 = (float)(1.0D + (double)f1);
                } else
                {
                    k++;
                }
                j++;}

                if (f1 != 0.0F){return f / f1;} else return -100f;


            case(3):
                float af1[] = player3_scores;
                int j1 = af1.length;

                while (i < j1)
                {

                float f3 = af1[j];
                if (f3 != 0.0F)
                {
                    f += f3 - (float)getPar(k);
                    k++;
                    f1 = (float)(1.0D + (double)f1);
                } else
                {
                    k++;
                }
                j++;}
        if (f1 != 0.0F){return f / f1;} else return 0;

            case(4):
                float af[] = player4_scores;
                int l = af.length;
                int i1 = 0;
                float f2;
                while(i1 <l)
                {

                f2 = af[i1];
                if (f2 != 0.0F)
                {
                    f += f2 - (float)getPar(k);
                    k++;
                    f1 = (float)(1.0D + (double)f1);
                } else
                {
                    k++;
                }
                i1++;}
        if (f1 != 0.0F){return f / f1;} else return -100f;

        }
        return -100F;

    }

    public void updateScores(int i, int j, int k)
    {
        switch (i)
        {
            default:
                return;

            case 1: // '\001'
                player1_scores[k - 1] = j;
                updateNines(i);

                playerone_total.setText((new StringBuilder("Total Score: ")).append(Integer.toString(Math.round(getTotal(1)))).toString());
                total_scorecard_1.setText(Integer.toString(Math.round(getTotal(1))));

                if (toParAverage(1) == -100F)
                {
                    playerone_topar.setText("To Par: N/A");
                    playerone_average.setText("Average To Par: N/A");
                } else
                {
                    playerone_topar.setText((new StringBuilder("To Par: ")).append(Integer.toString(Math.round(toPar(1)))).toString());
                    playerone_average.setText((new StringBuilder("Average To Par: ")).append(Float.toString(toParAverage(1))).toString());

                }
                if (checkFilled())
                {
                    save_button.setEnabled(true);
                    return;
                } else
                {
                    save_button.setEnabled(false);
                    return;
                }

            case 2: // '\002'
                player2_scores[k - 1] = j;
                updateNines(i);
                playertwo_total.setText((new StringBuilder("Total Score: ")).append(Integer.toString(Math.round(getTotal(2)))).toString());
                total_scorecard_2.setText(Integer.toString(Math.round(getTotal(2))));
                if (toParAverage(2) == -100F)
                {
                    playertwo_topar.setText("To Par: N/A");
                    playertwo_average.setText("Average To Par: N/A");
                } else
                {
                    playertwo_topar.setText((new StringBuilder("To Par: ")).append(Integer.toString(Math.round(toPar(2)))).toString());
                    playertwo_average.setText((new StringBuilder("Average To Par: ")).append(Float.toString(toParAverage(2))).toString());
                }
                if (checkFilled())
                {
                    save_button.setEnabled(true);
                    return;
                } else
                {
                    save_button.setEnabled(false);
                    return;
                }

            case 3: // '\003'
                player3_scores[k - 1] = j;
                updateNines(i);
                playerthree_total.setText((new StringBuilder("Total Score: ")).append(Integer.toString(Math.round(getTotal(3)))).toString());
                total_scorecard_3.setText(Integer.toString(Math.round(getTotal(3))));
                if (toParAverage(3) == -100F)
                {
                    playerthree_topar.setText("To Par: N/A");
                    playerthree_average.setText("Average To Par: N/A");
                } else
                {
                    playerthree_topar.setText((new StringBuilder("To Par: ")).append(Integer.toString(Math.round(toPar(3)))).toString());
                    playerthree_average.setText((new StringBuilder("Average To Par: ")).append(Float.toString(toParAverage(3))).toString());
                }
                if (checkFilled())
                {
                    save_button.setEnabled(true);
                    return;
                } else
                {
                    save_button.setEnabled(false);
                    return;
                }

            case 4: // '\004'
                player4_scores[k - 1] = j;
                updateNines(i);
                playerfour_total.setText((new StringBuilder("Total Score: ")).append(Integer.toString(Math.round(getTotal(4)))).toString());
                total_scorecard_4.setText(Integer.toString(Math.round(getTotal(4))));
                break;
        }
        if (toParAverage(4) == -100F)
        {
            playerfour_topar.setText("To Par: N/A");
            playerfour_average.setText("Average To Par: N/A");
        } else
        {
            playerfour_topar.setText((new StringBuilder("To Par: ")).append(Integer.toString(Math.round(toPar(4)))).toString());
            playerfour_average.setText((new StringBuilder("Average To Par: ")).append(Float.toString(toParAverage(4))).toString());
        }
        if (checkFilled())
        {
            save_button.setEnabled(true);
            return;
        } else
        {
            save_button.setEnabled(false);
            return;
        }
    }

    public void viewCourseStat(View view)
    {
        (new Course_Stat_Dialog()).show(getFragmentManager(), "course_stat");
    }

    public void viewPlayerStat(String s)
    {
        Player_Stat_Dialog.player_name = s;
        (new Player_Stat_Dialog()).show(getFragmentManager(), "player_stat");
    }

}


//
//public Scores()
//{
//}
//
//private TextWatcher createWatcher(final int player, final int hole)
//{
////  return new TextWatcher() {
////
////   //   final Scores this$0;
////      private final int val$hole;
////      private final int val$player;
////
////      public void afterTextChanged(Editable editable)
////      {
////          if (editable.toString().equals(""))
////          {
////              updateScores(player, 0, hole);
////              return;
////          } else
////          {
////              updateScores(player, Integer.parseInt(editable.toString()), hole);
////              return;
////          }
////      }
////
////      public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
////      {
////      }
////
////      public void onTextChanged(CharSequence charsequence, int i, int j, int k)
////      {
////      }
////
////      
////      {
////         // this$0 = Scores.this;
////          player = i;
////          hole = j;
////      }
////  };
//}
//
//private void setPars()
//{
//  int i;
//  int j;
//  int k;
//  i = 0;
//  j = 0;
//  k = 0;
//_L3:
//  if (k < 9) goto _L2; else goto _L1
//_L1:
//  int l = 9;
//_L4:
//  if (l >= 18)
//  {
//      par_back.setText(Integer.toString(j));
//      par_front.setText(Integer.toString(i));
//      return;
//  }
//  break MISSING_BLOCK_LABEL_61;
//_L2:
//  i += par_list[k];
//  k++;
//    goto _L3
//  j += par_list[l];
//  l++;
//    goto _L4
//}
//
//private void setParsFront()
//{
//  int i = 0;
//  int j = 0;
//  do
//  {
//      if (j >= 9)
//      {
//          par_front.setText(Integer.toString(i));
//          return;
//      }
//      i += par_list[j];
//      j++;
//  } while (true);
//}
//
//private void updateNines(int i)
//{
//  if (!type_play.equals("eighteen_holes")) goto _L2; else goto _L1
//_L1:
//  int j;
//  int k;
//  j = 0;
//  k = 0;
//  i;
//  JVM INSTR tableswitch 1 4: default 48
////                   1 49
////                   2 135
////                   3 221
////                   4 307;
//     goto _L2 _L3 _L4 _L5 _L6
//_L2:
//  return;
//_L3:
//  int j2 = 0;
//  int k2;
//  while (j2 < 9) 
//  {
//      j = (int)((float)j + player1_scores[j2]);
//      j2++;
//  }
//  k2 = 9;
//  do
//  {
//      if (k2 >= 18)
//      {
//          player1_fronttotal.setText(Integer.toString(Math.round(j)));
//          player1_backtotal.setText(Integer.toString(Math.round(k)));
//          return;
//      }
//      k = (int)((float)k + player1_scores[k2]);
//      k2++;
//  } while (true);
//_L4:
//  int l1 = 0;
//  int i2;
//  while (l1 < 9) 
//  {
//      j = (int)((float)j + player2_scores[l1]);
//      l1++;
//  }
//  i2 = 9;
//  do
//  {
//      if (i2 >= 18)
//      {
//          player2_fronttotal.setText(Integer.toString(Math.round(j)));
//          player2_backtotal.setText(Integer.toString(Math.round(k)));
//          return;
//      }
//      k = (int)((float)k + player2_scores[i2]);
//      i2++;
//  } while (true);
//_L5:
//  int j1 = 0;
//  int k1;
//  while (j1 < 9) 
//  {
//      j = (int)((float)j + player3_scores[j1]);
//      j1++;
//  }
//  k1 = 9;
//  do
//  {
//      if (k1 >= 18)
//      {
//          player3_fronttotal.setText(Integer.toString(Math.round(j)));
//          player3_backtotal.setText(Integer.toString(Math.round(k)));
//          return;
//      }
//      k = (int)((float)k + player3_scores[k1]);
//      k1++;
//  } while (true);
//_L6:
//  int l = 0;
//_L8:
//  int i1;
//  while (l < 9) 
//  {
//      j = (int)((float)j + player3_scores[l]);
//      l++;
//  }
//  i1 = 9;
//  do
//  {
//      if (i1 >= 18)
//      {
//          player4_fronttotal.setText(Integer.toString(Math.round(j)));
//          player4_backtotal.setText(Integer.toString(Math.round(k)));
//          return;
//      }
//      k = (int)((float)k + player3_scores[i1]);
//      i1++;
//  } while (true);
//  if (true) goto _L8; else goto _L7
//_L7:
//}
//
//public boolean checkFilled()
//{
//  boolean flag;
//  boolean flag1;
//  boolean flag2;
//  boolean flag3;
//  boolean flag4;
//  boolean flag5;
//  boolean flag6;
//  boolean flag7;
//  boolean flag8;
//  boolean flag9;
//  boolean flag10;
//  boolean flag11;
//  boolean flag12;
//  boolean flag13;
//  boolean flag14;
//  boolean flag15;
//  boolean flag16;
//  boolean flag17;
//  boolean flag18;
//  boolean flag19;
//  boolean flag20;
//  boolean flag21;
//  boolean flag22;
//  boolean flag23;
//  boolean flag24;
//  boolean flag25;
//  boolean flag26;
//  boolean flag27;
//  boolean flag28;
//  boolean flag29;
//  boolean flag30;
//  boolean flag31;
//  boolean flag32;
//  boolean flag33;
//  boolean flag34;
//  boolean flag35;
//  boolean flag36;
//  boolean flag37;
//  boolean flag38;
//  boolean flag39;
//  boolean flag40;
//  boolean flag41;
//  boolean flag42;
//  boolean flag43;
//  boolean flag44;
//  boolean flag45;
//  boolean flag46;
//  boolean flag47;
//  boolean flag48;
//  boolean flag49;
//  boolean flag50;
//  boolean flag51;
//  boolean flag52;
//  boolean flag53;
//  boolean flag54;
//  boolean flag55;
//  boolean flag56;
//  boolean flag57;
//  boolean flag58;
//  boolean flag59;
//  boolean flag60;
//  boolean flag61;
//  boolean flag62;
//  boolean flag63;
//  boolean flag64;
//  boolean flag65;
//  boolean flag66;
//  boolean flag67;
//  boolean flag68;
//  boolean flag69;
//  boolean flag70;
//  boolean flag71;
//  if (one_1.getText().toString().matches(""))
//  {
//      flag = false;
//  } else
//  {
//      flag = true;
//  }
//  if (one_2.getText().toString().matches(""))
//  {
//      flag1 = false;
//  } else
//  {
//      flag1 = true;
//  }
//  if (one_3.getText().toString().matches(""))
//  {
//      flag2 = false;
//  } else
//  {
//      flag2 = true;
//  }
//  if (one_4.getText().toString().matches(""))
//  {
//      flag3 = false;
//  } else
//  {
//      flag3 = true;
//  }
//  if (one_5.getText().toString().matches(""))
//  {
//      flag4 = false;
//  } else
//  {
//      flag4 = true;
//  }
//  if (one_6.getText().toString().matches(""))
//  {
//      flag5 = false;
//  } else
//  {
//      flag5 = true;
//  }
//  if (one_7.getText().toString().matches(""))
//  {
//      flag6 = false;
//  } else
//  {
//      flag6 = true;
//  }
//  if (one_8.getText().toString().matches(""))
//  {
//      flag7 = false;
//  } else
//  {
//      flag7 = true;
//  }
//  if (one_9.getText().toString().matches(""))
//  {
//      flag8 = false;
//  } else
//  {
//      flag8 = true;
//  }
//  if (one_10.getText().toString().matches(""))
//  {
//      flag9 = false;
//  } else
//  {
//      flag9 = true;
//  }
//  if (one_11.getText().toString().matches(""))
//  {
//      flag10 = false;
//  } else
//  {
//      flag10 = true;
//  }
//  if (one_12.getText().toString().matches(""))
//  {
//      flag11 = false;
//  } else
//  {
//      flag11 = true;
//  }
//  if (one_13.getText().toString().matches(""))
//  {
//      flag12 = false;
//  } else
//  {
//      flag12 = true;
//  }
//  if (one_14.getText().toString().matches(""))
//  {
//      flag13 = false;
//  } else
//  {
//      flag13 = true;
//  }
//  if (one_15.getText().toString().matches(""))
//  {
//      flag14 = false;
//  } else
//  {
//      flag14 = true;
//  }
//  if (one_16.getText().toString().matches(""))
//  {
//      flag15 = false;
//  } else
//  {
//      flag15 = true;
//  }
//  if (one_17.getText().toString().matches(""))
//  {
//      flag16 = false;
//  } else
//  {
//      flag16 = true;
//  }
//  if (one_18.getText().toString().matches(""))
//  {
//      flag17 = false;
//  } else
//  {
//      flag17 = true;
//  }
//  if (two_1.getText().toString().matches(""))
//  {
//      flag18 = false;
//  } else
//  {
//      flag18 = true;
//  }
//  if (two_2.getText().toString().matches(""))
//  {
//      flag19 = false;
//  } else
//  {
//      flag19 = true;
//  }
//  if (two_3.getText().toString().matches(""))
//  {
//      flag20 = false;
//  } else
//  {
//      flag20 = true;
//  }
//  if (two_4.getText().toString().matches(""))
//  {
//      flag21 = false;
//  } else
//  {
//      flag21 = true;
//  }
//  if (two_5.getText().toString().matches(""))
//  {
//      flag22 = false;
//  } else
//  {
//      flag22 = true;
//  }
//  if (two_6.getText().toString().matches(""))
//  {
//      flag23 = false;
//  } else
//  {
//      flag23 = true;
//  }
//  if (two_7.getText().toString().matches(""))
//  {
//      flag24 = false;
//  } else
//  {
//      flag24 = true;
//  }
//  if (two_8.getText().toString().matches(""))
//  {
//      flag25 = false;
//  } else
//  {
//      flag25 = true;
//  }
//  if (two_9.getText().toString().matches(""))
//  {
//      flag26 = false;
//  } else
//  {
//      flag26 = true;
//  }
//  if (two_11.getText().toString().matches(""))
//  {
//      flag27 = false;
//  } else
//  {
//      flag27 = true;
//  }
//  if (two_11.getText().toString().matches(""))
//  {
//      flag28 = false;
//  } else
//  {
//      flag28 = true;
//  }
//  if (two_12.getText().toString().matches(""))
//  {
//      flag29 = false;
//  } else
//  {
//      flag29 = true;
//  }
//  if (two_13.getText().toString().matches(""))
//  {
//      flag30 = false;
//  } else
//  {
//      flag30 = true;
//  }
//  if (two_14.getText().toString().matches(""))
//  {
//      flag31 = false;
//  } else
//  {
//      flag31 = true;
//  }
//  if (two_15.getText().toString().matches(""))
//  {
//      flag32 = false;
//  } else
//  {
//      flag32 = true;
//  }
//  if (two_16.getText().toString().matches(""))
//  {
//      flag33 = false;
//  } else
//  {
//      flag33 = true;
//  }
//  if (two_17.getText().toString().matches(""))
//  {
//      flag34 = false;
//  } else
//  {
//      flag34 = true;
//  }
//  if (two_18.getText().toString().matches(""))
//  {
//      flag35 = false;
//  } else
//  {
//      flag35 = true;
//  }
//  if (three_1.getText().toString().matches(""))
//  {
//      flag36 = false;
//  } else
//  {
//      flag36 = true;
//  }
//  if (three_2.getText().toString().matches(""))
//  {
//      flag37 = false;
//  } else
//  {
//      flag37 = true;
//  }
//  if (three_3.getText().toString().matches(""))
//  {
//      flag38 = false;
//  } else
//  {
//      flag38 = true;
//  }
//  if (three_4.getText().toString().matches(""))
//  {
//      flag39 = false;
//  } else
//  {
//      flag39 = true;
//  }
//  if (three_5.getText().toString().matches(""))
//  {
//      flag40 = false;
//  } else
//  {
//      flag40 = true;
//  }
//  if (three_6.getText().toString().matches(""))
//  {
//      flag41 = false;
//  } else
//  {
//      flag41 = true;
//  }
//  if (three_7.getText().toString().matches(""))
//  {
//      flag42 = false;
//  } else
//  {
//      flag42 = true;
//  }
//  if (three_8.getText().toString().matches(""))
//  {
//      flag43 = false;
//  } else
//  {
//      flag43 = true;
//  }
//  if (three_9.getText().toString().matches(""))
//  {
//      flag44 = false;
//  } else
//  {
//      flag44 = true;
//  }
//  if (three_10.getText().toString().matches(""))
//  {
//      flag45 = false;
//  } else
//  {
//      flag45 = true;
//  }
//  if (three_11.getText().toString().matches(""))
//  {
//      flag46 = false;
//  } else
//  {
//      flag46 = true;
//  }
//  if (three_12.getText().toString().matches(""))
//  {
//      flag47 = false;
//  } else
//  {
//      flag47 = true;
//  }
//  if (three_13.getText().toString().matches(""))
//  {
//      flag48 = false;
//  } else
//  {
//      flag48 = true;
//  }
//  if (three_14.getText().toString().matches(""))
//  {
//      flag49 = false;
//  } else
//  {
//      flag49 = true;
//  }
//  if (three_15.getText().toString().matches(""))
//  {
//      flag50 = false;
//  } else
//  {
//      flag50 = true;
//  }
//  if (three_16.getText().toString().matches(""))
//  {
//      flag51 = false;
//  } else
//  {
//      flag51 = true;
//  }
//  if (three_17.getText().toString().matches(""))
//  {
//      flag52 = false;
//  } else
//  {
//      flag52 = true;
//  }
//  if (three_18.getText().toString().matches(""))
//  {
//      flag53 = false;
//  } else
//  {
//      flag53 = true;
//  }
//  if (four_1.getText().toString().matches(""))
//  {
//      flag54 = false;
//  } else
//  {
//      flag54 = true;
//  }
//  if (four_2.getText().toString().matches(""))
//  {
//      flag55 = false;
//  } else
//  {
//      flag55 = true;
//  }
//  if (four_3.getText().toString().matches(""))
//  {
//      flag56 = false;
//  } else
//  {
//      flag56 = true;
//  }
//  if (four_4.getText().toString().matches(""))
//  {
//      flag57 = false;
//  } else
//  {
//      flag57 = true;
//  }
//  if (four_5.getText().toString().matches(""))
//  {
//      flag58 = false;
//  } else
//  {
//      flag58 = true;
//  }
//  if (four_6.getText().toString().matches(""))
//  {
//      flag59 = false;
//  } else
//  {
//      flag59 = true;
//  }
//  if (four_7.getText().toString().matches(""))
//  {
//      flag60 = false;
//  } else
//  {
//      flag60 = true;
//  }
//  if (four_8.getText().toString().matches(""))
//  {
//      flag61 = false;
//  } else
//  {
//      flag61 = true;
//  }
//  if (four_9.getText().toString().matches(""))
//  {
//      flag62 = false;
//  } else
//  {
//      flag62 = true;
//  }
//  if (four_10.getText().toString().matches(""))
//  {
//      flag63 = false;
//  } else
//  {
//      flag63 = true;
//  }
//  if (four_11.getText().toString().matches(""))
//  {
//      flag64 = false;
//  } else
//  {
//      flag64 = true;
//  }
//  if (four_12.getText().toString().matches(""))
//  {
//      flag65 = false;
//  } else
//  {
//      flag65 = true;
//  }
//  if (four_13.getText().toString().matches(""))
//  {
//      flag66 = false;
//  } else
//  {
//      flag66 = true;
//  }
//  if (four_14.getText().toString().matches(""))
//  {
//      flag67 = false;
//  } else
//  {
//      flag67 = true;
//  }
//  if (four_15.getText().toString().matches(""))
//  {
//      flag68 = false;
//  } else
//  {
//      flag68 = true;
//  }
//  if (four_16.getText().toString().matches(""))
//  {
//      flag69 = false;
//  } else
//  {
//      flag69 = true;
//  }
//  if (four_17.getText().toString().matches(""))
//  {
//      flag70 = false;
//  } else
//  {
//      flag70 = true;
//  }
//  if (four_18.getText().toString().matches(""))
//  {
//      flag71 = false;
//  } else
//  {
//      flag71 = true;
//  }
//  number_players;
//  JVM INSTR tableswitch 1 4: default 1760
////                   1 2191
////                   2 2412
////                   3 2813
////                   4 3394;
//     goto _L1 _L2 _L3 _L4 _L5
//_L1:
//  return false;
//_L2:
//  if (type_play.equals("eighteen_holes"))
//  {
//      return flag && flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7 && flag8 && flag9 && flag10 && flag11 && flag12 && flag13 && flag14 && flag15 && flag16 && flag17;
//  }
//  if (type_play.equals("front_nine"))
//  {
//      return flag && flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7 && flag8;
//  }
//  if (type_play.equals("back_nine"))
//  {
//      return flag9 && flag10 && flag11 && flag12 && flag13 && flag14 && flag15 && flag16 && flag17;
//  }
//  continue; /* Loop/switch isn't completed */
//_L3:
//  if (type_play.equals("eighteen_holes"))
//  {
//      return flag && flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7 && flag8 && flag9 && flag10 && flag11 && flag12 && flag13 && flag14 && flag15 && flag16 && flag17 && flag18 && flag19 && flag20 && flag21 && flag22 && flag23 && flag24 && flag25 && flag26 && flag27 && flag28 && flag29 && flag30 && flag31 && flag32 && flag33 && flag34 && flag35;
//  }
//  if (type_play.equals("front_nine"))
//  {
//      return flag && flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7 && flag8 && flag18 && flag19 && flag20 && flag21 && flag22 && flag23 && flag24 && flag25 && flag26;
//  }
//  if (type_play.equals("back_nine"))
//  {
//      return flag9 && flag10 && flag11 && flag12 && flag13 && flag14 && flag15 && flag16 && flag17 && flag27 && flag28 && flag29 && flag30 && flag31 && flag32 && flag33 && flag34 && flag35;
//  }
//  if (true) goto _L1; else goto _L4
//_L4:
//  if (type_play.equals("eighteen_holes"))
//  {
//      return flag && flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7 && flag8 && flag9 && flag10 && flag11 && flag12 && flag13 && flag14 && flag15 && flag16 && flag17 && flag18 && flag19 && flag20 && flag21 && flag22 && flag23 && flag24 && flag25 && flag26 && flag27 && flag28 && flag29 && flag30 && flag31 && flag32 && flag33 && flag34 && flag35 && flag36 && flag37 && flag38 && flag39 && flag40 && flag41 && flag42 && flag43 && flag44 && flag45 && flag46 && flag47 && flag48 && flag49 && flag50 && flag51 && flag52 && flag53;
//  }
//  if (type_play.equals("front_nine"))
//  {
//      return flag && flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7 && flag8 && flag18 && flag19 && flag20 && flag21 && flag22 && flag23 && flag24 && flag25 && flag26 && flag36 && flag37 && flag38 && flag39 && flag40 && flag41 && flag42 && flag43 && flag44;
//  }
//  if (type_play.equals("back_nine"))
//  {
//      return flag9 && flag10 && flag11 && flag12 && flag13 && flag14 && flag15 && flag16 && flag17 && flag27 && flag28 && flag29 && flag30 && flag31 && flag32 && flag33 && flag34 && flag35 && flag45 && flag46 && flag47 && flag48 && flag49 && flag50 && flag51 && flag52 && flag53;
//  }
//  if (true)
//  {
//      continue; /* Loop/switch isn't completed */
//  }
//_L5:
//  if (type_play.equals("eighteen_holes"))
//  {
//      return flag && flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7 && flag8 && flag9 && flag10 && flag11 && flag12 && flag13 && flag14 && flag15 && flag16 && flag17 && flag18 && flag19 && flag20 && flag21 && flag22 && flag23 && flag24 && flag25 && flag26 && flag27 && flag28 && flag29 && flag30 && flag31 && flag32 && flag33 && flag34 && flag35 && flag36 && flag37 && flag38 && flag39 && flag40 && flag41 && flag42 && flag43 && flag44 && flag45 && flag46 && flag47 && flag48 && flag49 && flag50 && flag51 && flag52 && flag53 && flag54 && flag55 && flag56 && flag57 && flag58 && flag59 && flag60 && flag61 && flag62 && flag63 && flag64 && flag65 && flag66 && flag67 && flag68 && flag69 && flag70 && flag71;
//  }
//  if (type_play.equals("front_nine"))
//  {
//      return flag && flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7 && flag8 && flag18 && flag19 && flag20 && flag21 && flag22 && flag23 && flag24 && flag25 && flag26 && flag36 && flag37 && flag38 && flag39 && flag40 && flag41 && flag42 && flag43 && flag44 && flag54 && flag55 && flag56 && flag57 && flag58 && flag59 && flag60 && flag61 && flag62;
//  }
//  if (type_play.equals("back_nine"))
//  {
//      return flag9 && flag10 && flag11 && flag12 && flag13 && flag14 && flag15 && flag16 && flag17 && flag27 && flag28 && flag29 && flag30 && flag31 && flag32 && flag33 && flag34 && flag35 && flag45 && flag46 && flag47 && flag48 && flag49 && flag50 && flag51 && flag52 && flag53 && flag64 && flag65 && flag66 && flag67 && flag68 && flag69 && flag70 && flag71;
//  }
//  if (true) goto _L1; else goto _L6
//_L6:
//}
//
//public int getPar(int i)
//{
//  switch (i)
//  {
//  default:
//      return -100;
//
//  case 1: // '\001'
//      return par1_value;
//
//  case 2: // '\002'
//      return par2_value;
//
//  case 3: // '\003'
//      return par3_value;
//
//  case 4: // '\004'
//      return par4_value;
//
//  case 5: // '\005'
//      return par5_value;
//
//  case 6: // '\006'
//      return par6_value;
//
//  case 7: // '\007'
//      return par7_value;
//
//  case 8: // '\b'
//      return par8_value;
//
//  case 9: // '\t'
//      return par9_value;
//
//  case 10: // '\n'
//      return par10_value;
//
//  case 11: // '\013'
//      return par11_value;
//
//  case 12: // '\f'
//      return par12_value;
//
//  case 13: // '\r'
//      return par13_value;
//
//  case 14: // '\016'
//      return par14_value;
//
//  case 15: // '\017'
//      return par15_value;
//
//  case 16: // '\020'
//      return par16_value;
//
//  case 17: // '\021'
//      return par17_value;
//
//  case 18: // '\022'
//      return par18_value;
//  }
//}
//
//public float getTotal(int i)
//{
//  int j = 0;
//  int k = 0;
//  float af[];
//  int l;
//  switch (i)
//  {
//  default:
//      return -1F;
//
//  case 1: // '\001'
//      float af3[] = player1_scores;
//      int k1 = af3.length;
//      do
//      {
//          if (j >= k1)
//          {
//              return (float)k;
//          }
//          k = (int)(af3[j] + (float)k);
//          j++;
//      } while (true);
//
//  case 2: // '\002'
//      float af2[] = player2_scores;
//      int j1 = af2.length;
//      do
//      {
//          if (j >= j1)
//          {
//              return (float)k;
//          }
//          k = (int)(af2[j] + (float)k);
//          j++;
//      } while (true);
//
//  case 3: // '\003'
//      float af1[] = player3_scores;
//      int i1 = af1.length;
//      do
//      {
//          if (j >= i1)
//          {
//              return (float)k;
//          }
//          k = (int)(af1[j] + (float)k);
//          j++;
//      } while (true);
//
//  case 4: // '\004'
//      af = player4_scores;
//      l = af.length;
//      break;
//  }
//  do
//  {
//      if (j >= l)
//      {
//          return (float)k;
//      }
//      k = (int)(af[j] + (float)k);
//      j++;
//  } while (true);
//}
//
//public void onBackPressed()
//{
//  android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
//  builder.setTitle("Are Your Sure?");
//  builder.setMessage("Data Will Be Lost");
//  builder.setPositiveButton("YES", new android.content.DialogInterface.OnClickListener() {
//
//     // final Scores this$0;
//
//      public void onClick(DialogInterface dialoginterface, int i)
//      {
//          onBackPressed();
//      }
//
//      
//      {
//         // this$0 = Scores.this;
//      }
//  });
//  builder.setNegativeButton("NO", new android.content.DialogInterface.OnClickListener() {
//
//      //final Scores this$0;
//
//      public void onClick(DialogInterface dialoginterface, int i)
//      {
//      }
//
//      
//      {
//         // this$0 = Scores.this;
//      }
//  });
//  builder.show();
//}
//
//protected void onCreate(Bundle bundle)
//{
//  super.onCreate(bundle);
//  getActionBar().setDisplayShowTitleEnabled(false);
//  getActionBar().setBackgroundDrawable(null);
//  setContentView(0x7f03001f);
//  Intent intent = getIntent();
//  course_name = intent.getStringExtra("com.example.PocketCaddies.Course_Name");
//  type_play = intent.getStringExtra("com.example.PocketCaddies.typle_player");
//  course = Memory.findCourse(course_name);
//  par_list = course.getPars();
//  Button button = (Button)findViewById(0x7f0500e8);
//  android.view.View.OnClickListener onclicklistener = new android.view.View.OnClickListener() {
//
//     // final Scores this$0;
//
//      public void onClick(View view11)
//      {
//          viewPlayerStat(Scores.player_one);
//      }
//
//      
//      {
//          //this$0 = Scores.this;
//      }
//  };
//  button.setOnClickListener(onclicklistener);
//  Button button1 = (Button)findViewById(0x7f0500ef);
//  android.view.View.OnClickListener onclicklistener1 = new android.view.View.OnClickListener() {
//
//      //final Scores this$0;
//
//      public void onClick(View view11)
//      {
//          viewPlayerStat(Scores.player_two);
//      }
//
//      
//      {
//          //this$0 = Scores.this;
//      }
//  };
//  button1.setOnClickListener(onclicklistener1);
//  Button button2 = (Button)findViewById(0x7f0500f6);
//  android.view.View.OnClickListener onclicklistener2 = new android.view.View.OnClickListener() {
//
//
//      public void onClick(View view11)
//      {
//          viewPlayerStat(Scores.player_three);
//      }
//
//      
//      {
//        //  super();
//      }
//  };
//  button2.setOnClickListener(onclicklistener2);
//  Button button3 = (Button)findViewById(0x7f0500fd);
//  android.view.View.OnClickListener onclicklistener3 = new android.view.View.OnClickListener() {
//
//
//      public void onClick(View view11)
//      {
//          viewPlayerStat(Scores.player_four);
//      }
//
//      
//      {
//      }
//  };
//  button3.setOnClickListener(onclicklistener3);
//  player1_scores = new float[18];
//  player2_scores = new float[18];
//  player3_scores = new float[18];
//  player4_scores = new float[18];
//  playerone_total = (TextView)findViewById(0x7f0500e4);
//  playertwo_total = (TextView)findViewById(0x7f0500eb);
//  playerthree_total = (TextView)findViewById(0x7f0500f2);
//  playerfour_total = (TextView)findViewById(0x7f0500f9);
//  player1_fronttotal = (TextView)findViewById(0x7f05008a);
//  player2_fronttotal = (TextView)findViewById(0x7f0500a2);
//  player3_fronttotal = (TextView)findViewById(0x7f0500ba);
//  player4_fronttotal = (TextView)findViewById(0x7f0500d2);
//  player1_backtotal = (TextView)findViewById(0x7f050094);
//  player2_backtotal = (TextView)findViewById(0x7f0500ac);
//  player3_backtotal = (TextView)findViewById(0x7f0500c4);
//  player4_backtotal = (TextView)findViewById(0x7f0500dc);
//  playerone_topar = (TextView)findViewById(0x7f0500e5);
//  playertwo_topar = (TextView)findViewById(0x7f0500ec);
//  playerthree_topar = (TextView)findViewById(0x7f0500f3);
//  playerfour_topar = (TextView)findViewById(0x7f0500fa);
//  playerone_average = (TextView)findViewById(0x7f0500e6);
//  playertwo_average = (TextView)findViewById(0x7f0500ed);
//  playerthree_average = (TextView)findViewById(0x7f0500f4);
//  playerfour_average = (TextView)findViewById(0x7f0500fb);
//  total_scorecard_1 = (TextView)findViewById(0x7f050095);
//  total_scorecard_2 = (TextView)findViewById(0x7f0500ad);
//  total_scorecard_3 = (TextView)findViewById(0x7f0500c5);
//  total_scorecard_4 = (TextView)findViewById(0x7f0500dd);
//  save_button = (Button)findViewById(0x7f0500df);
//  save_button.setEnabled(false);
//  player_one = intent.getStringExtra("com.examples.PocketCaddies.Player1");
//  player_two = intent.getStringExtra("com.examples.PocketCaddies.Player2");
//  player_three = intent.getStringExtra("com.examples.PocketCaddies.Player3");
//  player_four = intent.getStringExtra("com.examples.PocketCaddies.Player4");
//  Player player = Memory.findPlayer(player_one);
//  Player player1 = Memory.findPlayer(player_two);
//  Player player2 = Memory.findPlayer(player_three);
//  Player player3 = Memory.findPlayer(player_four);
//  player1_previousaverage = (TextView)findViewById(0x7f0500e7);
//  player2_previousaverage = (TextView)findViewById(0x7f0500ee);
//  player3_previousaverage = (TextView)findViewById(0x7f0500f5);
//  player4_previousaverage = (TextView)findViewById(0x7f0500fc);
//  View view = findViewById(0x7f05007f);
//  View view1 = findViewById(0x7f050097);
//  View view2 = findViewById(0x7f0500af);
//  View view3 = findViewById(0x7f0500c7);
//  View view4 = findViewById(0x7f050089);
//  View view5 = findViewById(0x7f0500a1);
//  View view6 = findViewById(0x7f0500b9);
//  View view7 = findViewById(0x7f0500d1);
//  one_1 = (EditText)findViewById(0x7f050080);
//  one_1.addTextChangedListener(createWatcher(1, 1));
//  one_2 = (EditText)findViewById(0x7f050081);
//  one_2.addTextChangedListener(createWatcher(1, 2));
//  one_3 = (EditText)findViewById(0x7f050082);
//  one_3.addTextChangedListener(createWatcher(1, 3));
//  one_4 = (EditText)findViewById(0x7f050083);
//  one_4.addTextChangedListener(createWatcher(1, 4));
//  one_5 = (EditText)findViewById(0x7f050084);
//  one_5.addTextChangedListener(createWatcher(1, 5));
//  one_6 = (EditText)findViewById(0x7f050085);
//  one_6.addTextChangedListener(createWatcher(1, 6));
//  one_7 = (EditText)findViewById(0x7f050086);
//  one_7.addTextChangedListener(createWatcher(1, 7));
//  one_8 = (EditText)findViewById(0x7f050087);
//  one_8.addTextChangedListener(createWatcher(1, 8));
//  one_9 = (EditText)findViewById(0x7f050088);
//  one_9.addTextChangedListener(createWatcher(1, 9));
//  one_10 = (EditText)findViewById(0x7f05008b);
//  one_10.addTextChangedListener(createWatcher(1, 10));
//  one_11 = (EditText)findViewById(0x7f05008c);
//  one_11.addTextChangedListener(createWatcher(1, 11));
//  one_12 = (EditText)findViewById(0x7f05008d);
//  one_12.addTextChangedListener(createWatcher(1, 12));
//  one_13 = (EditText)findViewById(0x7f05008e);
//  one_13.addTextChangedListener(createWatcher(1, 13));
//  one_14 = (EditText)findViewById(0x7f05008f);
//  one_14.addTextChangedListener(createWatcher(1, 14));
//  one_15 = (EditText)findViewById(0x7f050090);
//  one_15.addTextChangedListener(createWatcher(1, 15));
//  one_16 = (EditText)findViewById(0x7f050091);
//  one_16.addTextChangedListener(createWatcher(1, 16));
//  one_17 = (EditText)findViewById(0x7f050092);
//  one_17.addTextChangedListener(createWatcher(1, 17));
//  one_18 = (EditText)findViewById(0x7f050093);
//  one_18.addTextChangedListener(createWatcher(1, 18));
//  two_1 = (EditText)findViewById(0x7f050098);
//  two_1.addTextChangedListener(createWatcher(2, 1));
//  two_2 = (EditText)findViewById(0x7f050099);
//  two_2.addTextChangedListener(createWatcher(2, 2));
//  two_3 = (EditText)findViewById(0x7f05009a);
//  two_3.addTextChangedListener(createWatcher(2, 3));
//  two_4 = (EditText)findViewById(0x7f05009b);
//  two_4.addTextChangedListener(createWatcher(2, 4));
//  two_5 = (EditText)findViewById(0x7f05009c);
//  two_5.addTextChangedListener(createWatcher(2, 5));
//  two_6 = (EditText)findViewById(0x7f05009d);
//  two_6.addTextChangedListener(createWatcher(2, 6));
//  two_7 = (EditText)findViewById(0x7f05009e);
//  two_7.addTextChangedListener(createWatcher(2, 7));
//  two_8 = (EditText)findViewById(0x7f05009f);
//  two_8.addTextChangedListener(createWatcher(2, 8));
//  two_9 = (EditText)findViewById(0x7f0500a0);
//  two_9.addTextChangedListener(createWatcher(2, 9));
//  two_10 = (EditText)findViewById(0x7f0500a3);
//  two_10.addTextChangedListener(createWatcher(2, 10));
//  two_11 = (EditText)findViewById(0x7f0500a4);
//  two_11.addTextChangedListener(createWatcher(2, 11));
//  two_12 = (EditText)findViewById(0x7f0500a5);
//  two_12.addTextChangedListener(createWatcher(2, 12));
//  two_13 = (EditText)findViewById(0x7f0500a6);
//  two_13.addTextChangedListener(createWatcher(2, 13));
//  two_14 = (EditText)findViewById(0x7f0500a7);
//  two_14.addTextChangedListener(createWatcher(2, 14));
//  two_15 = (EditText)findViewById(0x7f0500a8);
//  two_15.addTextChangedListener(createWatcher(2, 15));
//  two_16 = (EditText)findViewById(0x7f0500a9);
//  two_16.addTextChangedListener(createWatcher(2, 16));
//  two_17 = (EditText)findViewById(0x7f0500aa);
//  two_17.addTextChangedListener(createWatcher(2, 17));
//  two_18 = (EditText)findViewById(0x7f0500ab);
//  two_18.addTextChangedListener(createWatcher(2, 18));
//  three_1 = (EditText)findViewById(0x7f0500b0);
//  three_1.addTextChangedListener(createWatcher(3, 1));
//  three_2 = (EditText)findViewById(0x7f0500b1);
//  three_2.addTextChangedListener(createWatcher(3, 2));
//  three_3 = (EditText)findViewById(0x7f0500b2);
//  three_3.addTextChangedListener(createWatcher(3, 3));
//  three_4 = (EditText)findViewById(0x7f0500b3);
//  three_4.addTextChangedListener(createWatcher(3, 4));
//  three_5 = (EditText)findViewById(0x7f0500b4);
//  three_5.addTextChangedListener(createWatcher(3, 5));
//  three_6 = (EditText)findViewById(0x7f0500b5);
//  three_6.addTextChangedListener(createWatcher(3, 6));
//  three_7 = (EditText)findViewById(0x7f0500b6);
//  three_7.addTextChangedListener(createWatcher(3, 7));
//  three_8 = (EditText)findViewById(0x7f0500b7);
//  three_8.addTextChangedListener(createWatcher(3, 8));
//  three_9 = (EditText)findViewById(0x7f0500b8);
//  three_9.addTextChangedListener(createWatcher(3, 9));
//  three_10 = (EditText)findViewById(0x7f0500bb);
//  three_10.addTextChangedListener(createWatcher(3, 10));
//  three_11 = (EditText)findViewById(0x7f0500bc);
//  three_11.addTextChangedListener(createWatcher(3, 11));
//  three_12 = (EditText)findViewById(0x7f0500bd);
//  three_12.addTextChangedListener(createWatcher(3, 12));
//  three_13 = (EditText)findViewById(0x7f0500be);
//  three_13.addTextChangedListener(createWatcher(3, 13));
//  three_14 = (EditText)findViewById(0x7f0500bf);
//  three_14.addTextChangedListener(createWatcher(3, 14));
//  three_15 = (EditText)findViewById(0x7f0500c0);
//  three_15.addTextChangedListener(createWatcher(3, 15));
//  three_16 = (EditText)findViewById(0x7f0500c1);
//  three_16.addTextChangedListener(createWatcher(3, 16));
//  three_17 = (EditText)findViewById(0x7f0500c2);
//  three_17.addTextChangedListener(createWatcher(3, 17));
//  three_18 = (EditText)findViewById(0x7f0500c3);
//  three_18.addTextChangedListener(createWatcher(3, 18));
//  four_1 = (EditText)findViewById(0x7f0500c8);
//  four_1.addTextChangedListener(createWatcher(4, 1));
//  four_2 = (EditText)findViewById(0x7f0500c9);
//  four_2.addTextChangedListener(createWatcher(4, 2));
//  four_3 = (EditText)findViewById(0x7f0500ca);
//  four_3.addTextChangedListener(createWatcher(4, 3));
//  four_4 = (EditText)findViewById(0x7f0500cb);
//  four_4.addTextChangedListener(createWatcher(4, 4));
//  four_5 = (EditText)findViewById(0x7f0500cc);
//  four_5.addTextChangedListener(createWatcher(4, 5));
//  four_6 = (EditText)findViewById(0x7f0500cd);
//  four_6.addTextChangedListener(createWatcher(4, 6));
//  four_7 = (EditText)findViewById(0x7f0500ce);
//  four_7.addTextChangedListener(createWatcher(4, 7));
//  four_8 = (EditText)findViewById(0x7f0500cf);
//  four_8.addTextChangedListener(createWatcher(4, 8));
//  four_9 = (EditText)findViewById(0x7f0500d0);
//  four_9.addTextChangedListener(createWatcher(4, 9));
//  four_10 = (EditText)findViewById(0x7f0500d3);
//  four_10.addTextChangedListener(createWatcher(4, 10));
//  four_11 = (EditText)findViewById(0x7f0500d4);
//  four_11.addTextChangedListener(createWatcher(4, 11));
//  four_12 = (EditText)findViewById(0x7f0500d5);
//  four_12.addTextChangedListener(createWatcher(4, 12));
//  four_13 = (EditText)findViewById(0x7f0500d6);
//  four_13.addTextChangedListener(createWatcher(4, 13));
//  four_14 = (EditText)findViewById(0x7f0500d7);
//  four_14.addTextChangedListener(createWatcher(4, 14));
//  four_15 = (EditText)findViewById(0x7f0500d8);
//  four_15.addTextChangedListener(createWatcher(4, 15));
//  four_16 = (EditText)findViewById(0x7f0500d9);
//  four_16.addTextChangedListener(createWatcher(4, 16));
//  four_17 = (EditText)findViewById(0x7f0500da);
//  four_17.addTextChangedListener(createWatcher(4, 17));
//  four_18 = (EditText)findViewById(0x7f0500db);
//  four_18.addTextChangedListener(createWatcher(4, 18));
//  par_total = (TextView)findViewById(0x7f05007d);
//  par_front = (TextView)findViewById(0x7f050071);
//  par_back = (TextView)findViewById(0x7f05007c);
//  par_total.setText(Integer.toString(course.getTotalPar()));
//  findViewById(0x7f0500e2);
//  TextView textview = (TextView)findViewById(0x7f0500e3);
//  View view8 = findViewById(0x7f0500e9);
//  TextView textview1 = (TextView)findViewById(0x7f0500ea);
//  View view9 = findViewById(0x7f0500f0);
//  TextView textview2 = (TextView)findViewById(0x7f0500f1);
//  View view10 = findViewById(0x7f0500f7);
//  TextView textview3 = (TextView)findViewById(0x7f0500f8);
//  course_name_view = (TextView)findViewById(0x7f050062);
//  course_name_view.setText(course_name);
//  if (Memory.findPlayer(player_one) != null)
//  {
//      if (player.getTimesPlayed() == 0)
//      {
//          player1_previousaverage.setText("No Previous Rounds");
//      } else
//      {
//          player1_previousaverage.setText((new StringBuilder("Previous Rounds Average: ")).append(Float.toString(player.getAverage())).toString());
//      }
//  } else
//  {
//      player1_previousaverage.setText("Guest Profile");
//  }
//  player1_view = (TextView)findViewById(0x7f05007e);
//  if (player_one != null)
//  {
//      player1_view.setText(player_one);
//      button.setText((new StringBuilder(String.valueOf(player_one))).append("'s stats").toString());
//      textview.setText((new StringBuilder(String.valueOf(player_one))).append("'s Stats").toString());
//      number_players = 1;
//  }
//  player2_view = (TextView)findViewById(0x7f050096);
//  if (player_two != null)
//  {
//      player2_view.setText(player_two);
//      button1.setText((new StringBuilder(String.valueOf(player_two))).append("'s stats").toString());
//      textview1.setText((new StringBuilder(String.valueOf(player_two))).append("'s Stats").toString());
//      number_players = 2;
//      TextView textview4;
//      CharSequence charsequence;
//      if (Memory.findPlayer(player_two) != null)
//      {
//          if (player1.getTimesPlayed() == 0)
//          {
//              player2_previousaverage.setText("No Previous Rounds");
//          } else
//          {
//              player2_previousaverage.setText((new StringBuilder("Previous Rounds Average: ")).append(Float.toString(player1.getAverage())).toString());
//          }
//      } else
//      {
//          player2_previousaverage.setText("Guest Profile");
//      }
//  } else
//  {
//      view1.setVisibility(8);
//      number_players = 1;
//      view5.setVisibility(8);
//      view8.setVisibility(8);
//      findViewById(0x7f0500ad).setVisibility(8);
//  }
//  player3_view = (TextView)findViewById(0x7f0500ae);
//  if (player_three != null)
//  {
//      player3_view.setText(player_three);
//      button2.setText((new StringBuilder(String.valueOf(player_three))).append("'s stats").toString());
//      number_players = 3;
//      textview2.setText((new StringBuilder(String.valueOf(player_three))).append("'s Stats").toString());
//      if (Memory.findPlayer(player_two) != null)
//      {
//          if (player2.getTimesPlayed() == 0)
//          {
//              player3_previousaverage.setText("No Previous Rounds");
//          } else
//          {
//              player3_previousaverage.setText((new StringBuilder("Previous Rounds Average: ")).append(Float.toString(player2.getAverage())).toString());
//          }
//      } else
//      {
//          player3_previousaverage.setText("Guest Profile");
//      }
//  } else
//  {
//      view2.setVisibility(8);
//      view6.setVisibility(8);
//      view9.setVisibility(8);
//      findViewById(0x7f0500c5).setVisibility(8);
//  }
//  player4_view = (TextView)findViewById(0x7f0500c6);
//  if (player_four != null)
//  {
//      player4_view.setText(player_four);
//      button3.setText((new StringBuilder(String.valueOf(player_four))).append("'s stats").toString());
//      number_players = 4;
//      textview3.setText((new StringBuilder(String.valueOf(player_four))).append("'s Stats").toString());
//      if (Memory.findPlayer(player_three) != null)
//      {
//          if (player3.getTimesPlayed() == 0)
//          {
//              player4_previousaverage.setText("No Previous Rounds");
//          } else
//          {
//              player4_previousaverage.setText((new StringBuilder("Previous Rounds Average: ")).append(Float.toString(player3.getAverage())).toString());
//          }
//      } else
//      {
//          player4_previousaverage.setText("Guest Profile");
//      }
//  } else
//  {
//      view3.setVisibility(8);
//      view7.setVisibility(8);
//      view10.setVisibility(8);
//      findViewById(0x7f0500dd).setVisibility(8);
//  }
//  if (type_play.equals("eighteen_holes") || type_play.equals("front_nine"))
//  {
//      par1_view = (TextView)findViewById(0x7f050068);
//      par1_value = par_list[0];
//      par1_view.setText(String.valueOf(par1_value));
//      par2_view = (TextView)findViewById(0x7f050069);
//      par2_value = par_list[1];
//      par2_view.setText(String.valueOf(par2_value));
//      par3_view = (TextView)findViewById(0x7f05006a);
//      par3_value = par_list[2];
//      par3_view.setText(String.valueOf(par3_value));
//      par4_view = (TextView)findViewById(0x7f05006b);
//      par4_value = par_list[3];
//      par4_view.setText(String.valueOf(par4_value));
//      par5_view = (TextView)findViewById(0x7f05006c);
//      par5_value = par_list[4];
//      par5_view.setText(String.valueOf(par5_value));
//      par6_view = (TextView)findViewById(0x7f05006d);
//      par6_value = par_list[5];
//      par6_view.setText(String.valueOf(par6_value));
//      par7_view = (TextView)findViewById(0x7f05006e);
//      par7_value = par_list[6];
//      par7_view.setText(String.valueOf(par7_value));
//      par8_view = (TextView)findViewById(0x7f05006f);
//      par8_value = par_list[7];
//      par8_view.setText(String.valueOf(par8_value));
//      par9_view = (TextView)findViewById(0x7f050070);
//      par9_value = par_list[8];
//      par9_view.setText(String.valueOf(par9_value));
//  } else
//  {
//      findViewById(0x7f050067).setVisibility(8);
//      findViewById(0x7f050066).setVisibility(8);
//      findViewById(0x7f050064).setVisibility(8);
//      view.setVisibility(8);
//      view1.setVisibility(8);
//      view2.setVisibility(8);
//      view3.setVisibility(8);
//      findViewById(0x7f050071).setVisibility(8);
//      findViewById(0x7f05007d).setVisibility(8);
//      findViewById(0x7f05008a).setVisibility(8);
//      findViewById(0x7f0500a2).setVisibility(8);
//      findViewById(0x7f0500ba).setVisibility(8);
//      findViewById(0x7f0500d2).setVisibility(8);
//      findViewById(0x7f050094).setVisibility(8);
//      findViewById(0x7f0500ac).setVisibility(8);
//      findViewById(0x7f0500c4).setVisibility(8);
//      findViewById(0x7f0500dc).setVisibility(8);
//  }
//  if (type_play.equals("eighteen_holes") || type_play.equals("back_nine"))
//  {
//      setPars();
//      par10_view = (TextView)findViewById(0x7f050073);
//      par10_value = par_list[9];
//      par10_view.setText(String.valueOf(par10_value));
//      par11_view = (TextView)findViewById(0x7f050074);
//      par11_value = par_list[10];
//      par11_view.setText(String.valueOf(par11_value));
//      par12_view = (TextView)findViewById(0x7f050075);
//      par12_value = par_list[11];
//      par12_view.setText(String.valueOf(par12_value));
//      par13_view = (TextView)findViewById(0x7f050076);
//      par13_value = par_list[12];
//      par13_view.setText(String.valueOf(par13_value));
//      par14_view = (TextView)findViewById(0x7f050077);
//      par14_value = par_list[13];
//      par14_view.setText(String.valueOf(par14_value));
//      par15_view = (TextView)findViewById(0x7f050078);
//      par15_value = par_list[14];
//      par15_view.setText(String.valueOf(par15_value));
//      par16_view = (TextView)findViewById(0x7f050079);
//      par16_value = par_list[15];
//      par16_view.setText(String.valueOf(par16_value));
//      par17_view = (TextView)findViewById(0x7f05007a);
//      par17_value = par_list[16];
//      par17_view.setText(String.valueOf(par17_value));
//      par18_view = (TextView)findViewById(0x7f05007b);
//      par18_value = par_list[17];
//      par18_view.setText(String.valueOf(par18_value));
//  } else
//  {
//      setParsFront();
//      findViewById(0x7f050065).setVisibility(8);
//      findViewById(0x7f05007c).setVisibility(8);
//      findViewById(0x7f05007d).setVisibility(8);
//      findViewById(0x7f050072).setVisibility(8);
//      findViewById(0x7f050072).setVisibility(8);
//      findViewById(0x7f050072).setVisibility(8);
//      findViewById(0x7f050072).setVisibility(8);
//      view4.setVisibility(8);
//      view5.setVisibility(8);
//      view6.setVisibility(8);
//      view7.setVisibility(8);
//  }
//  date_played = new Date();
//  date_played.getTime();
//  textview4 = (TextView)findViewById(0x7f0500e0);
//  charsequence = DateFormat.format("hh:mm", (new Date()).getTime());
//  textview4.setText((new StringBuilder("  Start Time: ")).append(charsequence).toString());
//  setTimes();
//}
//
//public boolean onCreateOptionsMenu(Menu menu)
//{
//  getMenuInflater().inflate(0x7f0c000e, menu);
//  return true;
//}
//
//public boolean onOptionsItemSelected(MenuItem menuitem)
//{
//  android.app.AlertDialog.Builder builder;
//  switch (menuitem.getItemId())
//  {
//  default:
//      return super.onOptionsItemSelected(menuitem);
//
//  case 16908332: 
//      builder = new android.app.AlertDialog.Builder(this);
//      break;
//  }
//  builder.setTitle("Are Your Sure?");
//  builder.setMessage("Data Will Be Lost");
//  builder.setPositiveButton("YES", new android.content.DialogInterface.OnClickListener() {
//
//      final Scores this$0;
//
//      public void onClick(DialogInterface dialoginterface, int i)
//      {
//          Intent intent = new Intent(Scores.this, TypeActivity.class);
//          intent.putExtra("com.example.PocketCaddies.Course_Name", Scores.course_name);
//          intent.putExtra("com.examples.PocketCaddies.Player1", Scores.player_one);
//          intent.putExtra("com.examples.PocketCaddies.Player2", Scores.player_two);
//          intent.putExtra("com.examples.PocketCaddies.Player3", Scores.player_three);
//          intent.putExtra("com.examples.PocketCaddies.Player4", Scores.player_four);
//          startActivity(intent);
//      }
//
//      
//      {
//          this$0 = Scores.this;
//      }
//  });
//  builder.setNegativeButton("NO", new android.content.DialogInterface.OnClickListener() {
//
//      final Scores this$0;
//
//      public void onClick(DialogInterface dialoginterface, int i)
//      {
//      }
//
//      
//      {
//          this$0 = Scores.this;
//      }
//  });
//  builder.show();
//  return true;
//}
//
//public void saveRound(View view)
//{
//  (new SaveRoundDialog()).show(getFragmentManager(), "save_player");
//}
//
//public void setTimes()
//{
//  ((TextView)findViewById(0x7f0500e1)).setText("Time Per Hole: N/A");
//}
//
//public float toPar(int i)
//{
//  int j = 0;
//  int k = 0;
//  int l = 1;
//  float af[];
//  int i1;
//  switch (i)
//  {
//  default:
//      return -1F;
//
//  case 1: // '\001'
//      float af3[] = player1_scores;
//      int l1 = af3.length;
//      do
//      {
//          if (j >= l1)
//          {
//              playerone_difference = k;
//              return (float)k;
//          }
//          float f3 = af3[j];
//          if (f3 != 0.0F)
//          {
//              k = (int)((float)k + (f3 - (float)getPar(l)));
//              l++;
//          } else
//          {
//              l++;
//          }
//          j++;
//      } while (true);
//
//  case 2: // '\002'
//      float af2[] = player2_scores;
//      int k1 = af2.length;
//      do
//      {
//          if (j >= k1)
//          {
//              playertwo_difference = k;
//              return (float)k;
//          }
//          float f2 = af2[j];
//          if (f2 != 0.0F)
//          {
//              k = (int)((float)k + (f2 - (float)getPar(l)));
//              l++;
//          } else
//          {
//              l++;
//          }
//          j++;
//      } while (true);
//
//  case 3: // '\003'
//      float af1[] = player3_scores;
//      int j1 = af1.length;
//      do
//      {
//          if (j >= j1)
//          {
//              playerthree_difference = k;
//              return (float)k;
//          }
//          float f1 = af1[j];
//          if (f1 != 0.0F)
//          {
//              k = (int)((float)k + (f1 - (float)getPar(l)));
//              l++;
//          } else
//          {
//              l++;
//          }
//          j++;
//      } while (true);
//
//  case 4: // '\004'
//      af = player4_scores;
//      i1 = af.length;
//      break;
//  }
//  do
//  {
//      if (j >= i1)
//      {
//          playerfour_difference = k;
//          return (float)k;
//      }
//      float f = af[j];
//      if (f != 0.0F)
//      {
//          k = (int)((float)k + (f - (float)getPar(l)));
//          l++;
//      } else
//      {
//          l++;
//      }
//      j++;
//  } while (true);
//}
//
//public float toParAverage(int i)
//{
//  int j;
//  float f;
//  float f1;
//  int k;
//  j = 0;
//  f = 0.0F;
//  f1 = 0.0F;
//  k = 1;
//  i;
//  JVM INSTR tableswitch 1 4: default 40
////                   1 44
////                   2 121
////                   3 198
////                   4 275;
//     goto _L1 _L2 _L3 _L4 _L5
//_L1:
//  return -100F;
//_L2:
//  float af3[] = player1_scores;
//  int l1 = af3.length;
//  do
//  {
//      if (j >= l1)
//      {
//          if (f1 != 0.0F)
//          {
//              return f / f1;
//          }
//          continue; /* Loop/switch isn't completed */
//      }
//      float f5 = af3[j];
//      if (f5 != 0.0F)
//      {
//          f += f5 - (float)getPar(k);
//          k++;
//          f1 = (float)(1.0D + (double)f1);
//      } else
//      {
//          k++;
//      }
//      j++;
//  } while (true);
//_L3:
//  float af2[] = player2_scores;
//  int k1 = af2.length;
//  do
//  {
//      if (j >= k1)
//      {
//          if (f1 != 0.0F)
//          {
//              return f / f1;
//          }
//          continue; /* Loop/switch isn't completed */
//      }
//      float f4 = af2[j];
//      if (f4 != 0.0F)
//      {
//          f += f4 - (float)getPar(k);
//          k++;
//          f1 = (float)(1.0D + (double)f1);
//      } else
//      {
//          k++;
//      }
//      j++;
//  } while (true);
//_L4:
//  float af1[] = player3_scores;
//  int j1 = af1.length;
//  do
//  {
//      if (j >= j1)
//      {
//          if (f1 != 0.0F)
//          {
//              return f / f1;
//          }
//          continue; /* Loop/switch isn't completed */
//      }
//      float f3 = af1[j];
//      if (f3 != 0.0F)
//      {
//          f += f3 - (float)getPar(k);
//          k++;
//          f1 = (float)(1.0D + (double)f1);
//      } else
//      {
//          k++;
//      }
//      j++;
//  } while (true);
//_L5:
//  float af[] = player4_scores;
//  int l = af.length;
//  int i1 = 0;
//  do
//  {
//      float f2;
//      if (i1 >= l)
//      {
//          if (f1 == 0.0F)
//          {
//              return -1000F;
//          } else
//          {
//              return f / f1;
//          }
//      }
//      f2 = af[i1];
//      if (f2 != 0.0F)
//      {
//          f += f2 - (float)getPar(k);
//          k++;
//          f1 = (float)(1.0D + (double)f1);
//      } else
//      {
//          k++;
//      }
//      i1++;
//  } while (true);
//  if (true) goto _L1; else goto _L6
//_L6:
//}
//
//public void updateScores(int i, int j, int k)
//{
//  switch (i)
//  {
//  default:
//      return;
//
//  case 1: // '\001'
//      player1_scores[k - 1] = j;
//      updateNines(i);
//      playerone_total.setText((new StringBuilder("Total Score: ")).append(Integer.toString(Math.round(getTotal(1)))).toString());
//      total_scorecard_1.setText(Integer.toString(Math.round(getTotal(1))));
//      if (toParAverage(1) == -100F)
//      {
//          playerone_topar.setText("To Par: N/A");
//          playerone_average.setText("Average To Par: N/A");
//      } else
//      {
//          playerone_topar.setText((new StringBuilder("To Par: ")).append(Integer.toString(Math.round(toPar(1)))).toString());
//          playerone_average.setText((new StringBuilder("Average To Par: ")).append(Float.toString(toParAverage(1))).toString());
//      }
//      if (checkFilled())
//      {
//          save_button.setEnabled(true);
//          return;
//      } else
//      {
//          save_button.setEnabled(false);
//          return;
//      }
//
//  case 2: // '\002'
//      player2_scores[k - 1] = j;
//      updateNines(i);
//      playertwo_total.setText((new StringBuilder("Total Score: ")).append(Integer.toString(Math.round(getTotal(2)))).toString());
//      total_scorecard_2.setText(Integer.toString(Math.round(getTotal(2))));
//      if (toParAverage(2) == -100F)
//      {
//          playertwo_topar.setText("To Par: N/A");
//          playertwo_average.setText("Average To Par: N/A");
//      } else
//      {
//          playertwo_topar.setText((new StringBuilder("To Par: ")).append(Integer.toString(Math.round(toPar(2)))).toString());
//          playertwo_average.setText((new StringBuilder("Average To Par: ")).append(Float.toString(toParAverage(2))).toString());
//      }
//      if (checkFilled())
//      {
//          save_button.setEnabled(true);
//          return;
//      } else
//      {
//          save_button.setEnabled(false);
//          return;
//      }
//
//  case 3: // '\003'
//      player3_scores[k - 1] = j;
//      updateNines(i);
//      playerthree_total.setText((new StringBuilder("Total Score: ")).append(Integer.toString(Math.round(getTotal(3)))).toString());
//      total_scorecard_3.setText(Integer.toString(Math.round(getTotal(3))));
//      if (toParAverage(3) == -100F)
//      {
//          playerthree_topar.setText("To Par: N/A");
//          playerthree_average.setText("Average To Par: N/A");
//      } else
//      {
//          playerthree_topar.setText((new StringBuilder("To Par: ")).append(Integer.toString(Math.round(toPar(3)))).toString());
//          playerthree_average.setText((new StringBuilder("Average To Par: ")).append(Float.toString(toParAverage(3))).toString());
//      }
//      if (checkFilled())
//      {
//          save_button.setEnabled(true);
//          return;
//      } else
//      {
//          save_button.setEnabled(false);
//          return;
//      }
//
//  case 4: // '\004'
//      player4_scores[k - 1] = j;
//      updateNines(i);
//      playerfour_total.setText((new StringBuilder("Total Score: ")).append(Integer.toString(Math.round(getTotal(4)))).toString());
//      total_scorecard_4.setText(Integer.toString(Math.round(getTotal(4))));
//      break;
//  }
//  if (toParAverage(4) == -100F)
//  {
//      playerfour_topar.setText("To Par: N/A");
//      playerfour_average.setText("Average To Par: N/A");
//  } else
//  {
//      playerfour_topar.setText((new StringBuilder("To Par: ")).append(Integer.toString(Math.round(toPar(4)))).toString());
//      playerfour_average.setText((new StringBuilder("Average To Par: ")).append(Float.toString(toParAverage(4))).toString());
//  }
//  if (checkFilled())
//  {
//      save_button.setEnabled(true);
//      return;
//  } else
//  {
//      save_button.setEnabled(false);
//      return;
//  }
//}
//
//public void viewCourseStat(View view)
//{
//  (new Course_Stat_Dialog()).show(getFragmentManager(), "course_stat");
//}
//
//public void viewPlayerStat(String s)
//{
//  Player_Stat_Dialog.player_name = s;
//  (new Player_Stat_Dialog()).show(getFragmentManager(), "player_stat");
//}
