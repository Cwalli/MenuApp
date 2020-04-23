package com.company.entity;

import java.util.Date;

public class InstMenu {
    private int id;
    private int DishId;
    private int IstitutionId;
    private Date createdAt;
    private Date updatedAt;


    public InstMenu(int id, int dishId, int istitutionId, Date createdAt, Date updatedAt) {
        this.id = id;
        this.DishId = dishId;
        this.IstitutionId = istitutionId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;

    }

    public InstMenu(int dishId, int istitutionId) {
        this.DishId = dishId;
        this.IstitutionId = istitutionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDishId() {
        return DishId;
    }

    public void setDishId(int dishId) {
        DishId = dishId;
    }

    public int getIstitutionId() {
        return IstitutionId;
    }

    public void setIstitutionId(int istitutionId) {
        IstitutionId = istitutionId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static InstMenu createItemForSaving(int DishId, int IstitutionId) {
        return new InstMenu(DishId, IstitutionId);
    }

    @Override
    public String toString() {
        return "InstMenu{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", DishId=" + DishId +
                ", IstitutionId=" + IstitutionId +
                '}';
    }
}
