/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.dudesk.hypnos3d.resources;

import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @since 17 nov. 2019
 * @author Tristan Muller
 */
public final class ResourceManager
{
    // ---------------------------------------------------------------------
    // Static fields
    // ---------------------------------------------------------------------

    private static final ResourceManager INSTANCE = new ResourceManager();
    
    // ---------------------------------------------------------------------
    // Fields
    // ---------------------------------------------------------------------
    
    private final Map<URI, Resource> resources;
    
    // ---------------------------------------------------------------------
    // Constructors
    // ---------------------------------------------------------------------

    public ResourceManager()
    {
        this.resources = new HashMap();
    }
    
    // ---------------------------------------------------------------------
    // Methods
    // ---------------------------------------------------------------------
    
    public final synchronized void addResource(final Resource resource)
    {
        if (resource != null)
        {
            if (resource.getURI() != null)
            {
                getResources().put(resource.getURI(), resource);
            }
        }
    }
    
    public final synchronized Resource getResource(final URI uri)
    {
        if (uri != null)
        {
            return getResources().get(uri);
        }
        
        return null;
    }
    
    public final synchronized void loadResources()
    {
        final ExecutorService service = Executors.newWorkStealingPool();
        
        final Collection<Resource> resourceCollection = 
                Collections.unmodifiableCollection(getResources().values());
        
        resourceCollection.forEach((resource) ->
        {
            if (!resource.isLoaded())
            {                
                service.execute(() ->
                {
                    resource.load();
                });
            }
        });
        
        service.shutdown();
        while(!service.isTerminated()) {}
        
        System.out.println("Successfully loaded " + 
                resourceCollection.size() + " resources");
    }
    
    // ---------------------------------------------------------------------
    // Inheritance methods
    // ---------------------------------------------------------------------

    // ---------------------------------------------------------------------
    // Setteurs
    // ---------------------------------------------------------------------
    
    // ---------------------------------------------------------------------
    // Getteurs
    // ---------------------------------------------------------------------
    
    private synchronized Map<URI, Resource> getResources()
    {
        return resources;
    }
    
    public static final ResourceManager getInstance()
    {
        return INSTANCE;
    }
    
    // ---------------------------------------------------------------------
    // Others methods
    // ---------------------------------------------------------------------

}
