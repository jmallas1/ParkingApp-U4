package org.jrm.pos;

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
