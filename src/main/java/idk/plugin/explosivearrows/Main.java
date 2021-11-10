package idk.plugin.explosivearrows;

import cn.nukkit.entity.Entity;
import cn.nukkit.entity.projectile.EntityArrow;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.ProjectileHitEvent;
import cn.nukkit.level.Explosion;
import cn.nukkit.plugin.PluginBase;

public class Main extends PluginBase implements Listener {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onProjectileHit(ProjectileHitEvent e) {
        Entity projectile = e.getEntity();
        if (projectile instanceof EntityArrow) {
            Explosion explosion = new Explosion(projectile, this.getConfig().getDouble("explosionSize", 2.0), projectile);
            if (this.getConfig().getBoolean("breakBlocks", true)) {
                explosion.explodeA();
            }
            explosion.explodeB();
        }
    }
}
