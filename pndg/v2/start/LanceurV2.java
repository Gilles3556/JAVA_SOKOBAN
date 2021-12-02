package pndg.v2.start;

import pndg.v2.dao.DAOmemoireException;
import pndg.v2.presenter.Presenter;

import java.awt.*;

public class LanceurV2 {
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
