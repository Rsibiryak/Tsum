package ru.tsum.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * CustomLogger
 * <p>
 * Class for logging
 *
 * @author Alexander_Suvorov
 */
public class CustomLogger {
    protected static final Logger LOGGER = LogManager.getLogger(CustomLogger.class);
    private static CustomLogger customLogger;

    public static Logger getLogger() {
        if (customLogger == null) {
            customLogger = new CustomLogger();
        }
        return LOGGER;
    }
}
