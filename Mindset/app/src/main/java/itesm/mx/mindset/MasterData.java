package itesm.mx.mindset;

import java.util.ArrayList;

/**
 * Created by Jibril on 11/9/17.
 */

public class MasterData {
    private static MasterData instance = null;

    public static ArrayList<Tip> listTips;

    private MasterData() {

        createData();
        if (instance != null) {
            throw new RuntimeException("Use getInstance() to get a single instance of MasterData");
        }

    }

    public static MasterData getInstance() {
        if (instance == null) {
            synchronized (MasterData.class) {
                if (instance == null) {
                    instance = new MasterData();
                }
            }
        }
        return instance;
    }

    private void createData() {

        listTips = new ArrayList<Tip>();

        Tip tip;
        tip = new Tip("Tip para diet", "Descripcion para diet", "diet", R.drawable.diethealth);
        listTips.add(tip);
        tip = new Tip("Tip para physical", "Descripcion para physical", "physical", R.drawable.physicalhealth);
        listTips.add(tip);
        tip = new Tip("Tip para mental", "Descripcion para mental", "mental", R.drawable.mentalhealth);
        listTips.add(tip);
        tip = new Tip("Tip para heart", "Descripcion para heart", "heart", R.drawable.hearthealth);
        listTips.add(tip);
        tip = new Tip("Tip para sleep", "Descripcion para sleep", "sleep", R.drawable.sleephealth);
        listTips.add(tip);
    }

    public ArrayList<Tip> getAllTips () {
        return this.listTips;
    }

    public Tip getTips(int index) { return listTips.get(index); }

    public int getTips(String name) {

        for (int i = 0; i < listTips.size(); i++) {
            if (listTips.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
