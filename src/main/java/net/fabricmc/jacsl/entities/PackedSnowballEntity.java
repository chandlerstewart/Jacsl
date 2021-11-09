package net.fabricmc.jacsl.entities;


import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.fabricmc.jacsl.Main;

/*
We will be creating a custom snowball-like projectile that deals some nasty debuffs.
Since this is a thrown projectile, we will extending ThrownItemEntity.
Some ThrownItemEntities include:
- Snowballs
- Ender Pearls
 */
public class PackedSnowballEntity extends ThrownItemEntity {
    public PackedSnowballEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public PackedSnowballEntity(World world, LivingEntity owner) {

        super(EntityType.SNOWBALL, owner, world);
    }

    public PackedSnowballEntity(World world, double x, double y, double z) {
        super(EntityType.SNOWBALL, x, y, z, world);
    }


@Override
    protected Item getDefaultItem() {
        return null;
    }
    /*

    @Override
    public Packet createSpawnPacket() {
        return EntitySpawnPacket.create(this, ProjectileTutorialClient.PacketID);
    }
*/


    protected void onEntityHit(EntityHitResult entityHitResult) { // called on entity hit.
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity(); // sets a new Entity instance as the EntityHitResult (victim)
        int i = entity instanceof BlazeEntity ? 3 : 0; // sets i to 3 if the Entity instance is an instance of BlazeEntity
        entity.damage(DamageSource.thrownProjectile(this, this.getOwner()), (float)i); // deals damage

        if (entity instanceof LivingEntity) { // checks if entity is an instance of LivingEntity (meaning it is not a boat or minecart)
            ((LivingEntity) entity).addStatusEffect((new StatusEffectInstance(StatusEffects.WITHER, 20 * 3, 10))); // applies a status effect
          //  ((LivingEntity) entity).addStatusEffect((new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 3, 2))); // applies a status effect
            //((LivingEntity) entity).addStatusEffect((new StatusEffectInstance(StatusEffects.POISON, 20 * 3, 1))); // applies a status effect
            entity.playSound(SoundEvents.BLOCK_SNOW_STEP, 2F, 1F); // plays a sound for the entity hit only
        }
    }

    protected void onCollision(HitResult hitResult) { // called on collision with a block
        super.onCollision(hitResult);
        if (!this.world.isClient) { // checks if the world is client
            this.world.sendEntityStatus(this, (byte)3); // particle?
            this.remove(); // kills the projectile
        }

    }

}

