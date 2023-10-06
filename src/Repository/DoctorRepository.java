package Repository;

import DataAccess.DoctorDao;
import java.util.ArrayList;
import model.Doctor;

public class DoctorRepository implements IDoctorRepository {

    @Override
    public void addDoctor(ArrayList<Doctor> ld) {
        DoctorDao.Instance().addDoctor(ld);
    }

    @Override
    public void updateDoctor(ArrayList<Doctor> ld) {
        DoctorDao.Instance().updateDoctor(ld);
    }

    @Override
    public void deleteDoctor(ArrayList<Doctor> ld) {
        DoctorDao.Instance().deleteDoctor(ld);
    }

    @Override
    public void searchDoctor(ArrayList<Doctor> ld) {
        DoctorDao.Instance().searchDoctor(ld);
    }
}
