package model;

import java.util.List;

import model.entity.DynamicEntity;
import model.entity.EntityType;

public final class CollisionManagerImpl implements CollisionManager {

    @Override
    public void playerCollidesWidth(final Player pl, final List<DynamicEntity> objects, final Model model) {
        for (final DynamicEntity obj : objects) {
            if (obj.getType() == EntityType.PLATFORM) {
                final int platformHeight = (int) obj.getBounds().getMinY();
                final int platformStart = (int) obj.getBounds().getMinY();
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
    }

}
