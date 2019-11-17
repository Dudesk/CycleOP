/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dudesk.hypnos3d.resources.textures;

import java.net.URI;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Tristan Muller
 */
public class TextureDataTest
{
    @Test
    public void testLoad()
    {
        try
        {
            final Image data = new Image(
                    new URI("resources/meshes/alduin/alduin.png"));
            data.load();
            Assert.assertNotEquals(null, data.getBuffer());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
