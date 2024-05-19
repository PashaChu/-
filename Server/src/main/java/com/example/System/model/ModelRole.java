package com.example.System.model;

import com.example.System.entity.Role;

import java.util.List;
import java.util.stream.Collectors;

public class ModelRole {

    private Long id;
    private String role;
    private List<ModelClient> clients;

    public static ModelRole toModel(Role entity) {
        ModelRole model = new ModelRole();
        model.setId(entity.getId());
        model.setRole(entity.getRole());
        model.setRecords(entity.getUsers().stream().map(ModelClient::toModel).collect(Collectors.toList()));
        return model;
    }

    public ModelRole(){}

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getRole() {return role;}
    public void setRole(String role) {this.role = role;}

    public List<ModelClient> getRecords(){return clients;}
    public void setRecords(List<ModelClient> clients) {this.clients = clients;}

}
