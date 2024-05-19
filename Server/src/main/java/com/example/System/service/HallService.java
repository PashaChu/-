package com.example.System.service;

import com.example.System.entity.Hall;
import com.example.System.exception.UserNotFoundException;
import com.example.System.model.ModelHall;
import com.example.System.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HallService {
    private final HallRepository hallRepository;

    @Autowired
    public HallService(HallRepository hallRepository){this.hallRepository = hallRepository;}

    public Hall saveHall(Hall hall) {
        return hallRepository.save(hall);
    }

    public List<ModelHall> findAllHall(){
        return hallRepository.findAll().stream().map(ModelHall::toModel).collect(Collectors.toList());
    }

    public ModelHall getOneHall(Long id) throws UserNotFoundException {
        Hall hall = hallRepository.findById(id);
        if (hall == null) {
            throw new UserNotFoundException("Зал не найден.");
        }
        return ModelHall.toModel(hall);
    }

    public Hall updateHall(Hall hall) { return hallRepository.update(hall); }

    public Long deleteHall(Long id) {
        hallRepository.deleteById(id);
        return id;
    }
}
