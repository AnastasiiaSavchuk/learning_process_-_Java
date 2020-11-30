package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    private int id;
    private String total;
    private Set<Cart> carts = new HashSet<>();

    public Item(String total) {
        this.total = total;
    }
}