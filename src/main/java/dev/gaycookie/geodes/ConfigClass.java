package dev.gaycookie.geodes;

import java.util.Arrays;
import java.util.List;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = ResourcefulGeodes.MODID)
public class ConfigClass implements ConfigData {
  public String config_version = "0.0.1";
  public List<Object> loot_table = this.populateLootTable();

  private List<Object> populateLootTable() {
    return Arrays.asList(
      new GeodeLootTableEntry(2.5, "minecraft:diamond"),
      new GeodeLootTableEntry(5, "minecraft:emerald"),
      new GeodeLootTableEntry(7.5, "minecraft:amethyst_shard"),
      new GeodeLootTableEntry(12.5, "minecraft:raw_gold"),
      new GeodeLootTableEntry(17.5, "minecraft:raw_iron"),
      new GeodeLootTableEntry(22.5, "minecraft:raw_copper"),
      new GeodeLootTableEntry(30, "minecraft:coal"),
      new GeodeLootTableEntry(40, "minecraft:redstone"),
      new GeodeLootTableEntry(50, "minecraft:lapis_lazuli"),
      new GeodeLootTableEntry(100, "minecraft:air")
    );
  }
}
