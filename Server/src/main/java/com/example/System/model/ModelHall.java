package com.example.System.model;

import com.example.System.entity.Hall;

import java.util.List;
import java.util.stream.Collectors;

public class ModelHall {

    private Long id;
    private String name;
    private List<ModelRecord> records;

    public static ModelHall toModel(Hall entity){
        ModelHall model = new ModelHall();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setRecords(entity.getRecords().stream().map(ModelRecord::toModel).collect(Collectors.toList()));
        return model;
    }

    public ModelHall(){}

    public Long getId(){return id;}
    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public List<ModelRecord> getRecords() {return records;}
    public void setRecords(List<ModelRecord> records) {this.records = records;}

}
