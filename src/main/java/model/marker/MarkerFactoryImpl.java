package model.marker;

import java.awt.geom.Point2D;
import java.util.Random;

import javafx.scene.image.Image;

public class MarkerFactoryImpl implements MarkerFactory {

    private static final double MARKER_X = 980;
    private static final double LOW_MARKER_Y = 365;
    private static final double HIGH_MARKER_Y = 40;
    private final Random random;

    public MarkerFactoryImpl() {
        super();
        this.random = new Random();
    }

    @Override
    public Marker createCommonMarker(final String text) {
        return this.random.nextInt() % 2 == 0
                ? this.createHighMarker(new Image("RedBalloon.png"), text)
                : this.createLowMarker(new Image("SwagCat.png"), text);
    }

    @Override
    public Marker createLastDeathMarker() {
        return this.createLowMarkerWithoutText(new Image("Tombstone.png"));
    }

    @Override
    public Marker createRecordMarker() {
        return this.createLowMarkerWithoutText(new Image("RecordFlag.png"));
    }

    private Marker createGeneralised(final Point2D.Double point, final Image image, final String text) {
        return new MarkerImpl(point, image, text);
    }

    private Marker createGeneralisedWithoutText(final Point2D.Double point, final Image image) {
        return new MarkerImpl(point, image, "");
    }

    private Marker createLowMarker(final Image image, final String text) {
        return this.createGeneralised(new Point2D.Double(MARKER_X, LOW_MARKER_Y), image, text);
    }

    private Marker createHighMarker(final Image image, final String text) {
        return this.createGeneralised(new Point2D.Double(MARKER_X, HIGH_MARKER_Y), image, text);
    }

    private Marker createLowMarkerWithoutText(final Image image) {
        return this.createGeneralisedWithoutText(new Point2D.Double(MARKER_X, LOW_MARKER_Y), image);
    }

}
