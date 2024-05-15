package nl.YEA;

import nl.YEA.view.InOutputUtil;

public class Main {
    public static void main(String[] args) {
        try {
            InOutputUtil.getInstance().getHoofdScherm().show();
        }finally {
            Singleton.getInstance().closeDbConnection();
        }
    }
}