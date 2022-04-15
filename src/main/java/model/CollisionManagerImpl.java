package model;

import java.util.List;

import javafx.geometry.Rectangle2D;
import model.entity.DynamicEntity;
import model.entity.EntityType;

public final class CollisionManagerImpl implements CollisionManager {

    private static final double COLLISION_BOUND = 30.0f;
    private boolean onPlatform;
    private double platformY;

    public CollisionManagerImpl() {
        this.onPlatform = false;
        this.platformY = PlayerImpl.LAND;
    }

    @Override
    public void playerCollidesWidth(final Player pl, final List<DynamicEntity> objects, final Model model) { 
        this.onPlatform = false;
        this.platformY = PlayerImpl.LAND;
        objects.forEach(e -> {
            //Dovrebbe essere uguale istanceof o l'enum 
            if (e.getType() == EntityType.PLATFORM /*instanceof Platform*/) {
                if (pl.getBounds().getMaxY() <= e.getBounds().getMinY()
                   && pl.getBounds().getMaxX() >= e.getBounds().getMinX() 
                   && pl.getBounds().getMinX() <= e.getBounds().getMaxX()) {
                            onPlatform = true;
                            platformY = e.getBounds().getMinY();
                }
            } else {
                if (pl.isShieldActive() && e.getType() == EntityType.OBSATCLE) {
                    e.hit(false);
                } else if (e.getBounds().intersects(new Rectangle2D(pl.getBounds().getMinX() + COLLISION_BOUND / 2, pl.getBounds().getMinY() + COLLISION_BOUND / 2, pl.getBounds().getWidth() - COLLISION_BOUND, pl.getBounds().getHeight() - COLLISION_BOUND)) 
                            && !e.wasHit()) {
                  e.activateEffect(model);
                  e.hit(true);
              }
            }
        });
        if (onPlatform) {
            pl.setOnPlatform(true);
            pl.setLandHeight(platformY);
        } else {
            pl.setOnPlatform(false);
            pl.setLandHeight(PlayerImpl.LAND);
        }
    }

}
