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

import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * <img src="doc-files/textAreaControlLine.png" width="407" height="103" alt="">
 * @author Tristan Muller
 */
public class TextAreaControlLine extends ControlLine {
    
    private final JTextArea textArea;
    private final JScrollPane scrollPane;

    public TextAreaControlLine(final String title) {
        super();
        this.textArea = new JTextArea();
        this.textArea.setLineWrap(true);
        this.scrollPane = new JScrollPane(textArea, 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.scrollPane.setPreferredSize(new Dimension(500, 100));
        this.addText(title);
        this.addContent(scrollPane);
    }
    
    public final String getTextValue() {
        return textArea.getText();
    }
    
}
