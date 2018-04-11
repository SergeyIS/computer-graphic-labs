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
            
            double x0 = 0;
            double y0 = 0;
            double R = 0.3f;
            double count = 16;    
            double delta = Math.PI/count;
            double alpha = 0;
            double x, y;
            
            gl.glColor3d(1, 1, 1);
            gl.glLineWidth(2);
            gl.glBegin(GL.GL_LINE_LOOP);
                double x1, y1;
                for (int j = 0; j <= 2*count; j++) {

                    if(j % 2 == 0){
                        x = x0 + R*Math.cos(alpha);
                        y = y0 + R*Math.sin(alpha);
                        x1 = x0 + R*Math.cos(alpha+delta);
                        y1 = y0 + R*Math.sin(alpha+delta);
                    }
                    else{
                        x = x0 + (R + R/4)*Math.cos(alpha);
                        y = y0 + (R + R/4)*Math.sin(alpha);
                        x1 = x0 +(R + R/4)*Math.cos(alpha+delta);
                        y1 = y0 + (R + R/4)*Math.sin(alpha+delta);
                    }

                    gl.glVertex2d(x, y); 
                    gl.glVertex2d(x1, y1);
                    alpha+=delta;
                }
            gl.glEnd();  
            
            gl.glBegin(GL.GL_LINE_LOOP);
                for (int j = 0; j <= 2*count; j++) {
                        x = x0 + R/2*Math.cos(alpha);
                        y = y0 + R/2*Math.sin(alpha);
                        x1 = x0 + R/2*Math.cos(alpha+delta);
                        y1 = y0 + R/2*Math.sin(alpha+delta);

                    gl.glVertex2d(x, y); 
                    gl.glVertex2d(x1, y1);
                    alpha+=delta;
                }
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

