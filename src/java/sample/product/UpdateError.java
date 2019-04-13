
package sample.product;

import java.io.Serializable;

/**
 *
 * @author Phung Nguyen
 */
public class UpdateError implements Serializable{
   
    private String nameError;
    private String brandError;
    private String priceError;
    private String quantityError;
    private String statusError;
    private String typeErr;

    public UpdateError() {
    }


    public String getNameError() {
        return nameError;
    }

    public void setNameError(String nameError) {
        this.nameError = nameError;
    }

    public String getBrandError() {
        return brandError;
    }

    public void setBrandError(String brandError) {
        this.brandError = brandError;
    }

    public String getPriceError() {
        return priceError;
    }

    public void setPriceError(String priceError) {
        this.priceError = priceError;
    }

    public String getQuantityError() {
        return quantityError;
    }

    public void setQuantityError(String quantityError) {
        this.quantityError = quantityError;
    }

    public String getStatusError() {
        return statusError;
    }

    public void setStatusError(String statusError) {
        this.statusError = statusError;
    }

    public String getTypeErr() {
        return typeErr;
    }

    public void setTypeErr(String typeErr) {
        this.typeErr = typeErr;
    }
    
}
