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


public class EnterPoint implements GLEventListener {

    public static void main(String[] args) {
        Frame frame = new Frame("Simple JOGL Application");
        GLCanvas canvas = new GLCanvas();

        canvas.addGLEventListener(new EnterPoint());
        frame.add(canvas);
        frame.setSize(640, 640);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable() {

                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        // Center frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        //animator.start();
    }

    public void init(GLAutoDrawable drawable) {
        // Use debug pipeline
        // drawable.setGL(new DebugGL(drawable.getGL()));
        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
    }

    public void display(GLAutoDrawable drawable) 
    {
        try
        {
            GL gl = drawable.getGL();
                
            double x, y, x0, y0, R, alpha, delta;
            x0 = 0;
            y0 = 0;
            R = 0.3f;
            delta = Math.PI/12;
            alpha = 0;
           
            double color;
            for (int i = 0; i < 2*Math.PI/delta; i++) {
                color = Math.sin(i*delta);
                gl.glColor3d(color, color, color);
                gl.glBegin(GL.GL_LINE_LOOP);
                    for (int j = 0; j <= 2*Math.PI/delta; j++) {
                        x = x0 + R*Math.cos(alpha);
                        y = y0 + R*Math.sin(alpha);
                        alpha+=delta;
                        gl.glVertex2d(x, y);                
                    }
                gl.glEnd();
                
                x0 = R*Math.cos(alpha);
                y0 = R*Math.sin(alpha); 
            }      
           gl.glFlush();
        }
        catch(Exception e)
        {
            System.out.printf(e.getMessage());
        }
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged)
    {
        
    }
}

