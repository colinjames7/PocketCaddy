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
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.example.pocketcaddies:
//            Memory, Course, SelectCourseActivity

@SuppressLint("NewApi")
public class CourseDialog extends DialogFragment
{

    private Boolean all_holes;
    private View back_nine;
    private EditText course_name_input;
    private RadioButton eighteenbutton;
    private Boolean fully_entered;
    private LayoutInflater inflator;
    private RadioButton nineButton;
    private RadioGroup radiocourse;
    private View view1;
    private View view2;
    Memory memory;

    public CourseDialog()
    {
    }

    private boolean checkDuplicates(String s)
    {

        ArrayList arraylist = memory.createCourseNames();
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

    private Boolean checkFilled()
    {
        boolean flag;
        Boolean boolean1;
        boolean flag1;
        Boolean boolean2;
        boolean flag2;
        Boolean boolean3;
        boolean flag3;
        Boolean boolean4;
        boolean flag4;
        Boolean boolean5;
        boolean flag5;
        Boolean boolean6;
        boolean flag6;
        Boolean boolean7;
        boolean flag7;
        Boolean boolean8;
        boolean flag8;
        Boolean boolean9;
        boolean flag9;
        Boolean boolean10;
        boolean flag10;
        Boolean boolean11;
        boolean flag11;
        Boolean boolean12;
        boolean flag12;
        Boolean boolean13;
        boolean flag13;
        Boolean boolean14;
        boolean flag14;
        Boolean boolean15;
        boolean flag15;
        Boolean boolean16;
        boolean flag16;
        Boolean boolean17;
        boolean flag17;
        Boolean boolean18;
        if (((EditText)view1.findViewById(R.id.first_hole)).getText().toString().matches(""))
        {
            flag = false;
        } else
        {
            flag = true;
        }
        boolean1 = Boolean.valueOf(flag);
        if (((EditText)view1.findViewById(R.id.second_hole)).getText().toString().matches(""))
        {
            flag1 = false;
        } else
        {
            flag1 = true;
        }
        boolean2 = Boolean.valueOf(flag1);
        if (((EditText)view1.findViewById(R.id.third_hole)).getText().toString().matches(""))
        {
            flag2 = false;
        } else
        {
            flag2 = true;
        }
        boolean3 = Boolean.valueOf(flag2);
        if (((EditText)view1.findViewById(R.id.fourth_hole)).getText().toString().matches(""))
        {
            flag3 = false;
        } else
        {
            flag3 = true;
        }
        boolean4 = Boolean.valueOf(flag3);
        if (((EditText)view1.findViewById(R.id.fifth_hole)).getText().toString().matches(""))
        {
            flag4 = false;
        } else
        {
            flag4 = true;
        }
        boolean5 = Boolean.valueOf(flag4);
        if (((EditText)view1.findViewById(R.id.sixth_hole)).getText().toString().matches(""))
        {
            flag5 = false;
        } else
        {
            flag5 = true;
        }
        boolean6 = Boolean.valueOf(flag5);
        if (((EditText)view1.findViewById(R.id.seventh_hole)).getText().toString().matches(""))
        {
            flag6 = false;
        } else
        {
            flag6 = true;
        }
        boolean7 = Boolean.valueOf(flag6);
        if (((EditText)view1.findViewById(R.id.eighth_hole)).getText().toString().matches(""))
        {
            flag7 = false;
        } else
        {
            flag7 = true;
        }
        boolean8 = Boolean.valueOf(flag7);
        if (((EditText)view1.findViewById(R.id.ninth_hole)).getText().toString().matches(""))
        {
            flag8 = false;
        } else
        {
            flag8 = true;
        }
        boolean9 = Boolean.valueOf(flag8);
        if (((EditText)view1.findViewById(R.id.tenth_hole)).getText().toString().matches(""))
        {
            flag9 = false;
        } else
        {
            flag9 = true;
        }
        boolean10 = Boolean.valueOf(flag9);
        if (((EditText)view1.findViewById(R.id.eleventh_hole)).getText().toString().matches(""))
        {
            flag10 = false;
        } else
        {
            flag10 = true;
        }
        boolean11 = Boolean.valueOf(flag10);
        if (((EditText)view1.findViewById(R.id.twelfth_hole)).getText().toString().matches(""))
        {
            flag11 = false;
        } else
        {
            flag11 = true;
        }
        boolean12 = Boolean.valueOf(flag11);
        if (((EditText)view1.findViewById(R.id.thirteenth_hole)).getText().toString().matches(""))
        {
            flag12 = false;
        } else
        {
            flag12 = true;
        }
        boolean13 = Boolean.valueOf(flag12);
        if (((EditText)view1.findViewById(R.id.fourteenth_hole)).getText().toString().matches(""))
        {
            flag13 = false;
        } else
        {
            flag13 = true;
        }
        boolean14 = Boolean.valueOf(flag13);
        if (((EditText)view1.findViewById(R.id.fifteenth_hole)).getText().toString().matches(""))
        {
            flag14 = false;
        } else
        {
            flag14 = true;
        }
        boolean15 = Boolean.valueOf(flag14);
        if (((EditText)view1.findViewById(R.id.sixteenth_hole)).getText().toString().matches(""))
        {
            flag15 = false;
        } else
        {
            flag15 = true;
        }
        boolean16 = Boolean.valueOf(flag15);
        if (((EditText)view1.findViewById(R.id.seventeenth_hole)).getText().toString().matches(""))
        {
            flag16 = false;
        } else
        {
            flag16 = true;
        }
        boolean17 = Boolean.valueOf(flag16);
        if (((EditText)view1.findViewById(R.id.eighteenth_hole)).getText().toString().matches(""))
        {
            flag17 = false;
        } else
        {
            flag17 = true;
        }
        boolean18 = Boolean.valueOf(flag17);
        if (all_holes.booleanValue())
        {
            if (boolean1.booleanValue() && boolean2.booleanValue() && boolean3.booleanValue() && boolean4.booleanValue() && boolean5.booleanValue() && boolean6.booleanValue() && boolean7.booleanValue() && boolean8.booleanValue() && boolean9.booleanValue() && boolean10.booleanValue() && boolean11.booleanValue() && boolean11.booleanValue() && boolean12.booleanValue() && boolean13.booleanValue() && boolean14.booleanValue() && boolean15.booleanValue() && boolean16.booleanValue() && boolean17.booleanValue() && boolean18.booleanValue())
            {
                return Boolean.valueOf(true);
            } else
            {
                return Boolean.valueOf(false);
            }
        }
        if (boolean1.booleanValue() && boolean2.booleanValue() && boolean3.booleanValue() && boolean4.booleanValue() && boolean5.booleanValue() && boolean6.booleanValue() && boolean7.booleanValue() && boolean8.booleanValue() && boolean9.booleanValue())
        {
            return Boolean.valueOf(true);
        } else
        {
            return Boolean.valueOf(false);
        }
    }

    private int[] getPars()
    {
        int i = Integer.parseInt(((EditText)view1.findViewById(R.id.first_hole)).getText().toString());
        int j = Integer.parseInt(((EditText)view1.findViewById(R.id.second_hole)).getText().toString());
        int k = Integer.parseInt(((EditText)view1.findViewById(R.id.third_hole)).getText().toString());
        int l = Integer.parseInt(((EditText)view1.findViewById(R.id.fourth_hole)).getText().toString());
        int i1 = Integer.parseInt(((EditText)view1.findViewById(R.id.fifth_hole)).getText().toString());
        int j1 = Integer.parseInt(((EditText)view1.findViewById(R.id.sixth_hole)).getText().toString());
        int k1 = Integer.parseInt(((EditText)view1.findViewById(R.id.seventh_hole)).getText().toString());
        int l1 = Integer.parseInt(((EditText)view1.findViewById(R.id.eighth_hole)).getText().toString());
        int i2 = Integer.parseInt(((EditText)view1.findViewById(R.id.ninth_hole)).getText().toString());
        if (!all_holes.booleanValue())
        {
            return (new int[] {
                i, j, k, l, i1, j1, k1, l1, i2
            });
        } else
        {
            return (new int[] {
                i, j, k, l, i1, j1, k1, l1, i2, Integer.parseInt(((EditText)view1.findViewById(R.id.tenth_hole)).getText().toString()),
                Integer.parseInt(((EditText)view1.findViewById(R.id.eleventh_hole)).getText().toString()), Integer.parseInt(((EditText)view1.findViewById(R.id.twelfth_hole)).getText().toString()), Integer.parseInt(((EditText)view1.findViewById(R.id.thirteenth_hole)).getText().toString()), Integer.parseInt(((EditText)view1.findViewById(R.id.fourteenth_hole)).getText().toString()), Integer.parseInt(((EditText)view1.findViewById(R.id.fifteenth_hole)).getText().toString()), Integer.parseInt(((EditText)view1.findViewById(R.id.sixteenth_hole)).getText().toString()), Integer.parseInt(((EditText)view1.findViewById(R.id.seventeenth_hole)).getText().toString()), Integer.parseInt(((EditText)view1.findViewById(R.id.eighteenth_hole)).getText().toString())
            });
        }
    }

    public void goBack()
    {
        dismiss();
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        memory = Memory.loadData();
        all_holes = Boolean.valueOf(true);
        fully_entered = Boolean.valueOf(false);
        setCancelable(false);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        inflator = getActivity().getLayoutInflater();
        view1 = inflator.inflate(R.layout.course_input_dialog, null);
        view2 = getActivity().findViewById(android.R.id.content);
        back_nine = view1.findViewById(R.id.back_nine);
        radiocourse = (RadioGroup)view1.findViewById(R.id.course_select_dialog);
        nineButton = (RadioButton)view1.findViewById(R.id.nine_hole_select);
        eighteenbutton = (RadioButton)view1.findViewById(R.id.eighteen_hole_select);
        radiocourse.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            final CourseDialog this$0;

            public void onCheckedChanged(RadioGroup radiogroup, int i)
            {
                if (nineButton.isChecked())
                {
                    back_nine.setVisibility(View.INVISIBLE);
                    all_holes = Boolean.valueOf(false);
                }
                if (eighteenbutton.isChecked())
                {
                    back_nine.setVisibility(View.VISIBLE);
                    all_holes = Boolean.valueOf(true);
                }
            }

            
            {
                this$0 = CourseDialog.this;
            }
        });
        builder.setView(view1).setPositiveButton(R.string.Enter, new DialogInterface.OnClickListener() {

            final CourseDialog this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                course_name_input.getText().toString();
            }

            
            {
                this$0 = CourseDialog.this;
            }
        }).setNegativeButton(R.string.Cancel, new DialogInterface.OnClickListener() {

            final CourseDialog this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
            }

            
            {
                this$0 = CourseDialog.this;
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

                final CourseDialog this$0;

                public void onClick(View view)
                {
                    checkFilled();
                    course_name_input = (EditText)view1.findViewById(R.id.course_input);
                    String s = course_name_input.getText().toString();
                    if (!s.matches(""))
                    {
                        fully_entered = Boolean.valueOf(true);
                    }
                    if (fully_entered.booleanValue() && checkFilled().booleanValue() && checkDuplicates(s))
                    {
                        dismiss();
                        Course course = new Course(s, getPars(), getPars().length);
                        Memory.loadData();
                        memory.courses.add(course);
                        Memory.saveData(memory);
                        SelectCourseActivity.player_names.add(s);
                        SelectCourseActivity.playeradapter.notifyDataSetChanged();
                    }
                }

            
            {
                this$0 = CourseDialog.this;
            }
            });
        }
    }












}
