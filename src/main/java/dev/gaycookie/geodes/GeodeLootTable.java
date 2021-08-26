package dev.gaycookie.geodes;

import java.util.List;

import org.apache.commons.lang3.RandomUtils;

public class GeodeLootTable {
  private List<Object> loot_table;
  private GeodeLootTableEntry last_item;

  public GeodeLootTable(List<Object> loot_table) {
    this.loot_table = loot_table;
  }

  public GeodeLootTableEntry getRandomEntry() {
    double random = RandomUtils.nextDouble(0.0, 100.0);

    for (Object geodeTableEntry : this.loot_table) {
      GeodeLootTableEntry entry = (GeodeLootTableEntry) geodeTableEntry;

      if (random <= entry.weight) {
        if (entry == this.last_item) return this.getRandomEntry();
        
        if (entry.item != "minecraft:air") last_item = entry;
        return entry;
      }
    }

    return null;
  }

  public List<Object> getLootTable() {
    return this.loot_table;
  }
}
