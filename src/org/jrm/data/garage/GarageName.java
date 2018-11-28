package org.jrm.data.garage;

/**
 * Class model for a GarageName. I couldn't bring myself to use
 * a singleton "in earnest" anywhere in my program so I put this
 * together to meet the "must show use of a singleton" requirement.
 * @author Jared Mallas
 * @version 1.0
 */
public class GarageName
{
    private String name;

    private static GarageName inst = null;

    private GarageName(){}

    public static GarageName getInstance()
    {
        synchronized(GarageName.class)
        {
            if (inst == null)
            {
                inst = new GarageName();
            }
        }
        return inst;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
