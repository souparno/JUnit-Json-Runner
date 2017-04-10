package org.junit.runner;

import org.junit.runner.notification.RunListener;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.lang.reflect.*;

class JsonListener extends RunListener {

    private JSONObject _tests_passed = new JSONObject();
    private JSONObject _tests_started = new JSONObject();
    private JSONObject _tests_finished = new JSONObject();
    private JSONObject _tests_failures = new JSONObject();
    private JSONObject _tests_ignored = new JSONObject();
    private JSONArray myArray = new JSONArray();
  
    public void testRunStarted(Description description) throws Exception {
     
    }

    public void testRunFinished(Result result) throws Exception {
        System.out.println(myArray);
    }

    public void testStarted(Description description) throws Exception {
        String key = description.getDisplayName();
        long value = System.currentTimeMillis();

        _tests_started.put(key, value);
    }

    public void testFinished(Description description) throws Exception {
	Class<?> testClass = description.getTestClass();
        Class<?> baseClass = testClass.getSuperclass();
	Method m = baseClass.getDeclaredMethod("getDescription");
	Object o = m.invoke(null);
        
	JSONObject j = new JSONObject();
	j.put("description", o);
	j.put("status", "failed");
        String key = description.getDisplayName();       

       if(!_tests_failures.containsKey(key) || !_tests_ignored.containsKey(key)) {
             j.put("status", "passed");
             myArray.add(j);      
       }

    }

    public void testFailure(Failure failure) throws Exception {
       String key = failure.getDescription().getDisplayName();
       long value = System.currentTimeMillis();

       _tests_failures.put(key, value);
    }

    public void testAssumptionFailure(Failure failure) {
       String key = failure.getDescription().getDisplayName();
       long value = System.currentTimeMillis();

       _tests_failures.put(key, value);
    }

    public void testIgnored(Description description) throws Exception {
      String key = description.getMethodName();
      long value = System.currentTimeMillis();
     
       _tests_ignored.put(key, value);
    }

}
