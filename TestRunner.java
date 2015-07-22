import java.util.ArrayList;
import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.notification.RunListener;


import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

class TestRunner {

  public static void main (String args[]) {
    
   List<Class<?>> classes= new ArrayList<Class<?>>();
    
    for(String each : args){
      try {
        classes.add(Class.forName(each));
      } catch (ClassNotFoundException e) {
        System.out.println("Class Not found");
      }
    }

    JUnitCore core = new JUnitCore();
    RunListener listener = new MyListener();
    core.addListener(listener);
    core.run(classes.toArray(new Class[0]));   
  }
}



class MyListener extends RunListener {

    public void testRunStarted(Description description) throws Exception {
        System.out.println("Number of tests to execute: " + description.testCount());
    }

    public void testRunFinished(Result result) throws Exception {
        System.out.println("Number of tests executed: " + result.getRunCount());
    }

    public void testStarted(Description description) throws Exception {
        System.out.println("Starting: " + description.getMethodName());
    }

    public void testFinished(Description description) throws Exception {
        System.out.println("Finished: " + description.getMethodName());
    }

    public void testFailure(Failure failure) throws Exception {
        System.out.println("Failed: " + failure.getDescription().getMethodName());
    }

    public void testAssumptionFailure(Failure failure) {
        System.out.println("Failed: " + failure.getDescription().getMethodName());
    }

    public void testIgnored(Description description) throws Exception {
        System.out.println("Ignored: " + description.getMethodName());
    }

}
