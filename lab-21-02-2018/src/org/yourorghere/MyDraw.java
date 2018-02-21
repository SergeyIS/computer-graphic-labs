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

public class MyDraw {

    public MyDraw(GL glObject) {
        gl = glObject;
    }

    public void DrawCircle() {
        int n = 48;
        double R = 0.7;
        double da = Math.PI * 2 / n;
        double alpha = 0;
        double x, y;
        double k;

        
        gl.glLineWidth(4);
        gl.glBegin(GL.GL_TRIANGLE_FAN);
        gl.glVertex2d(0, 0);
        while (alpha <= 12 * Math.PI + da) 
        {
            k = Math.abs(Math.cos(alpha + Math.random()));
            x = R * k * Math.cos(alpha);
            y = R * k * Math.sin(alpha);
            
            
            gl.glColor3d(Math.abs(Math.cos(alpha)),
                    Math.abs(Math.cos(alpha + 1)),
                    Math.abs(Math.cos(alpha + 2)));

            gl.glVertex2d(x, y);
            alpha += da;
        }
        gl.glEnd();

        gl.glFlush();
    }

    public void DrawStar()
    {
        int n = 10;
        double R = 0.7;
        double da = Math.PI * 2 / n;
        double alpha = 0;
        double x, y;
        
        gl.glLineWidth(4);
        gl.glBegin(GL.GL_TRIANGLE_FAN);
        gl.glVertex2d(0, 0);
        while (alpha <= 12 * Math.PI + da) 
        {
            x = R * Math.cos(alpha);
            y = R * Math.sin(alpha);
            
            
            gl.glColor3d(Math.random(), Math.random(), Math.random());

            gl.glVertex2d(x, y);
            
            x = R * Math.cos(alpha + da/2) / 2;
            y = R * Math.sin(alpha + da/2) / 2;

            gl.glVertex2d(x, y);
            
            alpha += da;
        }
        gl.glEnd();

        gl.glFlush();
    }
    
    private GL gl;
}
