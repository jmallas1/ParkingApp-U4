package org.jrm.pos;

import org.jrm.data.garage.Garage;
import org.jrm.data.ticket.ParkingTicket;
import org.jrm.data.ticket.SpecialEvent;
import org.jrm.util.POSUtils;
import org.jrm.util.TimeUtils;

import java.util.Date;

/**
 * Class model for POS entry behavior to be injected at runtime
 * @author Jared Mallas
 * @version 1.0
 */
public class POSEntryBehavior implements POSBehavior
{
    private Boolean debug = false;
    private Garage location;
    private Boolean done = false;
    private ParkingTicket pt;
    private String userChoice;

    public POSEntryBehavior(Garage location) {
        this.location = location;
    }

    /**
     * Display a common 'banner" for POS system
     */
    public void displayBanner()
    {
        System.out.println("Welcome to " + this.location.getName());
        System.out.println("=========================");
        System.out.println("\n");

        System.out.println("1 - Enter / print ticket");
        System.out.println("\n");
        System.out.println("2 - Special Event");
        System.out.println("\n");
        System.out.println("3 - Close garage");
        System.out.println("\n");
        System.out.printf("=> ");
    }

    /**
     * Main method to run the simple loop of the parking entry POS
     */
    public void startUp()
    {
        displayBanner();

        while(!done)
        {
            userChoice = POSUtils.waitForInput();

            if (Integer.parseInt(userChoice) == 1)
            {
                if(debug)
                {
                    Date dt1 = TimeUtils.stringDateToDate("2018-10-03 07:00");
                    Date dt2 = TimeUtils.stringDateToDate("2018-10-03 12:00");
                    pt = new ParkingTicket(TimeUtils.randomTimeString(dt1, dt2));
                }
                else { pt = new ParkingTicket(); }

                location.pushTicket(pt);
                System.out.println("Ticket number: " + pt.getTicketID());
                try
                {
                    Thread.sleep(4000);
                }
                catch (InterruptedException ex)
                {
                    System.out.println("Wait interrupted");
                    System.exit(1);
                }
                displayBanner();
            }
            else if(Integer.parseInt(userChoice) == 2)
            {
                pt = new ParkingTicket(new SpecialEvent(20f));
                location.pushTicket(pt);
                System.out.println("Ticket number: " + pt.getTicketID());
                try
                {
                    Thread.sleep(4000);
                }
                catch (InterruptedException ex)
                {
                    System.out.println("Wait interrupted");
                    System.exit(1);
                }
                displayBanner();
            }
            else if (Integer.parseInt(userChoice) == 3)
            {
                location.closeGarage();
                done = true;
            }
        }
    }
}
