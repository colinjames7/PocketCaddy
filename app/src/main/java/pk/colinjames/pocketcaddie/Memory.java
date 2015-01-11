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

    public  ArrayList<Course> courses = new ArrayList();
    public   ArrayList players = new ArrayList();

    public Memory()
    {
        //courses = new ArrayList();
        players = new ArrayList();

    }

    public  void updateCourse(Course c){
        for(Course f: courses){
            if (f.getName().equals(c.getName())){
                courses.remove(f);
                courses.add(c);
        }


    } }

    public  ArrayList createCourseNames()
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

    public  ArrayList createPlayerNames()
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

    public  Course findCourse(String s)
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

    public  Player findPlayer(String s)
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


    public static Memory loadData()
    {
        Memory memory = null;
        try
        {
            ObjectInputStream objectinputstream = new ObjectInputStream(new FileInputStream((new File(Environment.getExternalStorageDirectory(), "memory.data"))));
            memory = (Memory)objectinputstream.readObject();
            objectinputstream.close();

            //Log.d("succs2", "SUCCESS2");
        }
        catch (Exception exception)
        {
            Log.d("fiald2", "FAIL2");
            memory = null;
            //return memory;
        }
        return memory;
    }

    public static void saveData(Memory memory)
    {
        try
        {
            ObjectOutputStream objectoutputstream = new ObjectOutputStream(new FileOutputStream((new File(Environment.getExternalStorageDirectory(), "memory.data"))));
            objectoutputstream.writeObject(memory);
           // objectoutputstream.flush();
            objectoutputstream.close();
            Log.d("succs", "SUCCESS");
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            Log.d("fiald", "FAIL");
        }
    }

}
