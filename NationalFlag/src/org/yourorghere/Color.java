package org.yourorghere;

public class Color {
    
    public Color(float red, float green, float blue){
        _red = red;
        _green = green;
        _blue = blue;
    }
    
    
    public float getRed() {
        return _red;
    }

    public float getGreen() {
        return _green;
    }

    public float getBlue() {
        return _blue;
    }
    
    public static final Color RED = new Color(1, 0, 0);
    public static final Color GREEN = new Color(0, 1, 0);
    public static final Color BLUE = new Color(0,0,1);
    public static final Color WHITE = new Color(1,1,1);
    
    private float _red, _green, _blue;
    
}
