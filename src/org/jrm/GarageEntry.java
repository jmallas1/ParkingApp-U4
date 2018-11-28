package org.jrm;

import org.jrm.data.garage.Garage;
import org.jrm.pos.*;

/**
 * Class model for a Garage entry system
 * @author Jared Mallas
 * @version 1.0
 */
public class GarageEntry
{
    public static void main(String[] args)
    {
        Garage gar = new Garage("Jared's Garage");

        POSFactory factory = new POSFactory(gar);
        POS pe = factory.getPOS(POSType.ENTRY);

        pe.startUp();
    }
}
