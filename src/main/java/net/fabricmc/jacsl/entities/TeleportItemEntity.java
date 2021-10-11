package net.fabricmc.jacsl.entities;

import ca.weblite.objc.Client;
import net.fabricmc.jacsl.Main;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class TeleportItemEntity extends ThrownItemEntity {

    private PlayerEntity playerEntity;

    @Override
    protected void onCollision(HitResult hitResult) {

        //if (!this.world.isClient) {
        this.world.sendEntityStatus(this, (byte)3);

        double xpos = hitResult.getPos().x;
        double ypos = hitResult.getPos().y;
        double zpos = hitResult.getPos().z;

        playerEntity.teleport(xpos, ypos, zpos);

        this.remove();
        //}

        super.onCollision(hitResult);
    }

    public TeleportItemEntity(World world, LivingEntity owner) {
        super(EntityType.SNOWBALL, owner, world);
        this.playerEntity = (PlayerEntity) owner;
    }

    @Override
    protected Item getDefaultItem() {
        return null;
    }
}
