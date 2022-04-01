package main.model.entity;

public interface CollectibleEntity {

    /**
     * Set the state of the entity.
     * @param collectedState true if the entity was collected 
     */
    void setCollected(boolean collectedState);

    /**
     * 
     * @return true if the entity was collected, false otherwise
     */
    boolean wasCollected();

    /**
     * Activate the effect of the collectible entity.
     * @param 
     */
    void activateEffect(/*Model ? Controller ?*/);

}
