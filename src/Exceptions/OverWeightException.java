/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author Metehan ÇEVİK
 */

public class OverWeightException extends Exception {
    public OverWeightException() {
    }

    public OverWeightException(String msg) {
        super(msg);
    }
}