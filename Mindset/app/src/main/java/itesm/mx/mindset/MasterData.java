package itesm.mx.mindset;

import java.util.ArrayList;

/**
 * Created by Jibril on 11/9/17.
 */

public class MasterData {
    private static MasterData instance = null;

    public static ArrayList<Event> listEvents;

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

        listEvents = new ArrayList<Event>();

        Event event;
        event = new Event ("10/10/2017", "10pm", "Tarea", R.drawable.samplemeditation);
        listEvents.add(event);
        event = new Event ("10/10/2017", "11pm", "Tarea", R.drawable.samplemeditation);
        listEvents.add(event);
        event = new Event ("10/10/2017", "12pm", "Tarea", R.drawable.samplemeditation);
        listEvents.add(event);
        event = new Event ("10/10/2017", "1pm", "Meditar", R.drawable.samplemeditation);
        listEvents.add(event);
        event = new Event ("10/10/2017", "2pm", "Tarea", R.drawable.samplemeditation);
        listEvents.add(event);
        event = new Event ("10/10/2017", "3pm", "Tarea", R.drawable.samplemeditation);
        listEvents.add(event);
        event = new Event ("10/10/2017", "4pm", "Tarea", R.drawable.samplemeditation);
        listEvents.add(event);
        event = new Event ("10/10/2017", "6pm", "Trabajo", R.drawable.samplemeditation);
        listEvents.add(event);
        event = new Event ("10/10/2017", "10pm", "Tarea", R.drawable.samplemeditation);
        listEvents.add(event);
        event = new Event ("10/10/2017", "10pm", "Proyecto", R.drawable.samplemeditation);
        listEvents.add(event);
        event = new Event ("10/10/2017", "10pm", "Proyecto", R.drawable.samplemeditation);
        listEvents.add(event);
        event = new Event ("10/10/2017", "10pm", "Proyecto", R.drawable.samplemeditation);
        listEvents.add(event);
        event = new Event ("10/10/2017", "10pm", "Proyecto", R.drawable.samplemeditation);
        listEvents.add(event);
    }

    public ArrayList<Event> getAllEvents () {
        return this.listEvents;
    }

    public Event getEvent(int index) { return listEvents.get(index); }

    public int getEvent(String name) {

        for (int i = 0; i < listEvents.size(); i++) {
            if (listEvents.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
