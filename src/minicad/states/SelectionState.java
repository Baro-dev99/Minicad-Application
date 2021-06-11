package minicad.states;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import minicad.forms.Drawable;

public class SelectionState extends State {

    private int px, py;
    List<Drawable> slist = new ArrayList<>();
    private Drawable copy = null;

    private void clearSelection() {
        for (Drawable d : slist) {
            d.setSelected(false);
        }
        slist.clear();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        List<Drawable> ls = canvas.getLs();
        Drawable d = null;
        for (int i = ls.size() - 1; i >= 0; i--) {
            if (ls.get(i).contains(e.getX(), e.getY())) {
                d = ls.get(i);
                break;
            }
        }

        if (e.isControlDown()) {// ctrl key pressed
            if (d == null) {
                return;
            } else if (slist.contains(d)) {
                d.setSelected(false);
                slist.remove(d);
                canvas.repaint();
            } else {
                d.setSelected(true);
                slist.add(0, d);
                canvas.repaint();
            }
        } else {
            if (d == null) {
                clearSelection();
                canvas.repaint();
            } else if (slist.contains(d)) {
//                clearSelection();
//                d.setSelected(true);
//                slist.add(d);
//                canvas.getLs().remove(d);
//                canvas.getLs().add(d);
//                canvas.repaint();
            } else {
                clearSelection();
                d.setSelected(true);
                slist.add(d);
                canvas.getLs().remove(d);
                canvas.getLs().add(d);
                canvas.repaint();
            }
        }

        px = e.getX();
        py = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        canvas.requestFocusInWindow();
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (slist.isEmpty()) {
            return;
        }
        for (Drawable d : slist) {
            d.move(e.getX() - px, e.getY() - py);
        }

        px = e.getX();
        py = e.getY();
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
        if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_C
                && slist.size() == 1) {
            try {
                copy = (Drawable) slist.get(0).clone();
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(SelectionState.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_V) {
            copy.move(10, 10);
            canvas.getLs().add(copy);
            copy.setSelected(false);
            canvas.repaint();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static final State INSTANCE = new SelectionState();
}
