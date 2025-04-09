package net.weltontep.morebountifulstones.item.custom;

import net.minecraft.block.Block;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import net.weltontep.morebountifulstones.block.AndesiteBlocks;
import net.weltontep.morebountifulstones.block.DioriteBlocks;
import net.weltontep.morebountifulstones.block.GraniteBlocks;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static net.weltontep.morebountifulstones.item.ModToolMaterials.EMERALD;

public class EmeraldPaxel extends Item {
    private static final Map<Block, Block> ANDESITE_BLOCK_CHISEL_MAP =
            Map.of(
                    AndesiteBlocks.ANDESITE_POLISHED_CHISELED_ORNATE, AndesiteBlocks.ANDESITE_POLISHED_CHISELED_ORNATE2,
                    AndesiteBlocks.ANDESITE_POLISHED_CHISELED_ORNATE2, AndesiteBlocks.ANDESITE_POLISHED_CHISELED_ORNATE,
                    AndesiteBlocks.ANDESITE_POLISHED_CUT_BRICKS_BRAIDED, AndesiteBlocks.ANDESITE_POLISHED_CUT_BRICKS_BRAIDED2,
                    AndesiteBlocks.ANDESITE_POLISHED_CUT_BRICKS_BRAIDED2, AndesiteBlocks.ANDESITE_POLISHED_CUT_BRICKS_BRAIDED,
                    AndesiteBlocks.ANDESITE_POLISHED_CUT_BRICKS_PINWHEEL, AndesiteBlocks.ANDESITE_POLISHED_CUT_BRICKS_PINWHEEL2,
                    AndesiteBlocks.ANDESITE_POLISHED_CUT_BRICKS_PINWHEEL2, AndesiteBlocks.ANDESITE_POLISHED_CUT_BRICKS_PINWHEEL,
                    AndesiteBlocks.ANDESITE_POLISHED_CUT_BRICKS_ROAD, AndesiteBlocks.ANDESITE_POLISHED_CUT_BRICKS_ROAD2,
                    AndesiteBlocks.ANDESITE_POLISHED_CUT_BRICKS_ROAD2, AndesiteBlocks.ANDESITE_POLISHED_CUT_BRICKS_ROAD,
                    AndesiteBlocks.ANDESITE_POLISHED_PILLAR, AndesiteBlocks.ANDESITE_POLISHED_PILLAR2,
                    AndesiteBlocks.ANDESITE_POLISHED_PILLAR2, AndesiteBlocks.ANDESITE_POLISHED_PILLAR
            );
    private static final Map<Block, Block> ANDESITE_BLOCK_CHISEL_MAP2 =
            Map.of(
                    AndesiteBlocks.ANDESITE_POLISHED_CUT_PILLAR, AndesiteBlocks.ANDESITE_POLISHED_CUT_TILE_PILLAR,
                    AndesiteBlocks.ANDESITE_POLISHED_CUT_TILE_PILLAR, AndesiteBlocks.ANDESITE_POLISHED_CUT_PILLAR,
                    AndesiteBlocks.ANDESITE_POLISHED_CARVED_CIRCULAR, AndesiteBlocks.ANDESITE_POLISHED_CARVED_DENT,
                    AndesiteBlocks.ANDESITE_POLISHED_CARVED_DENT, AndesiteBlocks.ANDESITE_POLISHED_CARVED_MOSAIC,
                    AndesiteBlocks.ANDESITE_POLISHED_CARVED_MOSAIC, AndesiteBlocks.ANDESITE_POLISHED_CARVED_CIRCULAR,
                    AndesiteBlocks.ANDESITE_POLISHED_CARVED_CIRCULAR_PILLAR, AndesiteBlocks.ANDESITE_POLISHED_CARVED_DENT_PILLAR,
                    AndesiteBlocks.ANDESITE_POLISHED_CARVED_DENT_PILLAR, AndesiteBlocks.ANDESITE_POLISHED_CARVED_MOSAIC_PILLAR,
                    AndesiteBlocks.ANDESITE_POLISHED_CARVED_MOSAIC_PILLAR, AndesiteBlocks.ANDESITE_POLISHED_CARVED_CIRCULAR_PILLAR,
                    AndesiteBlocks.ANDESITE_POLISHED_CUT_PLANK_PILLAR, AndesiteBlocks.ANDESITE_POLISHED_CUT_PLANK_PILLAR2,
                    AndesiteBlocks.ANDESITE_POLISHED_CUT_PLANK_PILLAR2, AndesiteBlocks.ANDESITE_POLISHED_CUT_PLANK_PILLAR
            );

