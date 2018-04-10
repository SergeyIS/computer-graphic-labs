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
        frame.setSize(640, 480);
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
        animator.start();
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
            
            float x0 = -1f;
            float y0 = 1f;
            float width = 2f;
            float dy = 0.05f;
            float rightLine = 0.8f;
            float lineLength = 2f;
            
            
            gl.glClearColor(1, 1, 1, 0);
            
            gl.glBegin(GL.GL_LINES);
                gl.glColor3f(0.6f,0.6f,1f);
                for(float y = y0; y >= -1; y-=2*dy){
                    gl.glVertex2f(x0, y);
                    gl.glVertex2f(x0 + width, y);
                }
                
                for (float delta = -1; delta < 1; delta+=0.4f) {
                    gl.glVertex2f(delta, -1);
                    gl.glVertex2f(1f, -delta);

                    gl.glVertex2f(-1, -delta);
                    gl.glVertex2f(delta, 1);
                }
                
                gl.glColor3f(1,0,0);
                gl.glVertex2f(rightLine, y0);
                gl.glVertex2f(rightLine, y0 - lineLength);   
            gl.glEnd();
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

