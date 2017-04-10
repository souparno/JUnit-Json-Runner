import java.io.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class perfectTest
 {

  ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  

  @Before
  public void setUpStream() {
     System.setOut(new PrintStream(outContent));
  }

  @After
  public void cleanUpStream() {
     System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
  }

    @Test
    public void perfTest() {
      System.out.println("Should find the sum of the factors");
      int a=6;
      perfect obj = new perfect();
      int b = obj.perfectSum(a);  
      assertEquals(6,b);
    }

    @Test
    public void checkTest() {
      System.out.println("should check between the original number and the sum");
      perfect obj = new perfect();
      int result = obj.check(6, 6); 
      int expResult = 1;
      assertEquals(expResult,result);
    }


    @Test
    public void checkTest1() {
      System.out.println("should check between the original number and the sum");
      perfect obj = new perfect();
      int result = obj.check(6, 11); 
      int expResult = 0;
      assertEquals(expResult,result);
    }

    @Test
   public void mainTestPalindrome() throws java.io.IOException{
        ByteArrayInputStream in = new ByteArrayInputStream("121".getBytes());
	System.setIn(in);
	perfect.main();
        assertEquals("input a number\nperfect", outContent.toString().toLowerCase());
     
   }

   @Test
   public void mainTestNotPalindrome() throws java.io.IOException{
        ByteArrayInputStream in = new ByteArrayInputStream("123".getBytes());
	System.setIn(in);
	perfect.main();
     assertEquals("input a number\nnot perfect", outContent.toString());
   }
}

