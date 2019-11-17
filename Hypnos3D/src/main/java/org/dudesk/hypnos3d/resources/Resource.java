/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.dudesk.hypnos3d.resources;

import java.net.URI;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.Immutable;

/**
 *
 * @since 16 nov. 2019
 * @author Tristan Muller
 */
@Immutable
public abstract class Resource
{
    // ---------------------------------------------------------------------
    // Static fields
    // ---------------------------------------------------------------------

    // ---------------------------------------------------------------------
    // Fields
    // ---------------------------------------------------------------------
    
    @GuardedBy("final")
    private final URI uri;
    
    @GuardedBy("this")
    private boolean loaded;
    
    // ---------------------------------------------------------------------
    // Constructors
    // ---------------------------------------------------------------------

    public Resource(final URI uri)
    {
        this.uri = uri;
        this.loaded = false;
    }
    
    // ---------------------------------------------------------------------
    // Methods
    // ---------------------------------------------------------------------

    public final synchronized void load()
    {
        if (!isLoaded() && getURI() != null)
        {
            onLoad();
            setLoaded(true);
        }
    }
    
    // ---------------------------------------------------------------------
    // Inheritance methods
    // ---------------------------------------------------------------------

    protected abstract void onLoad();
    
    // ---------------------------------------------------------------------
    // Setteurs
    // ---------------------------------------------------------------------

    private synchronized void setLoaded(final boolean loaded)
    {
        this.loaded = loaded;
    }
    
    // ---------------------------------------------------------------------
    // Getteurs
    // ---------------------------------------------------------------------

    public final URI getURI()
    {
        return uri;
    }

    public synchronized boolean isLoaded()
    {
        return loaded;
    }
    
    // ---------------------------------------------------------------------
    // Others methods
    // ---------------------------------------------------------------------

    @Override
    public String toString()
    {
        return super.toString() + uri.toASCIIString();
    }

}
