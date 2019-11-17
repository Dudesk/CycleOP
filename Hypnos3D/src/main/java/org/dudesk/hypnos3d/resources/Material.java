/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.dudesk.hypnos3d.resources;

import java.awt.Color;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @since 17 nov. 2019
 * @author Tristan Muller
 */
public class Material {

    // ---------------------------------------------------------------------
    // Static fields
    // ---------------------------------------------------------------------

    // ---------------------------------------------------------------------
    // Fields
    // ---------------------------------------------------------------------
    
    private String name;
    
    private Object baseColorTexture;
    private Color baseColorFactor;
    
    private Object metallicRoughnessTexture;
    private float metallicFactor;
    private float roughnessFactor;
    
    private Object normalTexture;
    
    private Object occlusionTexture;
    
    private Object emissiveTexture;
    private Color emissiveFactor;
    
    // ---------------------------------------------------------------------
    // Constructors
    // ---------------------------------------------------------------------

    public Material()
    {
        this.name = "Untitled" + RandomStringUtils.randomAlphanumeric(16);
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

    // ---------------------------------------------------------------------
    // Getteurs
    // ---------------------------------------------------------------------

    // ---------------------------------------------------------------------
    // Others methods
    // ---------------------------------------------------------------------

}
