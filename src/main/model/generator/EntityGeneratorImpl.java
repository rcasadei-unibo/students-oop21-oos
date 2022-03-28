package main.model.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.geometry.Dimension2D;
import main.model.entity.DynamicEntity;

public class EntityGeneratorImpl implements EntityGenerator {

    private final List<DynamicEntity> entityList;
    private int entityCount;
    private final Dimension2D worldDimension;

    public EntityGeneratorImpl(final Dimension2D worldDimension) {
        this.entityList = new ArrayList<>();
        //this.entityList.add(new Obstacle(null, worldDimension));
        this.entityCount = 0;
        this.worldDimension = worldDimension;
    }

    @Override
    public List<DynamicEntity> getEntityList() {
        return Collections.unmodifiableList(entityList);
    }

    @Override
    public void updateList() {
        this.removeEntity();
        if (this.entityList.isEmpty() || this.checkPosition()) {
            this.addEntity();
        }
        this.entityList.forEach(e -> e.updatePosition());

    }

    @Override
    public void addEntity() {
        // TODO Auto-generated method stub
        this.entityCount++;
    }

    @Override
    public void removeEntity() {
        if (!this.entityList.isEmpty() && this.entityList.get(0).isOutofScreen()) {
            this.entityList.remove(0);
        }

    }

    @Override
    public boolean checkPosition() {
        // TODO Auto-generated method stub
        return false;
    }

}
