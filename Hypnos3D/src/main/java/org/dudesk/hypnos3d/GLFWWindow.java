package org.dudesk.hypnos3d;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import org.lwjgl.glfw.GLFW;
import static org.lwjgl.glfw.GLFW.glfwInit;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.glfw.GLFWWindowSizeCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL45C;
import static org.lwjgl.system.MemoryUtil.NULL;

public class GLFWWindow
{
    // ---------------------------------------------------------------------
    // Static fields
    // ---------------------------------------------------------------------

    // ---------------------------------------------------------------------
    // Fields
    // ---------------------------------------------------------------------
    
    private long id;
    
    // ---------------------------------------------------------------------
    // Constructors
    // ---------------------------------------------------------------------

    public GLFWWindow()
    {
        if (GLFW.glfwInit())
        {
            final long monitor = GLFW.glfwGetPrimaryMonitor();
            final GLFWVidMode mode = GLFW.glfwGetVideoMode(monitor);
            
            if (mode != null)
            {
                this.id = GLFW.glfwCreateWindow(mode.width(), mode.height(), 
                        "", monitor, NULL);
            }
        }

        init();
    }
    
    public GLFWWindow(int width, int height)
    {
        if (glfwInit())
        {
            this.id = GLFW.glfwCreateWindow(width, height, "", NULL, NULL);
        }

        init();
    }
    
    // ---------------------------------------------------------------------
    // Methods
    // ---------------------------------------------------------------------

    private void init()
    {
        if (GLFW.glfwInit())
        {
            GLFWErrorCallback.createPrint(System.err).set();
            GLFW.glfwMakeContextCurrent(id);
            GLFW.glfwSwapInterval(1);
            GL.createCapabilities(false);

            GLFW.glfwSetWindowSizeCallback(id, new GLFWWindowSizeCallback()
            {
                @Override
                public void invoke(long window, int width, int height)
                {
                    GL45C.glViewport(0, 0, width, height);
                }
            });
        }
    }

    public void display()
    {
        if (GLFW.glfwInit())
        {
            GL45C.glClearColor(0, 0, 0, 1);
            GL45C.glClear(GL45C.GL_COLOR_BUFFER_BIT | GL45C.GL_DEPTH_BUFFER_BIT);
            GLFW.glfwSwapBuffers(id);
            GLFW.glfwPollEvents();
        }
    }

    public void destroy()
    {
        if (GLFW.glfwInit())
        {
            glfwFreeCallbacks(id);
            GLFW.glfwDestroyWindow(id);
        }
    }
    
    // ---------------------------------------------------------------------
    // Inheritance methods
    // ---------------------------------------------------------------------

    // ---------------------------------------------------------------------
    // Setteurs
    // ---------------------------------------------------------------------
    
    public void setTitle(String title)
    {
        if (GLFW.glfwInit())
        {
            GLFW.glfwSetWindowTitle(id, title);
        }
    }

    public void setSize(int width, int height)
    {
        if (GLFW.glfwInit())
        {
            GLFW.glfwSetWindowSize(id, width, height);
        }
    }

    public void setFullscreen(boolean fullscreen)
    {
        if (GLFW.glfwInit())
        {
            long monitor = GLFW.glfwGetPrimaryMonitor();
            GLFWVidMode mode = GLFW.glfwGetVideoMode(monitor);
            
            if (mode != null)
            {
                GLFW.glfwSetWindowMonitor(id, monitor, 0, 0, mode.width(), 
                        mode.height(), mode.refreshRate());
            }
        }
    }

    public void setVisible(boolean visible)
    {
        if (GLFW.glfwInit())
        {
            if (visible)
            {
                GLFW.glfwShowWindow(id);

                int[] w = new int[1];
                int[] h = new int[1];
                GLFW.glfwGetFramebufferSize(id, w, h);
            }
            else
            {
                GLFW.glfwHideWindow(id);
            }
        }
    }
    
    // ---------------------------------------------------------------------
    // Getteurs
    // ---------------------------------------------------------------------

    public boolean isShouldClose()
    {
        if (GLFW.glfwInit())
        {
            return GLFW.glfwWindowShouldClose(id);
        }

        return true;
    }
    
    // ---------------------------------------------------------------------
    // Others methods
    // ---------------------------------------------------------------------
    
    public static final void main(final String[] args)
    {
        final GLFWWindow window = new GLFWWindow();
        window.setVisible(true);
        
        while (!window.isShouldClose())
        {
            window.display();
        }
        
        window.destroy();
    }
    
}
