/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minicad.forms;

import java.awt.Color;

/**
 *
 * @author omar
 */
public class FilledRectangleFactory extends FormFactory{

    @Override
    public Drawable createForm(int x, int y, int width, int height, Color color) {
        return new FilledRectangle(x, y, width, height, color);
    }
    
    public static final FormFactory INSTANCE = new FilledRectangleFactory();
}
