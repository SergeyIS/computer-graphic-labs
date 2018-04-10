package org.yourorghere;

import javax.media.opengl.GL;

public class Flag {
    
    public Flag(GL gl){
        _gl = gl;
    }
    
    public void drawSquare(float left, float top, float width, float heigh, Color color){
        
        _gl.glBegin(GL.GL_QUADS);
            _gl.glColor3f(color.getRed(),color.getGreen(),color.getBlue());
            _gl.glVertex2f(left, top);
            _gl.glVertex2f(left, top - heigh);
            _gl.glVertex2f(left + width, top - heigh);
            _gl.glVertex2f(left + width, top);
        _gl.glEnd();
        _gl.glColor3f(0, 0, 0);
    }
   
    public void drawStriped(float left, float top, float width, float heigh, int count, Color color1, Color color2){
        
        _gl.glBegin(GL.GL_QUADS);
            for (int i = 1; i <= count; i++) {
                _gl.glColor3f(color1.getRed(), color1.getGreen(), color1.getBlue());
                _gl.glVertex2f(left, top);
                _gl.glVertex2f(left, top - heigh);
                _gl.glVertex2f(left + width, top - heigh);        
                _gl.glVertex2f(left + width, top);   

                top-=heigh;
                _gl.glColor3f(color2.getRed(), color2.getGreen(), color2.getBlue());
                _gl.glVertex2f(left, top);
                _gl.glVertex2f(left, top - heigh);
                _gl.glVertex2f(left + width, top - heigh);        
                _gl.glVertex2f(left + width, top);
                
                top-=heigh;
            }
        _gl.glEnd();
        _gl.glColor3f(0, 0, 0);
    }
    
    
    
    public void drawStar(float xCenter, float yCenter, float radius, Color color)
    {
        float x, y;
        float step = (float)(Math.PI * 4 / 5);
        float angle = (float)(-Math.PI/2);
        
        _gl.glColor3f(color.getRed(), color.getGreen(), color.getBlue());
        _gl.glBegin(GL.GL_LINE_LOOP);
            for (int i = 0; i < 5; ++i, angle += step)
            {
                x = xCenter + radius * (float)Math.cos(angle);
                y = yCenter + radius * (float)Math.sin(angle);
                _gl.glVertex2f(x, y);
            }
        _gl.glEnd();
        _gl.glColor3f(0, 0, 0);
    }
    
    private GL _gl;
}
