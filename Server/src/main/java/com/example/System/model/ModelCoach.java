package com.example.System.model;

import com.example.System.entity.Client;
import com.example.System.entity.Coach;

import java.util.List;
import java.util.stream.Collectors;

public class ModelCoach {

    private Long id;
    private String surname;
    private String name;
    private String patronymic;
    private List<ModelRecord> records;

    public static ModelCoach toModel(Coach entity) {
        ModelCoach model = new ModelCoach();
        model.setId(entity.getId());
        model.setSurname(entity.getSurname());
        model.setName(entity.getName());
        model.setPatronymic(entity.getPatronymic());
        model.setRecords(entity.getRecords().stream().map(ModelRecord::toModel).collect(Collectors.toList()));
        return model;
    }

    public List<ModelRecord> getRecords(){return records;}
    public void setRecords(List<ModelRecord> records) {this.records = records;}

    public ModelCoach(){}

    public Long getId(){return id;}
    public void setId(Long id) {this.id = id;}

    public String getSurname(){return surname;}
    public void setSurname(String surname){this.surname = surname;}

    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public String getPatronymic(){return patronymic;}
    public void setPatronymic(String patronymic){this.patronymic = patronymic;}

}
