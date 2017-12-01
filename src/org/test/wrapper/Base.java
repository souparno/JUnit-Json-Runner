package org.test.wrapper;

import java.io.*;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;
import java.lang.reflect.*;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Base {

    public ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    public static String instruction;
    public static String description;
    public static String hint;
    public static Object obj;

    @Before
    public void setUpStream() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStream() {
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }

    public static Object getDebuggingObject() {
        return obj;
    }

    public static void debug(Object myobj) {
        obj = myobj;
    }

    public static String getInstruction() {
        return instruction;
    }

    public static String getDescription() {
        return description;
    }

    public static String getHint() {
        return hint;
    }

    public static Method getMethod(Object obj, String fn_Name) {
        Method fun = null;
        try {
            Method[] methods = obj.getClass().getMethods();
            for (Method m : methods) {
                if (m.getName().equals(fn_Name)) {
                    fun = m;
                    break;
                }
            }
        } catch (SecurityException e) {}
        if (fun == null) {
            assertEquals(0, 1);
        }
        return fun;
    }
}
