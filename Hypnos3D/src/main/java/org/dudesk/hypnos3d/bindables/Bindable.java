/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.dudesk.hypnos3d.bindables;

/**
 *
 * @since 16 nov. 2019
 * @author Tristan Muller
 */
public interface Bindable {

    // ---------------------------------------------------------------------
    // Methods
    // ---------------------------------------------------------------------

    public void init();
    public void bind();
    public void dispose();
    
    // ---------------------------------------------------------------------
    // Others methods
    // ---------------------------------------------------------------------

}
