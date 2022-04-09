package model;

import java.util.List;

import model.entity.DynamicEntity;
import model.entity.EntityType;

public final class CollisionManagerImpl implements CollisionManager {

    @Override
    public void playerCollidesWidth(final Player pl, final List<DynamicEntity> objects, final Model model) {
        for (final DynamicEntity obj : objects) {
            if (obj.getBounds().intersects(pl.getBounds())) {
                if (obj.getType() == EntityType.PLATFORM)  {
                    pl.setOnPlatform(true);
                    pl.setLandHeight((int) obj.getBounds().getMaxY());
                } else {
                    pl.setOnPlatform(false);
                }
                obj.activateEffect(model);
            }
        }
    }

}
