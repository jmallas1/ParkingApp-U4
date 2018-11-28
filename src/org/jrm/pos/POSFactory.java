package org.jrm.pos;

import org.jrm.data.garage.Garage;

/**
 * Class model for a POS machine factory
 * @author Jared Mallas
 * @version 1.0
 */
public class POSFactory
{
    Garage garage;

    public POSFactory(Garage garage)
    {
        this.garage = garage;
    }

    public POS getPOS()
    {
        //return new POSEntry(this.garage);
        return new POSCommon(new POSEntryBehavior(garage));
    }

    public POS getPOS(POSType type)
    {
        switch(type)
        {
            case ENTRY: return new POSCommon(new POSEntryBehavior(garage));
            case EXIT: return new POSCommon(new POSExitBehavior(garage));
            default: return null;
        }
    }
}
