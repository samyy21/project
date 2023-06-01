package com.paytm.pgplus.upipsphandler.log;

import com.paytm.pgplus.logging.LogUtil;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.MessageFactory;
import org.apache.logging.log4j.spi.AbstractLogger;
import org.apache.logging.log4j.spi.ExtendedLoggerWrapper;
import org.apache.logging.log4j.util.MessageSupplier;
import org.apache.logging.log4j.util.Supplier;

/**@author namanmandlik
 * Extended Logger helps in Enhanced logging / Filtering of logs for specific MIDs based on FF4J property.
 */
public final class ExtendedLogger extends ExtendedLoggerWrapper {
    private static final long serialVersionUID = 30804488858750L;
    private static final String FQCN = ExtendedLogger.class.getName();
    private final ExtendedLoggerWrapper logger;

    private ExtendedLogger(final Logger logger) {
        super((AbstractLogger) logger, logger.getName(), logger.getMessageFactory());
        this.logger = this;
    }

    /**
     * Returns a custom Logger using the fully qualified name of the Class as
     * the Logger name.
     *
     * @param loggerName The Class whose name should be used as the Logger name.
     *            If null it will default to the calling class.
     * @return The custom Logger.
     */
    public static ExtendedLogger create(final Class<?> loggerName) {
        final Logger wrapped = LogManager.getLogger(loggerName);
        return new ExtendedLogger(wrapped);
    }

    /**
     * Returns a custom Logger using the fully qualified name of the Class as
     * the Logger name.
     *
     * @param loggerName The Class whose name should be used as the Logger name.
     *            If null it will default to the calling class.
     * @param messageFactory The message factory is used only when creating a
     *            logger, subsequent use does not change the logger but will log
     *            a warning if mismatched.
     * @return The custom Logger.
     */
    public static ExtendedLogger create(final Class<?> loggerName, final MessageFactory messageFactory) {
        final Logger wrapped = LogManager.getLogger(loggerName, messageFactory);
        return new ExtendedLogger(wrapped);
    }

    /**
     * Returns a custom Logger with the specified name.
     *
     * @param name The logger name. If null the name of the calling class will
     *            be used.
     * @return The custom Logger.
     */
    public static ExtendedLogger create(final String name) {
        final Logger wrapped = LogManager.getLogger(name);
        return new ExtendedLogger(wrapped);
    }

    /**
     * Returns a custom Logger with the specified name.
     *
     * @param name The logger name. If null the name of the calling class will
     *            be used.
     * @param messageFactory The message factory is used only when creating a
     *            logger, subsequent use does not change the logger but will log
     *            a warning if mismatched.
     * @return The custom Logger.
     */
    public static ExtendedLogger create(final String name, final MessageFactory messageFactory) {
        final Logger wrapped = LogManager.getLogger(name, messageFactory);
        return new ExtendedLogger(wrapped);
    }

