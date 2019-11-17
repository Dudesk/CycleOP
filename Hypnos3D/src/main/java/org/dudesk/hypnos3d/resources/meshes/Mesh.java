/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dudesk.hypnos3d.resources.meshes;

import java.util.Arrays;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 *
 * @author Tristan Muller
 */
@ThreadSafe
public final class Mesh
{
    // ---------------------------------------------------------------------
    // Static fields
    // ---------------------------------------------------------------------

    // ---------------------------------------------------------------------
    // Fields
    // ---------------------------------------------------------------------
    
    /**
     * Vertices positions array.
     */
    @GuardedBy("this")
    private float[] vertices;
    
    /**
     * Normals array.
     */
    @GuardedBy("this")
    private float[] normals;
    
    /**
     * Tangents array.
     */
    @GuardedBy("this")
    private float[] tangents;
    
    /**
     * Bitangents array.
     */
    @GuardedBy("this")
    private float[] bitangents;
    
    /**
     * First UV used for the base channels of emissive, 
     * albedo, specular, and gloss.
     */
    @GuardedBy("this")
    private float[] texcoord0;
    
    /**
     * Second UV, used for ambient occlusion.
     */
    @GuardedBy("this")
    private float[] texcoord1;
    
    /**
     * Third UV, used for normal maps.
     */
    @GuardedBy("this")
    private float[] texcoord2;
    
    /**
     * Last UV, used for others details.
     */
    @GuardedBy("this")
    private float[] texcoord3;
    
    /**
     * Indices array.
     */
    @GuardedBy("this")
    private int[] indices;
    
    // ---------------------------------------------------------------------
    // Constructors
    // ---------------------------------------------------------------------

    public Mesh()
    {
        this.vertices = null;
        this.normals = null;
        this.texcoord0 = null;
        this.texcoord1 = null;
        this.texcoord2 = null;
        this.texcoord3 = null;
        this.indices = null;
    }
    
    // ---------------------------------------------------------------------
    // Methods
    // ---------------------------------------------------------------------
    
    // ---------------------------------------------------------------------
    // Overriden methods
    // ---------------------------------------------------------------------

    // ---------------------------------------------------------------------
    // Setteurs
    // ---------------------------------------------------------------------

    public final synchronized void setVertices(final float[] vertices)
    {
        this.vertices = vertices;
    }

    public final synchronized void setNormals(final float[] normals)
    {
        this.normals = normals;
    }

    public final synchronized void setTangents(final float[] tangents)
    {
        this.tangents = tangents;
    }

    public final synchronized void setBitangents(final float[] bitangents)
    {
        this.bitangents = bitangents;
    }

    public final synchronized void setTexcoord0(final float[] texcoord0)
    {
        this.texcoord0 = texcoord0;
    }

    public final synchronized void setTexcoord1(final float[] texcoord1)
    {
        this.texcoord1 = texcoord1;
    }

    public final synchronized void setTexcoord2(final float[] texcoord2)
    {
        this.texcoord2 = texcoord2;
    }

    public final synchronized void setTexcoord3(final float[] texcoord3)
    {
        this.texcoord3 = texcoord3;
    }

    public final synchronized void setIndices(final int[] indices)
    {
        this.indices = indices;
    }

    
    
    // ---------------------------------------------------------------------
    // Getteurs
    // ---------------------------------------------------------------------

    public final synchronized float[] getVertices()
    {
        return vertices;
    }

    public final synchronized float[] getNormals()
    {
        return normals;
    }

    public final synchronized float[] getTangents()
    {
        return tangents;
    }

    public final synchronized float[] getBitangents()
    {
        return bitangents;
    }

    public final synchronized float[] getTexcoord0()
    {
        return texcoord0;
    }

    public final synchronized float[] getTexcoord1()
    {
        return texcoord1;
    }

    public final synchronized float[] getTexcoord2()
    {
        return texcoord2;
    }

    public final synchronized float[] getTexcoord3()
    {
        return texcoord3;
    }

    public final synchronized int[] getIndices()
    {
        return indices;
    }
    
    // ---------------------------------------------------------------------
    // Others methods
    // ---------------------------------------------------------------------

    @Override
    public String toString()
    {
        String string = super.toString() + "\n";
        
        if (vertices != null) {
            string += "    vertices (" + vertices.length + ")" 
                    + Arrays.toString(vertices) + "\n";
        }
        
        if (normals != null) {
            string += "    normals (" + normals.length + ")" 
                    + Arrays.toString(normals) + "\n";
        }
        
        if (tangents != null) {
            string += "    tangents (" + tangents.length + ")" 
                    + Arrays.toString(tangents) + "\n";
        }
        
        if (bitangents != null) {
            string += "    bitangents (" + bitangents.length + ")" 
                    + Arrays.toString(bitangents) + "\n";
        }
        
        if (texcoord0 != null) {
            string += "    texcoord0 (" + texcoord0.length + ")" 
                    + Arrays.toString(texcoord0) + "\n";
        }
        
        if (texcoord1 != null) {
            string += "    texcoord1 (" + texcoord1.length + ")" 
                    + Arrays.toString(texcoord1) + "\n";
        }
        
        if (texcoord2 != null) {
            string += "    texcoord2 (" + texcoord2.length + ")" 
                    + Arrays.toString(texcoord2) + "\n";
        }
        
        if (texcoord3 != null) {
            string += "    texcoord3 (" + texcoord3.length + ")" 
                    + Arrays.toString(texcoord3) + "\n";
        }
        
        if (indices != null) {
            string += "    indices (" + indices.length + ")" 
                    + Arrays.toString(indices) + "\n";
        }
        
        return string + "}";
    }
    
}
