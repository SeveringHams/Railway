package com.railwayteam.railways.content.custom_bogeys.passenger;

import com.railwayteam.railways.registry.CRBlockEntities;
import com.railwayteam.railways.registry.CRBogeySizes;
import com.railwayteam.railways.registry.CRBogeyStyles;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.schematics.requirement.ISpecialBlockItemRequirement;
import com.simibubi.create.content.trains.bogey.AbstractBogeyBlock;
import com.simibubi.create.content.trains.bogey.BogeyStyle;
import com.simibubi.create.content.trains.track.TrackMaterial;
import com.simibubi.create.foundation.block.IBE;
import com.simibubi.create.foundation.block.ProperWaterloggedBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class PassengerBogeyBlock extends AbstractBogeyBlock<PassengerBogeyBlockEntity>
	implements IBE<PassengerBogeyBlockEntity>, ProperWaterloggedBlock, ISpecialBlockItemRequirement {

	public PassengerBogeyBlock(Properties props) {
		super(props, CRBogeySizes.PASSENGER);
		registerDefaultState(defaultBlockState().setValue(WATERLOGGED, false));
	}

	@Override
	public TrackMaterial.TrackType getTrackType(BogeyStyle style) {
		return TrackMaterial.TrackType.STANDARD;
	}

	@Override
	public double getWheelPointSpacing() {
		return 2;
	}

	@Override
	public double getWheelRadius() {
		return 6.5 / 16d;
	}

	@Override
	public Vec3 getConnectorAnchorOffset() {
		return new Vec3(0, 7 / 32f, 1);
	}

	@Override
	public BogeyStyle getDefaultStyle() {
		return CRBogeyStyles.TWOAXLESONE;
	}

	@Override
	public ItemStack getCloneItemStack(BlockGetter level, BlockPos pos, BlockState state) {
		return AllBlocks.RAILWAY_CASING.asStack();
	}

	@Override
	public Class<PassengerBogeyBlockEntity> getBlockEntityClass() {
		return PassengerBogeyBlockEntity.class;
	}

	@Override
	public BlockEntityType<? extends PassengerBogeyBlockEntity> getBlockEntityType() {
		return CRBlockEntities.PASSENGER_BOGEY.get();
	}

}