    private static final Map<Block, Block> DIORITE_BLOCK_CHISEL_MAP =
            Map.of(
                    DioriteBlocks.DIORITE_POLISHED_CHISELED_ORNATE, DioriteBlocks.DIORITE_POLISHED_CHISELED_ORNATE2,
                    DioriteBlocks.DIORITE_POLISHED_CHISELED_ORNATE2, DioriteBlocks.DIORITE_POLISHED_CHISELED_ORNATE,
                    DioriteBlocks.DIORITE_POLISHED_CUT_BRICKS_BRAIDED, DioriteBlocks.DIORITE_POLISHED_CUT_BRICKS_BRAIDED2,
                    DioriteBlocks.DIORITE_POLISHED_CUT_BRICKS_BRAIDED2, DioriteBlocks.DIORITE_POLISHED_CUT_BRICKS_BRAIDED,
                    DioriteBlocks.DIORITE_POLISHED_CUT_BRICKS_PINWHEEL, DioriteBlocks.DIORITE_POLISHED_CUT_BRICKS_PINWHEEL2,
                    DioriteBlocks.DIORITE_POLISHED_CUT_BRICKS_PINWHEEL2, DioriteBlocks.DIORITE_POLISHED_CUT_BRICKS_PINWHEEL,
                    DioriteBlocks.DIORITE_POLISHED_CUT_BRICKS_ROAD, DioriteBlocks.DIORITE_POLISHED_CUT_BRICKS_ROAD2,
                    DioriteBlocks.DIORITE_POLISHED_CUT_BRICKS_ROAD2, DioriteBlocks.DIORITE_POLISHED_CUT_BRICKS_ROAD,
                    DioriteBlocks.DIORITE_POLISHED_PILLAR, DioriteBlocks.DIORITE_POLISHED_PILLAR2,
                    DioriteBlocks.DIORITE_POLISHED_PILLAR2, DioriteBlocks.DIORITE_POLISHED_PILLAR
            );
    private static final Map<Block, Block> DIORITE_BLOCK_CHISEL_MAP2 =
            Map.of(
                    DioriteBlocks.DIORITE_POLISHED_CUT_PILLAR, DioriteBlocks.DIORITE_POLISHED_CUT_TILE_PILLAR,
                    DioriteBlocks.DIORITE_POLISHED_CUT_TILE_PILLAR, DioriteBlocks.DIORITE_POLISHED_CUT_PILLAR,
                    DioriteBlocks.DIORITE_POLISHED_CARVED_CIRCULAR, DioriteBlocks.DIORITE_POLISHED_CARVED_DENT,
                    DioriteBlocks.DIORITE_POLISHED_CARVED_DENT, DioriteBlocks.DIORITE_POLISHED_CARVED_MOSAIC,
                    DioriteBlocks.DIORITE_POLISHED_CARVED_MOSAIC, DioriteBlocks.DIORITE_POLISHED_CARVED_CIRCULAR,
                    DioriteBlocks.DIORITE_POLISHED_CARVED_CIRCULAR_PILLAR, DioriteBlocks.DIORITE_POLISHED_CARVED_DENT_PILLAR,
                    DioriteBlocks.DIORITE_POLISHED_CARVED_DENT_PILLAR, DioriteBlocks.DIORITE_POLISHED_CARVED_MOSAIC_PILLAR,
                    DioriteBlocks.DIORITE_POLISHED_CARVED_MOSAIC_PILLAR, DioriteBlocks.DIORITE_POLISHED_CARVED_CIRCULAR_PILLAR,
                    DioriteBlocks.DIORITE_POLISHED_CUT_PLANK_PILLAR, DioriteBlocks.DIORITE_POLISHED_CUT_PLANK_PILLAR2,
                    DioriteBlocks.DIORITE_POLISHED_CUT_PLANK_PILLAR2, DioriteBlocks.DIORITE_POLISHED_CUT_PLANK_PILLAR
            );

