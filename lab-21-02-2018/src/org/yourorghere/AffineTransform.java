package org.yourorghere;

import com.sun.opengl.util.Animator;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;


public class AffineTransform 
{
    public AffineTransform(GL globject)
    {
        this.gl = globject;
    }
    
    public void DrawAxis()
    {
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        
        gl.glBegin(GL.GL_LINES);
            gl.glColor3f(1, 0, 0);
            gl.glVertex3f(-1, 0, 0);
            gl.glVertex3f(1, 0, 0);
            
            gl.glColor3f(0, 1, 0);
            gl.glVertex3f(0, -1, 0);
            gl.glVertex3f(0, 1, 0);
            
            gl.glColor3f(0, 0, 1);
            gl.glVertex3f(0, 0, -1);
            gl.glVertex3f(0, 0, 1);
        gl.glEnd();
    }
    
    public void RotateAxis()
    {
        gl.glLoadIdentity();
        gl.glRotatef(32f, 1f, 0, 0);
        gl.glRotatef(32f, 0, 0, 1f);
    }
    
    
    public void DrawCube()
    {
        gl.glEnable(gl.GL_DEPTH_TEST);
        
        gl.glClear(gl.GL_COLOR_BUFFER_BIT | gl.GL_DEPTH_BUFFER_BIT);
        
        gl.glBegin(GL.GL_QUADS);
        
            //up and bottom
            gl.glColor3f(0, 0, 1);
            gl.glVertex3f(0.5f, 0.5f, 0.5f);
            gl.glVertex3f(-0.5f, 0.5f, 0.5f);
            gl.glVertex3f(-0.5f, -0.5f, 0.5f);
            gl.glVertex3f(0.5f, -0.5f, 0.5f);
            
            gl.glVertex3f(0.5f, 0.5f, -0.5f);
            gl.glVertex3f(-0.5f, 0.5f, -0.5f);
            gl.glVertex3f(-0.5f, -0.5f, -0.5f);
            gl.glVertex3f(0.5f, -0.5f, -0.5f);
            
            //right and left
            gl.glColor3f(0, 1, 0);
            gl.glVertex3f(0.5f, 0.5f, 0.5f);
            gl.glVertex3f(-0.5f, 0.5f, 0.5f);
            gl.glVertex3f(-0.5f, 0.5f, -0.5f);
            gl.glVertex3f(0.5f, 0.5f, -0.5f);
            
            gl.glVertex3f(0.5f, -0.5f, 0.5f);
            gl.glVertex3f(-0.5f, -0.5f, 0.5f);
            gl.glVertex3f(-0.5f, -0.5f, -0.5f);
            gl.glVertex3f(0.5f, -0.5f, -0.5f);
            
            //front and back
            gl.glColor3f(1, 0, 0);
            gl.glVertex3f(0.5f, 0.5f, 0.5f);
            gl.glVertex3f(-0.5f, 0.5f, 0.5f);
            gl.glVertex3f(-0.5f, 0.5f, -0.5f);
            gl.glVertex3f(0.5f, 0.5f, -0.5f);
            
            gl.glVertex3f(0.5f, -0.5f, -0.5f);
            gl.glVertex3f(-0.5f, -0.5f, -0.5f);
            gl.glVertex3f(-0.5f, -0.5f, 0.5f);
            gl.glVertex3f(0.5f, -0.5f, 0.5f);
        gl.glEnd();
    }
    private GL gl;
}
