package com.railwayteam.railways.registry;

import com.railwayteam.railways.Railways;
import com.simibubi.create.content.trains.bogey.BogeySizes;

public class CRBogeySizes {
    public static final BogeySizes.BogeySize COILSPRING = create("coilspring", 6.5f / 16f);
    public static final BogeySizes.BogeySize PASSENGER = create("passenger", 6.5f / 16f);

    public static BogeySizes.BogeySize create(String name, float size) {
        return BogeySizes.addSize(Railways.asResource(name), size);
    }

    public static void register() {

    }
}