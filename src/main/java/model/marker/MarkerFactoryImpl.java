package model.marker;

import java.awt.geom.Point2D;
import java.util.Random;

import javafx.scene.image.Image;

public class MarkerFactoryImpl implements MarkerFactory {

    private static final double MARKER_X = 860;
    private static final double LOW_MARKER_Y = 480;
    private static final double HIGH_MARKER_Y = 100;
    private final Random random;

    public MarkerFactoryImpl() {
        super();
        this.random = new Random();
    }

    @Override
    public Marker createCommonMarker() {
        return this.random.nextInt() % 2 == 0
                ? this.createHighMarker(new Image("")) 
                : this.createLowMarker(new Image("SwagCat.png"));
    }

    @Override
    public Marker createLastDeathMarker() {
        return this.createLowMarker(new Image("Tombstone.png"));
    }

    @Override
    public Marker createRecordMarker() {
        return this.createLowMarker(new Image("Record.png"));
    }

    private Marker createGeneralised(final Point2D.Double point, final Image image) {
        return new MarkerImpl(point, image);
    }

    private Marker createLowMarker(final Image image) {
        return this.createGeneralised(new Point2D.Double(MARKER_X, LOW_MARKER_Y), image);
    }

    private Marker createHighMarker(final Image image) {
        return this.createGeneralised(new Point2D.Double(MARKER_X, HIGH_MARKER_Y), image);
    }

}