    private static final Map<Block, Block> GRANITE_BLOCK_CHISEL_MAP =
            Map.of(
                    GraniteBlocks.GRANITE_POLISHED_CHISELED_ORNATE, GraniteBlocks.GRANITE_POLISHED_CHISELED_ORNATE2,
                    GraniteBlocks.GRANITE_POLISHED_CHISELED_ORNATE2, GraniteBlocks.GRANITE_POLISHED_CHISELED_ORNATE,
                    GraniteBlocks.GRANITE_POLISHED_CUT_BRICKS_BRAIDED, GraniteBlocks.GRANITE_POLISHED_CUT_BRICKS_BRAIDED2,
                    GraniteBlocks.GRANITE_POLISHED_CUT_BRICKS_BRAIDED2, GraniteBlocks.GRANITE_POLISHED_CUT_BRICKS_BRAIDED,
                    GraniteBlocks.GRANITE_POLISHED_CUT_BRICKS_PINWHEEL, GraniteBlocks.GRANITE_POLISHED_CUT_BRICKS_PINWHEEL2,
                    GraniteBlocks.GRANITE_POLISHED_CUT_BRICKS_PINWHEEL2, GraniteBlocks.GRANITE_POLISHED_CUT_BRICKS_PINWHEEL,
                    GraniteBlocks.GRANITE_POLISHED_CUT_BRICKS_ROAD, GraniteBlocks.GRANITE_POLISHED_CUT_BRICKS_ROAD2,
                    GraniteBlocks.GRANITE_POLISHED_CUT_BRICKS_ROAD2, GraniteBlocks.GRANITE_POLISHED_CUT_BRICKS_ROAD,
                    GraniteBlocks.GRANITE_POLISHED_PILLAR, GraniteBlocks.GRANITE_POLISHED_PILLAR2,
                    GraniteBlocks.GRANITE_POLISHED_PILLAR2, GraniteBlocks.GRANITE_POLISHED_PILLAR
            );
    private static final Map<Block, Block> GRANITE_BLOCK_CHISEL_MAP2 =
            Map.of(
                    GraniteBlocks.GRANITE_POLISHED_CUT_PILLAR, GraniteBlocks.GRANITE_POLISHED_CUT_TILE_PILLAR,
                    GraniteBlocks.GRANITE_POLISHED_CUT_TILE_PILLAR, GraniteBlocks.GRANITE_POLISHED_CUT_PILLAR,
                    GraniteBlocks.GRANITE_POLISHED_CARVED_CIRCULAR, GraniteBlocks.GRANITE_POLISHED_CARVED_DENT,
                    GraniteBlocks.GRANITE_POLISHED_CARVED_DENT, GraniteBlocks.GRANITE_POLISHED_CARVED_MOSAIC,
                    GraniteBlocks.GRANITE_POLISHED_CARVED_MOSAIC, GraniteBlocks.GRANITE_POLISHED_CARVED_CIRCULAR,
                    GraniteBlocks.GRANITE_POLISHED_CARVED_CIRCULAR_PILLAR, GraniteBlocks.GRANITE_POLISHED_CARVED_DENT_PILLAR,
                    GraniteBlocks.GRANITE_POLISHED_CARVED_DENT_PILLAR, GraniteBlocks.GRANITE_POLISHED_CARVED_MOSAIC_PILLAR,
                    GraniteBlocks.GRANITE_POLISHED_CARVED_MOSAIC_PILLAR, GraniteBlocks.GRANITE_POLISHED_CARVED_CIRCULAR_PILLAR,
                    GraniteBlocks.GRANITE_POLISHED_CUT_PLANK_PILLAR, GraniteBlocks.GRANITE_POLISHED_CUT_PLANK_PILLAR2,
                    GraniteBlocks.GRANITE_POLISHED_CUT_PLANK_PILLAR2, GraniteBlocks.GRANITE_POLISHED_CUT_PLANK_PILLAR
            );
    private static final ToolMaterial material = EMERALD;

    public EmeraldPaxel(int attackDamage, float attackSpeed, Item.Settings emeraldPaxel) {
        super(new Settings());
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(ANDESITE_BLOCK_CHISEL_MAP.containsKey(clickedBlock)) {
            if (!world.isClient()) {
                world.setBlockState(context.getBlockPos(), ANDESITE_BLOCK_CHISEL_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> Objects.requireNonNull(context.getPlayer()).sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundCategory.BLOCKS);

            }
        };

        if(ANDESITE_BLOCK_CHISEL_MAP2.containsKey(clickedBlock)) {
            if (!world.isClient()) {
                world.setBlockState(context.getBlockPos(), ANDESITE_BLOCK_CHISEL_MAP2.get(clickedBlock).getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> Objects.requireNonNull(context.getPlayer()).sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundCategory.BLOCKS);

            }
        };

        if(DIORITE_BLOCK_CHISEL_MAP.containsKey(clickedBlock)) {
            if (!world.isClient()) {
                world.setBlockState(context.getBlockPos(), DIORITE_BLOCK_CHISEL_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> Objects.requireNonNull(context.getPlayer()).sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundCategory.BLOCKS);

            }
        };

        if(DIORITE_BLOCK_CHISEL_MAP2.containsKey(clickedBlock)) {
            if (!world.isClient()) {
                world.setBlockState(context.getBlockPos(), DIORITE_BLOCK_CHISEL_MAP2.get(clickedBlock).getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> Objects.requireNonNull(context.getPlayer()).sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundCategory.BLOCKS);

            }
        };

        if(GRANITE_BLOCK_CHISEL_MAP.containsKey(clickedBlock)) {
            if (!world.isClient()) {
                world.setBlockState(context.getBlockPos(), GRANITE_BLOCK_CHISEL_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> Objects.requireNonNull(context.getPlayer()).sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundCategory.BLOCKS);

            }
        };

        if(GRANITE_BLOCK_CHISEL_MAP2.containsKey(clickedBlock)) {
            if (!world.isClient()) {
                world.setBlockState(context.getBlockPos(), GRANITE_BLOCK_CHISEL_MAP2.get(clickedBlock).getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> Objects.requireNonNull(context.getPlayer()).sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundCategory.BLOCKS);

            }
        }

        return ActionResult.SUCCESS;

    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.morebountifulstones.emerald_paxel.tooltip"));
        tooltip.add(Text.translatable("tooltip.morebountifulstones.emerald_paxel.tooltip2"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}