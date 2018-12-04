package org.jrm.data.ticket;

import java.util.Date;

public interface ParkingPricing
{
    Float getFee(Date timeIn, Date timeOut);
}
