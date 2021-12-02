package pndg.v3.start;

import pndg.v3.dao.DAOmemoireException;
import pndg.v3.presenter.Presenter;

import java.awt.*;

public class LanceurV3 {
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
