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

package org.dudesk.theiaui.controls;

import java.awt.Dimension;
import org.dudesk.theiaui.TitledPanel;

/**
 *
 * @since 8 nov. 2019
 * @author Tristan Muller (tristan.muller@cirad.fr)
 */
public class ControlPanel extends TitledPanel {

    /* ------------------------------------------------------------------ */
    /* Fields                                                             */
    /* ------------------------------------------------------------------ */

    private final int controlWidth;
    private int controlHeight;
    
    /* ------------------------------------------------------------------ */
    /* Constructors                                                       */
    /* ------------------------------------------------------------------ */

    public ControlPanel(final String title, final int controlWidth) {
        super(title);
        this.controlWidth = controlWidth;
        this.controlHeight = 35;
    }
    
    /* ------------------------------------------------------------------ */
    /* Methods                                                            */
    /* ------------------------------------------------------------------ */

    public final void addLine(final ControlLine line) {
        controlHeight += line.getLineHeight() + 5;
        line.setPreferredSize(new Dimension(controlWidth, line.getLineHeight()));
        getContentPanel().add(line);
        setPreferredSize(new Dimension(controlWidth + 50, controlHeight));
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
