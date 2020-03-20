package Lab4.Compulsory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main
{

    public static void main(String[] args)
    {
        //Create residents & sort them

        Stream<Resident> residentsStream = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Resident("R" + i));
        ArrayList<Resident> residentsArrayList = residentsStream.sorted((Comparator.comparing(Resident::getName))).collect(Collectors.toCollection(ArrayList::new));

        //Create hospitals

        Stream<Hospital> hospitalsStream = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Hospital("H" + i, 2));
        TreeSet<Hospital> hospitalsTreeSet = hospitalsStream.collect(Collectors.toCollection(TreeSet::new));
        Hospital H0 = new Hospital("H0", 1);
        hospitalsTreeSet.remove(H0);
        hospitalsTreeSet.add(H0);

        //Resident preference HashMap

        ArrayList<Hospital> hospitalsArrayList = new ArrayList<Hospital>( hospitalsTreeSet);

        Resident resident_0 = residentsArrayList.get(0);
        Resident resident_1 = residentsArrayList.get(1);
        Resident resident_2 = residentsArrayList.get(2);
        Resident resident_3 = residentsArrayList.get(3);

        Hospital hospital_0 = hospitalsArrayList.get(0);
        Hospital hospital_1 = hospitalsArrayList.get(1);
        Hospital hospital_2 = hospitalsArrayList.get(2);

        resident_0.addPreference(hospital_0);
        resident_0.addPreference(hospital_1);
        resident_0.addPreference(hospital_2);

        resident_1.addPreference(hospital_0);
        resident_1.addPreference(hospital_1);
        resident_1.addPreference(hospital_2);

        resident_2.addPreference(hospital_0);
        resident_2.addPreference(hospital_1);

        resident_3.addPreference(hospital_0);
        resident_3.addPreference(hospital_2);

        Map<Resident, ArrayList<Hospital>> resPrefMap = new HashMap<>();
        for (Resident resid : residentsArrayList) {
            resPrefMap.put(resid, resid.getPreferences());
        }
        System.out.print(" Rezidenti si preferintele lor: \n");
        resPrefMap.forEach((resident, hospitalPref) -> { System.out.print(resident.getName() + ": ");
        System.out.print("[");
        for (Hospital hospital : hospitalPref) {
                System.out.print(hospital.getName() + " ");
            }
            System.out.print("]\n");
        });

        System.out.print("\n");

        //Hospital preference LinkedHashMap

        hospital_0.addPreference(resident_3);
        hospital_0.addPreference(resident_0 );
        hospital_0.addPreference(resident_1);
        hospital_0.addPreference(resident_2);

        hospital_1.addPreference(resident_0 );
        hospital_1.addPreference(resident_2);
        hospital_1.addPreference(resident_1);

        hospital_2.addPreference(resident_0 );
        hospital_2.addPreference(resident_1);
        hospital_2.addPreference(resident_3);

        Map<Hospital, ArrayList<Resident>> hosPrefMap = new LinkedHashMap<>();
        for (Hospital hosp: hospitalsArrayList) {
            hosPrefMap.put(hosp, hosp.getPreferences());
        }
        System.out.print(" Spitale si preferintele lor: \n");
        hosPrefMap.forEach((hospital, residentPref) -> { System.out.print(hospital.getName() + ": ");
            System.out.print("[");
            for (Resident resident : residentPref) {
                System.out.print(resident.getName() + " ");
            }
            System.out.print("]\n");
        });
        System.out.print("\n");

        //Hospitals that have R0 as their top preference

        System.out.print(" Spitale care prefera R0: \n");
        hospitalsArrayList.stream().filter(hos -> {
            if (hos.getPreferences().get(0).equals(resident_0))
                return true;
            else
                return false;
            })
                .forEach(hos -> System.out.println(hos.getName()));
        System.out.print("\n");

        //Display the residents who find acceptable H0 and H2

        System.out.print(" Rezidenti care considera H0 si H2: \n");
        List<Hospital> target = Arrays.asList(hospital_0, hospital_2);
        residentsArrayList.stream().filter(res -> resPrefMap.get(res).containsAll(target))
        .forEach(res -> {
            System.out.println(res.getName());
        });
    }
}
