package br.com.fiap.cervejaria.dto;

import br.com.fiap.cervejaria.entity.User;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class UserDTO {
    private Integer id;
    private String username;
    private ZonedDateTime createdDate;
    private ZonedDateTime updatedDate;

    public UserDTO() {

    }

    public UserDTO(User savedUser) {
        this.id = savedUser.getId();
        this.username = savedUser.getUsername();
        this.createdDate = ZonedDateTime.ofInstant(savedUser.getCreatedDate().toInstant(), ZoneOffset.systemDefault());
        this.updatedDate = ZonedDateTime.ofInstant(savedUser.getUpdatedDate().toInstant(), ZoneOffset.systemDefault());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public ZonedDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(ZonedDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}
