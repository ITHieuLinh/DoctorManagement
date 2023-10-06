package controller;

import Repository.DoctorRepository;
import java.util.ArrayList;
import model.Doctor;
import view.Menu;

public class DoctorManagement extends Menu<String> {

    static String[] mc = {"Add Doctor", "Update Doctor", "Delete Doctor", "Search Doctor", "Exit"};
    ArrayList<Doctor> ld;
    DoctorRepository program;

    public DoctorManagement() {
        super("       Doctor Management", mc);
        ld = new ArrayList<>();
        program = new DoctorRepository();

    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                program.addDoctor(ld);
                break;
            case 2:
                program.updateDoctor(ld);
                break;
            case 3:
                program.deleteDoctor(ld);
                break;
            case 4:
                program.searchDoctor(ld);
                break;
            case 5:
                System.exit(0);
        }
    }
}
