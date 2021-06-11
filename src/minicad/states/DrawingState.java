/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minicad.states;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import minicad.forms.Drawable;

/**
 *
 * @author omar
 */
public class DrawingState extends State {

    private int px, py;
    private Drawable current = null;

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        canvas.getLs().add(current = canvas.getFactory()
                .createForm(px = e.getX(), py = e.getY(), 0, 0,
                        canvas.getColor()));
        canvas.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int dx = e.getX() - px;
        int dy = e.getY() - py;

        if (dx < 0) {
            current.setX(e.getX());
        }
        if (dy < 0) {
            current.setY(e.getY());
        }

        current.setWidth(Math.abs(dx));
        current.setHeight(Math.abs(dy));
        canvas.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static final State INSTANCE = new DrawingState();
}
