
package sample.product;

import java.io.Serializable;

/**
 *
 * @author Phung Nguyen
 */
public class CreateProductError implements Serializable{
    private String productIdErr, productIdDuplicate;
    private String nameErr;
    private String brandErr;
    private String priceErr;
    private String quantityErr;
    private String statusErr;
    private String typeErr;

    public CreateProductError() {
    }

    public String getProductIdDuplicate() {
        return productIdDuplicate;
    }

    public void setProductIdDuplicate(String productIdDuplicate) {
        this.productIdDuplicate = productIdDuplicate;
    }
  
    public String getProductIdErr() {
        return productIdErr;
    }

    public void setProductIdErr(String productIdErr) {
        this.productIdErr = productIdErr;
    }

    public String getNameErr() {
        return nameErr;
    }

    public void setNameErr(String nameErr) {
        this.nameErr = nameErr;
    }


    public String getBrandErr() {
        return brandErr;
    }

    public void setBrandErr(String brandErr) {
        this.brandErr = brandErr;
    }

    public String getPriceErr() {
        return priceErr;
    }

    public void setPriceErr(String priceErr) {
        this.priceErr = priceErr;
    }

    public String getQuantityErr() {
        return quantityErr;
    }

    public void setQuantityErr(String quantityErr) {
        this.quantityErr = quantityErr;
    }

    public String getStatusErr() {
        return statusErr;
    }

    public void setStatusErr(String statusErr) {
        this.statusErr = statusErr;
    }

    public String getTypeErr() {
        return typeErr;
    }

    public void setTypeErr(String typeErr) {
        this.typeErr = typeErr;
    }
    
}
