import java.io.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import java.lang.reflect.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Base{

  ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  static String description; 
  static String hint; 

  @Before
  public void setUpStream() {
     System.setOut(new PrintStream(outContent));
  }

  @After
  public void cleanUpStream() {
     System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
  }

  public static String getDescription() {
    return description;
  }

  public static String getHint(){
    return hint;
  }

  public static Method getMethod(Object obj,String fn_Name){
	Method fun = null;
	 try {
            Method[] methods = obj.getClass().getMethods();
	    for (Method m : methods) {
		if (m.getName().equals(fn_Name)) {
			fun = m;
			break;
		}
	    }
         } catch (Exception e){}
         if(fun == null){
             assertEquals(0, 1);
         }
	 return fun;
  }
}
