package model.entity;

import javafx.geometry.Dimension2D;
import view.entity.EntityImages;

public final class DynamicEntityFactoryImpl implements DynamicEntityFactory {

    private final Dimension2D worldDimension;

    public DynamicEntityFactoryImpl(final Dimension2D worldDimension) {
        this.worldDimension = worldDimension;
    }

    @Override
    public DynamicEntity createObsatcle(final EntityLevel level, final double speedX) {
        return new DynamicEntityImpl.Builder(worldDimension, speedX)
                                    .image(Math.random() > 0.5 ? EntityImages.OBSTACLE_ONE.getImageFromPath() : EntityImages.OBSTACLE_TWO.getImageFromPath())
                                    .level(level)
                                    .type(EntityType.OBSATCLE)
                                    .distance(EntityType.OBSATCLE.getDistanceFactor())
                                    .build();
    }

    @Override
    public DynamicEntity createPlatform(final EntityLevel level, final double speedX) {
        return new DynamicEntityImpl.Builder(worldDimension, speedX)
                                    .image(EntityImages.PLATFORM.getImageFromPath())
                                    .level(level)
                                    .type(EntityType.PLATFORM)
                                    .distance(EntityType.PLATFORM.getDistanceFactor())
                                    .build();
    }

    /*
     * Aggiungere metodi che costruiscano collezioni con due Entità ? 
     * 
     * */

}
