package com.promotion.food.enity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "type_menu")

public class TypeMenu {
    @Id
    @Column(name = "type_menu_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long typeMenuId;
    @Column(name = "type_menu_name")
    private String typeMenuName;
    @Column(name = "is_activate", nullable = false)
    private Boolean activate = true; // ✅ default เป็น true


    public TypeMenu() {
        // จำเป็นสำหรับ JPA
    }

    public TypeMenu(String typeMenuName, Boolean activate, List<TypeMenuFood> typeMenuFoods) {
        this.typeMenuName = typeMenuName;
        this.activate = activate;
    }

    public TypeMenu(String typeMenuName, Boolean activate) {
        this.typeMenuName = typeMenuName;
        this.activate = activate;
    }

    public long getTypeMenuId() {
        return typeMenuId;
    }

    public void setTypeMenuId(long typeMenuId) {
        this.typeMenuId = typeMenuId;
    }

    public String getTypeMenuName() {
        return typeMenuName;
    }

    public void setTypeMenuName(String typeMenuName) {
        this.typeMenuName = typeMenuName;
    }

    public Boolean getActivate() {
        return activate;
    }

    public void setActivate(Boolean activate) {
        this.activate = activate;
    }


    @Override
    public String toString() {
        return "TypeMenu{" +
                "typeMenuId=" + typeMenuId +
                ", typeMenuName='" + typeMenuName + '\'' +
                ", getActivate=" + activate +
                '}';
    }
}
