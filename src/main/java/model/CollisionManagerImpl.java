package model;

import java.util.ArrayList;
import java.util.List;

import model.entity.DynamicEntityImpl;
import model.entity.EntityType;

public final class CollisionManagerImpl implements CollisionManager {

    private Player pl;
    private List<DynamicEntityImpl> objects = new ArrayList();

    public CollisionManagerImpl(final Player pl, final List<DynamicEntityImpl> objects) {
        this.pl = pl;
        this.objects = objects;
    }

    @Override
    public void playerCollidesWidth(final Model model) {
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
