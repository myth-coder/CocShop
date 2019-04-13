/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phungnt.utils;

import java.util.Random;

/**
 *
 * @author Phung Nguyen
 */
public class RandomID {
    public static  int randomOrderID(){
        int n;
        Random rand = new Random();
         return  n = rand.nextInt(100) +1;
    }
}
