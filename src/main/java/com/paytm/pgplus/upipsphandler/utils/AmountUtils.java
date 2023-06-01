package com.paytm.pgplus.upipsphandler.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public abstract class AmountUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(com.paytm.pgplus.pgproxycommon.utils.AmountUtils.class);
    private static final Double MONEY_MULTIPLER_CONSTANT = 100.0;
    private static ThreadLocal<NumberFormat> numberFormatStore = new ThreadLocal();
    private static ThreadLocal<NumberFormat> numberFormatRequestStore = new ThreadLocal();

    public AmountUtils() {
    }

//    public static String getTransactionAmountForResponse(Double transactionAmount) {
//        return transactionAmount != null ? getTransactionAmountInRupee(transactionAmount.toString()) : null;
//    }
//
//    public static double getAmountInRs(Double amountInPaise) {
//        return amountInPaise == null ? 0.0 : Double.parseDouble(getTransactionAmountInRupee(String.valueOf(amountInPaise)));
//    }
//
//    public static double getAmountInPaise(Double amountInRs) {
//        return amountInRs == null ? 0.0 : Double.parseDouble(getTransactionAmountInPaise(String.valueOf(amountInRs)));
//    }

    public static String getTransactionAmountInRupee(String transactionAmount) {
        try {
            if (NumberUtils.isNumber(transactionAmount)) {
                double txnAmount = Double.parseDouble(transactionAmount);
                txnAmount /= MONEY_MULTIPLER_CONSTANT;
                String formattedTxnAmount = format(txnAmount);
                LOGGER.debug("Formatted Txn Amount is :: {}", formattedTxnAmount);
                return formattedTxnAmount;
            }
        } catch (Exception var4) {
            LOGGER.error("Error in parsing the txnAmount : {}", transactionAmount);
        }

        return transactionAmount;
    }

//    public static String getPaddedTransactionAmountInRupee(String transactionAmount) {
//        if (NumberUtils.isNumber(transactionAmount)) {
//            String formattedTxnAmount = getTransactionAmountInRupee(transactionAmount);
//            return formattedTxnAmount.startsWith(".") ? "0" + formattedTxnAmount : formattedTxnAmount;
//        } else {
//            return transactionAmount;
//        }
//    }

//    public static String getTransactionAmountInPaise(String transactionAmount) {
//        if (NumberUtils.isNumber(transactionAmount)) {
//            double txnAmount = Double.parseDouble(transactionAmount);
//            txnAmount *= MONEY_MULTIPLER_CONSTANT;
//            String formattedTxnAmount = formatForRequest(txnAmount);
//            LOGGER.debug("Formatted Txn Amount is :: {}", formattedTxnAmount);
//            return formattedTxnAmount;
//        } else {
//            return transactionAmount;
//        }
//    }

    public static String formatNumberToTwoDecimalPlaces(String transactionAmount) {
        if (NumberUtils.isNumber(transactionAmount)) {
            String formattedTxnAmount = format(Double.parseDouble(transactionAmount));
            LOGGER.debug("Formatted Txn Amount is :: {}", formattedTxnAmount);
            return formattedTxnAmount.startsWith(".") ? "0" + formattedTxnAmount : formattedTxnAmount;
        } else {
            return transactionAmount;
        }
    }

    private static String format(double txnAmount) {
        return getNumberFormat().format(txnAmount).replaceAll(",", "").replaceFirst("^0+(?!$)", "");
    }
//
//    private static String formatForRequest(double txnAmount) {
//        return getNumberFormatForRequest().format(txnAmount).replaceAll(",", "").replaceFirst("^0+(?!$)", "");
//    }
//
//    public static Long getAmount(String amount) {
//        return Long.parseLong(amount);
//    }

    private static NumberFormat getNumberFormat() {
        NumberFormat threadSafeNumberFormat = (NumberFormat)numberFormatStore.get();
        if (threadSafeNumberFormat == null) {
            threadSafeNumberFormat = NumberFormat.getInstance();
            threadSafeNumberFormat.setMaximumFractionDigits(2);
            threadSafeNumberFormat.setMinimumFractionDigits(2);
            threadSafeNumberFormat.setMinimumIntegerDigits(1);
            numberFormatStore.set(threadSafeNumberFormat);
        }

        return threadSafeNumberFormat;
    }

//    private static NumberFormat getNumberFormatForRequest() {
//        NumberFormat threadSafeNumberFormat = (NumberFormat)numberFormatRequestStore.get();
//        if (threadSafeNumberFormat == null) {
//            threadSafeNumberFormat = NumberFormat.getInstance();
//            threadSafeNumberFormat.setMaximumFractionDigits(0);
//            threadSafeNumberFormat.setMinimumFractionDigits(0);
//            numberFormatRequestStore.set(threadSafeNumberFormat);
//        }
//
//        return threadSafeNumberFormat;
//    }

//    public static String getOfferAmountInPercentage(String offerAmount, String totalAmount) {
//        if (!StringUtils.isEmpty(offerAmount) && !StringUtils.isEmpty(totalAmount) && Double.valueOf(totalAmount) > 0.0) {
//            double cashback = Double.parseDouble(offerAmount) * MONEY_MULTIPLER_CONSTANT;
//            double totalTransactionAmount = Double.parseDouble(totalAmount);
//            double percentage = cashback / totalTransactionAmount;
//            BigDecimal bd = (new BigDecimal(percentage)).setScale(2, RoundingMode.DOWN);
//            double formattedPercentage = bd.doubleValue();
//            String formattedTxnAmount = String.valueOf(formattedPercentage);
//            return formattedTxnAmount;
//        } else {
//            return null;
//        }
//    }
}

