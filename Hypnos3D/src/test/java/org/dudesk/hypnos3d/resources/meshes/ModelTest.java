/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dudesk.hypnos3d.resources.meshes;

import java.net.URI;
import org.junit.Test;

/**
 *
 * @author Tristan Muller
 */
public class ModelTest
{
    @Test
    public void testLoadAlduin() throws InterruptedException
    {
        try
        {
            final Model model = new Model(
                    new URI("resources/meshes/alduin/alduin.gltf"));
            model.load();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

}
