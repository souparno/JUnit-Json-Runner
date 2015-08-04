package myclass;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyClassTest {
   
    @Test
    public void testAdd() {
        int a = 0;
        int b = 0;
        MyClass instance = new MyClass();
        int expResult = 0;
        int result = instance.add(a, b);
        assertEquals(expResult, result);
    }

}
