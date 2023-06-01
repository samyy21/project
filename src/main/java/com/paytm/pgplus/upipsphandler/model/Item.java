package com.paytm.pgplus.upipsphandler.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.beans.ConstructorProperties;
import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class Item implements Serializable {
    private static final long serialVersionUID = 351093401121615081L;
    private String id;
    private String productId;
    private String brandId;
    private List<String> categoryList;
    private String merchantId;
    private String model;
    private String ean;
    private Double price;
    private Double listingPrice;
    private int quantity;
    private String discoverability;
    private String verticalId;
    private Boolean isPhysical;
    private Boolean isEmiEnabled;
    private OfferDetail offerDetails;
    private Boolean isStandardEmi;
    private double originalPrice;

    public Item(Boolean isStandardEmi, Boolean isPhysical, Boolean isEmiEnabled, String productId, String id, double listingPrice, double price, int quantity) {
        this.isStandardEmi = isStandardEmi;
        this.isPhysical = isPhysical;
        this.productId = productId;
        this.isEmiEnabled = isEmiEnabled;
        this.id = id;
        this.price = price;
        this.listingPrice = listingPrice;
        this.quantity = quantity;
    }

    public Item(Item item) {
        this.id = item.id;
        this.productId = item.productId;
        this.brandId = item.brandId;
        this.categoryList = item.categoryList;
        this.merchantId = item.merchantId;
        this.model = item.model;
        this.ean = item.ean;
        this.price = item.price;
        this.listingPrice = item.listingPrice;
        this.quantity = item.quantity;
        this.discoverability = item.discoverability;
        this.verticalId = item.verticalId;
        this.isPhysical = item.isPhysical;
        this.isEmiEnabled = item.isEmiEnabled;
        this.offerDetails = item.offerDetails;
        this.isStandardEmi = item.isStandardEmi;
        this.originalPrice = item.originalPrice;
    }

    public String getId() {
        return this.id;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getBrandId() {
        return this.brandId;
    }

    public List<String> getCategoryList() {
        return this.categoryList;
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public String getModel() {
        return this.model;
    }

    public String getEan() {
        return this.ean;
    }

    public Double getPrice() {
        return this.price;
    }

    public Double getListingPrice() {
        return this.listingPrice;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getDiscoverability() {
        return this.discoverability;
    }

    public String getVerticalId() {
        return this.verticalId;
    }

    public Boolean getIsPhysical() {
        return this.isPhysical;
    }

    public Boolean getIsEmiEnabled() {
        return this.isEmiEnabled;
    }

    public OfferDetail getOfferDetails() {
        return this.offerDetails;
    }

    public Boolean getIsStandardEmi() {
        return this.isStandardEmi;
    }

    public double getOriginalPrice() {
        return this.originalPrice;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public void setCategoryList(List<String> categoryList) {
        this.categoryList = categoryList;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setListingPrice(Double listingPrice) {
        this.listingPrice = listingPrice;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDiscoverability(String discoverability) {
        this.discoverability = discoverability;
    }

    public void setVerticalId(String verticalId) {
        this.verticalId = verticalId;
    }

    public void setIsPhysical(Boolean isPhysical) {
        this.isPhysical = isPhysical;
    }

    public void setIsEmiEnabled(Boolean isEmiEnabled) {
        this.isEmiEnabled = isEmiEnabled;
    }

    public void setOfferDetails(OfferDetail offerDetails) {
        this.offerDetails = offerDetails;
    }

    public void setIsStandardEmi(Boolean isStandardEmi) {
        this.isStandardEmi = isStandardEmi;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Item)) {
            return false;
        } else {
            Item other = (Item)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label199: {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label199;
                        }
                    } else if (this$id.equals(other$id)) {
                        break label199;
                    }

                    return false;
                }

                Object this$productId = this.getProductId();
                Object other$productId = other.getProductId();
                if (this$productId == null) {
                    if (other$productId != null) {
                        return false;
                    }
                } else if (!this$productId.equals(other$productId)) {
                    return false;
                }

                label185: {
                    Object this$brandId = this.getBrandId();
                    Object other$brandId = other.getBrandId();
                    if (this$brandId == null) {
                        if (other$brandId == null) {
                            break label185;
                        }
                    } else if (this$brandId.equals(other$brandId)) {
                        break label185;
                    }

                    return false;
                }

                Object this$categoryList = this.getCategoryList();
                Object other$categoryList = other.getCategoryList();
                if (this$categoryList == null) {
                    if (other$categoryList != null) {
                        return false;
                    }
                } else if (!this$categoryList.equals(other$categoryList)) {
                    return false;
                }

                label171: {
                    Object this$merchantId = this.getMerchantId();
                    Object other$merchantId = other.getMerchantId();
                    if (this$merchantId == null) {
                        if (other$merchantId == null) {
                            break label171;
                        }
                    } else if (this$merchantId.equals(other$merchantId)) {
                        break label171;
                    }

                    return false;
                }

                Object this$model = this.getModel();
                Object other$model = other.getModel();
                if (this$model == null) {
                    if (other$model != null) {
                        return false;
                    }
                } else if (!this$model.equals(other$model)) {
                    return false;
                }

                label157: {
                    Object this$ean = this.getEan();
                    Object other$ean = other.getEan();
                    if (this$ean == null) {
                        if (other$ean == null) {
                            break label157;
                        }
                    } else if (this$ean.equals(other$ean)) {
                        break label157;
                    }

                    return false;
                }

                label150: {
                    Object this$price = this.getPrice();
                    Object other$price = other.getPrice();
                    if (this$price == null) {
                        if (other$price == null) {
                            break label150;
                        }
                    } else if (this$price.equals(other$price)) {
                        break label150;
                    }

                    return false;
                }

                Object this$listingPrice = this.getListingPrice();
                Object other$listingPrice = other.getListingPrice();
                if (this$listingPrice == null) {
                    if (other$listingPrice != null) {
                        return false;
                    }
                } else if (!this$listingPrice.equals(other$listingPrice)) {
                    return false;
                }

                if (this.getQuantity() != other.getQuantity()) {
                    return false;
                } else {
                    label135: {
                        Object this$discoverability = this.getDiscoverability();
                        Object other$discoverability = other.getDiscoverability();
                        if (this$discoverability == null) {
                            if (other$discoverability == null) {
                                break label135;
                            }
                        } else if (this$discoverability.equals(other$discoverability)) {
                            break label135;
                        }

                        return false;
                    }

                    label128: {
                        Object this$verticalId = this.getVerticalId();
                        Object other$verticalId = other.getVerticalId();
                        if (this$verticalId == null) {
                            if (other$verticalId == null) {
                                break label128;
                            }
                        } else if (this$verticalId.equals(other$verticalId)) {
                            break label128;
                        }

                        return false;
                    }

                    label121: {
                        Object this$isPhysical = this.getIsPhysical();
                        Object other$isPhysical = other.getIsPhysical();
                        if (this$isPhysical == null) {
                            if (other$isPhysical == null) {
                                break label121;
                            }
                        } else if (this$isPhysical.equals(other$isPhysical)) {
                            break label121;
                        }

                        return false;
                    }

                    Object this$isEmiEnabled = this.getIsEmiEnabled();
                    Object other$isEmiEnabled = other.getIsEmiEnabled();
                    if (this$isEmiEnabled == null) {
                        if (other$isEmiEnabled != null) {
                            return false;
                        }
                    } else if (!this$isEmiEnabled.equals(other$isEmiEnabled)) {
                        return false;
                    }

                    label107: {
                        Object this$offerDetails = this.getOfferDetails();
                        Object other$offerDetails = other.getOfferDetails();
                        if (this$offerDetails == null) {
                            if (other$offerDetails == null) {
                                break label107;
                            }
                        } else if (this$offerDetails.equals(other$offerDetails)) {
                            break label107;
                        }

                        return false;
                    }

                    Object this$isStandardEmi = this.getIsStandardEmi();
                    Object other$isStandardEmi = other.getIsStandardEmi();
                    if (this$isStandardEmi == null) {
                        if (other$isStandardEmi != null) {
                            return false;
                        }
                    } else if (!this$isStandardEmi.equals(other$isStandardEmi)) {
                        return false;
                    }

                    if (Double.compare(this.getOriginalPrice(), other.getOriginalPrice()) != 0) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof Item;
    }

    public int hashCode() {
        int PRIME = 1;
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $productId = this.getProductId();
        result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
        Object $brandId = this.getBrandId();
        result = result * 59 + ($brandId == null ? 43 : $brandId.hashCode());
        Object $categoryList = this.getCategoryList();
        result = result * 59 + ($categoryList == null ? 43 : $categoryList.hashCode());
        Object $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : $merchantId.hashCode());
        Object $model = this.getModel();
        result = result * 59 + ($model == null ? 43 : $model.hashCode());
        Object $ean = this.getEan();
        result = result * 59 + ($ean == null ? 43 : $ean.hashCode());
        Object $price = this.getPrice();
        result = result * 59 + ($price == null ? 43 : $price.hashCode());
        Object $listingPrice = this.getListingPrice();
        result = result * 59 + ($listingPrice == null ? 43 : $listingPrice.hashCode());
        result = result * 59 + this.getQuantity();
        Object $discoverability = this.getDiscoverability();
        result = result * 59 + ($discoverability == null ? 43 : $discoverability.hashCode());
        Object $verticalId = this.getVerticalId();
        result = result * 59 + ($verticalId == null ? 43 : $verticalId.hashCode());
        Object $isPhysical = this.getIsPhysical();
        result = result * 59 + ($isPhysical == null ? 43 : $isPhysical.hashCode());
        Object $isEmiEnabled = this.getIsEmiEnabled();
        result = result * 59 + ($isEmiEnabled == null ? 43 : $isEmiEnabled.hashCode());
        Object $offerDetails = this.getOfferDetails();
        result = result * 59 + ($offerDetails == null ? 43 : $offerDetails.hashCode());
        Object $isStandardEmi = this.getIsStandardEmi();
        result = result * 59 + ($isStandardEmi == null ? 43 : $isStandardEmi.hashCode());
        long $originalPrice = Double.doubleToLongBits(this.getOriginalPrice());
        result = result * 59 + (int)($originalPrice >>> 32 ^ $originalPrice);
        return result;
    }

    public String toString() {
        return "Item(id=" + this.getId() + ", productId=" + this.getProductId() + ", brandId=" + this.getBrandId() + ", categoryList=" + this.getCategoryList() + ", merchantId=" + this.getMerchantId() + ", model=" + this.getModel() + ", ean=" + this.getEan() + ", price=" + this.getPrice() + ", listingPrice=" + this.getListingPrice() + ", quantity=" + this.getQuantity() + ", discoverability=" + this.getDiscoverability() + ", verticalId=" + this.getVerticalId() + ", isPhysical=" + this.getIsPhysical() + ", isEmiEnabled=" + this.getIsEmiEnabled() + ", offerDetails=" + this.getOfferDetails() + ", isStandardEmi=" + this.getIsStandardEmi() + ", originalPrice=" + this.getOriginalPrice() + ")";
    }

    public Item() {
    }

    @ConstructorProperties({"id", "productId", "brandId", "categoryList", "merchantId", "model", "ean", "price", "listingPrice", "quantity", "discoverability", "verticalId", "isPhysical", "isEmiEnabled", "offerDetails", "isStandardEmi", "originalPrice"})
    public Item(String id, String productId, String brandId, List<String> categoryList, String merchantId, String model, String ean, Double price, Double listingPrice, int quantity, String discoverability, String verticalId, Boolean isPhysical, Boolean isEmiEnabled, OfferDetail offerDetails, Boolean isStandardEmi, double originalPrice) {
        this.id = id;
        this.productId = productId;
        this.brandId = brandId;
        this.categoryList = categoryList;
        this.merchantId = merchantId;
        this.model = model;
        this.ean = ean;
        this.price = price;
        this.listingPrice = listingPrice;
        this.quantity = quantity;
        this.discoverability = discoverability;
        this.verticalId = verticalId;
        this.isPhysical = isPhysical;
        this.isEmiEnabled = isEmiEnabled;
        this.offerDetails = offerDetails;
        this.isStandardEmi = isStandardEmi;
        this.originalPrice = originalPrice;
    }
}

