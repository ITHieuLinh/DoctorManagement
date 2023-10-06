package DataAccess;

import common.Library;
import common.Validation;
import java.util.ArrayList;
import model.Doctor;

public class DoctorDao {

    private static DoctorDao instance = null;
    Library l;
    Validation v;
    //Validation valid;
    ArrayList<Doctor> list;

    public DoctorDao() {
        l = new Library();
        v = new Validation();
        //valid = new Validation();
        list = new ArrayList<>();
    }

    public static DoctorDao Instance() {
        if (instance == null) {
            synchronized (DoctorDao.class) {
                if (instance == null) {
                    instance = new DoctorDao();
                }
            }
        }
        return instance;
    }

    //allow user add doctor
    public void addDoctor(ArrayList<Doctor> ld) {
        String code = l.inputString("Enter code: ");
        //check code exist or not
        if (!v.checkCodeExist(ld, code)) {
            System.err.println("Code exist.");
            code = l.inputString("Enter code again: ");
        }
        String name = l.inputString("Enter name: ");
        String specialization = l.inputString("Enter specialization: ");
        int availability = v.getIntNoLimit("Enter availability ");
        //check worker duplicate
        if (!v.checkDuplicate(ld, code, name, specialization, availability)) {
            System.err.println("Duplicate.");
            return;
        }
        ld.add(new Doctor(code, name, specialization, availability));
        System.err.println("Add successful.");
    }

    //allow user update doctor
    public void updateDoctor(ArrayList<Doctor> ld) {
        if (ld.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        String code = l.inputString("Enter code: ");
        //check code exist or not
        if (v.checkCodeExist(ld, code)) {
            System.err.println("Not found doctor");
            code = l.inputString("Enter code again: ");
        }
        String codeUpdate = l.inputString("Enter update code: ");
        Doctor doctor = getDoctorByCode(ld, code);
        String name = l.inputString("Enter update name: ");
        String specialization = l.inputString("Enter update specialization: ");
        int availability = v.getIntNoLimit("Enter availability ");
        //check user change infomation or not
        if (!v.checkDuplicate(ld, code, name, specialization, availability)) {
            System.err.println("Duplicate doctor information");
            return;
        }
        doctor.setCode(codeUpdate);
        doctor.setName(name);
        doctor.setSpecialization(specialization);
        doctor.setAvailability(availability);
        System.err.println("Update successful");
    }

    //allow user delete doctor
    public void deleteDoctor(ArrayList<Doctor> ld) {
        if (ld.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        String code = l.inputString("Enter code: ");
        //check code exist or not
        if (v.checkCodeExist(ld, code)) {
            System.err.println("Not found doctor");
            return;
        }
        Doctor doctor = getDoctorByCode(ld, code);
        if (doctor == null) {
            System.err.println("Not found doctor.");
            return;
        } else {
            ld.remove(doctor);
        }
        System.err.println("Delete successful.");
    }

    //allow user search doctor
    public void searchDoctor(ArrayList<Doctor> ld) {
        if (ld.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        String searchString = l.inputString("Enter text: ");
        ArrayList<Doctor> listFoundByString = getListDoctorByString(ld, searchString);
        if (listFoundByString.isEmpty()) {
            System.err.println("No result");
        } else {
            System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name",
                    "Specialization", "Availability");
            for (Doctor doctor : listFoundByString) {
                System.out.printf("%-10s%-15s%-25s%-20d\n", doctor.getCode(),
                        doctor.getName(), doctor.getSpecialization(),
                        doctor.getAvailability());
            }
        }
    }

    //get docter by code
    public Doctor getDoctorByCode(ArrayList<Doctor> ld, String code) {
        for (Doctor doctor : ld) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return doctor;
            }
        }
        return null;
    }

    public ArrayList<Doctor> getListDoctorByString(ArrayList<Doctor> ld, String searchString) {
        ArrayList<Doctor> list = new ArrayList<>();
        for (Doctor doctor : ld) {
            if (doctor.getCode().contains(searchString) || doctor.getName().contains(searchString)
                    || doctor.getSpecialization().contains(searchString)) {
                list.add(doctor);
            }
        }
        return list;
    }
}
