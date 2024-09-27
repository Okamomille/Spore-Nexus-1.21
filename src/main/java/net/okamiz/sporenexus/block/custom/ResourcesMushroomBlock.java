package net.okamiz.sporenexus.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.util.ParticleUtils;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.okamiz.sporenexus.block.SNBlocks;
import net.okamiz.sporenexus.item.SNItems;

import java.util.Random;

public class ResourcesMushroomBlock extends CropBlock {
    public static final int MAX_AGE = 6;
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 6);
    public Item drop;

    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(5.0, 0.0, 5.0, 11.0, 6.0, 11.0),
            Block.box(5.0, 0.0, 5.0, 11.0, 6.0, 11.0),
            Block.box(5.0, 0.0, 5.0, 11.0, 6.0, 11.0),
            Block.box(4.0, 0.0, 4.0, 12.0, 8.0, 12.0),
            Block.box(4.0, 0.0, 4.0, 12.0, 8.0, 12.0),
            Block.box(4.0, 0.0, 4.0, 12.0, 8.0, 12.0),
            Block.box(2.0, 0.0, 2.0, 14.0, 12.0, 14.0),
    };
    public ResourcesMushroomBlock(Properties properties, Item drop) {
        super(properties);
        this.drop = drop;
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[this.getAge(state)];
    }
    protected int getBonemealAgeIncrease(Level level) {
        return Mth.nextInt(level.random, 0, 1);
    }
    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[this.getAge(state)];
    }


    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.getBlock().defaultBlockState().is(SNBlocks.FERTILIZED_MYCELIUM);
    }


    @Override
    protected ItemLike getBaseSeedId() {
        return this.asBlock();
    }

    @Override
    protected IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }


    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {

        if(!level.isClientSide()){
            if(level.getBlockState(pos).getValue(AGE) == this.MAX_AGE){
                level.setBlock(pos, state.setValue(AGE, 0), 3);
                ParticleUtils.spawnParticleInBlock(level, pos, 5, ParticleTypes.HAPPY_VILLAGER);

                Random random = new Random();

                for (int i = 0; i < random.nextInt(1, 3); i++) {

                    if(drop != null){
                        if(drop == Items.COAL){
                            level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(SNItems.COAL_FRAGMENTS.get())));
                        }
                        if(drop == Items.LAPIS_LAZULI){
                            level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(SNItems.LAPIS_LAZULI_FRAGMENTS.get())));
                        }
                        if(drop == Items.QUARTZ){
                            level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(SNItems.QUARTZ_FRAGMENTS.get())));
                        }
                        if(drop == Items.REDSTONE){
                            level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(SNItems.REDSTONE_FRAGMENTS.get())));
                        }
                        if(drop == Items.RAW_IRON){
                            level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(SNItems.IRON_FRAGMENTS.get())));
                        }
                        if(drop == Items.RAW_COPPER){
                            level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(SNItems.COPPER_FRAGMENTS.get())));
                        }
                        if(drop == Items.RAW_GOLD){
                            level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(SNItems.GOLD_FRAGMENTS.get())));
                        }
                        if(drop == Items.DIAMOND){
                            level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(SNItems.DIAMOND_FRAGMENTS.get())));
                        }
                        if(drop == Items.EMERALD){
                            level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(SNItems.EMERALD_FRAGMENTS.get())));
                        }
                        if(drop == Items.NETHERITE_SCRAP){
                            level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(SNItems.NETHERITE_FRAGMENTS.get())));
                        }
                    }

                }
                return InteractionResult.SUCCESS;
            }else{
                return InteractionResult.PASS;
            }
        }else{
            return InteractionResult.PASS;
        }
    }
}
