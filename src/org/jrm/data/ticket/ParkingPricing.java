package org.jrm.data.ticket;

import java.util.Date;

/**
 * Interface model for parking pricing
 * @author Jared Mallas
 * @version 1.0
 */
public interface ParkingPricing
{
    Float getFee(Date timeIn, Date timeOut);
}
