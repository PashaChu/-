package com.example.System.model;

import com.example.System.entity.RecordCenter;

import java.sql.Date;

public class ModelRecord {

    private Long id;
    private Date date;
    private Long client_id;
    private Long coach_id;
    private Long hall_id;
    private Long training_id;

    public static ModelRecord toModel(RecordCenter entity) {
        ModelRecord model = new ModelRecord();
        model.setId(entity.getId());
        model.setDate(entity.getDate());
        if(entity.getClient() != null){
            model.setClient(entity.getClient().getId());
        }
        if(entity.getCoach() != null){
            model.setCoach(entity.getCoach().getId());
        }
        if(entity.getHall() != null){
            model.setHall(entity.getHall().getId());
        }
        if(entity.getTraining() != null){
            model.setTraining(entity.getTraining().getId());
        }
        return model;
    }
    public ModelRecord(){}

    public Long getId(){return id;}
    public void setId(Long id) {this.id = id;}

    public Date getDate(){return date;}
    public void setDate(Date date){this.date = date;}

    public Long getClient(){return client_id;}
    public void setClient(Long client){this.client_id = client;}

    public Long getCoach(){return coach_id;}
    public void setCoach(Long coach){this.coach_id = coach;}

    public Long getHall(){return hall_id;}
    public void setHall(Long hall){this.hall_id = hall;}

    public Long getTraining(){return training_id;}
    public void setTraining(Long training){this.training_id = training;}

}
