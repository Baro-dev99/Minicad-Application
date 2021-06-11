package minicad;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import minicad.forms.Drawable;
import minicad.forms.FilledRectangleFactory;
import minicad.forms.FormFactory;
import minicad.states.DrawingState;
import minicad.states.State;

public class Canvas extends JPanel {

    private State state = DrawingState.INSTANCE;
    private FormFactory factory = FilledRectangleFactory.INSTANCE;    
    private List<Drawable> ls = new ArrayList<>();    
    private Color color = Color.red;

    public Canvas() {
        init();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Drawable d : ls) {
            d.draw(g);
        }
    }

    private void init() {
        setFocusable(true);
        addMouseListener(new CanvasMouseListener());
        addMouseMotionListener(new CanvasMouseMotionListener());
        addKeyListener(new CanvasKeyListener());
    }

    private class CanvasMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            state.mouseClicked(e);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            state.mousePressed(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            state.mouseReleased(e);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            state.mouseEntered(e);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            state.mouseExited(e);
        }
    }

    private class CanvasMouseMotionListener implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {
            state.mouseDragged(e);
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            state.mouseMoved(e);
        }
    }
    
    private class CanvasKeyListener implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
            state.keyTyped(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            state.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            state.keyReleased(e);
        }
        
    }

    public FormFactory getFactory() {
        return factory;
    }

    public List<Drawable> getLs() {
        return ls;
    }

    public Color getColor() {
        return color;
    }    
    
    public void setColor(Color color) {
        this.color = color;
    }

    public void setFactory(FormFactory factory) {
        this.factory = factory;
    }    

    public void setState(State state) {
        this.state = state;
    }        
}
