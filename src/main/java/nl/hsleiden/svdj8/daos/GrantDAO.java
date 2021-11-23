package nl.hsleiden.svdj8.daos;

import nl.hsleiden.svdj8.models.tables.GivenAnswer;
import nl.hsleiden.svdj8.models.tables.Grant;
import nl.hsleiden.svdj8.repository.GrantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Component
public class GrantDAO {

    @Autowired
    private GrantRepository grantRepository;

    public GrantDAO(GrantRepository grantRepository) {
        this. grantRepository = grantRepository;
    }

    public List<Grant> getAll(){
        ArrayList<Grant> grants = (ArrayList<Grant>) this.grantRepository.findAll();
        grants.sort(Comparator.comparingLong(Grant::getGrantID));
        return grants;
    }

    public Grant getById(long id) {
        Optional<Grant> optionalGrant = grantRepository.findById(id);
        return optionalGrant.orElse(null);
    }
    public Optional<Grant> getByIdOptional(long id){
        Optional<Grant> optionalGrant = grantRepository.findById(id);
        return optionalGrant;
    }

    public Grant addGrant(Grant newGrant){
        return grantRepository.save(newGrant);
    }

    public void deleteById(long id){
        grantRepository.deleteById(id);
    }
}
