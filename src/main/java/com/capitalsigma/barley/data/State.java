package com.capitalsigma.barley.data;

/**
 * Created by patrick on 7/14/15.
 */
public class State {
    private static State instance;

    private State() {

    }

    // Do we need synchronized here?
    public static synchronized State getState() {
        if (instance == null) {
            instance = new State();
        }

        return instance;
    }
}
