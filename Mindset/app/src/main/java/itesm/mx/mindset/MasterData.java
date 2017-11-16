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
        tip = new Tip("Nutrición", " Una alimentación balanceada te permite cumplir tus antojos de vez en cuando. \n" +
                "Es importante incluir alimentos que nutran el cuerpo para tener una vida armoniosa.", "nutricion", R.drawable.diethealth);
        listTips.add(tip);
        tip = new Tip("Físico", "Consistencia es la clave para el\n" +
                "Éxito! No te rindas y dedica tiempo a mantener tu cuerpo saludable. Mínimo 30 minutos diarios.", "fisico", R.drawable.physicalhealth);
        listTips.add(tip);
        tip = new Tip("Salud mental", "Enfócate en ti y en como te sientes, si eres feliz, \nsi vas siendo mejor persona, y si te sientes pleno contigo mismo.", "mental", R.drawable.mentalhealth);
        listTips.add(tip);
        tip = new Tip("Salud", "Recuerda siempre cuidarte a ti mismo en todos los aspectos para cuidar de tu salud.", "salud", R.drawable.hearthealth);
        listTips.add(tip);
        tip = new Tip("Descanso", "El descanso es fundamental para el balance de la vida. \n" +
                "Descansar el tiempo adecuado, quema calorías, regenera células y mantiene tu piel Fresca y sana.", "descanso", R.drawable.sleephealth);
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
