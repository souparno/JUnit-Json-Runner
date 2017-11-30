package org.junit.runner;

import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.Failure;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.lang.reflect.*;

class JsonListener extends RunListener {

    private int _testFailed = 0;
    private final JSONArray myArray;

    JsonListener() {
        this.myArray = new JSONArray();
    }

    @Override
    public void testRunStarted(Description description) throws Exception {

    }

    @Override
    public void testRunFinished(Result result) throws Exception {
        System.out.println(myArray);
    }

    @Override
    public void testStarted(Description description) throws Exception {
        _testFailed = 0;
    }

    @Override
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

        if (_testFailed == 0) {
            j.put("status", "passed");
        }
        myArray.add(j);
    }

    @Override
    public void testFailure(Failure failure) throws Exception {
        _testFailed = 1;
    }

    @Override
    public void testAssumptionFailure(Failure failure) {
        _testFailed = 1;
    }

    @Override
    public void testIgnored(Description description) throws Exception {
        _testFailed = 1;
    }

}
