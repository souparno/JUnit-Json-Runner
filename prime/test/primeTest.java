import java.io.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.Description;

public class primeTest
 {

  ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  public static String desc; 

  @Before
  public void setUpStream() {
     System.setOut(new PrintStream(outContent));
  }

  @After
  public void cleanUpStream() {
     System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
  }

    @Test 
    public void primeTest_not_divisible() {
      primeTest.desc = "check this out";
     //Description testone=Description.createTestDescription("primeTest","testone");
      //System.out.println("Should find divisible by any varriable ,if not divisible return 0");
      int a=7;
      prime obj = new prime();
      int b = obj.prime_check(a);  
      assertEquals(0,b);
    }
    @Test
    public void primeTest_divisible() {
     System.out.println("Should find divisible by any varriable ,if divisible return 1");
      int a=6;
      prime obj = new prime();
      int b = obj.prime_check(a);  
      assertEquals(1,b);
    }


   @Test
   public void mainTestPalindrome() throws java.io.IOException{
        ByteArrayInputStream in = new ByteArrayInputStream("121".getBytes());
	System.setIn(in);
	prime.main();
        assertEquals("input a number\nprime", outContent.toString().toLowerCase());
     
   }

   @Test
   public void mainTestNotPalindrome() throws java.io.IOException{
        ByteArrayInputStream in = new ByteArrayInputStream("123".getBytes());
	System.setIn(in);
	prime.main();
     assertEquals("input a number\nnot prime", outContent.toString());
   }
}

