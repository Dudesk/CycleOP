/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dudesk.hypnos3d.resources;

import java.net.URI;
import org.dudesk.hypnos3d.resources.meshes.Model;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Tristan Muller
 */
public class ResourceManagerTest
{
    @Test
    public void testLoadResources()
    {
        try
        {
            final URI uri = new URI("resources/meshes/alduin/alduin.gltf");
            ResourceManager.getInstance().addResource(new Model(uri));
            Assert.assertNotNull(ResourceManager.getInstance().getResource(uri));
            
            for (int i = 0; i < 10; i++)
            {
                ResourceManager.getInstance().addResource(new Model(
                    new URI("resources/meshes/damagedHelmet/damagedHelmet.gltf")));
            }
            
            ResourceManager.getInstance().loadResources();
            Assert.assertTrue("Cannot load Alduin model",
                    ResourceManager.getInstance().getResource(uri).isLoaded());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
