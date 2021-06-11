
package minicad.forms;

import java.awt.Color;
import java.awt.Graphics;

public interface Drawable extends Cloneable{

    public void move(int dx, int dy);

    public void draw(Graphics g);

    public boolean contains(int px, int py);

    public void fill(Graphics g, Color c);

    //getters and setters
    public int getX();

    public void setX(int x);

    public int getY();

    public void setY(int y);

    public int getWidth();

    public void setWidth(int width);

    public int getHeight();

    public void setHeight(int height);

    public Color getColor();

    public void setColor(Color color);

    public void setSelected(boolean b);

    public boolean isSelected();
        
    public Object clone() throws CloneNotSupportedException;
}
