package dev.gaycookie.geodes.items;

import dev.gaycookie.geodes.GeodeLootTableEntry;
import dev.gaycookie.geodes.ResourcefulGeodes;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.*;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.List;

public class GeodeItem extends Item {
  public GeodeItem() {
    super(new Item.Settings().maxCount(64).group(ItemGroup.MISC).rarity(Rarity.RARE));
  }

  @Override
  public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
    TranslatableText lore = new TranslatableText("item.geodes.geode.lore");
    lore.formatted(Formatting.ITALIC, Formatting.DARK_PURPLE);
    tooltip.add(lore);
  }

  @Override
  public ActionResult useOnBlock(ItemUsageContext context) {
    PlayerEntity player = context.getPlayer();
    BlockState state = context.getWorld().getBlockState(context.getBlockPos());
    World world = context.getWorld();

    if (state.getBlock() != Blocks.ANVIL && state.getBlock() != Blocks.CHIPPED_ANVIL && state.getBlock() != Blocks.DAMAGED_ANVIL) {
      return super.useOnBlock(context);
    }

    if (player == null) return super.useOnBlock(context);

    if (!player.isCreative()) context.getStack().decrement(1);
    player.swingHand(context.getHand());

    if (!world.isClient) {
      world.playSound(null, context.getBlockPos().getX() + .5, context.getBlockPos().getY() + 1.5, context.getBlockPos().getZ() + .5, SoundEvents.BLOCK_ANVIL_LAND, SoundCategory.AMBIENT, 0.75f, 2f);
      ((ServerWorld) world).spawnParticles(ParticleTypes.COMPOSTER, context.getBlockPos().getX() + .5, context.getBlockPos().getY() + 1, context.getBlockPos().getZ() + .5, 10, .2, .2, .2, 0.1);

      GeodeLootTableEntry randomItem = ResourcefulGeodes.GEODE_LOOT_TABLE.getRandomEntry();
      if (randomItem != null) {
        ItemEntity item = new ItemEntity(EntityType.ITEM, world);
        item.setStack(new ItemStack(Registry.ITEM.get(new Identifier(randomItem.item)), 1));
        item.setPosition(context.getBlockPos().getX() + .5, context.getBlockPos().getY() + 1, context.getBlockPos().getZ() + .5);
        world.spawnEntity(item);
      }
    }

    return super.useOnBlock(context);
  }
}
