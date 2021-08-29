package dev.gaycookie.geodes;

import java.util.List;

import org.apache.commons.lang3.RandomUtils;

public class GeodeLootTable {
  private List<Object> loot_table_overworld;
  private List<Object> loot_table_nether;
  private List<Object> loot_table_end;
  private GeodeLootTableEntry last_item;

  public GeodeLootTable(ConfigClass config) {
    this.loot_table_overworld = config.overworld_loot_table;
    this.loot_table_nether = config.nether_loot_table;
    this.loot_table_end = config.end_loot_table;
  }

  public GeodeLootTableEntry getRandomLootTableEntry(String worldType) {
    double random = RandomUtils.nextDouble(0.0, 100.0);

    if (worldType == "end") {
      for (Object geodeTableEntry : this.loot_table_end) {
        GeodeLootTableEntry entry = (GeodeLootTableEntry) geodeTableEntry;
  
        if (random <= entry.weight) {
          return entry;
        }
      }
    } else if (worldType == "nether") {
      for (Object geodeTableEntry : this.loot_table_nether) {
        GeodeLootTableEntry entry = (GeodeLootTableEntry) geodeTableEntry;
  
        if (random <= entry.weight) {
          return entry;
        }
      }
    } else {
      for (Object geodeTableEntry : this.loot_table_overworld) {
        GeodeLootTableEntry entry = (GeodeLootTableEntry) geodeTableEntry;
  
        if (random <= entry.weight) {
          if (entry == this.last_item) return this.getRandomLootTableEntry(worldType);
          if (entry.item != "minecraft:air") last_item = entry;
          return entry;
        }
      }
    }

    return null;
  }
}
