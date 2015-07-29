package org.junit.runner;

import org.junit.runner.notification.RunListener;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.io.FileWriter;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

class JsonListener extends RunListener {

    private JSONObject _tests_passed = new JSONObject();
    private JSONObject _tests_started = new JSONObject();
    private JSONObject _tests_finished = new JSONObject();
    private JSONObject _tests_failures = new JSONObject();
    private JSONObject _tests_ignored = new JSONObject();
  
    public void testRunStarted(Description description) throws Exception {
     
    }

    public void testRunFinished(Result result) throws Exception {
       System.out.println("_tests_passed "+ _tests_passed);
       System.out.println("_tests_started" + _tests_started);
       System.out.println("_tests_finished"+ _tests_finished);
       System.out.println("_tests_failures"+_tests_failures);
       System.out.println("_tests_ignored"+_tests_ignored);
    }

    public void testStarted(Description description) throws Exception {
        String key = description.getMethodName();
        String msg = description.getDisplayName();

        _tests_started.put(key, msg);
    }

    public void testFinished(Description description) throws Exception {
       String key = description.getMethodName();       
       String msg = description.getDisplayName();

       _tests_finished.put(key, msg);
    }

    public void testFailure(Failure failure) throws Exception {
       String key = failure.getDescription().getMethodName();
       String msg = failure.getDescription().getDisplayName();

       _tests_failures.put(key, msg); 
    }

    public void testAssumptionFailure(Failure failure) {
      String key = failure.getDescription().getMethodName();
      String msg = failure.getDescription().getDisplayName();

      _tests_failures.put(key, msg); 
   }

    public void testIgnored(Description description) throws Exception {
      String key = description.getMethodName();
      String msg = description.getDisplayName();

      _tests_ignored.put(key, msg);
    }

}
