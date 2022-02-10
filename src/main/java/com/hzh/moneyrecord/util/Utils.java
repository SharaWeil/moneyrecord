package com.hzh.moneyrecord.util;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Utils {

    private static final ClassLoader classLoader;
    static {
        classLoader = Thread.currentThread().getContextClassLoader();
    }

    public static Class classForName(String className) throws ClassNotFoundException {
        return Class.forName(className,true,classLoader);
    }
}
