package view.entity;

import java.util.Collections;
import java.util.List;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.entity.DynamicEntity;

public final class EntityViewImpl implements EntityView {

    private final Pane pane; 
    private final List<DynamicEntity> entities;

    public EntityViewImpl(final Pane pane, final List<DynamicEntity> entities) {
        this.pane = pane;
        this.entities = entities;
    }

    @Override
    public void render() {
        Collections.unmodifiableList(entities).forEach(i -> {
            this.pane.getChildren().add(this.createImage(i));
        });
    }

    private ImageView createImage(final DynamicEntity entity) {
        final ImageView image = new ImageView(entity.getImage());
        image.setPreserveRatio(true);
        image.setLayoutX(entity.getBounds().getMinX());
        image.setLayoutY(entity.getBounds().getMinY());
        image.setFitHeight(entity.getBounds().getHeight());
        image.setFitWidth(entity.getBounds().getWidth());
        return image;
    }

}
