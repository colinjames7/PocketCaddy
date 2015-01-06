// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package pk.colinjames.pocketcaddie;

import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.example.pocketcaddies:
//            Course, Player

public class Memory
    implements Serializable
{

    public static ArrayList courses = new ArrayList();
    static Memory instance = null;
    public static ArrayList players = new ArrayList();

    public Memory()
    {
    }

    public static ArrayList createCourseNames()
    {
        ArrayList arraylist = courses;
        ArrayList arraylist1 = new ArrayList();
        Iterator iterator = arraylist.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return arraylist1;
            }
            arraylist1.add(((Course)iterator.next()).getName());
        } while (true);
    }

    public static ArrayList createPlayerNames()
    {
        ArrayList arraylist = players;
        ArrayList arraylist1 = new ArrayList();
        Iterator iterator = arraylist.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return arraylist1;
            }
            arraylist1.add(((Player)iterator.next()).getName());
        } while (true);
    }

    public static Course findCourse(String s)
    {
        Iterator iterator = courses.iterator();
        Course course;
        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }
            course = (Course)iterator.next();
        } while (!course.getName().equals(s));
        return course;
    }

    public static Player findPlayer(String s)
    {
        Iterator iterator = players.iterator();
        Player player;
        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }
            player = (Player)iterator.next();
        } while (!player.getName().equals(s));
        return player;
    }

    public static Memory getInstance()
    {
        if (instance == null)
        {
            instance = new Memory();
        }
        return instance;
    }

    public static Memory loadData()
    {
        Memory memory = null;
        try
        {
            ObjectInputStream objectinputstream = new ObjectInputStream(new FileInputStream((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/pocketCaddies.data").toString()));
            memory = (Memory)objectinputstream.readObject();
            objectinputstream.close();
            instance = memory;
            Log.d("succs2", "SUCCESS2");
        }
        catch (Exception exception)
        {
            Log.d("fiald2", "FAIL2");
            return memory;
        }
        return memory;
    }

    public static void saveData(Memory memory)
    {
        try
        {
            ObjectOutputStream objectoutputstream = new ObjectOutputStream(new FileOutputStream(new File((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/pocketCaddies.data").toString())));
            objectoutputstream.writeObject(memory);
            objectoutputstream.close();
            Log.d("succs", "SUCCESS");
            return;
        }
        catch (Exception exception)
        {
            Log.d("fiald", "FAIL");
        }
    }

}
