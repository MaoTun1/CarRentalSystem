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

public class SorryWeDontHaveThatOneException extends Exception {
    public SorryWeDontHaveThatOneException() {
    }

    public SorryWeDontHaveThatOneException(String msg) {
        super(msg);
    }
}