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

    private int _testFailed = 0;
    private JSONArray myArray = new JSONArray();
  
    public void testRunStarted(Description description) throws Exception {
     
    }

    public void testRunFinished(Result result) throws Exception {
        System.out.println(myArray);
    }

    public void testStarted(Description description) throws Exception {
        _testFailed = 0;
    }

    public void testFinished(Description description) throws Exception {
	Class<?> testClass = description.getTestClass();
        Class<?> baseClass = testClass.getSuperclass();
	Method getDescription = baseClass.getDeclaredMethod("getDescription");
	Method getHint = baseClass.getDeclaredMethod("getHint");
	Object _description = getDescription.invoke(null);
        Object _hint = getHint.invoke(null);

	JSONObject j = new JSONObject();
	j.put("description", _description);
	j.put("hint", _hint);
	j.put("status", "failed");

       if(_testFailed == 0) {
             j.put("status", "passed");
       } 
       myArray.add(j);      
    }

    public void testFailure(Failure failure) throws Exception {
       _testFailed = 1;
    }

    public void testAssumptionFailure(Failure failure) {
       _testFailed = 1;
    }

    public void testIgnored(Description description) throws Exception {
       _testFailed = 1;
    }

}
