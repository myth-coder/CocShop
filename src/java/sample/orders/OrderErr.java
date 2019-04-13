
package sample.orders;

import java.io.Serializable;

/**
 *
 * @author Phung Nguyen
 */
public class OrderErr implements Serializable{
    private String addressErr, phoneNumberErr;

    public OrderErr() {
    }

    public String getAddressErr() {
        return addressErr;
    }

    public void setAddressErr(String addressErr) {
        this.addressErr = addressErr;
    }

    public String getPhoneNumberErr() {
        return phoneNumberErr;
    }

    public void setPhoneNumberErr(String phoneNumberErr) {
        this.phoneNumberErr = phoneNumberErr;
    }
    
}
