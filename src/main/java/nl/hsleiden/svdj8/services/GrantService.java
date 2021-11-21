package nl.hsleiden.svdj8.services;

import nl.hsleiden.svdj8.exceptions.NoGrantFoundException;
import nl.hsleiden.svdj8.models.tables.Grant;
import nl.hsleiden.svdj8.repository.GrantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GrantService {

    private final GrantRepository grantRepository;

    @Autowired
    public GrantService(GrantRepository grantRepository){
        this.grantRepository = grantRepository;
    }

    public Grant addGrant(Grant grant){
        return grantRepository.save(grant);
    }

    public List<Grant> getGrants(){
        return StreamSupport
                .stream(grantRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    public Grant getGrant(Long id){
        return grantRepository.findById(id).orElseThrow(() ->
                new RuntimeException(new NoGrantFoundException(id)));
    }

    public Grant deleteGrant(Long id){
        Grant grant = getGrant(id);
        grantRepository.delete(grant);
        return grant;
    }

    public Grant editGrant(Long id, Grant grant){
        Grant grantToEdit = getGrant(id);
        grantToEdit.setDescription(grant.getDescription());
        grantToEdit.setName(grant.getName());
//        grantToEdit.setKeywords(grant.getKeywords());
        return grant;
    }
}
