// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package pk.colinjames.pocketcaddie;


// Referenced classes of package com.example.pocketcaddies:
//            Round

public class Course
{

    private float average_per_hole;
    private float avg_1;
    private float avg_10;
    private float avg_11;
    private float avg_12;
    private float avg_13;
    private float avg_14;
    private float avg_15;
    private float avg_16;
    private float avg_17;
    private float avg_18;
    private float avg_2;
    private float avg_3;
    private float avg_4;
    private float avg_5;
    private float avg_6;
    private float avg_7;
    private float avg_8;
    private float avg_9;
    private float avg_score_list[];
    private float back_best;
    private String course_name;
    private float eighteen_best;
    private float front_best;
    private int hole_pars[];
    private int number_played;

    public Course(String s, int ai[], int i)
    {
        int j = 0;
        course_name = s;
        hole_pars = ai;
        average_per_hole = 0.0F;
        number_played = 0;
        avg_score_list = new float[i];
        float af[] = avg_score_list;
        int k = af.length;
        do
        {
            if (j >= k)
            {
                avg_1 = 0.0F;
                avg_2 = 0.0F;
                avg_3 = 0.0F;
                avg_4 = 0.0F;
                avg_5 = 0.0F;
                avg_6 = 0.0F;
                avg_7 = 0.0F;
                avg_8 = 0.0F;
                avg_9 = 0.0F;
                avg_10 = 0.0F;
                avg_11 = 0.0F;
                avg_12 = 0.0F;
                avg_13 = 0.0F;
                avg_14 = 0.0F;
                avg_15 = 0.0F;
                avg_16 = 0.0F;
                avg_17 = 0.0F;
                avg_18 = 0.0F;
                eighteen_best = 1000F;
                front_best = 1000F;
                back_best = 1000F;
                return;
            }
            float _tmp = af[j];
            j++;
        } while (true);
    }

    public void addRound(Round round)
    {
        String s = round.getType();
        float f = round.getAverageScore();
        float af[] = round.getScore();
        average_per_hole = (f + average_per_hole * (float)number_played) / (float)(1 + number_played);
        if (s.equals("eighteen_holes"))
        {
            if (round.getTotal() < eighteen_best)
            {
                eighteen_best = round.getTotal();
            }
            if (round.getFrontTotal() < front_best)
            {
                front_best = round.getFrontTotal();
            }
            if (round.getBackTotal() < back_best)
            {
                back_best = round.getBackTotal();
            }
            avg_1 = (avg_1 * (float)number_played + af[0]) / (float)(1 + number_played);
            avg_2 = (avg_2 * (float)number_played + af[1]) / (float)(1 + number_played);
            avg_3 = (avg_3 * (float)number_played + af[2]) / (float)(1 + number_played);
            avg_4 = (avg_4 * (float)number_played + af[3]) / (float)(1 + number_played);
            avg_5 = (avg_5 * (float)number_played + af[4]) / (float)(1 + number_played);
            avg_6 = (avg_6 * (float)number_played + af[5]) / (float)(1 + number_played);
            avg_7 = (avg_7 * (float)number_played + af[6]) / (float)(1 + number_played);
            avg_8 = (avg_8 * (float)number_played + af[7]) / (float)(1 + number_played);
            avg_9 = (avg_9 * (float)number_played + af[8]) / (float)(1 + number_played);
            avg_10 = (avg_10 * (float)number_played + af[9]) / (float)(1 + number_played);
            avg_11 = (avg_11 * (float)number_played + af[10]) / (float)(1 + number_played);
            avg_12 = (avg_12 * (float)number_played + af[11]) / (float)(1 + number_played);
            avg_13 = (avg_13 * (float)number_played + af[12]) / (float)(1 + number_played);
            avg_14 = (avg_14 * (float)number_played + af[13]) / (float)(1 + number_played);
            avg_15 = (avg_15 * (float)number_played + af[14]) / (float)(1 + number_played);
            avg_16 = (avg_16 * (float)number_played + af[15]) / (float)(1 + number_played);
            avg_17 = (avg_17 * (float)number_played + af[16]) / (float)(1 + number_played);
            avg_18 = (avg_18 * (float)number_played + af[17]) / (float)(1 + number_played);
        }
        if (s.equals("front_nine"))
        {
            if (round.getTotal() < front_best)
            {
                front_best = round.getTotal();
            }
            avg_1 = (avg_1 * (float)number_played + af[0]) / (float)(1 + number_played);
            avg_2 = (avg_2 * (float)number_played + af[1]) / (float)(1 + number_played);
            avg_3 = (avg_3 * (float)number_played + af[2]) / (float)(1 + number_played);
            avg_4 = (avg_4 * (float)number_played + af[3]) / (float)(1 + number_played);
            avg_5 = (avg_5 * (float)number_played + af[4]) / (float)(1 + number_played);
            avg_6 = (avg_6 * (float)number_played + af[5]) / (float)(1 + number_played);
            avg_7 = (avg_7 * (float)number_played + af[6]) / (float)(1 + number_played);
            avg_8 = (avg_8 * (float)number_played + af[7]) / (float)(1 + number_played);
            avg_9 = (avg_9 * (float)number_played + af[8]) / (float)(1 + number_played);
        }
        if (s.equals("back_nine"))
        {
            if (round.getTotal() < back_best)
            {
                back_best = round.getTotal();
            }
            avg_10 = (avg_10 * (float)number_played + af[9]) / (float)(1 + number_played);
            avg_11 = (avg_11 * (float)number_played + af[10]) / (float)(1 + number_played);
            avg_12 = (avg_12 * (float)number_played + af[11]) / (float)(1 + number_played);
            avg_13 = (avg_13 * (float)number_played + af[12]) / (float)(1 + number_played);
            avg_14 = (avg_14 * (float)number_played + af[13]) / (float)(1 + number_played);
            avg_15 = (avg_15 * (float)number_played + af[14]) / (float)(1 + number_played);
            avg_16 = (avg_16 * (float)number_played + af[15]) / (float)(1 + number_played);
            avg_17 = (avg_17 * (float)number_played + af[16]) / (float)(1 + number_played);
            avg_18 = (avg_18 * (float)number_played + af[17]) / (float)(1 + number_played);
        }
        number_played = 1 + number_played;
    }

