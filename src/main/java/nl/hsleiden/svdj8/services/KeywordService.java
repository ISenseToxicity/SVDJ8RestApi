package nl.hsleiden.svdj8.services;

import nl.hsleiden.svdj8.exceptions.NoKeywordFoundException;
import nl.hsleiden.svdj8.models.tables.Keyword;
import nl.hsleiden.svdj8.repository.KeywordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class KeywordService {

    private final KeywordRepository keywordRepository;

    @Autowired
    public KeywordService(KeywordRepository keywordRepository){
        this.keywordRepository = keywordRepository;
    }

    public Keyword addKeyword(Keyword keyword){
        return keywordRepository.save(keyword);
    }

    public List<Keyword> getKeywords(){
        return StreamSupport
                .stream(keywordRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    public Keyword getKeyword(Long id){
        return keywordRepository.findById(id).orElseThrow(() ->
        new RuntimeException(new NoKeywordFoundException(id)));
    }

    public Keyword deleteKeyword(Long id){
        Keyword keyword = getKeyword(id);
        keywordRepository.delete(keyword);
        return keyword;
    }

    public Keyword editKeyword(Long id, Keyword keyword){
        Keyword keywordToEdit = getKeyword(id);
        keywordToEdit.setGrant(keywordToEdit.getGrant());
        keywordToEdit.setRestriction(keyword.getRestriction());
        return keywordToEdit;
    }
}
