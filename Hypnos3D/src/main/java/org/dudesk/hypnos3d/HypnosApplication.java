/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.dudesk.hypnos3d;

/**
 *
 * @since 16 nov. 2019
 * @author Tristan Muller
 */
public class HypnosApplication {

    // ---------------------------------------------------------------------
    // Static fields
    // ---------------------------------------------------------------------

    // ---------------------------------------------------------------------
    // Fields
    // ---------------------------------------------------------------------
    
    private final GLFWWindow window;
    
    // ---------------------------------------------------------------------
    // Constructors
    // ---------------------------------------------------------------------

    public HypnosApplication()
    {
        this.window = new GLFWWindow();
    }
    
    // ---------------------------------------------------------------------
    // Methods
    // ---------------------------------------------------------------------

    public final void run()
    {
        window.setVisible(true);
        
        while (!window.isShouldClose())
        {
            window.display();
        }
        
        window.destroy();
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

    public final GLFWWindow getWindow()
    {
        return window;
    }
    
    // ---------------------------------------------------------------------
    // Others methods
    // ---------------------------------------------------------------------
    
    public static final void main(final String[] args)
    {
        final HypnosApplication application = new HypnosApplication();
        application.run();
    }

}
