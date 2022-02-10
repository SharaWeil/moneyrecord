package com.hzh.moneyrecord.util;

import lombok.Data;
import lombok.Setter;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;

import java.net.URL;

public class BaseLogging {
    private Logger logger;

    private final Logging logging = new Logging();

    private String logName() {
        return this.getClass().getName();
    }

    private Logger logger() {
        if (logger == null) {
            initializeLogIfNecessary(true);
            logger = LoggerFactory.getLogger(logName());
        }
        return logger;
    }

    protected void logInfo(String msg) {
        if (logger().isInfoEnabled()){
            logger().info(msg);
        }
    }
    protected void logDebug(String msg) {
        if (logger().isDebugEnabled()){
            logger().debug(msg);
        }
    }
    protected void logTrace(String msg) {
        if (logger().isTraceEnabled()){
            logger().trace(msg);
        }
    }
    protected void logWarning(String msg) {
        if (logger().isWarnEnabled()){
            logger().warn(msg);
        }
    }

    protected void logInfo(String msg,Throwable throwable) {
        if (logger().isInfoEnabled()){
            logger().info(msg,throwable);
        }
    }
    protected void logDebug(String msg,Throwable throwable) {
        if (logger().isDebugEnabled()){
            logger().debug(msg,throwable);
        }
    }
    protected void logTrace(String msg,Throwable throwable) {
        if (logger().isTraceEnabled()){
            logger().trace(msg,throwable);
        }
    }
    protected void logWarning(String msg,Throwable throwable) {
        if (logger().isWarnEnabled()){
            logger().warn(msg,throwable);
        }
    }



    private void initializeLogIfNecessary(boolean isInterpreter) {
        if (!logging.isInitialized()) {
            synchronized (logging.getLock()) {
                if (!logging.isInitialized()) {
                    initializeLogging(isInterpreter);
                }
            }
        }

    }

    private void initializeLogging(boolean isInterpreter) {
        String binderClass = StaticLoggerBinder.getSingleton().getLoggerFactoryClassStr();
        boolean usingLog4j12 = "org.slf4j.impl.Log4jLoggerFactory".equals(binderClass);
        if (usingLog4j12) {
            boolean log4j12Initialized = LogManager.getRootLogger().getAllAppenders().hasMoreElements();
            if (!log4j12Initialized) {
                String defaultLogProps = "log4j.properties";
                URL url = ConfigFactory.loadResourceFile(defaultLogProps);
                if (ObjectUtils.isNotEmpty(url)) {
                    PropertyConfigurator.configure(url);
                }
            }
            if (isInterpreter) {
                // Use the repl's main class to define the default log level when running the shell,
                // overriding the root logger's config if they're different.
                org.apache.log4j.Logger rootLogger = LogManager.getRootLogger();
                org.apache.log4j.Logger replLogger = LogManager.getLogger(logName());
                Level replLevel = replLogger.getLevel();
                if (ObjectUtils.isEmpty(replLevel)) {
                    replLevel = Level.WARN;
                }
                if (replLevel != rootLogger.getEffectiveLevel()) {
                    System.err.printf("Setting default log level to \"%s\".\n", replLevel);
                    System.err.println("To adjust logging level use sc.setLogLevel(newLevel). " +
                            "For Ysera, use setLogLevel(newLevel).");
                    rootLogger.setLevel(replLevel);
                }
            }
        }
        logging.setInitialized(true);
    }
}

@Data
@Setter
class Logging {
    private boolean initialized = false;
    private final Object lock = new Object();

    static {
        try {
            Class bridgeClass = Utils.classForName("org.slf4j.bridge.SLF4JBridgeHandler");
            bridgeClass.getMethod("removeHandlersForRootLogger").invoke(null);
            Boolean isInstalled = (Boolean) bridgeClass.getMethod("isInstalled").invoke(null);
            if (!isInstalled) {
                bridgeClass.getMethod("install").invoke(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isInitialized() {
        return initialized;
    }
}
