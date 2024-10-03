package net.okamiz.sporenexus.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.MyceliumBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.okamiz.sporenexus.block.SNBlocks;
import net.okamiz.sporenexus.item.SNItems;
import net.okamiz.sporenexus.util.SNTags;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Supplier;

public class ResourcesMushroomBlock extends CropBlock {
    public static final int MAX_AGE = 6;
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 6);
    public Supplier<Item> drop;
    ItemStack fragmentsDrop;
    ItemStack fungalEssenceDrop;
    ItemStack mushroomCapDrop;
    ItemStack mushroomSporesDrop;
    ItemStack relicDrop;

    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(5.0, 0.0, 5.0, 11.0, 6.0, 11.0),
            Block.box(5.0, 0.0, 5.0, 11.0, 6.0, 11.0),
            Block.box(5.0, 0.0, 5.0, 11.0, 6.0, 11.0),
            Block.box(4.0, 0.0, 4.0, 12.0, 8.0, 12.0),
            Block.box(4.0, 0.0, 4.0, 12.0, 8.0, 12.0),
            Block.box(4.0, 0.0, 4.0, 12.0, 8.0, 12.0),
            Block.box(2.0, 0.0, 2.0, 14.0, 12.0, 14.0),
    };
    public ResourcesMushroomBlock(Properties properties, Supplier<Item> drop) {
        super(properties);
        this.drop = drop;
    }

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        this.fragmentsDrop = new ItemStack(drop.get());
        this.fungalEssenceDrop = new ItemStack(SNItems.FUNGAL_ESSENCE.get());
        this.mushroomCapDrop = new ItemStack(SNItems.MUSHROOM_CAP.get());
        this.mushroomSporesDrop = new ItemStack(SNItems.MUSHROOM_SPORES.get());
        this.relicDrop = new ItemStack(SNItems.SPORE_RELIC.get());
        super.onPlace(state, level, pos, oldState, movedByPiston);
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
        return state.getBlock().defaultBlockState().is(SNTags.Blocks.MYCELIUM_SOILS);
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

        public void resetAge(Level level, BlockPos pos){
            level.setBlock(pos, this.defaultBlockState().setValue(AGE, 0), 3);
        }


    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {

        if(!level.isClientSide()){
            if(level.getBlockState(pos).getValue(AGE) == this.MAX_AGE){
                resetAge(level, pos);
                ParticleUtils.spawnParticleInBlock(level, pos, 5, ParticleTypes.HAPPY_VILLAGER);

                Random random = new Random();
                int fragDropCount = random.nextInt(3);

                if(fragDropCount == 0){
                    dropFragments(level, pos);
                }
                if(fragDropCount == 1){
                    dropFragments(level, pos);
                    dropFragments(level, pos);
                }
                if(fragDropCount == 2){
                    dropFragments(level, pos);
                    dropFragments(level, pos);
                    dropFragments(level, pos);
                }
                drop(level, pos);

                return InteractionResult.SUCCESS;
            }else{
                return InteractionResult.PASS;
            }
        }else{
            return InteractionResult.PASS;
        }
    }


    private void drop(Level level, BlockPos pos){
        Random random = new Random();
        int fungalEssenceDropRate = random.nextInt(2);
        int mushroomCapDropRate = random.nextInt(3);
        int mushroomSporesDropRate = random.nextInt(5);
        int sporeRelicDropRate = random.nextInt(100);

        if(fungalEssenceDropRate == 0){
            level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), fungalEssenceDrop));
        }
        if(mushroomCapDropRate == 0){
            level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), mushroomCapDrop));
        }
        if(mushroomSporesDropRate == 0){
            level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), mushroomSporesDrop));
        }

        if(sporeRelicDropRate <= 1){
            level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), relicDrop));
        }


    }

    private void dropFragments(Level level, BlockPos pos){
        if(drop != null){
                level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), fragmentsDrop));

        }
    }


    public List<ItemStack> getCustomDrops(){

        List<ItemStack> drops = new ArrayList<>();

        drops.add(fragmentsDrop);
        drops.add(fragmentsDrop);
        drops.add(fungalEssenceDrop);

        return drops;
    }



    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!level.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
        if (level.getRawBrightness(pos, 0) >= 9) {
            int age = this.getAge(state);
            if (age < this.getMaxAge()) {
                float growthSpeed = getGrowthSpeed(state, level, pos);
                if (net.neoforged.neoforge.common.CommonHooks.canCropGrow(level, pos, state, random.nextInt((int)(25.0F / growthSpeed) + 1) == 0)) {
                    level.setBlock(pos, this.getStateForAge(age + 1), 2);
                    net.neoforged.neoforge.common.CommonHooks.fireCropGrowPost(level, pos, state);
                }
            }
        }
    }


    protected static float getGrowthSpeed(BlockState blockState, BlockGetter blockGetter, BlockPos pos) {
        Block block = blockState.getBlock();
        float growthSpeed = 1.0F;
        BlockPos groundBlockPos = pos.below();

                float additiveGrowthSpeed = 0.0F;
                float fertilizedMyceliumBaseSpeed = 3.0F;
                BlockState groundBlockState = blockGetter.getBlockState(groundBlockPos);

                if (groundBlockState.getBlock() instanceof FertilizedMycelium) {
                    additiveGrowthSpeed = fertilizedMyceliumBaseSpeed;
                }
                if (groundBlockState.getBlock() instanceof EnrichedMycelium) {
                    additiveGrowthSpeed = fertilizedMyceliumBaseSpeed * 1.25F;
                }

        growthSpeed += additiveGrowthSpeed;

        for (int i = -3; i < 3; i++) {
            for (int j = -3; j < 3; j++) {
                if(blockGetter.getBlockState(pos.offset(i, 0, j)).is(SNBlocks.SPORE_SPREADER)){
                    growthSpeed *=2;
                }
            }
        }


        BlockPos posNorth = pos.north();
        BlockPos posSouth = pos.south();
        BlockPos posWest = pos.west();
        BlockPos posEast = pos.east();
        boolean isBlockEastOrWest = blockGetter.getBlockState(posWest).is(block) || blockGetter.getBlockState(posEast).is(block);
        boolean isBlockNorthOrSouth = blockGetter.getBlockState(posNorth).is(block) || blockGetter.getBlockState(posSouth).is(block);
        if (isBlockEastOrWest && isBlockNorthOrSouth) {
            growthSpeed /= 2.0F;
        } else {
            boolean isAnyThisBlockAround = blockGetter.getBlockState(posWest.north()).is(block)
                    || blockGetter.getBlockState(posEast.north()).is(block)
                    || blockGetter.getBlockState(posEast.south()).is(block)
                    || blockGetter.getBlockState(posWest.south()).is(block);
            if (isAnyThisBlockAround) {
                growthSpeed /= 2.0F;
            }
        }

        return growthSpeed;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

                tooltipComponents.add(Component.translatable("tooltip.sporenexus.ore_mushroom_line1"));
                tooltipComponents.add(Component.translatable("tooltip.sporenexus.ore_mushroom_line2"));
                tooltipComponents.add(Component.translatable("tooltip.sporenexus.ore_mushroom_line3"));

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
