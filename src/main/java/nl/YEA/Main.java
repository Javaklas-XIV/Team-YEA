package nl.YEA;

import nl.YEA.view.InOutputUtil;

public class Main {
    public static void main(String[] args) {
        InOutputUtil.getInstance().getHoofdScherm().show();
        Singleton.getInstance().closeDbConnection();
    }
}