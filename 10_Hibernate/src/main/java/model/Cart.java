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
public class Cart implements Serializable {

    private int id;
    private String total;
    private String name;
    private Set<Item> items = new HashSet<>();

    public Cart(String total, String name) {
        this.total = total;
        this.name = name;
    }
}