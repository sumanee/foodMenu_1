package com.promotion.food.dto;


public class TypeMenuDto {

    private  Long typeMenuId;
    private  String typeMenuName;
    private  boolean activate = true;

    public TypeMenuDto() {}


    public TypeMenuDto(Long typeMenuId, String typeMenuName, boolean activate) {
        this.typeMenuId = typeMenuId;
        this.typeMenuName = typeMenuName;
        this.activate = activate;
    }

    public Long getTypeMenuId() {
        return typeMenuId;
    }

    public void setTypeMenuId(Long typeMenuId) {
        this.typeMenuId = typeMenuId;
    }

    public String getTypeMenuName() {
        return typeMenuName;
    }

    public void setTypeMenuName(String typeMenuName) {
        this.typeMenuName = typeMenuName;
    }

    public boolean getActivate() {
        return activate;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }

    @Override
    public String toString() {
        return "TypeMenuDto{" +
                "typeMenuId=" + typeMenuId +
                ", typeMenuName='" + typeMenuName + '\'' +
                ", getActivate=" + activate +
                '}';
    }
}
