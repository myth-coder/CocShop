/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.account;

import java.io.Serializable;

/**
 *
 * @author Phung Nguyen
 */
public class UpdateErr implements Serializable{
    private String passwordErr, fullNameErr, addressErr, phoneNumberErr;

    public UpdateErr() {
    }

    public String getPasswordErr() {
        return passwordErr;
    }

    public void setPasswordErr(String passwordErr) {
        this.passwordErr = passwordErr;
    }

    public String getFullNameErr() {
        return fullNameErr;
    }

    public void setFullNameErr(String fullNameErr) {
        this.fullNameErr = fullNameErr;
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
