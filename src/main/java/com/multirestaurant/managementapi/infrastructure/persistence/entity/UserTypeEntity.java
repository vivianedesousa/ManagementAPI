package com.multirestaurant.managementapi.infrastructure.persistence.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
    //esta sera entidade especificar do DB
    // o DTO NAO CONHECER A ENTITY
    //ENTITY (representa a tabela)
    @Entity
    @Table(name = "user_types")
    public class UserTypeEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(nullable = false, length = 100, unique = true)
        private String name;

        public UserTypeEntity() {}

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
