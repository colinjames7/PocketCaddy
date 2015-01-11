// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package pk.colinjames.pocketcaddie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

// Referenced classes of package com.example.pocketcaddies:
//            Course, Player

public class Round implements Serializable
{

    private Course course_played;
    private Date date_played;
    private ArrayList opponents;
    private Player player_played;
    private float score_played[];
    private float score_to_par;
    private String type_round;

    public Round(Course course, float af[], Player player, ArrayList arraylist, Date date, String s, float f)
    {
        course_played = course;
        score_played = af;
        player_played = player;
        opponents = arraylist;
        date_played = date;
        type_round = s;
        score_to_par = f;
    }

    public float getAverageScore()
    {
        if (type_round.equals("eighteen_holes"))
        {
            return score_to_par / 18F;
        } else
        {
            return score_to_par / 9F;
        }
    }

    public float getBackTotal()
    {
        boolean flag;
        float f;
        flag = type_round.equals("eighteen_holes");
        f = 0.0F;
        
        if(!flag){ return f;}
        int i = 9;
        while(i<18) {
          f += score_played[i];
          i++;
        }
        return f;
        
        
//        if (!flag) goto _L2; else goto _L1
//_L1:
//        int i = 9;
//_L5:
//        if (i < 18) goto _L3; else goto _L2
//_L2:
//        return f;
//_L3:
//        f += score_played[i];
//        i++;
//        if (true) goto _L5; else goto _L4
//_L4:
    }

    public Course getCourse()
    {
        return course_played;
    }

    public Date getDate()
    {
        return date_played;
    }

    public float getFrontTotal()
    {
    	
    	
        boolean flag;
        float f;
        flag = type_round.equals("eighteen_holes");
        f = 0.0F;
        
        if(!flag){ return f;}
        int i = 0;
        while(i<9) {
          f += score_played[i];
          i++;
        }
        return f;
//        boolean flag;
//        float f;
//        flag = type_round.equals("eighteen_holes");
//        f = 0.0F;
//        if (!flag) goto _L2; else goto _L1
//_L1:
//        int i = 0;
//_L5:
//        if (i < 9) goto _L3; else goto _L2
//_L2:
//        return f;
//_L3:
//        f += score_played[i];
//        i++;
//        if (true) goto _L5; else goto _L4
//_L4:
    }

    public ArrayList getOpponents()
    {
        return opponents;
    }

    public Player getPlayer()
    {
        return player_played;
    }

    public int getRoundLength()
    {
        return score_played.length;
    }

    public float[] getScore()
    {
        return score_played;
    }

    public float getScoreToPar()
    {
        return score_to_par;
    }

    public float getTotal()
    {
        float f = 0.0F;
        float af[] = score_played;
        int i = af.length;
        int j = 0;
        do
        {
            if (j >= i)
            {
                return f;
            }
            f += af[j];
            j++;
        } while (true);
    }

    public String getType()
    {
        return type_round;
    }
}
