package com.tamerb.easylab.service;

import com.tamerb.easylab.model.Laborant;
import com.tamerb.easylab.repository.LaborantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LaborantService {

    @Autowired
    private LaborantRepository laborantRepository;


    public List<Laborant> listAll() {
        return laborantRepository.findAll();
    }

    public void save(Laborant laborant) {
        laborantRepository.save(laborant);
    }

    public Laborant get(Long id) {
        return laborantRepository.findById(id).get();
    }

    public void delete(Long id) {
        laborantRepository.deleteById(id);
    }

}

