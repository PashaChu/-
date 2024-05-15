package com.example.System.model;

import com.example.System.entity.Client;

import java.util.List;
import java.util.stream.Collectors;

public class ModelClient {
    private Long id;
    private String surname;
    private String name;
    private String patronymic;
    private String login;
    private String password;
    private String telephone;
    private Long role_id;
    private List<ModelRecord> records;

    public static ModelClient toModel(Client entity) {
        ModelClient model = new ModelClient();
        model.setId(entity.getId());
        model.setSurname(entity.getSurname());
        model.setName(entity.getName());
        model.setPatronymic(entity.getPatronymic());
        model.setLogin(entity.getLogin());
        model.setPassword(entity.getPassword());
        model.setTelephone(entity.getTelephone());
        if(entity.getRole() != null){
            model.setRole(entity.getRole().getId());
        }
        model.setRecords(entity.getRecords().stream().map(ModelRecord::toModel).collect(Collectors.toList()));
        return model;
    }

    public String getPassword(){return password;}
    private void setPassword(String password) {this.password = password;}

    public List<ModelRecord> getRecords(){return records;}
    public void setRecords(List<ModelRecord> records) {this.records = records;}

    public ModelClient(){}

    public Long getId(){return id;}
    public void setId(Long id) {this.id = id;}

    public String getSurname(){return surname;}
    public void setSurname(String surname){this.surname = surname;}

    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public String getPatronymic(){return patronymic;}
    public void setPatronymic(String patronymic){this.patronymic = patronymic;}

    public String getLogin(){return login;}
    public void setLogin(String login){this.login = login;}

    public String getTelephone(){return telephone;}
    public void setTelephone(String telephone){this.telephone = telephone;}

    public Long getRole(){return role_id;}
    public void setRole(Long role_id){this.role_id = role_id;}

}
