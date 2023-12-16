package com.demo.SpringSecurityTest.promessManagement.services;

import com.demo.SpringSecurityTest.promessManagement.entity.Promess;
import com.demo.SpringSecurityTest.promessManagement.repositories.PromessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PromessService {

    public final PromessRepository promessRepository;

    public List<Promess>getAllPrmoess(){
        return promessRepository.findAll();
    }
    
    public Promess addPromess(Promess promess)
    {
        return promessRepository.save(promess);
    }

    public Promess deletePromess(Long id)
    {
        Optional<Promess> promess = promessRepository.findById(id);
        this.promessRepository.delete(promess.get());
        return promess.get();
    }

    public Promess updatePromess(Promess promess)
    {
        Optional<Promess> currentPromess = promessRepository.findById(promess.getIdPromess());
        if(currentPromess.isPresent())
        {
            promessRepository.saveAndFlush(promess);
            return currentPromess.get();
        }
        else return null;
    }
}
