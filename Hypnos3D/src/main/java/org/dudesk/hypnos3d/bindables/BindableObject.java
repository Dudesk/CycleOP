/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dudesk.hypnos3d.bindables;

import net.jcip.annotations.GuardedBy;

/**
 *
 * @since 16 nov. 2019
 * @author Tristan Muller
 */
public abstract class BindableObject implements Bindable
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

    public BindableObject()
    {
        this.initialized = false;
    }
    
    // ---------------------------------------------------------------------
    // Methods
    // ---------------------------------------------------------------------
    
    // ---------------------------------------------------------------------
    // Inheritance methods
    // ---------------------------------------------------------------------
    
    @Override
    public void init()
    {
        if (!initialized)
        {
            initialized = true;
            onInit();
        }
    }
    
    protected abstract void onInit();
    
    @Override
    public void bind()
    {
        if (!initialized)
        {
            init();
        }
        
        onBind();
    }
    
    protected abstract void onBind();

    @Override
    public void dispose()
    {
        if (initialized)
        {
            onDispose();
        }
    }
    
    protected abstract void onDispose();
    
    // ---------------------------------------------------------------------
    // Setteurs
    // ---------------------------------------------------------------------
    
    // ---------------------------------------------------------------------
    // Getteurs
    // ---------------------------------------------------------------------
    
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
