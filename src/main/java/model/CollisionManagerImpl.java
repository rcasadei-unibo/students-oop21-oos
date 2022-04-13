package model;

import java.util.List;

import model.entity.DynamicEntity;
import model.entity.EntityType;

public final class CollisionManagerImpl implements CollisionManager {

    /*@Override
    public void playerCollidesWidth(final Player pl, final List<DynamicEntity> objects, final Model model) {
        for (final DynamicEntity obj : objects) {
            if (obj.getType() == EntityType.PLATFORM) {
                final int platformHeight = (int) obj.getBounds().getMinY();
                final int platformStart = (int) obj.getBounds().getMinX();
                if (pl.getBounds().getMaxY() <= platformHeight 
                        && pl.getBounds().getMaxX() >= platformStart) {
                    pl.setOnPlatform(true);
                    pl.setLandHeight(platformHeight);
                }
            } else {
                pl.setOnPlatform(false);
            }
            if (obj.getBounds().intersects(pl.getBounds())) {
                obj.activateEffect(model);
            }
        }
    }*/

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
              if (e.getBounds().intersects(pl.getBounds())) {
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
