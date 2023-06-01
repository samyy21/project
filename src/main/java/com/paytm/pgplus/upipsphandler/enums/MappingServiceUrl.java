package com.paytm.pgplus.upipsphandler.enums;

import com.paytm.pgplus.cache.model.*;
import com.paytm.pgplus.cache.model.MerchantPreference;
import com.paytm.pgplus.cache.model.MerchantSubscriptionDetails;
import com.paytm.pgplus.cache.model.logo.PaytmLogoResponse;
import com.paytm.pgplus.cache.model.routing.manual.ManualRoutingConfigInfoResponse;
import com.paytm.pgplus.facade.boss.models.response.ContractDetailsQueryResponseBody;
import com.paytm.pgplus.facade.boss.models.response.ContractDetailsResponse;
import com.paytm.pgplus.mappingserviceclient.model.MerchantLimitResponse;
import com.paytm.pgplus.mappingserviceclient.model.MerchantRequestTypes;

import java.util.List;
import java.util.Map;

/**
 * @author amitdubey , kartik
 * @date Nov 5, 2016
 */
public enum MappingServiceUrl {

    GET_BIN_DETAIL_URL("/get/bankcard/bin/", false, BinDetail.class), GET_RESPONSE_CODE_URL_ALIPAY(
            "/get/responsecodedetails/resultcode/", false, ResponseCodeDetails.class), FETCH_MERCHANT_DATA(
            "/merchant/get/extended/info/", false, ExtendedInfo.class), GET_RESPONSE_CODE_URL_PAYTM(
            "/get/responsecodedetails/", false, ResponseCodeDetails.class), FETCH_PREFERENCE_DATA(
            "/merchant/get/preference/info/", false, PerfernceInfo.class), MERCHANT_MAPPING("/merchant/v1/paytm/",
            true, MerchantData.class), MERCHANT_INFO_LIST("/merchant/v1/paytm/merchantIdList", false,
            MerchantInfoResponse.class), MERCHANT_IDENTITY_MAPPING("/merchant/idmap/", false,
            MerchantIdentityInfo.class), MERCHANT_PROFILE("/merchant/profile/$MERCHANT_PAYTM_ID/paytm", false,
            com.paytm.pgplus.facade.merchant.models.MerchantInfo.class), BANK_INFO("/get/bankdetails/", false,
            BankMasterDetails.class), MERCHANT_URL_INFO("/get/entityurlinformid/", false, MerchantUrlInfo.class), FETCH_EMAIL_CONFIGURATION(
            "/config/email/", false, EmailConfigDetail.class), FETCH_PROPERTY_CONFIG("/config/properties/", false,
            PropertyData.class), FETCH_PROPERTY_CONFIGNT_ID("/config/properties/parentid/", false, PropertyData.class), ADD_PARENT_DATA(
            "/config/properties/addconfig/", false, PropertiesConfigDetail.class), ADD_OR_EDIT_CHILD_DATA(
            "/config/properties/addorupdatekey/", false, PropertyConfig.class), GET_USER_MAPPING_URL("/user/v1/", true,
            UserData.class), MERCHANT_OFFER_DETAILS("/get/entityofferdetailsformid/", false, MerchantOfferDetails.class), GET_PAYTM_PROPERTY(
            "/get/paytmproperties/", false, PaytmProperty.class), SUB_WALLET_INFO("/get/subwalletdetails/", false,
            SubWalletDetails.class), CUSTOM_PAYLOAD_DATA("/get/customPayload/", false, CustomPayloadList.class), GET_PAYTM_DEFAULT_VALUES(
            "/get/paytmDefaultValue/", false, PaytmDefaultValues.class), GET_PAYTM_DEFAULT_VALUES_LIST(
            "/get/paytmDefaultValueList/", false, PaytmDefaultValuesList.class), GET_EMI_VALID_BINS(
            "/get/fetchValidBins/", false, EMIValidBins.class), GET_ENTITY_IGNORE_PARAMS(
            "/get/fetchEntityIgnoreParams/", false, EntityIgnoreParamsResponse.class), FETCH_TXNLIMIT_DATA(
            "/merchant/get/txnlimit/info/", true, MerchantTxnLimitInfoResponse.class), MERCHANT_AGENT_MAPPING(
            "/merchantAgent/get/agentInfo/{id}/{type}", false, List.class), MERCHANT_AGENT_MAPPING_WITH_PARENT(
            "/merchantAgent/get/agentInfo/{id}/{type}?parentMid={parentMid}", false, List.class), DYNAMIC_WRAPPER_CONFIGS(
            "/get/dynamicWrapperConfigs", false, DynamicWrapperConfigList.class), GET_MERCHANT_MAPPING_INFO(
            "/merchant/idmap/$MERCHANT_GUID/guid", false, MerchantMappingInfo.class), GET_MERCHANT_PROFILE(
            "/merchant/profile/${PAYTM_MID}/paytm", false, MerchantProfile.class), FETCH_MERCHANT_KYC_INFO(
            "/get/merchantKycInfo/", false, MerchantKycInfo.class), GET_LOOKUP_INFO("/get/lookup/", false,
            LookupDataDetails.class), GET_MBID_INFO("/get/mbid", false, MBIdConfiguration.class), BANK_INFO_LIST(
            "/get/banksdetailslistfromids/", false, BankMasterDetails.class), BANK_INFO_LIST_FROM_BANKIDS(
            "/get/banksdetailslistfromids/", false, BankMasterDetails.class), BANK_INFO_LIST_FROM_BANKCODEDS(
            "/get/banksdetailslistfromCodes/", false, BankMasterDetails.class), MBID_INFO("/get/mbidlimit/id/", false,
            MBIDLimitMappingDetails.class), GET_CREDITCARD_ENTITY_DETAIL("/get/creditcardentity/", false,
            CreditCardEntityDetail.class), GET_CREDITCARD_IFSC_DETAIL("/get/creditcardifsc/", false, IfscDetails.class), GET_ENTITY_DISPLAY_INFO(
            "/get/entitydisplayinfo/", false, Map.class), GET_MERCHANT_LOGO_DETAILS("/get/merchantlogoinfo/", false,
            MerchantBussinessLogoInfo.class), GET_MERCHANT_LOGO_DETAILS_V2("/get/merchantlogoinfo/v2/", false,
            MerchantBussinessLogoInfo.class), MERCHANT_URL_INFO_V2("/get/entityurlinformid/v2/", false,
            MerchantUrlInfo.class), MERCHANT_API_URL_INFO("/get/merchantapiurlinfo/", false,
            MerchantApiUrlInfoResponse.class), GET_BIN_DETAIL_WITH_DISPLAY_NAME_URL("/get/bankcard/v1/bin/", false,
            BinDetailWithDisplayName.class), GET_EMI_ON_DC_ELIGIBILITY_DETAILS("/get/emiOnDcEligibilityBy?contact=",
            false, EmiOnDcResponse.class), GET_ENTITY_WALLET_INFO_NAME_URL("/query/merchant/walletInfo/", false,
            EntityWalletInfo.class), GET_BP_UNIQUE_ID_URL("/get/bp/uniqueid/", false, BpUniqueIdDetails.class), GET_MANUAL_ROUTING_INFO_URL(
            "/v2/merchant/get/manual/routing/config", false, ManualRoutingConfigInfoResponse.class), GET_PAYMENT_GATEWAY_INFO_URL(
            "/v1/gateways/static", false, List.class), GET_EMI_DETAILS_BY_MID("/get/mbidlimit/emiPlan", false,
            EMIDetailList.class), FETCH_USER_MERCHANT_EXTENDED_INFO("/user/getMerchantExtendedInfo/", false,
            ExtendedInfo.class), GET_EDC_DEVICE_DETAIL_TID("/eos/merchant/device/details/v2/tid/", true,
            EdcDeviceDetail.class), GET_EDC_DEVICE_DETAIL_TID_BANK("/eos/merchant/device/details/tid/bankName/", true,
            EdcDeviceMapping.class), GET_EDC_DEVICE_DETAIL_TID_LIST("/eos/merchant/device/details/bankslist/tid/",
            false, EdcDeviceDetailListResponse.class), GET_EDC_DEVICE_ACTIVE_ACQUIRINGS_TID(
            "/eos/merchant/device/activeAcquirings/tid/", true, EdcActiveAcquiring.class), FETCH_USER_MID(
            "/user/getUserMid/", false, UserMerchantInfo.class), FETCH_CONTRACT_DETAILS(
            "/merchant/query/contract/detail/", true, ContractDetailsQueryResponseBody.class), GET_PAYMETHOD_DETAILS(
            "/get/paymethodDetails/payMethod", false, PayMethodDetailsResponse.class), GET_CARD_NETWORK_DETAILS(
            "/get/cardNetworkDetails/cardNetwork", false, PayMethodDetailsResponse.class), GET_BANK_DETAILS(
            "/get/bankDetails/bank", false, BankDetailsResponse.class), BANK_MASTER("/get/bankmasterdetails", false,
            BankMasterDetails.class), BANK_MASTER_BY_PAY_MODE("/get/bankmasterdetails/paymode/", false,
            BankMasterDetails.class), GET_CONFIGURABLE_MID_LIST("/merchant/midList/{category}/{midType}", false,
            CustomPayoutResponse.class), GET_BANK_RESPONSE_CODE(
            "/get/bankresponsecodes/{bankCode}/{payMode}/{service}", false, BankResponseCodeDetails.class), MERCHANT_PREFERENCE_EXT(
            "/merchant/get/preferenceinfosext/", false, PerfernceInfo.class), GET_MERCHANT_THEMATIC_PREFRENCE_DETAILS(
            "/merchant/get/thematic/details/", false, ThematicPreferenceDetails.class), FETCH_NOTIFICATION_TEMPLATES(
            "/notification/get/notification/template", false, NotificationTemplates.class), MERCHANT_REQUEST_TYPES(
            "/get/merchantRequestTypes/{midType}/{paytmMid}", false, MerchantRequestTypes.class), GLOBAL_CONFIG(
            "/get/limit/merchantType/{key}", false, MerchantLimitResponse.class), MERCHANT_PROFILE_ALIPAY(
            "/merchant/profile/$MERCHANT_ALIPAY_ID/alipay", false,
            com.paytm.pgplus.facade.merchant.models.MerchantInfo.class), GET_TOKEN_DETAIL_URL("/get/bankcard/token/",
            false, BinDetail.class), GET_SUPPORTED_CURRENCIES_ACQUIRER("/dcc/supportedCurrencyList/acquirer/", false,
            AcquirerCurrencyDetails.class), GET_EMI_BRAND_DETAILS(
            "/query/merchant/brand/emi/{mid}?brandCodes={brandCodes}", true, EmiBrandSubventionPlan.class), FETCH_MERCHANT_ATTRIBUTE(
            "/merchant/fetch/attribute/", true, String.class), GET_IFSC_CODE_DETAILS("/get/ifsc/details/", false,
            IfscCodeDetails.class), MISC_ATTRIBUTE_INFO("/misc/attribute/{typeName}/{queryType}/{queryValue}", true,
            MiscAttributeInfo.class), RESELLER_MASTER_INFO("/reseller/master/mid/", true, ResellerMasterInfo.class), GET_CARD_TOKEN_INFO(
            "/coft/trid/mid/{mid}?cardScheme={cardScheme}&status={status}", true, CardTokenRequesterResponse.class), GET_MERCHANT_GATEWAY_CONFIG_VIA_AOA_MID(
            "/aoa/merchant/get/gateway/config/getByAoaMid/{merchantId}", false, RestResponse.class), GET_MERCHANT_GATEWAY_CONFIG_VIA_AOA_MID_GATEWAY_NAME(
            "/aoa/merchant/get/gateway/config/getByAoaMidGatewayName/{merchantId}/{gatewayName}", false,
            RestResponse.class), GET_BY_GATEWAY_MID("/aoa/merchant/get/gateway/config/getByGatewayMid/{merchantId}",
            false, RestResponse.class), GET_MERCHANT_GATEWAY_CONFIG_VIA_MID_GATEWAY_NAME(
            "/aoa/merchant/get/gateway/config/getByGatewayMidName/{merchantId}/{gatewayName}", true,
            AoaGatewayConfigInfoResponse.class), GET_TEMPLATE_CONFIG(
            "/notification/template/config/{mid}/{serviceType}/{bankCode}?clientName={clientName}", true,
            EmailTemplateInfo.class), FETCH_PAYTM_LOGO_WITH_SUB_ID("/logo/fetch/{logoType}/{identifier}?subId={subId}",
            false, PaytmLogoResponse.class), FETCH_PAYTM_LOGO("/logo/fetch/{logoType}/{identifier}", false,
            PaytmLogoResponse.class), GET_PAYTM_MID("/get/paytmid/", false, MerchantData.class), GET_MERCHANT_IDENTITY_INFO(
            "/merchant/v1/{type}/{merchantId}", true, MerchantIdentityInfo.class), GET_MERCHANT_SUBSCRIPTION_DETAILS(
            "/merchant/attribute/get/subscription/detail/{merchantId}/{idType}", false,
            MerchantSubscriptionDetails.class), GET_MERCHANT_PREFERENCE(
            "/merchant/attribute/preference/{merchantId}/{idType}", false, MerchantPreference.class), GET_MERCHANT_KEYS(
            "/merchant/attribute/key/{merchantId}/{idType}/paymode/{payMode}", false, MerchantKeysList.class), GET_MERCHANT_CONTRACT_DETAILS(
            "/query/merchant/migration/contract/details/{mid}", false, ContractDetailsResponse.class), GET_MERCHANT_CONRACT_WITH_PRODUCT_CODE(
            "/merchant/query/contract/detail/{merchantId}/{contractStatus}/{productCode}", true,
            ContractDetailsQueryResponseBody.class), GET_MERCHANT_RESPONSE_CODE_MAPPING_DETAIL(
            "/merchantResponseCode/mid/resultCode/{mid}/{resultCode}", true, MerchantResponseCodeMappingDetail.class), GET_COBRANDING_RECEIPT_INFO(
            "/logo/cobranding/mid/{mid}/channel/{channel}", true, CobrandingReceiptInfo.class), GET_VENDOR_INFO_DETAILS(
            "/get/vendor/splitDetails/", true, VendorParentDetails.class), GET_MERCHANT_STATIC_CONFIG(
            "/get/merchant/static/config/", true, MerchantStaticConfig.class), GET_PSP_SCHEMA(
            "/get/pspSchema", true, PspSchemaResponseBody.class), GET_ENTITY_EDC_CHANNEL_INFO(
            "/entityEdcChannelInfo/mid/{mid}?isExtMid={isExtMid}", true, EntityEdcChannelResponse.class), GET_MERCHANT_BLOCK_FILTERS("/get/merchant/block/config/{mid}", true, MerchantBlockFilters.class);


    private String url;
    private boolean isWrapped;
    private Class<?> cacheClass;

    private MappingServiceUrl(final String url, final boolean isWrapped, final Class<?> cacheClass) {
        this.url = url;
        this.isWrapped = isWrapped;
        this.cacheClass = cacheClass;
    }

    public String getUrl() {
        return url;
    }

    public boolean isWrapped() {
        return isWrapped;
    }

    public Class<?> getCacheClass() {
        return cacheClass;
    }
}
