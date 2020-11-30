package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    private int id;
    private String total;
    private String name;
    private Set<Item> items = new HashSet<>();

    public Cart(String total, String name) {
        this.total = total;
        this.name = name;
    }
}
