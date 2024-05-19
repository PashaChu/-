package com.example.System.model;

import com.example.System.entity.Training;

import java.util.List;
import java.util.stream.Collectors;

public class ModelTraining {

    private Long id;
    private String title;
    private List<ModelRecord> records;

    public static ModelTraining toModel(Training entity){
        ModelTraining model = new ModelTraining();
        model.setId(entity.getId());
        model.setTitle(entity.getTitle());
        model.setRecords(entity.getRecords().stream().map(ModelRecord::toModel).collect(Collectors.toList()));
        return model;
    }

    public ModelTraining(){}

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public  String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public List<ModelRecord> getRecords() {return records;}
    public void setRecords(List<ModelRecord> records) {this.records = records;}

}
