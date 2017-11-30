package org.junit.runner;

import org.junit.runner.notification.RunListener;

public class JsonRunner {

    public static void main(String args[]) {
        try {
            String[] classAndMethod = args[0].split("#");
            Request request = Request.method(Class.forName(classAndMethod[0]), classAndMethod[1]);
            JUnitCore core = new JUnitCore();
            RunListener listener = new JsonListener();
            core.addListener(listener);
            core.run(request);
        } catch (ClassNotFoundException e) {}
    }
}
