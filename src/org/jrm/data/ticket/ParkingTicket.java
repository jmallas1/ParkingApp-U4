package org.jrm.data.ticket;

import org.jrm.util.TimeUtils;
import java.util.Date;
import java.util.UUID;

/**
 * Class model for a Parking ticket at a parking garage
 * Tickets created with default constructor (and overloaded
 * ParkingTicket(String sTimeIn) constructor) will remain unique
 * by way of java.util.UUID
 * @author Jared Mallas
 * @version 1.0
 */
public class ParkingTicket
{
    private String ticketID;
    private Date timeIn;
    private ParkingPricing pricing;

    public ParkingTicket()
    {
        this.ticketID = UUID.randomUUID().toString();
        this.timeIn = getTimeStamp();
        this.pricing = new DailyParking();
    }

    public ParkingTicket(ParkingPricing pricing)
    {
        this.ticketID = UUID.randomUUID().toString();
        this.timeIn = getTimeStamp();
        this.pricing = pricing;
    }

    public ParkingTicket(String sTimeIn)
    {
        this.ticketID = UUID.randomUUID().toString();
        this.timeIn = TimeUtils.stringDateToDate(sTimeIn);
        this.pricing = new DailyParking();
    }

    public ParkingTicket(String ticketID, String sTimeIn)
    {
        /* use this as you're reading in the current "garage residents" */

        this.timeIn = TimeUtils.stringDateToDate(sTimeIn);
        this.ticketID = ticketID;
        this.pricing = new DailyParking();
    }

    public ParkingTicket(String ticketID, String sTimeIn, ParkingPricing pricing)
    {
        this.timeIn = TimeUtils.stringDateToDate(sTimeIn);
        this.ticketID = ticketID;
        this.pricing = pricing;
    }

    public Date getTimeStamp()
    {
        return new Date();
    }

    /**
     * Generate an appropriate charge for parking based on the rules set in pricing behavior
     * @param timeOut Date / time (yyyy-MM-dd HH:mm) by which to calculate charge
     * @return Float representing the total charge for parking
     */
    public Float getCharge(Date timeOut)
    {
        return pricing.getFee(this.timeIn, timeOut);
    }

    /**
     * Overloaded method of getCharge(Date timeOut) allowing the passing of a correctly
     * formatted string (yyyy-MM-dd HH:mm)
     * @param sTimeOut Formatted (yyyy-MM-dd HH:mm) string representation of a date
     * @return Float representing the total charge for parking
     */
    public Float getCharge(String sTimeOut)
    {
        return this.getCharge(TimeUtils.stringDateToDate(sTimeOut));
    }

    @Override
    public String toString()
    {
        return ticketID + ", " + TimeUtils.dateToString(timeIn) + ", " + pricing.getClass();
    }

    /* getters and setters */

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public Date getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(Date timeIn) {
        this.timeIn = timeIn;
    }

    public Object getPricing()
    {
        return pricing;
    }
}