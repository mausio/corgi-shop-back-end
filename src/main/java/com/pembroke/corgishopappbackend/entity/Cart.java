package com.pembroke.corgishopappbackend.entity;

import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "corgis")
    private List<CorgiDTO> corgis; 

    @Column(name = "itmes")
    private List<ItemDTO> items; 

    public Cart() {}

    public Cart(List<CorgiDTO> corgis, List<ItemDTO> items) {
        this.corgis = new ArrayList<>(corgis);
        this.items = new ArrayList<>(items);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<CorgiDTO> getCorgis() {
        return corgis;
    }

    public void setCorgis(List<CorgiDTO> corgis) {
        this.corgis = corgis;
    }

    public CorgiDTO getCorgi(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < corgis.size()) {
            return corgis.get(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    public void addCorgi(CorgiDTO corgi) {
        corgis.add(corgi);
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    public ItemDTO getItem(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    public void addItem(ItemDTO item) {
        items.add(item);
    }

    @Override
    public String toString() {
        return "CartDTO{" +
                "id=" + id +
                ", corgis=" + corgis +
                ", items=" + items +
                '}';
    }
}
