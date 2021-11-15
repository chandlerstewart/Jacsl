package net.fabricmc.jacsl.entities;

import net.fabricmc.jacsl.Main;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

import java.util.List;
import java.util.Random;

public class TeleportItemEntity extends ThrownItemEntity {

    private PlayerEntity playerEntity;
    private LivingEntity owner;
    private ItemStack itemStack;

    @Override
    protected void onCollision(HitResult hitResult) {

        this.world.sendEntityStatus(this, (byte)3);

        double xpos = hitResult.getPos().x;
        double ypos = hitResult.getPos().y;
        double zpos = hitResult.getPos().z;

        playerEntity.teleport(xpos, ypos, zpos);

        this.remove();


        Boolean hasBoomEnchant = EnchantmentHelper.getLevel(Main.TELPORTATIONBOOM_ENCHANTMENT, itemStack) > 0;
        Boolean hasKnockbackEnchant = EnchantmentHelper.getLevel(Main.TELPORTATIONKNOCKBACK_ENCHANTMENT, itemStack) > 0;

        float power = 4.0F;

        if (hasBoomEnchant) {
           world.createExplosion(owner, xpos, ypos, zpos, power, Explosion.DestructionType.DESTROY);
        }

        if (hasKnockbackEnchant){
            Random rand = new Random();
            List <Entity> affectedEntites = getAffectedEntites(power, xpos, ypos, zpos);
            for (Entity entity : affectedEntites)
            {
                entity.setVelocity(rand.nextDouble() * 10 - 5, rand.nextDouble() * 5, rand.nextDouble() * 10 - 5);
            }
        }

        super.onCollision(hitResult);
    }


    private List<Entity> getAffectedEntites(float power, double x, double y, double z)
    {
        float q = power * 2.0F;
        double k = MathHelper.floor(x - (double)q - 1.0D);
        double l = MathHelper.floor(x + (double)q + 1.0D);
        int t = MathHelper.floor(y - (double)q - 1.0D);
        int u = MathHelper.floor(y + (double)q + 1.0D);
        int v = MathHelper.floor(z - (double)q - 1.0D);
        int w = MathHelper.floor(z + (double)q + 1.0D);
        List<Entity> list = this.world.getOtherEntities(null, new Box((double)k, (double)t, (double)v, (double)l, (double)u, (double)w));

        return list;
    }

    public TeleportItemEntity(World world, LivingEntity owner, ItemStack itemStack) {
        super(EntityType.SNOWBALL, owner, world);
        this.playerEntity = (PlayerEntity) owner;
        this.owner = owner;
        this.itemStack = itemStack;
    }

    @Override
    protected Item getDefaultItem() {
        return null;
    }
}
