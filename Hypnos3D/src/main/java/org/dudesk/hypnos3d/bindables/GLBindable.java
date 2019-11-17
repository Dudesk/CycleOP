/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.dudesk.hypnos3d.bindables;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import org.dudesk.hypnos3d.resources.Bindable;

/**
 *
 * @since 17 nov. 2019
 * @author Tristan Muller
 */
@ThreadSafe
public abstract class GLBindable extends Bindable
{
    // ---------------------------------------------------------------------
    // Static fields
    // ---------------------------------------------------------------------

    // ---------------------------------------------------------------------
    // Fields
    // ---------------------------------------------------------------------
    
    @GuardedBy("this")
    private int glID;
    
    // ---------------------------------------------------------------------
    // Constructors
    // ---------------------------------------------------------------------

    public GLBindable()
    {
        this.glID = -1;
    }
    
    // ---------------------------------------------------------------------
    // Methods
    // ---------------------------------------------------------------------

    // ---------------------------------------------------------------------
    // Inheritance methods
    // ---------------------------------------------------------------------
    
    // ---------------------------------------------------------------------
    // Setteurs
    // ---------------------------------------------------------------------

    protected final synchronized void setGLID(final int glID)
    {
        if (glID == -1)
        {
            this.glID = glID;
        }
    }
    
    // ---------------------------------------------------------------------
    // Getteurs
    // ---------------------------------------------------------------------

    public final synchronized int getGLID()
    {
        return glID;
    }
    
    // ---------------------------------------------------------------------
    // Others methods
    // ---------------------------------------------------------------------
}
