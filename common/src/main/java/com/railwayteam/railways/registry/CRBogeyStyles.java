package com.railwayteam.railways.registry;

import com.railwayteam.railways.Railways;
import com.railwayteam.railways.content.custom_bogeys.invisible.InvisibleBogeyRenderer;
import com.railwayteam.railways.content.custom_bogeys.monobogey.MonoBogeyRenderer;
import com.railwayteam.railways.content.custom_bogeys.CRBogeyRenderer;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllBogeyStyles;
import com.simibubi.create.Create;
import com.simibubi.create.content.trains.CubeParticleData;
import com.simibubi.create.content.trains.bogey.BogeySizes;
import com.simibubi.create.content.trains.bogey.BogeyStyle;
import com.simibubi.create.foundation.utility.Components;
import net.minecraft.resources.ResourceLocation;

import static com.simibubi.create.AllBogeyStyles.STANDARD_CYCLE_GROUP;

public class CRBogeyStyles {

    public static final BogeyStyle MONOBOGEY = create("monobogey", "monobogey")
        .displayName(Components.translatable("railways.bogeys.styles.monobogey"))
        .size(BogeySizes.SMALL, () -> () -> new MonoBogeyRenderer.SmallMonoBogeyRenderer(), CRBlocks.MONO_BOGEY)
        .build();

    public static final BogeyStyle INVISIBLE = create("invisible", Create.asResource(STANDARD_CYCLE_GROUP))
            .displayName(Components.translatable("railways.bogeys.styles.invisible"))
            .size(BogeySizes.SMALL, () -> () -> new InvisibleBogeyRenderer(), CRBlocks.INVISIBLE_BOGEY)
            .contactParticle(new CubeParticleData())
            .build();

    public static final BogeyStyle SINGLEAXLES = create("singleaxles", Create.asResource(STANDARD_CYCLE_GROUP))
            .displayName(Components.translatable("railways.bogeys.styles.singleaxle"))
            .size(BogeySizes.SMALL, () -> CRBogeyRenderer.SingleaxleBogeyRenderer::new, AllBlocks.SMALL_BOGEY)
            .size(BogeySizes.LARGE, () -> CRBogeyRenderer.LeafspringBogeyRenderer::new, AllBlocks.LARGE_BOGEY)
            .size(CRBogeySizes.COILSPRING, () -> CRBogeyRenderer.CoilspringBogeyRenderer::new, CRBlocks.COILSPRING_BOGEY)
            .build();

    public static final BogeyStyle TWOAXLESONE = create("twoaxlesone", Create.asResource(STANDARD_CYCLE_GROUP))
            .displayName(Components.translatable("railways.bogeys.styles.twoaxlesone"))
            .size(BogeySizes.SMALL, () -> CRBogeyRenderer.FreightBogeyRenderer::new, AllBlocks.SMALL_BOGEY)
            .size(BogeySizes.LARGE, () -> CRBogeyRenderer.ArchbarBogeyRenderer::new, AllBlocks.LARGE_BOGEY)
            .size(CRBogeySizes.PASSENGER, () -> CRBogeyRenderer.PassengerBogeyRenderer::new, CRBlocks.PASSENGER_BOGEY)
            .build();

//    public static final BogeyStyle TWOAXLESTWO = create("twoaxlestwo", Create.asResource(STANDARD_CYCLE_GROUP))
//            .displayName(Components.translatable("railways.bogeys.styles.twoaxlestwo"))
//            .build();


    public static AllBogeyStyles.BogeyStyleBuilder create(String name, String cycleGroup) {
        return create(Railways.asResource(name), Railways.asResource(cycleGroup));
    }

    public static AllBogeyStyles.BogeyStyleBuilder create(String name, ResourceLocation cycleGroup) {
        return create(Railways.asResource(name), cycleGroup);
    }

    public static AllBogeyStyles.BogeyStyleBuilder create(ResourceLocation name, ResourceLocation cycleGroup) {
        return new AllBogeyStyles.BogeyStyleBuilder(name, cycleGroup);
    }

    public static void register() {
        Railways.LOGGER.info("Registered bogey styles from " + Railways.MODID);
    }
}