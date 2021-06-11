/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minicad.states;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import minicad.Canvas;

/**
 *
 * @author omar
 */
public abstract class State {

    protected Canvas canvas;

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public abstract void mouseClicked(MouseEvent e);

    public abstract void mousePressed(MouseEvent e);

    public abstract void mouseReleased(MouseEvent e);

    public abstract void mouseEntered(MouseEvent e);

    public abstract void mouseExited(MouseEvent e);

    public abstract void mouseDragged(MouseEvent e);

    public abstract void mouseMoved(MouseEvent e);

    public abstract void keyTyped(KeyEvent e);

    public abstract void keyPressed(KeyEvent e);

    public abstract void keyReleased(KeyEvent e);

}