    public float getAverage()
    {
        return average_per_hole;
    }

    public float[] getAvgScores()
    {
        return avg_score_list;
    }

    public float getBackBest()
    {
        return back_best;
    }

    public int getCourseLength()
    {
        return hole_pars.length;
    }

    public float getFrontBest()
    {
        return front_best;
    }

    public float getHoleAverage(int i)
    {
        switch (i)
        {
        default:
            return 900F;

        case 1: // '\001'
            return avg_1 - (float)hole_pars[0];

        case 2: // '\002'
            return avg_2 - (float)hole_pars[1];

        case 3: // '\003'
            return avg_3 - (float)hole_pars[2];

        case 4: // '\004'
            return avg_4 - (float)hole_pars[3];

        case 5: // '\005'
            return avg_5 - (float)hole_pars[4];

        case 6: // '\006'
            return avg_6 - (float)hole_pars[5];

        case 7: // '\007'
            return avg_7 - (float)hole_pars[6];

        case 8: // '\b'
            return avg_8 - (float)hole_pars[7];

        case 9: // '\t'
            return avg_9 - (float)hole_pars[8];

        case 10: // '\n'
            return avg_10 - (float)hole_pars[9];

        case 11: // '\013'
            return avg_11 - (float)hole_pars[10];

        case 12: // '\f'
            return avg_12 - (float)hole_pars[11];

        case 13: // '\r'
            return avg_13 - (float)hole_pars[12];

        case 14: // '\016'
            return avg_14 - (float)hole_pars[13];

        case 15: // '\017'
            return avg_15 - (float)hole_pars[14];

        case 16: // '\020'
            return avg_16 - (float)hole_pars[15];

        case 17: // '\021'
            return avg_17 - (float)hole_pars[16];

        case 18: // '\022'
            return avg_18 - (float)hole_pars[17];
        }
    }

    public String getName()
    {
        return course_name;
    }

    public int[] getPars()
    {
        return hole_pars;
    }

    public int getTimesPlayed()
    {
        return number_played;
    }

    public float getTotalBest()
    {
        return eighteen_best;
    }

    public int getTotalPar()
    {
        int i = 0;
        int ai[] = hole_pars;
        int j = ai.length;
        int k = 0;
        do
        {
            if (k >= j)
            {
                return i;
            }
            i += ai[k];
            k++;
        } while (true);
    }

    public void setName(String s)
    {
        course_name = s;
    }

    public void setPars(int ai[])
    {
        hole_pars = ai;
    }
}
