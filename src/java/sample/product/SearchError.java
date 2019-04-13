/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.product;

import java.io.Serializable;

/**
 *
 * @author Phung Nguyen
 */
public class SearchError implements Serializable{
    private String searchError;
    private String minError;
    private String maxError;
    public SearchError() {
    }

    public String getSearchError() {
        return searchError;
    }

    public void setSearchError(String searchError) {
        this.searchError = searchError;
    }

    public String getMinError() {
        return minError;
    }

    public void setMinError(String minError) {
        this.minError = minError;
    }

    public String getMaxError() {
        return maxError;
    }

    public void setMaxError(String maxError) {
        this.maxError = maxError;
    }
    
}
