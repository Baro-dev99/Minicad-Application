/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minicad.forms;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author omar
 */
public class Rectangle extends Form {

    public Rectangle(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }    
    
    @Override
    public void draw(Graphics g) {
        if (selected) {
            g.setColor(color.darker());
        } else {
            g.setColor(color);
        }
        g.drawRect(x, y, width, height);
    }

    @Override
    public void fill(Graphics g, Color c) {
    }
}
