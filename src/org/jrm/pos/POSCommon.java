package org.jrm.pos;

/**
 * Class model for a common POS machine requiring it's behavior
 * to be injected upon instantiation
 * @author Jared Mallas
 * @version 1.0
 */
public class POSCommon implements POS
{
    POSBehavior behavior;

    public POSCommon(POSBehavior pb)
    {
        behavior = pb;
    }

    @Override
    public void startUp() { behavior.startUp(); }
}
