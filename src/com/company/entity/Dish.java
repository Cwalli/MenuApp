package com.company.entity;

import java.util.Date;

public class Dish {
    private int id;
    private String dishName;
    private String dishSize;
    private double dishCost;
//    private BigDecimal dishCost;
    private int dishWeight;
    private String dishNote;
    private Date createdAt;
    private Date updatedAt;

    public Dish(int id, String dish_name, String dish_size, double dish_cost, int dish_weight, String dish_note, Date createdAt, Date updatedAt) {
        this.id = id;
        this.dishName = dish_name;
        this.dishSize = dish_size;
        this.dishCost = dish_cost;
        this.dishWeight = dish_weight;
        this.dishNote = dish_note;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Dish(String dish_name, String dish_size, double dish_cost, int dish_weight, String dish_note) {
        this.dishName = dish_name;
        this.dishSize = dish_size;
        this.dishCost = dish_cost;
        this.dishWeight = dish_weight;
        this.dishNote = dish_note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishSize() {
        return dishSize;
    }

    public void setDishSize(String dishSize) {
        this.dishSize = dishSize;
    }

    public double getDishCost() {
        return dishCost;
    }

    public void setDishCost(double dishCost) {
        this.dishCost = dishCost;
    }

    public int getDishWeight() {
        return dishWeight;
    }

    public void setDishWeight(int dishWeight) {
        this.dishWeight = dishWeight;
    }

    public String getDishNote() {
        return dishNote;
    }

    public void setDishNote(String dishNote) {
        this.dishNote = dishNote;
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
    public static Dish createItemForSaving( String dish_name, String dish_size, double dish_cost, int dish_weight, String dish_note) {
        return new Dish(dish_name, dish_size, dish_cost, dish_weight, dish_note);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", dish_name='" + dishName + '\'' +
                ", dish_size='" + dishSize + '\'' +
                ", dish_cost='" + dishCost + '\'' +
                ", dish_weight='" + dishWeight + '\'' +
                ", dish_note='" + dishNote + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
