package dev.gaycookie.geodes;

import java.util.Arrays;
import java.util.List;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = ResourcefulGeodes.MODID)
public class ConfigClass implements ConfigData {
  public String config_version = "0.0.2";
  public boolean fortune_effect = true;

  public List<Object> overworld_loot_table = Arrays.asList(
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

  public List<Object> nether_loot_table = Arrays.asList(
    new GeodeLootTableEntry(0.5, "minecraft:netherite_scrap"),
    new GeodeLootTableEntry(16, "minecraft:raw_gold"),
    new GeodeLootTableEntry(33, "minecraft:quartz"),
    new GeodeLootTableEntry(50, "minecraft:glowstone_dust"),
    new GeodeLootTableEntry(100, "minecraft:air")
  );

  public List<Object> end_loot_table = Arrays.asList(
    new GeodeLootTableEntry(0.1, "minecraft:elytra"),
    new GeodeLootTableEntry(1, "minecraft:dragon_head"),
    new GeodeLootTableEntry(2, "minecraft:shulker_shell"),
    new GeodeLootTableEntry(25, "minecraft:ender_pearl"),
    new GeodeLootTableEntry(100, "minecraft:air")
  );
}
