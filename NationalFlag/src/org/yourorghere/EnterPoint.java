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
        Frame frame = new Frame("National Flag");
        GLCanvas canvas = new GLCanvas();

        canvas.addGLEventListener(new EnterPoint());
        frame.add(canvas);
        frame.setSize(640, 480);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                new Thread(new Runnable() {

                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        animator.start();
    }

    public void init(GLAutoDrawable drawable) {
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
            gl.glEnable(GL.GL_DEPTH_BUFFER_BIT);
            
            
            Flag flag = new Flag(gl);
            
            float x0 = -1;
            float y0 = 1;
            float lineWidth = 2;
            float lineHeigh = 0.2f;
            int countOfLines = 6;
            float blockHeigh = 1;
            float blockWidth = 0.9f;
            
            //drawing block of lines with different colors red, white, red, ... , etc.
            flag.drawStriped(x0, y0, lineWidth, lineHeigh, countOfLines, Color.RED, Color.WHITE);       
            
            //drawing blue square in the left top corner
            flag.drawSquare(x0, y0, blockWidth, blockHeigh, Color.BLUE);
            
            //drawing stars on the flag
            float dx = 0.15f;
            float dy = 0.1f;
            float radius = 0.05f;
            
            for (int i = 0; i < 4; i++) {     
                for (int j = 0; j < 6; j++)
                    flag.drawStar(x0 + dx*j + radius, y0-dy, radius, Color.WHITE);
                
                for (int j = 1; j < 6; j++)
                    flag.drawStar(x0 + dx*j, y0-2*dy, radius, Color.WHITE);
                
                y0-=2*dy;
            }
            for (int j = 0; j < 6; j++)
                flag.drawStar(x0+dx*j + radius, y0-dy, radius, Color.WHITE);
            
            
            gl.glClear(GL.GL_DEPTH_BITS);
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

