package main.model.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javafx.geometry.Dimension2D;
import main.model.entity.Coin;
import main.model.entity.DynamicEntity;
import main.model.entity.EntityLevelType;
import main.model.entity.Obstacle;
import main.model.entity.Platform;
import main.view.EntityImages;

public final class EntityGeneratorImpl implements EntityGenerator {

    private static final int MAX_CASE = 3;
    private static final int POWERUP_RARITY = 30;
    private final List<DynamicEntity> entityList;
    private int entityCount;
    private final Dimension2D worldDimension;

    public EntityGeneratorImpl(final Dimension2D worldDimension) {
        this.entityList = new ArrayList<>();
        this.entityList.add(new Obstacle(EntityLevelType.LEVEL_ZERO, worldDimension, EntityImages.OBSTACLE_ONE.getImageFromPath()));
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
            if (entityCount < POWERUP_RARITY) {
                this.addEntity();
            } else  {
                this.addPowerUp();
                this.entityCount = 0;
            }

        }
        this.entityList.forEach(e -> e.updatePosition());

    }

    private void addEntity() {
        final Random rand = new Random();
        final int random = rand.nextInt(MAX_CASE);
        switch (this.entityList.get(entityList.size() - 1).getLevelType()) {
        case LEVEL_ZERO:
            this.addFromZero(random);
            break;
        case LEVEL_ONE:
            this.addFromOne(random);
            break;
        case LEVEL_TWO:
            this.addFromTwo(random);
            break;
        default:
            break;
        }
        this.entityCount++;
    }

    private void addPowerUp() {

    }

    private void addFromZero(final int random) {
        switch (Case.values()[random]) {
        case CASE_0:
            /*Obstacle ground level*/
            this.entityList.add(new Obstacle(EntityLevelType.LEVEL_ZERO, worldDimension, EntityImages.OBSTACLE_ONE.getImageFromPath()));
            break;
        case CASE_1:
            /*Platform level one with under an obstacle*/
            this.entityList.add(new Obstacle(EntityLevelType.LEVEL_ZERO, worldDimension, EntityImages.OBSTACLE_TWO.getImageFromPath()));
            this.entityList.add(new Platform(EntityLevelType.LEVEL_ONE, worldDimension, EntityImages.PLATFORM.getImageFromPath()));
            break;
        case CASE_2:
            /*Platform level one with under a coin*/
            this.entityList.add(new Coin(EntityLevelType.LEVEL_ZERO, worldDimension, EntityImages.COIN.getImageFromPath()));
            this.entityList.add(new Platform(EntityLevelType.LEVEL_ONE, worldDimension, EntityImages.PLATFORM.getImageFromPath()));
            break;

        default:
            break;
        }

    }

    private void addFromOne(final int random) {

        switch (Case.values()[random]) {
        case CASE_0:
            /*Platform level two*/
            this.entityList.add(new Platform(EntityLevelType.LEVEL_TWO, worldDimension, EntityImages.PLATFORM.getImageFromPath()));
            break;
        case CASE_1:
            /*Obstacle ground level*/
            this.entityList.add(new Obstacle(EntityLevelType.LEVEL_ZERO, worldDimension, EntityImages.OBSTACLE_ONE.getImageFromPath()));
            break;
        case CASE_2:
            /*Collection of coin*/
            this.entityList.add(new Coin(EntityLevelType.LEVEL_ONE, worldDimension, EntityImages.COIN.getImageFromPath()));
            break;

        default:
            break;
        }
    }

    private void addFromTwo(final int random) {

        switch (Case.values()[random]) {
        case CASE_0:
            /*Platform level one*/
            this.entityList.add(new Platform(EntityLevelType.LEVEL_ONE, worldDimension, EntityImages.PLATFORM.getImageFromPath()));
            break;
        case CASE_1:
            /*Obstacle ground level*/
            this.entityList.add(new Obstacle(EntityLevelType.LEVEL_ZERO, worldDimension, EntityImages.OBSTACLE_ONE.getImageFromPath()));
            break;
        case CASE_2:
            /*Collection of coin*/
            this.entityList.add(new Coin(EntityLevelType.LEVEL_ZERO, worldDimension, EntityImages.COIN.getImageFromPath()));
            break;

        default:
            break;
        }
    }

    private void removeEntity() {
        if (!this.entityList.isEmpty() && this.entityList.get(0).isOutofScreen()) {
            this.entityList.remove(0);
        }

    }

    private boolean checkPosition() {
        // TODO Auto-generated method stub
        return false;
    }

    private enum Case {
        CASE_0, CASE_1, CASE_2;
    }

}
