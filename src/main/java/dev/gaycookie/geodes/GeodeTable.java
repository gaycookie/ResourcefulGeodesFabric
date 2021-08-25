package dev.gaycookie.geodes;

import net.minecraft.item.Items;
import org.apache.commons.lang3.RandomUtils;

import java.util.Arrays;
import java.util.List;

public class GeodeTable {
  private final List<GeodeTableEntry> table;

  public GeodeTable() {
    this.table = this.populateTable();
  }

  public GeodeTableEntry getRandomEntry() {
    double random = RandomUtils.nextDouble(0.0, 100.0);

    for (GeodeTableEntry geodeTableEntry : table) {
      if (random <= geodeTableEntry.weight) {
        return geodeTableEntry;
      }
    }

    return null;
  }

  private List<GeodeTableEntry> populateTable() {
    return Arrays.asList(
      new GeodeTableEntry(2.5, Items.DIAMOND),
      new GeodeTableEntry(5, Items.EMERALD),
      new GeodeTableEntry(7.5, Items.AMETHYST_SHARD),
      new GeodeTableEntry(12.5, Items.RAW_GOLD),
      new GeodeTableEntry(17.5, Items.RAW_IRON),
      new GeodeTableEntry(22.5, Items.RAW_COPPER),
      new GeodeTableEntry(30, Items.COAL),
      new GeodeTableEntry(40, Items.REDSTONE),
      new GeodeTableEntry(50, Items.LAPIS_LAZULI),
      new GeodeTableEntry(100, Items.AIR)
    );
  }
}
