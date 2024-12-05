/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author Metehan ÇEVİK
 */

import Exceptions.SorryWeDontHaveThatOneException;

import java.time.LocalDate;

public interface RemoteDeliverAndDrop {
    void rentMe(LocalDate startDate, LocalDate endDate, String startLocation, String endLocation) throws SorryWeDontHaveThatOneException;

    void dropMe();
}