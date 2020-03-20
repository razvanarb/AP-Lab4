package Lab4.Compulsory;


import java.util.ArrayList;

public class Hospital implements Comparable{
    private String name;
    private int capacity;
    private ArrayList<Resident> preferences;

    public Hospital(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.preferences = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void addPreference(Resident r) {
        if (!preferences.contains(r))
            preferences.add(r);
    }
    public ArrayList<Resident> getPreferences() {
        return preferences;
    }


    @Override
    public int compareTo(Object o) {
        Hospital h = (Hospital) o;
        return this.getName().compareTo(h.getName());
    }
}