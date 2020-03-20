package Lab4.Compulsory;

import java.util.ArrayList;

public class Resident
{
    private String name;
    private ArrayList<Hospital> preferences;

    public Resident(String name)
    {
        this.name = name;
        this.preferences = new ArrayList<>();
    }

    public String getName()
    {
        return name;
    }

    public void addPreference(Hospital h) {
        if (!preferences.contains(h))
            preferences.add(h);
    }
    public ArrayList<Hospital> getPreferences() {
        return preferences;
    }

}
