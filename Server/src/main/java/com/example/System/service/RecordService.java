package com.example.System.service;

import com.example.System.entity.RecordCenter;
import com.example.System.exception.UserNotFoundException;
import com.example.System.model.ModelRecord;
import com.example.System.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecordService {
    private final RecordRepository recordRepository;

    @Autowired
    public RecordService(RecordRepository recordRepository){this.recordRepository = recordRepository;}

    public RecordCenter saveRecord(RecordCenter record) {
        return recordRepository.save(record);
    }

    public List<ModelRecord> findAllRecord(){
        return recordRepository.findAll().stream().map(ModelRecord::toModel).collect(Collectors.toList());
    }

    public ModelRecord getOneRecord(Long id, String login, String password) throws UserNotFoundException {
        RecordCenter record = recordRepository.findOne(id, login, password);
        if (record == null) {
            throw new UserNotFoundException("Запись не найдена.");
        }
        return ModelRecord.toModel(record);
    }

    public RecordCenter updateRecord(RecordCenter record) { return recordRepository.update(record); }

    public Long deleteRecord(Long id) {
        recordRepository.deleteById(id);
        return id;
    }
}
