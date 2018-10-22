package idk.plugin.explosivearrows;

import cn.nukkit.entity.Entity;
import cn.nukkit.entity.projectile.EntityArrow;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.ProjectileHitEvent;
import cn.nukkit.level.Explosion;
import cn.nukkit.plugin.PluginBase;

public class Main extends PluginBase implements Listener {

    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        this.saveDefaultConfig();
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent e) {
        Entity projectile = e.getEntity();
        if (!(projectile instanceof EntityArrow)) return;
        Explosion explosion = new Explosion(projectile, this.getConfig().getDouble("explosionSize", 2.0), projectile);
        explosion.explodeA();
        explosion.explodeB();
    }
}
