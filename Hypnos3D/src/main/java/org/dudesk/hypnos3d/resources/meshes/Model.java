/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.dudesk.hypnos3d.resources.meshes;

import java.net.URI;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.dudesk.hypnos3d.resources.Resource;
import org.lwjgl.assimp.AIAnimation;
import org.lwjgl.assimp.AIMaterial;
import org.lwjgl.assimp.AIMaterialProperty;
import org.lwjgl.assimp.AIMesh;
import org.lwjgl.assimp.AIScene;
import org.lwjgl.assimp.Assimp;

/**
 *
 * @since 17 nov. 2019
 * @author Tristan Muller
 */
public class Model extends Resource
{
    // ---------------------------------------------------------------------
    // Static fields
    // ---------------------------------------------------------------------

    // ---------------------------------------------------------------------
    // Fields
    // ---------------------------------------------------------------------
    
    private final List<Mesh> meshes;
    
    // ---------------------------------------------------------------------
    // Constructors
    // ---------------------------------------------------------------------

    public Model(URI uri)
    {
        super(uri);
        this.meshes = new ArrayList();
    }
    
    // ---------------------------------------------------------------------
    // Methods
    // ---------------------------------------------------------------------

    @Override
    public final void onLoad()
    {
        
        final AIScene scene = Assimp.aiImportFile(getURI().getPath(), 0);
            
        if (scene == null)
        {
            return;
        }
        
        if (scene.mFlags() == Assimp.AI_SCENE_FLAGS_INCOMPLETE)
        {       
            return;
        }
                        
        for (int i = 0; i < scene.mNumMeshes(); i++)
        {
            final AIMesh aiMesh = AIMesh.create(scene.mMeshes().get(i));
            
            if (aiMesh != null)
            {
                final Mesh mesh = new Mesh();
                
                /* Get each vertices */
                if (aiMesh.mVertices() != null)
                {
                    final float[] aiVertices = 
                            new float[aiMesh.mVertices().limit() * 3];

                    for (int j = 0; j < aiMesh.mVertices().limit(); j++)
                    {
                        aiVertices[j * 3 + 0] = aiMesh.mVertices().get(j).x();
                        aiVertices[j * 3 + 1] = aiMesh.mVertices().get(j).y();
                        aiVertices[j * 3 + 2] = aiMesh.mVertices().get(j).z();
                    }

                    mesh.setVertices(aiVertices);
                }

                /* Get each normals */
                if (aiMesh.mNormals() != null)
                {
                    final float[] aiNormals = 
                            new float[aiMesh.mNormals().limit() * 3];

                    for (int j = 0; j < aiMesh.mNormals().limit(); j++)
                    {
                        aiNormals[j * 3 + 0] = aiMesh.mNormals().get(j).x();
                        aiNormals[j * 3 + 1] = aiMesh.mNormals().get(j).y();
                        aiNormals[j * 3 + 2] = aiMesh.mNormals().get(j).z();
                    }

                    mesh.setNormals(aiNormals);
                }

                /* Get each tangent */
                if (aiMesh.mTangents() != null)
                {
                    final float[] aiTangents = 
                            new float[aiMesh.mTangents().limit() * 3];

                    for (int j = 0; j < aiMesh.mTangents().limit(); j++)
                    {
                        aiTangents[j * 3 + 0] = aiMesh.mTangents().get(j).x();
                        aiTangents[j * 3 + 1] = aiMesh.mTangents().get(j).y();
                        aiTangents[j * 3 + 2] = aiMesh.mTangents().get(j).z();
                    }

                    mesh.setTangents(aiTangents);
                }

                /* Get each bitangent */
                if (aiMesh.mBitangents()!= null)
                {
                    final float[] aiBitangents = 
                            new float[aiMesh.mBitangents().limit() * 3];

                    for (int j = 0; j < aiMesh.mBitangents().limit(); j++)
                    {
                        aiBitangents[j * 3 + 0] = aiMesh.mBitangents().get(j).x();
                        aiBitangents[j * 3 + 1] = aiMesh.mBitangents().get(j).y();
                        aiBitangents[j * 3 + 2] = aiMesh.mBitangents().get(j).z();
                    }

                    mesh.setBitangents(aiBitangents);
                }

                /* Get each texcoords */
                if (aiMesh.mTextureCoords() != null)
                {
                    for (int j = 0; j < aiMesh.mTextureCoords().limit(); j++)
                    {
                        if (aiMesh.mTextureCoords(j) != null)
                        {
                            final float[] aiTexcoords = 
                                    new float[aiMesh.mTextureCoords(j).limit() * 2];

                            for (int k = 0; k < aiMesh.mTextureCoords(j).limit(); k++)
                            {
                                aiTexcoords[k * 2 + 0] = 
                                        aiMesh.mTextureCoords(j).get(k).x();
                                aiTexcoords[k * 2 + 1] = 
                                        aiMesh.mTextureCoords(j).get(k).y();
                            }

                            switch(j)
                            {
                                case 0: mesh.setTexcoord0(aiTexcoords); break;
                                case 1: mesh.setTexcoord1(aiTexcoords); break;
                                case 2: mesh.setTexcoord2(aiTexcoords); break;
                                case 3: mesh.setTexcoord3(aiTexcoords); break;
                            }
                        }
                    }
                }

                /* Get each indices */
                if (aiMesh.mFaces() != null)
                {
                    final int[] aiIndices = 
                            new int[aiMesh.mFaces().limit() * 3];

                    for (int j = 0; j < aiMesh.mFaces().limit(); j++)
                    {
                        aiIndices[j * 3 + 0] = 
                                aiMesh.mFaces().get(j).mIndices().get(0);
                        aiIndices[j * 3 + 1] = 
                                aiMesh.mFaces().get(j).mIndices().get(1);
                        aiIndices[j * 3 + 2] = 
                                aiMesh.mFaces().get(j).mIndices().get(2);
                    }

                    mesh.setIndices(aiIndices);
                }
                
                meshes.add(mesh);
            }
        }
        
        for (int i = 0; i < scene.mNumMaterials(); i++)
        {
            final AIMaterial aiMaterial = 
                    AIMaterial.create(scene.mMaterials().get(i));
                      
            for (int j = 0; j < aiMaterial.mNumProperties(); j++)
            {
                final AIMaterialProperty aiProperty = 
                        AIMaterialProperty.create(aiMaterial.mProperties().get(j));
                                
                if (aiProperty.mKey().dataString().equals(Assimp.AI_MATKEY_NAME))
                {
                    final CharBuffer buffer = 
                            Charset.defaultCharset().decode(aiProperty.mData());
                }
            }
        }
        
        for (int i = 0; i < scene.mNumAnimations(); i++)
        {
            final AIAnimation aiAnimation = AIAnimation.create(scene.mAnimations().get(i));
            
        }
    }
    
    // ---------------------------------------------------------------------
    // Inheritance methods
    // ---------------------------------------------------------------------

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
