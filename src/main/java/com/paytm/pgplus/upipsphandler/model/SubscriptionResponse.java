package com.paytm.pgplus.upipsphandler.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.transaction.TransactionStatus;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionResponse implements Serializable {
    private static final long serialVersionUID = -6262470270585038991L;
    private String mid;
    private String txnId;
    private String orderId;
    private String txnAmount;
    private String txnDate;
    private String respCode;
    private String respMsg;
    private TransactionStatus status;
    private String subscriptionId;
//    private SubsPaymentMode paymentMode;
    private String payerUserID;
    private String payerAccountNumber;
    private String savedCardID;
    private String subscriptionExpiryDate;
    private String website;
    private String industryType;
    private String subsFreq;
    private String subsFreqUnit;
    private String userEmail;
    private String userMobile;
    private String custId;
    private String serviceId;
    private String accountType;
    private String merchantUniqueReference;
    private String nextDueDate;
//    private BankMandateInfo mandateInfo;
    private String subsStartDate;
    private boolean autoRenewalStatus;
    private boolean autoRetryStatus;
    private boolean communicationManagerStatus;
    private boolean orderCreated;
    private int graceDays;
    private String subsCallbackUrl;
//    private SubscriptionUpiInfo subscriptionUpiInfo;
    private String cardIndexNumber;
    private Integer orderActiveDays;
    private Boolean isOrderInactiveTimeOutEnabled;
    private String subsPurpose;
    private String subsMaxAmount;
    private String paymentMid;
    private String paymentOrderId;
    private boolean flexiSubscription;
    private String amountType;
    private String subsRenewalAmount;
    private String trialDays;
    private String planName;
    private String planDesc;
    private boolean siHubMode;
//    private SiHubDetails siHubDetails;
    private int totalPaymentCount;
}
