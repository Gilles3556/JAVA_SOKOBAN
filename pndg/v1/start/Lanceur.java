package pndg.v1.start;

import pndg.v1.dao.DAOmemoireException;
import pndg.v1.presenter.Presenter;

import java.awt.*;

public class Lanceur {
    public static void main( String[] args ) {
        EventQueue.invokeLater(() -> {
            Presenter pres = null;
            try {
                pres = new Presenter();
                pres.exec();
            } catch (DAOmemoireException e) {
                e.printStackTrace();
            }

        });
    }
}
