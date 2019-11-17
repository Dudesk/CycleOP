package org.dudesk.hypnos3d.resources.textures;

import java.io.IOException;
import java.net.URI;
import java.nio.*;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import org.dudesk.hypnos3d.resources.Resource;
import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryStack;

/**
 * Class to load or create image.
 * @author Tristan Muller
 */
@ThreadSafe
public final class Image extends Resource
{
    // ---------------------------------------------------------------------
    // Static fields
    // ---------------------------------------------------------------------

    // ---------------------------------------------------------------------
    // Fields
    // ---------------------------------------------------------------------
    
    @GuardedBy("this")
    private int width;
    
    @GuardedBy("this")
    private int height;
    
    @GuardedBy("this")
    private int channels;
    
    @GuardedBy("this")
    private Buffer buffer;

    // ---------------------------------------------------------------------
    // Constructors
    // ---------------------------------------------------------------------
    
    public Image(final int width, final int height, 
            final int channels, final Buffer buffer)
    {
        super(null);
        this.width = width;
        this.height = height;
        this.channels = channels;
        this.buffer = buffer;
    }
    
    public Image(final URI uri) throws IOException
    {
        super(uri);
    }
    
    // ---------------------------------------------------------------------
    // Methods
    // ---------------------------------------------------------------------
    
    // ---------------------------------------------------------------------
    // Inheritance methods
    // ---------------------------------------------------------------------

    @Override
    public void onLoad()
    {
        try (MemoryStack stack = MemoryStack.stackPush())
        {
            final IntBuffer comp = stack.mallocInt(1);
            final IntBuffer w = stack.mallocInt(1);
            final IntBuffer h = stack.mallocInt(1);

            STBImage.stbi_set_flip_vertically_on_load(true);
            
            if (STBImage.stbi_info(getURI().getPath(), w, h, comp))
            {
                buffer = STBImage.stbi_load(getURI().getPath(), w, h, comp, comp.get(0));
                channels = comp.get(0);
                width = w.get();
                height = h.get();
            }
        }
    }
    
    // ---------------------------------------------------------------------
    // Setteurs
    // ---------------------------------------------------------------------

    // ---------------------------------------------------------------------
    // Getteurs
    // ---------------------------------------------------------------------

    public final synchronized int getWidth()
    {
        return width;
    }

    public final synchronized int getHeight()
    {
        return height;
    }

    public final synchronized int getChannels()
    {
        return channels;
    }

    public final synchronized Buffer getBuffer()
    {
        return buffer;
    }
    
    // ---------------------------------------------------------------------
    // Others methods
    // ---------------------------------------------------------------------
    
}
