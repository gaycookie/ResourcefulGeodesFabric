package dev.gaycookie.geodes;

import net.minecraft.item.Item;

public class GeodeTableEntry {
    public final double weight;
    public final Item item;

    public GeodeTableEntry(double weight, Item item) {
        this.weight = weight;
        this.item = item;
    }
}
