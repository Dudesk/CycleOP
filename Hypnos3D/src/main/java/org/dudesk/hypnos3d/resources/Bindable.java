/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dudesk.hypnos3d.resources;

import net.jcip.annotations.GuardedBy;

/**
 *
 * @since 16 nov. 2019
 * @author Tristan Muller
 */
public abstract class Bindable
{
    // ---------------------------------------------------------------------
    // Static fields
    // ---------------------------------------------------------------------
    
    // ---------------------------------------------------------------------
    // Fields
    // ---------------------------------------------------------------------
    
    /**
     * If this resource has been loaded or not.
     */
    @GuardedBy("this")
    private boolean initialized;
    
    // ---------------------------------------------------------------------
    // Constructors
    // ---------------------------------------------------------------------

    public Bindable()
    {
        this.initialized = false;
    }
    
    // ---------------------------------------------------------------------
    // Methods
    // ---------------------------------------------------------------------
    
    public final synchronized void init()
    {
        if (!isInitialized())
        {
            onInit();
            setInitialized(true);
        }
    }
    
    public final synchronized void bind()
    {
        if (isInitialized())
        {
            onBind();
        }
    }
    
    public final synchronized void dispose()
    {
        if (isInitialized())
        {
            onDispose();
            setInitialized(false);
        }
    }
    
    // ---------------------------------------------------------------------
    // Inheritance methods
    // ---------------------------------------------------------------------
    
    protected abstract void onInit();
    
    protected abstract void onBind();

    protected abstract void onDispose();
    
    // ---------------------------------------------------------------------
    // Setteurs
    // ---------------------------------------------------------------------

    private synchronized void setInitialized(final boolean initialized)
    {
        this.initialized = initialized;
    }
    
    // ---------------------------------------------------------------------
    // Getteurs
    // ---------------------------------------------------------------------

    private synchronized boolean isInitialized()
    {
        return initialized;
    }
    
    // ---------------------------------------------------------------------
    // Others methods
    // ---------------------------------------------------------------------

    @Override
    public String toString()
    {
        return super.toString() + 
                "(initialized=" + Boolean.toString(initialized) + ")";
    }
    
}
