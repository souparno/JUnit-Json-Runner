package org.test.wrapper;

import java.util.LinkedList;
import java.util.Queue;

public class InputStreamBuilder {

    private final Queue<String> values = new LinkedList<>();

    public InputStreamBuilder toReturn(String value) {
        this.values.add(value);
        return this;
    }

    public InputStreamBuilder then(String value) {
        this.values.add(value);
        return this;
    }

    /**
     *
     * @return
     */
    public StubbedInputStream atSomePoint() {
        return new StubbedInputStream(values);
    }
}