    public void customInfo(final Marker marker, final Message msg) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, marker, msg, msg != null ? msg.getThrowable() : null);
        }
    }

    public void customInfo(final Marker marker, final Message msg, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, marker, msg, t);
        }
    }

    public void customInfo(final Marker marker, final Object message) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, marker, message, (Throwable) null);
        }
    }

    public void customInfo(final Marker marker, final CharSequence message) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, marker, message, (Throwable) null);
        }
    }

    public void customInfo(final Marker marker, final Object message, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, marker, message, t);
        }
    }

    public void customInfo(final Marker marker, final CharSequence message, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, marker, message, t);
        }
    }

    public void customInfo(final Marker marker, final String message) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, marker, message, (Throwable) null);
        }
    }

    public void customInfo(final Marker marker, final String message, final Object... params) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, marker, message, params);
        }
    }

    public void customInfo(final Marker marker, final String message, final Object p0) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, marker, message, p0);
        }
    }

    public void customInfo(final Marker marker, final String message, final Object p0, final Object p1) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, marker, message, p0, p1);
        }
    }

    public void customInfo(final Marker marker, final String message, final Object p0, final Object p1, final Object p2) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, marker, message, p0, p1, p2);
        }
    }

    public void customInfo(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                           final Object p3) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, marker, message, p0, p1, p2, p3);
        }

    }

    public void customInfo(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                           final Object p3, final Object p4) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, marker, message, p0, p1, p2, p3, p4);
        }
    }

    public void customInfo(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                           final Object p3, final Object p4, final Object p5) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, marker, message, p0, p1, p2, p3, p4, p5);
        }
    }

    public void customInfo(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                           final Object p3, final Object p4, final Object p5, final Object p6) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, marker, message, p0, p1, p2, p3, p4, p5, p6);
        }
    }

    public void customInfo(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                           final Object p3, final Object p4, final Object p5, final Object p6,
                           final Object p7) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, marker, message, p0, p1, p2, p3, p4, p5, p6, p7);
        }
    }

    public void customInfo(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                           final Object p3, final Object p4, final Object p5, final Object p6,
                           final Object p7, final Object p8) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
        }
    }

    public void customInfo(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                           final Object p3, final Object p4, final Object p5, final Object p6,
                           final Object p7, final Object p8, final Object p9) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
        }
    }

    public void customInfo(final Marker marker, final String message, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, marker, message, t);
        }
    }

    public void customInfo(final Message msg) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, null, msg, (Throwable) null);
        }
    }

    public void customInfo(final Message msg, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, null, msg, t);
        }
    }

    public void customInfo(final Object message) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, null, message, (Throwable) null);
        }
    }

    public void customInfo(final Object message, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, null, message, t);
        }
    }

    public void customInfo(final CharSequence message) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, null, message, (Throwable) null);
        }
    }

    public void customInfo(final CharSequence message, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, null, message, t);
        }
    }

    public void customInfo(final String message) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, null, message, (Throwable) null);
        }
    }

    public void customInfo(final String message, final Object... params) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, null, message, params);
        }
    }

    public void customInfo(final String message, final Object p0) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, null, message, p0);
        }
    }

    public void customInfo(final String message, final Object p0, final Object p1) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, null, message, p0, p1);
        }
    }

    public void customInfo(final String message, final Object p0, final Object p1, final Object p2) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, null, message, p0, p1, p2);
        }
    }

    public void customInfo(final String message, final Object p0, final Object p1, final Object p2,
                           final Object p3) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, null, message, p0, p1, p2, p3);
        }
    }

    public void customInfo(final String message, final Object p0, final Object p1, final Object p2,
                           final Object p3, final Object p4) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, null, message, p0, p1, p2, p3, p4);
        }
    }

    public void customInfo(final String message, final Object p0, final Object p1, final Object p2,
                           final Object p3, final Object p4, final Object p5) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, null, message, p0, p1, p2, p3, p4, p5);
        }
    }

    public void customInfo(final String message, final Object p0, final Object p1, final Object p2,
                           final Object p3, final Object p4, final Object p5, final Object p6) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, null, message, p0, p1, p2, p3, p4, p5, p6);
        }
    }

    public void customInfo(final String message, final Object p0, final Object p1, final Object p2,
                           final Object p3, final Object p4, final Object p5, final Object p6,
                           final Object p7) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, null, message, p0, p1, p2, p3, p4, p5, p6, p7);
        }
    }

    public void customInfo(final String message, final Object p0, final Object p1, final Object p2,
                           final Object p3, final Object p4, final Object p5, final Object p6,
                           final Object p7, final Object p8) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, null, message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
        }
    }

    public void customInfo(final String message, final Object p0, final Object p1, final Object p2,
                           final Object p3, final Object p4, final Object p5, final Object p6,
                           final Object p7, final Object p8, final Object p9) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, null, message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
        }
    }

    public void customInfo(final String message, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, null, message, t);
        }
    }

    public void customInfo(final Supplier<?> msgSupplier) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, null, msgSupplier, (Throwable) null);
        }
    }

    public void customInfo(final Supplier<?> msgSupplier, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, null, msgSupplier, t);
        }
    }

    public void customInfo(final Marker marker, final Supplier<?> msgSupplier) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, marker, msgSupplier, (Throwable) null);
        }
    }

    public void customInfo(final Marker marker, final String message, final Supplier<?>... paramSuppliers) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, marker, message, paramSuppliers);
        }
    }

    public void customInfo(final Marker marker, final Supplier<?> msgSupplier, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, marker, msgSupplier, t);
        }
    }

    public void customInfo(final String message, final Supplier<?>... paramSuppliers) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, null, message, paramSuppliers);
        }
    }

    public void customInfo(final Marker marker, final MessageSupplier msgSupplier) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, marker, msgSupplier, (Throwable) null);
        }
    }

    public void customInfo(final Marker marker, final MessageSupplier msgSupplier, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, marker, msgSupplier, t);
        }
    }

    public void customInfo(final MessageSupplier msgSupplier) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, null, msgSupplier, (Throwable) null);
        }
    }

    public void customInfo(final MessageSupplier msgSupplier, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.INFO, null, msgSupplier, t);
        }
    }

    public void customError(final Marker marker, final Message msg) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, marker, msg, msg != null ? msg.getThrowable() : null);
        }
    }

    public void customError(final Marker marker, final Message msg, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, marker, msg, t);
        }
    }

    public void customError(final Marker marker, final Object message) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, marker, message, (Throwable) null);
        }
    }

    public void customError(final Marker marker, final CharSequence message) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, marker, message, (Throwable) null);
        }
    }

    public void customError(final Marker marker, final Object message, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, marker, message, t);
        }
    }

    public void customError(final Marker marker, final CharSequence message, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, marker, message, t);
        }
    }

    public void customError(final Marker marker, final String message) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, marker, message, (Throwable) null);
        }
    }

    public void customError(final Marker marker, final String message, final Object... params) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, marker, message, params);
        }
    }

    public void customError(final Marker marker, final String message, final Object p0) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, marker, message, p0);
        }
    }

    public void customError(final Marker marker, final String message, final Object p0, final Object p1) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, marker, message, p0, p1);
        }
    }

    public void customError(final Marker marker, final String message, final Object p0, final Object p1, final Object p2) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, marker, message, p0, p1, p2);
        }
    }

    public void customError(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, marker, message, p0, p1, p2, p3);
        }
    }

    public void customError(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, marker, message, p0, p1, p2, p3, p4);
        }
    }

    public void customError(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, marker, message, p0, p1, p2, p3, p4, p5);
        }
    }

    public void customError(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5, final Object p6) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, marker, message, p0, p1, p2, p3, p4, p5, p6);
        }
    }

    public void customError(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5, final Object p6,
                            final Object p7) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, marker, message, p0, p1, p2, p3, p4, p5, p6, p7);
        }
    }

    public void customError(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5, final Object p6,
                            final Object p7, final Object p8) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
        }
    }

    public void customError(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5, final Object p6,
                            final Object p7, final Object p8, final Object p9) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
        }
    }

    public void customError(final Marker marker, final String message, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, marker, message, t);
        }
    }

    public void customError(final Message msg) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, null, msg, (Throwable) null);
        }
    }

    public void customError(final Message msg, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, null, msg, t);
        }
    }

    public void customError(final Object message) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, null, message, (Throwable) null);
        }
    }

    public void customError(final Object message, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, null, message, t);
        }
    }

    public void customError(final CharSequence message) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, null, message, (Throwable) null);
        }
    }

    public void customError(final CharSequence message, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, null, message, t);
        }
    }

    public void customError(final String message) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, null, message, (Throwable) null);
        }
    }

    public void customError(final String message, final Object... params) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, null, message, params);
        }
    }

    public void customError(final String message, final Object p0) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, null, message, p0);
        }
    }

    public void customError(final String message, final Object p0, final Object p1) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, null, message, p0, p1);
        }
    }

    public void customError(final String message, final Object p0, final Object p1, final Object p2) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, null, message, p0, p1, p2);
        }
    }

    public void customError(final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, null, message, p0, p1, p2, p3);
        }
    }

    public void customError(final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, null, message, p0, p1, p2, p3, p4);
        }
    }

    public void customError(final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, null, message, p0, p1, p2, p3, p4, p5);
        }
    }

    public void customError(final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5, final Object p6) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, null, message, p0, p1, p2, p3, p4, p5, p6);
        }
    }

    public void customError(final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5, final Object p6,
                            final Object p7) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, null, message, p0, p1, p2, p3, p4, p5, p6, p7);
        }
    }

    public void customError(final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5, final Object p6,
                            final Object p7, final Object p8) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, null, message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
        }
    }

    public void customError(final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5, final Object p6,
                            final Object p7, final Object p8, final Object p9) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, null, message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
        }
    }

    public void customError(final String message, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, null, message, t);
        }
    }

    public void customError(final Supplier<?> msgSupplier) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, null, msgSupplier, (Throwable) null);
        }
    }

    public void customError(final Supplier<?> msgSupplier, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, null, msgSupplier, t);
        }
    }

    public void customError(final Marker marker, final Supplier<?> msgSupplier) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, marker, msgSupplier, (Throwable) null);
        }
    }

    public void customError(final Marker marker, final String message, final Supplier<?>... paramSuppliers) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, marker, message, paramSuppliers);
        }
    }

    public void customError(final Marker marker, final Supplier<?> msgSupplier, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, marker, msgSupplier, t);
        }
    }

    public void customError(final String message, final Supplier<?>... paramSuppliers) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, null, message, paramSuppliers);
        }
    }

    public void customError(final Marker marker, final MessageSupplier msgSupplier) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, marker, msgSupplier, (Throwable) null);
        }
    }

    public void customError(final Marker marker, final MessageSupplier msgSupplier, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, marker, msgSupplier, t);
        }
    }

    public void customError(final MessageSupplier msgSupplier) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, null, msgSupplier, (Throwable) null);
        }
    }

    public void customError(final MessageSupplier msgSupplier, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.ERROR, null, msgSupplier, t);
        }
    }

    public void customDebug(final Marker marker, final Message msg) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, marker, msg, (Throwable) null);
        }
    }

    public void customDebug(final Marker marker, final Message msg, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, marker, msg, t);
        }
    }

    public void customDebug(final Marker marker, final Object message) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, marker, message, (Throwable) null);
        }
    }

    public void customDebug(final Marker marker, final CharSequence message) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, marker, message, (Throwable) null);
        }
    }

    public void customDebug(final Marker marker, final Object message, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, marker, message, t);
        }
    }

    public void customDebug(final Marker marker, final CharSequence message, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, marker, message, t);
        }
    }

    public void customDebug(final Marker marker, final String message) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, marker, message, (Throwable) null);
        }
    }

    public void customDebug(final Marker marker, final String message, final Object... params) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, marker, message, params);
        }
    }

    public void customDebug(final Marker marker, final String message, final Object p0) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, marker, message, p0);
        }
    }

    public void customDebug(final Marker marker, final String message, final Object p0, final Object p1) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, marker, message, p0, p1);
        }
    }

    public void customDebug(final Marker marker, final String message, final Object p0, final Object p1, final Object p2) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, marker, message, p0, p1, p2);
        }
    }

    public void customDebug(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, marker, message, p0, p1, p2, p3);
        }
    }

    public void customDebug(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, marker, message, p0, p1, p2, p3, p4);
        }
    }

    public void customDebug(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, marker, message, p0, p1, p2, p3, p4, p5);
        }
    }

    public void customDebug(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5, final Object p6) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, marker, message, p0, p1, p2, p3, p4, p5, p6);
        }
    }

    public void customDebug(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5, final Object p6,
                            final Object p7) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, marker, message, p0, p1, p2, p3, p4, p5, p6, p7);
        }
    }

    public void customDebug(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5, final Object p6,
                            final Object p7, final Object p8) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
        }
    }

    public void customDebug(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5, final Object p6,
                            final Object p7, final Object p8, final Object p9) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
        }
    }

    public void customDebug(final Marker marker, final String message, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, marker, message, t);
        }
    }

    public void customDebug(final Message msg) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, null, msg, (Throwable) null);
        }
    }

    public void customDebug(final Message msg, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, null, msg, t);
        }
    }

    public void customDebug(final Object message) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, null, message, (Throwable) null);
        }
    }

    public void customDebug(final Object message, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, null, message, t);
        }
    }

    public void customDebug(final CharSequence message) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, null, message, (Throwable) null);
        }
    }

    public void customDebug(final CharSequence message, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, null, message, t);
        }
    }

    public void customDebug(final String message) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, null, message, (Throwable) null);
        }
    }

    public void customDebug(final String message, final Object... params) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, null, message, params);
        }
    }

    public void customDebug(final String message, final Object p0) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, null, message, p0);
        }
    }

    public void customDebug(final String message, final Object p0, final Object p1) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, null, message, p0, p1);
        }
    }

    public void customDebug(final String message, final Object p0, final Object p1, final Object p2) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, null, message, p0, p1, p2);
        }
    }

    public void customDebug(final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, null, message, p0, p1, p2, p3);
        }
    }

    public void customDebug(final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, null, message, p0, p1, p2, p3, p4);
        }
    }

    public void customDebug(final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, null, message, p0, p1, p2, p3, p4, p5);
        }
    }

    public void customDebug(final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5, final Object p6) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, null, message, p0, p1, p2, p3, p4, p5, p6);
        }
    }

    public void customDebug(final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5, final Object p6,
                            final Object p7) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, null, message, p0, p1, p2, p3, p4, p5, p6, p7);
        }
    }


    public void customDebug(final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5, final Object p6,
                            final Object p7, final Object p8) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, null, message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
        }
    }

    public void customDebug(final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5, final Object p6,
                            final Object p7, final Object p8, final Object p9) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, null, message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
        }
    }

    public void customDebug(final String message, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, null, message, t);
        }
    }

    public void customDebug(final Supplier<?> msgSupplier) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, null, msgSupplier, (Throwable) null);
        }
    }

    public void customDebug(final Supplier<?> msgSupplier, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, null, msgSupplier, t);
        }
    }

    public void customDebug(final Marker marker, final Supplier<?> msgSupplier) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, marker, msgSupplier, (Throwable) null);
        }
    }

    public void customDebug(final Marker marker, final String message, final Supplier<?>... paramSuppliers) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, marker, message, paramSuppliers);
        }
    }

    public void customDebug(final Marker marker, final Supplier<?> msgSupplier, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, marker, msgSupplier, t);
        }
    }

    public void customDebug(final String message, final Supplier<?>... paramSuppliers) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, null, message, paramSuppliers);
        }
    }

    public void customDebug(final Marker marker, final MessageSupplier msgSupplier) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, marker, msgSupplier, (Throwable) null);
        }
    }

    public void customDebug(final Marker marker, final MessageSupplier msgSupplier, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, marker, msgSupplier, t);
        }
    }

    public void customDebug(final MessageSupplier msgSupplier) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, null, msgSupplier, (Throwable) null);
        }
    }

    public void customDebug(final MessageSupplier msgSupplier, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.DEBUG, null, msgSupplier, t);
        }
    }

    public void customWarn(final Marker marker, final Message msg) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, marker, msg, (Throwable) null);
        }
    }

    public void customWarn(final Marker marker, final Message msg, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, marker, msg, t);
        }
    }

    public void customWarn(final Marker marker, final Object message) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, marker, message, (Throwable) null);
        }
    }

    public void customWarn(final Marker marker, final CharSequence message) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, marker, message, (Throwable) null);
        }
    }

    public void customWarn(final Marker marker, final Object message, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, marker, message, t);
        }
    }

    public void customWarn(final Marker marker, final CharSequence message, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, marker, message, t);
        }
    }

    public void customWarn(final Marker marker, final String message) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, marker, message, (Throwable) null);
        }
    }

    public void customWarn(final Marker marker, final String message, final Object... params) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, marker, message, params);
        }
    }

    public void customWarn(final Marker marker, final String message, final Object p0) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, marker, message, p0);
        }
    }

    public void customWarn(final Marker marker, final String message, final Object p0, final Object p1) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, marker, message, p0, p1);
        }
    }

    public void customWarn(final Marker marker, final String message, final Object p0, final Object p1, final Object p2) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, marker, message, p0, p1, p2);
        }
    }

    public void customWarn(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                           final Object p3) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, marker, message, p0, p1, p2, p3);
        }
    }

    public void customWarn(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                           final Object p3, final Object p4) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, marker, message, p0, p1, p2, p3, p4);
        }
    }

    public void customWarn(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                           final Object p3, final Object p4, final Object p5) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, marker, message, p0, p1, p2, p3, p4, p5);
        }
    }

    public void customWarn(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                           final Object p3, final Object p4, final Object p5, final Object p6) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, marker, message, p0, p1, p2, p3, p4, p5, p6);
        }
    }

    public void customWarn(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                           final Object p3, final Object p4, final Object p5, final Object p6,
                           final Object p7) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, marker, message, p0, p1, p2, p3, p4, p5, p6, p7);
        }
    }

    public void customWarn(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                           final Object p3, final Object p4, final Object p5, final Object p6,
                           final Object p7, final Object p8) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
        }
    }

    public void customWarn(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                           final Object p3, final Object p4, final Object p5, final Object p6,
                           final Object p7, final Object p8, final Object p9) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
        }
    }

    public void customWarn(final Marker marker, final String message, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, marker, message, t);
        }
    }

    public void customWarn(final Message msg) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, null, msg, (Throwable) null);
        }
    }

    public void customWarn(final Message msg, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, null, msg, t);
        }
    }

    public void customWarn(final Object message) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, null, message, (Throwable) null);
        }
    }

    public void customWarn(final Object message, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, null, message, t);
        }
    }

    public void customWarn(final CharSequence message) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, null, message, (Throwable) null);
        }
    }

    public void customWarn(final CharSequence message, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, null, message, t);
        }
    }

    public void customWarn(final String message) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, null, message, (Throwable) null);
        }
    }

    public void customWarn(final String message, final Object... params) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, null, message, params);
        }
    }

    public void customWarn(final String message, final Object p0) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, null, message, p0);
        }
    }

    public void customWarn(final String message, final Object p0, final Object p1) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, null, message, p0, p1);
        }
    }

    public void customWarn(final String message, final Object p0, final Object p1, final Object p2) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, null, message, p0, p1, p2);
        }
    }

    public void customWarn(final String message, final Object p0, final Object p1, final Object p2,
                           final Object p3) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, null, message, p0, p1, p2, p3);
        }
    }

    public void customWarn(final String message, final Object p0, final Object p1, final Object p2,
                           final Object p3, final Object p4) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, null, message, p0, p1, p2, p3, p4);
        }
    }

    public void customWarn(final String message, final Object p0, final Object p1, final Object p2,
                           final Object p3, final Object p4, final Object p5) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, null, message, p0, p1, p2, p3, p4, p5);
        }
    }

    public void customWarn(final String message, final Object p0, final Object p1, final Object p2,
                           final Object p3, final Object p4, final Object p5, final Object p6) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, null, message, p0, p1, p2, p3, p4, p5, p6);
        }
    }

    public void customWarn(final String message, final Object p0, final Object p1, final Object p2,
                           final Object p3, final Object p4, final Object p5, final Object p6,
                           final Object p7) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, null, message, p0, p1, p2, p3, p4, p5, p6, p7);
        }
    }


    public void customWarn(final String message, final Object p0, final Object p1, final Object p2,
                           final Object p3, final Object p4, final Object p5, final Object p6,
                           final Object p7, final Object p8) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, null, message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
        }
    }

    public void customWarn(final String message, final Object p0, final Object p1, final Object p2,
                           final Object p3, final Object p4, final Object p5, final Object p6,
                           final Object p7, final Object p8, final Object p9) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, null, message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
        }
    }

    public void customWarn(final String message, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, null, message, t);
        }
    }

    public void customWarn(final Supplier<?> msgSupplier) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, null, msgSupplier, (Throwable) null);
        }
    }

    public void customWarn(final Supplier<?> msgSupplier, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, null, msgSupplier, t);
        }
    }

    public void customWarn(final Marker marker, final Supplier<?> msgSupplier) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, marker, msgSupplier, (Throwable) null);
        }
    }

    public void customWarn(final Marker marker, final String message, final Supplier<?>... paramSuppliers) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, marker, message, paramSuppliers);
        }
    }

    public void customWarn(final Marker marker, final Supplier<?> msgSupplier, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, marker, msgSupplier, t);
        }
    }

    public void customWarn(final String message, final Supplier<?>... paramSuppliers) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, null, message, paramSuppliers);
        }
    }

    public void customWarn(final Marker marker, final MessageSupplier msgSupplier) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, marker, msgSupplier, (Throwable) null);
        }
    }

    public void customWarn(final Marker marker, final MessageSupplier msgSupplier, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, marker, msgSupplier, t);
        }
    }

    public void customWarn(final MessageSupplier msgSupplier) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, null, msgSupplier, (Throwable) null);
        }
    }

    public void customWarn(final MessageSupplier msgSupplier, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.WARN, null, msgSupplier, t);
        }
    }

    public void customTrace(final Marker marker, final Message msg) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, marker, msg, (Throwable) null);
        }
    }

    public void customTrace(final Marker marker, final Message msg, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, marker, msg, t);
        }
    }

    public void customTrace(final Marker marker, final Object message) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, marker, message, (Throwable) null);
        }
    }

    public void customTrace(final Marker marker, final CharSequence message) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, marker, message, (Throwable) null);
        }
    }

    public void customTrace(final Marker marker, final Object message, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, marker, message, t);
        }
    }

    public void customTrace(final Marker marker, final CharSequence message, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, marker, message, t);
        }
    }

    public void customTrace(final Marker marker, final String message) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, marker, message, (Throwable) null);
        }
    }

    public void customTrace(final Marker marker, final String message, final Object... params) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, marker, message, params);
        }
    }

    public void customTrace(final Marker marker, final String message, final Object p0) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, marker, message, p0);
        }
    }

    public void customTrace(final Marker marker, final String message, final Object p0, final Object p1) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, marker, message, p0, p1);
        }
    }

    public void customTrace(final Marker marker, final String message, final Object p0, final Object p1, final Object p2) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, marker, message, p0, p1, p2);
        }
    }

    public void customTrace(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, marker, message, p0, p1, p2, p3);
        }
    }

    public void customTrace(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, marker, message, p0, p1, p2, p3, p4);
        }
    }

    public void customTrace(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, marker, message, p0, p1, p2, p3, p4, p5);
        }
    }

    public void customTrace(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5, final Object p6) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, marker, message, p0, p1, p2, p3, p4, p5, p6);
        }
    }

    public void customTrace(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5, final Object p6,
                            final Object p7) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, marker, message, p0, p1, p2, p3, p4, p5, p6, p7);
        }
    }

    public void customTrace(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5, final Object p6,
                            final Object p7, final Object p8) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
        }
    }

    public void customTrace(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5, final Object p6,
                            final Object p7, final Object p8, final Object p9) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
        }
    }

    public void customTrace(final Marker marker, final String message, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, marker, message, t);
        }
    }

    public void customTrace(final Message msg) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, null, msg, (Throwable) null);
        }
    }

    public void customTrace(final Message msg, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, null, msg, t);
        }
    }

    public void customTrace(final Object message) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, null, message, (Throwable) null);
        }
    }

    public void customTrace(final Object message, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, null, message, t);
        }
    }

    public void customTrace(final CharSequence message) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, null, message, (Throwable) null);
        }
    }

    public void customTrace(final CharSequence message, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, null, message, t);
        }
    }

    public void customTrace(final String message) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, null, message, (Throwable) null);
        }
    }

    public void customTrace(final String message, final Object... params) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, null, message, params);
        }
    }

    public void customTrace(final String message, final Object p0) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, null, message, p0);
        }
    }

    public void customTrace(final String message, final Object p0, final Object p1) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, null, message, p0, p1);
        }
    }

    public void customTrace(final String message, final Object p0, final Object p1, final Object p2) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, null, message, p0, p1, p2);
        }
    }

    public void customTrace(final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, null, message, p0, p1, p2, p3);
        }
    }

    public void customTrace(final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, null, message, p0, p1, p2, p3, p4);
        }
    }

    public void customTrace(final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, null, message, p0, p1, p2, p3, p4, p5);
        }
    }

    public void customTrace(final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5, final Object p6) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, null, message, p0, p1, p2, p3, p4, p5, p6);
        }
    }

    public void customTrace(final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5, final Object p6,
                            final Object p7) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, null, message, p0, p1, p2, p3, p4, p5, p6, p7);
        }
    }


    public void customTrace(final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5, final Object p6,
                            final Object p7, final Object p8) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, null, message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
        }
    }

    public void customTrace(final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5, final Object p6,
                            final Object p7, final Object p8, final Object p9) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, null, message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
        }
    }

    public void customTrace(final String message, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, null, message, t);
        }
    }

    public void customTrace(final Supplier<?> msgSupplier) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, null, msgSupplier, (Throwable) null);
        }
    }

    public void customTrace(final Supplier<?> msgSupplier, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, null, msgSupplier, t);
        }
    }

    public void customTrace(final Marker marker, final Supplier<?> msgSupplier) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, marker, msgSupplier, (Throwable) null);
        }
    }

    public void customTrace(final Marker marker, final String message, final Supplier<?>... paramSuppliers) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, marker, message, paramSuppliers);
        }
    }

    public void customTrace(final Marker marker, final Supplier<?> msgSupplier, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, marker, msgSupplier, t);
        }
    }

    public void customTrace(final String message, final Supplier<?>... paramSuppliers) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, null, message, paramSuppliers);
        }
    }

    public void customTrace(final Marker marker, final MessageSupplier msgSupplier) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, marker, msgSupplier, (Throwable) null);
        }
    }

    public void customTrace(final Marker marker, final MessageSupplier msgSupplier, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, marker, msgSupplier, t);
        }
    }

    public void customTrace(final MessageSupplier msgSupplier) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, null, msgSupplier, (Throwable) null);
        }
    }

    public void customTrace(final MessageSupplier msgSupplier, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.TRACE, null, msgSupplier, t);
        }
    }

    public void customFatal(final Marker marker, final Message msg) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, marker, msg, (Throwable) null);
        }
    }

    public void customFatal(final Marker marker, final Message msg, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, marker, msg, t);
        }
    }

    public void customFatal(final Marker marker, final Object message) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, marker, message, (Throwable) null);
        }
    }

    public void customFatal(final Marker marker, final CharSequence message) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, marker, message, (Throwable) null);
        }
    }

    public void customFatal(final Marker marker, final Object message, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, marker, message, t);
        }
    }

    public void customFatal(final Marker marker, final CharSequence message, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, marker, message, t);
        }
    }

    public void customFatal(final Marker marker, final String message) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, marker, message, (Throwable) null);
        }
    }

    public void customFatal(final Marker marker, final String message, final Object... params) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, marker, message, params);
        }
    }

    public void customFatal(final Marker marker, final String message, final Object p0) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, marker, message, p0);
        }
    }

    public void customFatal(final Marker marker, final String message, final Object p0, final Object p1) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, marker, message, p0, p1);
        }
    }

    public void customFatal(final Marker marker, final String message, final Object p0, final Object p1, final Object p2) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, marker, message, p0, p1, p2);
        }
    }

    public void customFatal(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, marker, message, p0, p1, p2, p3);
        }
    }

    public void customFatal(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, marker, message, p0, p1, p2, p3, p4);
        }
    }

    public void customFatal(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, marker, message, p0, p1, p2, p3, p4, p5);
        }
    }

    public void customFatal(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5, final Object p6) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, marker, message, p0, p1, p2, p3, p4, p5, p6);
        }
    }

    public void customFatal(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5, final Object p6,
                            final Object p7) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, marker, message, p0, p1, p2, p3, p4, p5, p6, p7);
        }
    }

    public void customFatal(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5, final Object p6,
                            final Object p7, final Object p8) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
        }
    }

    public void customFatal(final Marker marker, final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5, final Object p6,
                            final Object p7, final Object p8, final Object p9) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
        }
    }

    public void customFatal(final Marker marker, final String message, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, marker, message, t);
        }
    }

    public void customFatal(final Message msg) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, null, msg, (Throwable) null);
        }
    }

    public void customFatal(final Message msg, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, null, msg, t);
        }
    }

    public void customFatal(final Object message) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, null, message, (Throwable) null);
        }
    }

    public void customFatal(final Object message, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, null, message, t);
        }
    }

    public void customFatal(final CharSequence message) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, null, message, (Throwable) null);
        }
    }

    public void customFatal(final CharSequence message, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, null, message, t);
        }
    }

    public void customFatal(final String message) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, null, message, (Throwable) null);
        }
    }

    public void customFatal(final String message, final Object... params) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, null, message, params);
        }
    }

    public void customFatal(final String message, final Object p0) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, null, message, p0);
        }
    }

    public void customFatal(final String message, final Object p0, final Object p1) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, null, message, p0, p1);
        }
    }

    public void customFatal(final String message, final Object p0, final Object p1, final Object p2) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, null, message, p0, p1, p2);
        }
    }

    public void customFatal(final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, null, message, p0, p1, p2, p3);
        }
    }

    public void customFatal(final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, null, message, p0, p1, p2, p3, p4);
        }
    }

    public void customFatal(final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, null, message, p0, p1, p2, p3, p4, p5);
        }
    }

    public void customFatal(final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5, final Object p6) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, null, message, p0, p1, p2, p3, p4, p5, p6);
        }
    }

    public void customFatal(final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5, final Object p6,
                            final Object p7) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, null, message, p0, p1, p2, p3, p4, p5, p6, p7);
        }
    }


    public void customFatal(final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5, final Object p6,
                            final Object p7, final Object p8) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, null, message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
        }
    }

    public void customFatal(final String message, final Object p0, final Object p1, final Object p2,
                            final Object p3, final Object p4, final Object p5, final Object p6,
                            final Object p7, final Object p8, final Object p9) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, null, message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
        }
    }

    public void customFatal(final String message, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, null, message, t);
        }
    }

    public void customFatal(final Supplier<?> msgSupplier) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, null, msgSupplier, (Throwable) null);
        }
    }

    public void customFatal(final Supplier<?> msgSupplier, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, null, msgSupplier, t);
        }
    }

    public void customFatal(final Marker marker, final Supplier<?> msgSupplier) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, marker, msgSupplier, (Throwable) null);
        }
    }

    public void customFatal(final Marker marker, final String message, final Supplier<?>... paramSuppliers) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, marker, message, paramSuppliers);
        }
    }

    public void customFatal(final Marker marker, final Supplier<?> msgSupplier, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, marker, msgSupplier, t);
        }
    }

    public void customFatal(final String message, final Supplier<?>... paramSuppliers) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, null, message, paramSuppliers);
        }
    }

    public void customFatal(final Marker marker, final MessageSupplier msgSupplier) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, marker, msgSupplier, (Throwable) null);
        }
    }

    public void customFatal(final Marker marker, final MessageSupplier msgSupplier, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, marker, msgSupplier, t);
        }
    }

    public void customFatal(final MessageSupplier msgSupplier) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, null, msgSupplier, (Throwable) null);
        }
    }

    public void customFatal(final MessageSupplier msgSupplier, final Throwable t) {
        if (LogUtil.isEligibleForEnhancedLogging()) {
            logger.logIfEnabled(FQCN, Level.FATAL, null, msgSupplier, t);
        }
    }
}

