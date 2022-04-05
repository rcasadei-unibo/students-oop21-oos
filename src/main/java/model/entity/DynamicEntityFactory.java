package model.entity;

public interface DynamicEntityFactory {
    
    DynamicEntity createObsatcle(EntityLevel level, double speedX);
    
    DynamicEntity createPlatform(EntityLevel level, double speedX);
}
