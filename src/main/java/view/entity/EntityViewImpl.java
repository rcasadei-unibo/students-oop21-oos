package view.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.entity.DynamicEntity;

public final class EntityViewImpl implements EntityView {

    private final Pane pane; 
    private final List<ImageView> listImages;
    private final List<DynamicEntity> entities;

    public EntityViewImpl(final Pane pane, final List<DynamicEntity> entities) {
        this.pane = pane;
        this.listImages = new ArrayList<>();
        this.entities = entities;
    }

    @Override
    public void render() {
        this.pane.getChildren().removeAll(listImages);
        this.listImages.clear();
        final List<DynamicEntity> im = Collections.unmodifiableList(entities);
        im.forEach(i -> {
            this.listImages.add(this.createImage(i));
        });
        this.pane.getChildren().addAll(listImages);
    }

    private ImageView createImage(final DynamicEntity entity) {
        final ImageView image = new ImageView(entity.getImage());
        image.setPreserveRatio(true);
        image.setX(entity.getBounds().getMinX());
        image.setY(entity.getBounds().getMinY());
        image.setFitHeight(entity.getBounds().getHeight());
        image.setFitWidth(entity.getBounds().getWidth());
        return image;
    }

}
