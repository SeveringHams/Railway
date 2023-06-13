package com.railwayteam.railways.util.packet;

import com.railwayteam.railways.content.coupling.coupler.TrackCouplerBlockEntity;
import com.railwayteam.railways.multiloader.S2CPacket;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

public class TrackCouplerClientInfoPacket implements S2CPacket {
    final BlockPos blockPos;
    final TrackCouplerBlockEntity.ClientInfo info;

    public TrackCouplerClientInfoPacket(TrackCouplerBlockEntity te) {
        blockPos = te.getBlockPos();
        info = te.getClientInfo();
    }

    public TrackCouplerClientInfoPacket(FriendlyByteBuf buf) {
        blockPos = buf.readBlockPos();
        info = new TrackCouplerBlockEntity.ClientInfo(buf.readNbt());
    }

    @Override
    public void write(FriendlyByteBuf buffer) {
        buffer.writeBlockPos(blockPos);
        buffer.writeNbt(info.write());
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void handle(Minecraft mc) {
        Level level = mc.level;
        if (level != null) {
            BlockEntity te = level.getBlockEntity(blockPos);
            if (te instanceof TrackCouplerBlockEntity couplerTile)
                couplerTile.setClientInfo(info);
        }
    }
}
