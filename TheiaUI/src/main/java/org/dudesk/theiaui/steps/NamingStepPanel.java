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

package org.dudesk.theiaui.steps;

import org.dudesk.theiaui.controls.TextAreaControlLine;
import org.dudesk.theiaui.controls.TextFieldControlLine;

/**
 * <img src="doc-files/namingStepPanel.png" width="500" height="177" alt="">
 * @since 8 nov. 2019
 * @author Tristan Muller (tristan.muller@cirad.fr)
 */
public class NamingStepPanel extends StepPanel {

    /* ------------------------------------------------------------------ */
    /* Fields                                                             */
    /* ------------------------------------------------------------------ */

    private final TextFieldControlLine nameLine;
    private final TextAreaControlLine descLine;
    
    /* ------------------------------------------------------------------ */
    /* Constructors                                                       */
    /* ------------------------------------------------------------------ */

    public NamingStepPanel() {
        this("Naming");
    }
    
    public NamingStepPanel(final String title) {
        super(title, false);
        this.nameLine = new TextFieldControlLine("Name");
        this.descLine = new TextAreaControlLine("Description");
                
        getControlPanel().addLine(nameLine);
        getControlPanel().addLine(descLine);
        
        addCheckFieldValidityCallback(() -> {
            if (nameLine.getTextValue().isEmpty()) {
                return "The name value cannot be empty";
            }
            
            return null;
        });
    }
    
    /* ------------------------------------------------------------------ */
    /* Methods                                                            */
    /* ------------------------------------------------------------------ */

    public final void setNameValue(final String value) {
        nameLine.setName(value);
    }
    
    public final void setDescriptionValue(final String value) {
        descLine.setName(value);
    }
    
    public final String getNameValue() {
        return nameLine.getTextValue();
    }
    
    public final String getDescriptionValue() {
        return descLine.getTextValue();
    }
    
    /* ------------------------------------------------------------------ */
    /* Overriden methods                                                  */
    /* ------------------------------------------------------------------ */

    /* ------------------------------------------------------------------ */
    /* Setteurs                                                           */
    /* ------------------------------------------------------------------ */

    /* ------------------------------------------------------------------ */
    /* Getteurs                                                           */
    /* ------------------------------------------------------------------ */

    /* ------------------------------------------------------------------ */
    /* Others methods                                                     */
    /* ------------------------------------------------------------------ */

}
