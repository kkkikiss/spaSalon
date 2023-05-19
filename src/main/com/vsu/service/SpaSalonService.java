package main.com.vsu.service;
import main.com.vsu.entity.SpaSalon;
import main.com.vsu.repository.SpaSalonRepository;

import java.util.Collection;
import java.util.Objects;

public class SpaSalonService {

    private final SpaSalonRepository spaSalonRepository;

    public SpaSalonService(SpaSalonRepository spaSalonRepository) {
        this.spaSalonRepository = spaSalonRepository;
    }

    public Collection<SpaSalon> getSpaSalonList(Long idProfile) {
        return spaSalonRepository.getByIdProfile(idProfile);
    }

    public void addSpaSalon(SpaSalon spaSalon) {
        spaSalonRepository.insert(spaSalon);
    }

    public  boolean canModify(Long idProfile, Long idSpaSalon) {
        SpaSalon spaSalon = spaSalonRepository.getById(idSpaSalon);
        if (spaSalon == null) {
            return  false;
        }
        return Objects.equals(spaSalon.getIdProfile(), idProfile);
    }

    public void  deleteSpaSalon(Long id){
        spaSalonRepository.delete(id);
    }

    public SpaSalon getSpaSalon(Long id){
        return spaSalonRepository.getById(id);
    }

    public void  editSpaSalon(SpaSalon spaSalon){
        spaSalonRepository.update(spaSalon);
    }
}
