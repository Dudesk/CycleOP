/*
 * Copyright (C) 2019 Tristan Muller (tristan.muller@cirad.fr)
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

package org.dudesk.theiaui.wizard;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.dudesk.theiaui.MarginPanel;
import org.dudesk.theiaui.TitledPanel;
import org.dudesk.theiaui.controls.ControlPanel;

/**
 *
 * @since 8 nov. 2019
 * @author Tristan Muller (tristan.muller@cirad.fr)
 */
public abstract class WizardStep extends JPanel {

    /* ------------------------------------------------------------------ */
    /* Fields                                                             */
    /* ------------------------------------------------------------------ */

    private final String title;
    private final boolean mandatory;
    private final MarginPanel controlCardPanel;
    private final ControlPanel controlPanel;
    private final MarginPanel errorCardPanel;
    private final TitledPanel errorTitledPanel;
    private final JLabel errorLabel;
    
    /* ------------------------------------------------------------------ */
    /* Constructors                                                       */
    /* ------------------------------------------------------------------ */

    public WizardStep(final String title, final boolean mandatory) {
        super();
        this.title = title;
        this.mandatory = mandatory;
        this.controlCardPanel = new MarginPanel();
        this.controlPanel = new ControlPanel(title, 500);
        this.errorCardPanel = new MarginPanel();
        this.errorTitledPanel = new TitledPanel(null);
        this.errorTitledPanel.setPreferredSize(new Dimension(500, 35));
        this.errorLabel = new JLabel();
        this.errorLabel.setIcon(new ImageIcon(getClass().
                getResource("/icons/dialog-error.png")));
        this.errorLabel.setVisible(false);
        this.setLayout(new BorderLayout(0, 0));
        this.controlCardPanel.add(controlPanel);
        this.add(controlCardPanel, BorderLayout.CENTER);
        this.errorCardPanel.add(errorTitledPanel);
        this.errorTitledPanel.getContentPanel().add(errorLabel);
        this.add(errorCardPanel, BorderLayout.SOUTH);
    }
    
    /* ------------------------------------------------------------------ */
    /* Methods                                                            */
    /* ------------------------------------------------------------------ */
    
    public final boolean checkFieldsValidity() {
        boolean validity = true;
        
        final String error = onCheckValidity();
                
        if (error != null) {
            validity = false;
            errorLabel.setText(error);
        }
        
        this.errorLabel.setVisible(!validity);
        
        return validity;
    }
    
    /* ------------------------------------------------------------------ */
    /* Overriden methods                                                  */
    /* ------------------------------------------------------------------ */

    protected abstract String onCheckValidity();
    
    /* ------------------------------------------------------------------ */
    /* Setteurs                                                           */
    /* ------------------------------------------------------------------ */
    
    /* ------------------------------------------------------------------ */
    /* Getteurs                                                           */
    /* ------------------------------------------------------------------ */

    public final String getTitle() {
        return title;
    }
    
    public final ControlPanel getControlPanel() {
        return controlPanel;
    }
    
    public final boolean isMandatory() {
        return mandatory;
    }
    
    /* ------------------------------------------------------------------ */
    /* Others methods                                                     */
    /* ------------------------------------------------------------------ */

}
