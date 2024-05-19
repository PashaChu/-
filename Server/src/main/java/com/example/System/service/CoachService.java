package com.example.System.service;

import com.example.System.entity.Coach;
import com.example.System.exception.UserNotFoundException;
import com.example.System.model.ModelCoach;
import com.example.System.repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoachService {
    private final CoachRepository coachRepository;

    @Autowired
    public CoachService(CoachRepository coachRepository){this.coachRepository = coachRepository;}

    public Coach saveCoach(Coach coach) {
        return coachRepository.save(coach);
    }

    public List<ModelCoach> findAllCoach(){
        return coachRepository.findAll().stream().map(ModelCoach::toModel).collect(Collectors.toList());
    }

    public ModelCoach getOneCoach(Long id) throws UserNotFoundException {
        Coach coach = coachRepository.findById(id);
        if (coach == null) {
            throw new UserNotFoundException("Тренер не найден.");
        }
        return ModelCoach.toModel(coach);
    }

    public Coach updateCoach(Coach coach) { return coachRepository.update(coach); }

    public Long deleteCoach(Long id) {
        coachRepository.deleteById(id);
        return id;
    }
}
