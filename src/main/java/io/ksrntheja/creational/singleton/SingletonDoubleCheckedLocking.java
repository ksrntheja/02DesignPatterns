package io.ksrntheja.creational.singleton;

import java.io.Serializable;

public class SingletonDoubleCheckedLocking implements Serializable {

    private static volatile SingletonDoubleCheckedLocking obj = null;

    // Prevent form the reflection api.
    private SingletonDoubleCheckedLocking() {
        if (obj != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static SingletonDoubleCheckedLocking getInstance() {
        if (obj == null) {
            // To make thread safe
            synchronized (SingletonDoubleCheckedLocking.class) {
                // check again as multiple threads can reach above step
                if (obj == null) {
                    obj = new SingletonDoubleCheckedLocking();
                }
            }
        }
        return obj;
    }

    // Make singleton from serialize and deserialize operation.
    protected SingletonDoubleCheckedLocking readResolve() {
        return getInstance();
    }

}
