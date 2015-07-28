package org.junit.runner;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.notification.RunListener;

public class JsonRunner {

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
    RunListener listener = new JsonListener();
    core.addListener(listener);
    core.run(classes.toArray(new Class[0]));   
  }
}




