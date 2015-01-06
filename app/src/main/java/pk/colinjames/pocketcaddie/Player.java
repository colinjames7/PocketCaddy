// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package pk.colinjames.pocketcaddie;

import java.io.PrintStream;
import java.util.ArrayList;

// Referenced classes of package com.example.pocketcaddies:
//            Round

public class Player
{

    private float average_to_par;
    private String player_name;
    private ArrayList rounds_played;
    private int times_played;

    public Player(ArrayList arraylist, String s)
    {
        rounds_played = arraylist;
        player_name = s;
        times_played = 0;
        average_to_par = 0.0F;
    }

    public void addRound(Round round)
    {
        rounds_played.add(round);
        if (rounds_played.size() > 9)
        {
            rounds_played.remove(0);
        }
        float f = round.getAverageScore();
        System.out.print(f);
        float f1 = average_to_par * (float)times_played;
        System.out.print(f1);
        average_to_par = (f1 + f) / (float)(1 + times_played);
        System.out.print(average_to_par);
        times_played = 1 + times_played;
    }

    public float getAverage()
    {
        return average_to_par;
    }

    public String getName()
    {
        return player_name;
    }

    public ArrayList getRounds()
    {
        return rounds_played;
    }

    public int getTimesPlayed()
    {
        return times_played;
    }

    public void setName(String s)
    {
        player_name = s;
    }
}
