package com.example.System.service;

import com.example.System.entity.Training;
import com.example.System.exception.UserNotFoundException;
import com.example.System.model.ModelTraining;
import com.example.System.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingService {

    private final TrainingRepository trainingRepository;

    @Autowired
    public TrainingService(TrainingRepository trainingRepository){this.trainingRepository = trainingRepository;}

    public Training saveTraining(Training training) {
        return trainingRepository.save(training);
    }

    public List<ModelTraining> findAllTraining(){
        return trainingRepository.findAll().stream().map(ModelTraining::toModel).collect(Collectors.toList());
    }

    public ModelTraining getOneTraining(Long id) throws UserNotFoundException {
        Training training = trainingRepository.findById(id);
        if (training == null) {
            throw new UserNotFoundException("Данный вид тернировки не найден.");
        }
        return ModelTraining.toModel(training);
    }

    public Training updateTraining(Training training) { return trainingRepository.update(training); }

    public Long deleteTraining(Long id) {
        trainingRepository.deleteById(id);
        return id;
    }
}
