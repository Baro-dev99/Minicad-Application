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
public abstract class FormFactory {
    public abstract Drawable createForm(int x, int y, int width, int height, Color color);
}
