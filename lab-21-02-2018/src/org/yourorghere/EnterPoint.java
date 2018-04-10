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


public class EnterPoint implements GLEventListener 
{

    public static void main(String[] args)
    {
        Frame frame = new Frame("Simple JOGL Application");
        GLCanvas canvas = new GLCanvas();

        canvas.addGLEventListener(new EnterPoint());
        frame.add(canvas);
        frame.setSize(1000, 500);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e)
            {
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

    public void init(GLAutoDrawable drawable) 
    {
        // Use debug pipeline
        // drawable.setGL(new DebugGL(drawable.getGL()));
        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) 
    {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
    }

    public void display(GLAutoDrawable drawable) 
    {       
        try
        {
            GL gl = drawable.getGL(); 
            gl.glEnable(GL.GL_DEPTH_TEST);
            gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
            
            gl.glViewport(0, 1, 500, 500);
            gl.glClearColor(0.1f, 0.1f, 0.1f, 0);
            
            
            gl.glColor3f(1, 0, 1);
            gl.glLoadIdentity();
            gl.glRotatef(-107, 1, 0, 0);
            gl.glRotatef(35,0,0,1);

            
            MyDraw drawer = new MyDraw(gl);
            drawer.DrawAxis();
            
            gl.glViewport(500, 1, 500, 500);
            gl.glOrtho(-4, 4, -4, 4, -4, 4);
            drawer.DrawSphere();
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
