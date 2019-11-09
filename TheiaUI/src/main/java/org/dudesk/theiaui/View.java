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
package org.dudesk.theiaui;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.swing.JComponent;

/**
 *
 * @author Tristan Muller
 */
public abstract class View extends JComponent
{
    // ---------------------------------------------------------------------
    // Fields                                                             
    // ---------------------------------------------------------------------
    
    private final ResourceBundle bundle;
    private final List<ViewListener> listeners;

    // ---------------------------------------------------------------------
    // Constructors
    // ---------------------------------------------------------------------
    
    public View(final String bundleName)
    {
        this.bundle = ResourceBundle.getBundle(bundleName, Locale.ENGLISH);
        this.listeners = new CopyOnWriteArrayList();
    }
    
    // ---------------------------------------------------------------------
    // Methods
    // ---------------------------------------------------------------------
    
    public final String getBundleString(final String name, 
            final String defaultValue)
    {
        if (bundle != null)
        {
            return bundle.getString(name);
        }
        
        return defaultValue;
    }

    public final void addViewListener(final ViewListener listener)
    {
        this.listeners.add(listener);
    }
    
    // ---------------------------------------------------------------------
    // Overriden methods
    // ---------------------------------------------------------------------
    
    @Override
    public void setLocale(final Locale locale)
    {
        super.setLocale(locale);
        
        Collections.unmodifiableList(listeners).forEach((listener) ->
        {
            listener.onChangeLocale();
        });
    }

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
