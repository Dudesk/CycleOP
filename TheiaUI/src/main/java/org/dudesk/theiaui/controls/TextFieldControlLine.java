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

import javax.swing.JTextField;

/**
 * <img src="doc-files/textFieldControlLine.png" width="409" height="33" alt="">
 * @author Tristan Muller
 */
public class TextFieldControlLine extends ControlLine {
    
    private final JTextField textField;

    public TextFieldControlLine(final String title) {
        super();
        this.textField = new JTextField();
        this.addText(title);
        this.addContent(textField);
    }
    
    public final String getTextValue() {
        return textField.getText();
    }
    
}
