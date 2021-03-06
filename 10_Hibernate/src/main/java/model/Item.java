package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Item implements Serializable {

    private int id;
    private String total;
    private Set<Cart> carts = new HashSet<>();

    public Item(String total) {
        this.total = total;
    }
}