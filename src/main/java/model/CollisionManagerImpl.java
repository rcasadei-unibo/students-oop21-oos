package model;

import java.util.List;

import model.entity.DynamicEntityImpl;
import model.entity.EntityType;

public final class CollisionManagerImpl implements CollisionManager {

    @Override
    public void playerCollidesWidth(final Player pl, final List<DynamicEntityImpl> objects, final Model model) {
        for (final DynamicEntityImpl obj : objects) {
            if (obj.getBounds().intersects(pl.getBounds())) {
                if (obj.getType() == EntityType.PLATFORM)  {
                    pl.setLandHeight((int) obj.getBounds().getMaxY());
                }
                obj.activateEffect(model);
            }
        }
    }

}
