package dev.gaycookie.geodes;

import dev.gaycookie.geodes.items.DeepslateGeode;
import dev.gaycookie.geodes.items.StoneGeode;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ResourcefulGeodes implements ModInitializer {
  public static final String MODID = "geodes";
  public static final GeodeTable GEODE_TABLE = new GeodeTable();

  public static Item STONE_GEODE = new StoneGeode();
  public static Item DEEPSLATE_GEODE = new DeepslateGeode();

  @Override
  public void onInitialize() {
    this.registerItems();
    this.modifyLootTables();

    System.out.println("Resourceful Geodes was loaded!");
  }

  /**
   * Registers the items to the Registry.
   */
  private void registerItems() {
    Registry.register(Registry.ITEM, id("stone_geode"), STONE_GEODE);
    Registry.register(Registry.ITEM, id("deepslate_geode"), DEEPSLATE_GEODE);
  }

  /**
   * Modifies vanilla loot tables.
   */
  private void modifyLootTables() {
    LootTableLoadingCallback.EVENT.register((resourceManager, manager, id, supplier, setter) -> {
      /* Modify STONE loot table */
      if (id.equals(Blocks.STONE.getLootTableId())) {
        FabricLootPoolBuilder builder = FabricLootPoolBuilder.builder();

        builder.rolls(ConstantLootNumberProvider.create(1));
        builder.with(ItemEntry.builder(Items.AIR).weight(9));
        builder.with(ItemEntry.builder(STONE_GEODE).weight(1));

        supplier.pool(builder);
      }

      /* Modify DEEPSLATE loot table */
      if (id.equals(Blocks.DEEPSLATE.getLootTableId())) {
        FabricLootPoolBuilder builder = FabricLootPoolBuilder.builder();

        builder.rolls(ConstantLootNumberProvider.create(1));
        builder.with(ItemEntry.builder(Items.AIR).weight(9));
        builder.with(ItemEntry.builder(DEEPSLATE_GEODE).weight(1));

        supplier.pool(builder);
      }
    });
  }

  /**
   * Creates a simple Identifier with namespace defaulted to MODID.
   * @param path The path for the identifier.
   * @return new Identifier
   */
  public static Identifier id(String path) {
    return new Identifier(MODID, path);
  }
}
