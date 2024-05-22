package com.pembroke.corgishopappbackend.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pembroke.corgishopappbackend.dto.CorgiDTO;
import com.pembroke.corgishopappbackend.dto.ItemDTO;

import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<Corgi> corgis = new ArrayList<>();

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<Item> items = new ArrayList<>();

    @OneToOne(mappedBy = "cart")
    private User user;

    public Cart() {}

    public Cart(List<Corgi> corgis, List<Item> items) {
        this.corgis = corgis;
        this.items = items;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonManagedReference
    public List<Corgi> getCorgis() {
        return corgis;
    }

    public void setCorgis(List<Corgi> corgis) {
        this.corgis = corgis;
    }

    public Corgi getCorgi(int index) {
        return corgis.get(index);
    }

    public void addCorgi(Corgi corgi) {
        corgis.add(corgi);
    }

    @JsonManagedReference
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }


    public Item getItem(int index) {
        return items.get(index);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", corgis=" + corgis +
                ", items=" + items +
                '}';
    }
}
