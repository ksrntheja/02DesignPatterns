/*
    Creational pattern - Singleton
        Application needs one, and only one, instance of an object.
    JVM executes static initializer when the class is loaded and hence this is guaranteed to be thread safe.
    Use this method only when your singleton class is light.
*/
package io.ksrntheja.creational.singleton;

import java.io.Serializable;

public class SingletonEagerInstantiation implements Serializable {

    private static final SingletonEagerInstantiation obj = new SingletonEagerInstantiation();

    //Prevent form the reflection api.
    private SingletonEagerInstantiation() {
        throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
    }

    public static SingletonEagerInstantiation getInstance() {
        return obj;
    }


    // Make singleton from serialize and deserialize operation.
    protected SingletonEagerInstantiation readResolve() {
        return getInstance();
    }

}
