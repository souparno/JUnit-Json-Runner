import java.io.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class palindromeStringTest extends Base {

    @Test
    public void revTest() {
      description = "this should reverse the string";
      String  a="Madam";
      palindromeString obj = new palindromeString();
      String b = obj.rev(a);  
      assertEquals("hey there","madaM",b);
    }

    @Test
    public void checkTest() {
      description = "this should check if the reverse of the strings are equal to each other";
      palindromeString obj = new palindromeString();
      int result = obj.check("hello", "hello"); 
      int expResult = 1;
      assertEquals(expResult,result);
    }


    //@Test
    //public void checkTest1() {
      //palindromeString obj = new palindromeString();
      //int result = obj.check("hello", "hi"); 
      //int expResult = 0;
      //assertEquals(expResult,result);
    //}

    //@Test
   //public void mainTestPalindrome() throws java.io.IOException{
        //ByteArrayInputStream in = new ByteArrayInputStream("madam".getBytes());
	//System.setIn(in);
	//palindromeString.main();
        //assertEquals("input a number\npalindrome", outContent.toString().toLowerCase());
     
   //}

   //@Test
   //public void mainTestNotPalindrome() throws java.io.IOException{
        //ByteArrayInputStream in = new ByteArrayInputStream("hello".getBytes());
	//System.setIn(in);
	//palindromeString.main();
        //assertEquals("input a number\nnot palindrome", outContent.toString());
   //}
}

