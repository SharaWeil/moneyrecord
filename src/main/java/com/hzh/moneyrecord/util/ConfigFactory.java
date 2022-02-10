package com.hzh.moneyrecord.util;

import java.net.URL;

public class ConfigFactory {
    public static URL loadResourceFile(String fileName) {
        return ConfigFactory.class.getClassLoader().getResource(fileName);
    }
}
