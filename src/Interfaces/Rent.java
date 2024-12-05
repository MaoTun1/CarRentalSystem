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

public interface Rent {
    void rentMe(LocalDate startDate, LocalDate endDate) throws SorryWeDontHaveThatOneException;

    void dropMe();
}
