/*
 * Copyright (C) 2019 Tristan Muller
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.dudesk.theiaui.controls;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Tristan Muller
 */
public class ControlLine extends JPanel {
    
    // ---------------------------------------------------------------------
    // Fields                                                             
    // ---------------------------------------------------------------------
    
    private int lineHeight;

    // ---------------------------------------------------------------------
    // Constructors
    // ---------------------------------------------------------------------
    
    public ControlLine() {
        super(new GridLayout(1, 0));
        this.setBackground(new Color(240, 240, 240));
    }
    
    // ---------------------------------------------------------------------
    // Methods
    // ---------------------------------------------------------------------
    
    public final void addText(final String text) {
        final JLabel label= new JLabel(text + " :");
        
        if (label.getPreferredSize().height > lineHeight) {
            this.lineHeight = label.getPreferredSize().height;
        }
        
        this.add(label);
    }
    
    public final void addContent(final JComponent component) {
        if (component.getPreferredSize().height > lineHeight) {
            this.lineHeight = component.getPreferredSize().height;
        }
        
        this.add(component);
    }
    
    // ---------------------------------------------------------------------
    // Overriden methods
    // ---------------------------------------------------------------------

    // ---------------------------------------------------------------------
    // Setteurs
    // ---------------------------------------------------------------------

    // ---------------------------------------------------------------------
    // Getteurs
    // ---------------------------------------------------------------------
    
    public final int getLineHeight() {
        return lineHeight;
    }
    
    // ---------------------------------------------------------------------
    // Others methods
    // ---------------------------------------------------------------------
    
}
