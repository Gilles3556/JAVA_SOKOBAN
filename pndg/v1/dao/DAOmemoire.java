package pndg.v1.dao;

public class DAOmemoire {
    public final static int MAX_LEVEL=4;

    public final static String LEVEL1
            = "                \n"
            + "                \n"
            + "                \n"
            + "                \n"
            + "      ###       \n"
            + "      #.#       \n"
            + "      # ####    \n"
            + "    ###$ $.#    \n"
            + "    #. $@###    \n"
            + "    ####$#      \n"
            + "       #.#      \n"
            + "       ###      \n"
            + "               \n"
            + "                \n"
            + "                \n"
            + "                \n";

    public final static String LEVEL2
        = "                 \n"
        + "                 \n"
        + "                 \n"
        + "    #####        \n"
        + "    #  @#        \n"
        + "    # $$# ###    \n"
        + "    # $ # #.#    \n"
        + "    ### ###.#    \n"
        + "     ##    .#    \n"
        + "     #   #  #    \n"
        + "     #   ####    \n"
        + "     #####       \n"
        + "                 \n"
        + "                 \n"
        + "                 \n"
        + "                 \n";

    public final static String LEVEL3
            ="                \n"
            +"                \n"
            +"                \n"
            +"                \n"
            +"    ####        \n"
            +"   ##  #        \n"
            +"   # @$##       \n"
            +"   ##$ ##       \n"
            +"   ## $##       \n"
            +"   #.$  #       \n"
            +"   #.. .#       \n"
            +"   ######       \n"
            +"                \n"
            +"                \n"
            +"                \n"
            +"                \n";

    public final static String LEVEL4
            = "    ######\n"
            + "    ##   #\n"
            + "    ##$  #\n"
            + "  ####  $##\n"
            + "  ##  $ $ #\n"
            + "#### # ## #   ######\n"
            + "##   # ## #####  ..#\n"
            + "## $  $    @     ..#\n"
            + "###### ### # ##  ..#\n"
            + "    ##     #########\n"
            + "    ########\n";

    public final static String LEVEL5
            = "    ######\n"
            + "######   #\n"
            + "##  ##   #\n"
            + "##      $##\n"
            + "##      $ #\n"
            + "#### # ## #   ######\n"
            + "##   # ## #####   .#\n"
            + "## $              .#\n"
            + "######@### # ##   .#\n"
            + "    ##     #########\n"
            + "    ########\n";

    public DAOmemoire(){    }

    public String getLevel(int noLevel) throws DAOmemoireException {
        if (noLevel>MAX_LEVEL){
            throw new DAOmemoireException("ERR: FIN des niveaux");
        }
        String retour=null;
        switch (noLevel){
            case 1: retour =  LEVEL1;
                 break;
            case 2: retour =  LEVEL2;
                break;
            case 3: retour =  LEVEL3;
                break;
            case 4: retour =  LEVEL4;
                break;
        }
        return retour;
    }




}
