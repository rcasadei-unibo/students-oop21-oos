package model.marker;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import model.Statistics;

public class MarkerManagerImpl implements MarkerManager {

    private static final int DISTANCE_BETWEEN_MARKERS = 10;
    private final int lastDeathDistance;
    private final int recordDistance;
    private int numberNextMarker;
    private final MarkerFactory markerFactory;
    private Optional<Marker> lastDeathMarker;
    private Optional<Marker> recordMarker;
    private List<Optional<Marker>> markers;

    public MarkerManagerImpl(final int lastDeathDistance, final int recordDistance) {
        super();
        this.lastDeathDistance = lastDeathDistance;
        this.recordDistance = recordDistance;
        this.numberNextMarker = 1;
        this.markerFactory = new MarkerFactoryImpl();
        this.lastDeathMarker = Optional.empty();
        this.recordMarker = Optional.empty();
        this.markers = new ArrayList<>();
    }

    @Override
    public boolean isCommonMarkerToBeCreated(final int distance) {
        final int nextMarkerDist = this.numberNextMarker * DISTANCE_BETWEEN_MARKERS;

        if (distance >= nextMarkerDist && distance % nextMarkerDist >= 0) {
            this.numberNextMarker++;
            return true;
        }
        return false;
    }

    @Override
    public void check(final int distance) {
        if (this.isCommonMarkerToBeCreated(distance)) {
            this.markers.add(Optional.of(this.markerFactory.createCommonMarker(Integer.toString(this.approximatesDistance()))));
        }

        if (this.lastDeathMarker.isEmpty() && distance > 0 && distance >= this.lastDeathDistance) {
            this.lastDeathMarker = Optional.of(this.markerFactory.createLastDeathMarker());
            this.markers.add(this.lastDeathMarker);
        }

        if (this.recordMarker.isEmpty() && distance > 0 && distance >= this.recordDistance) {
            this.recordMarker = Optional.of(this.markerFactory.createRecordMarker());
            this.markers.add(this.recordMarker);
        }
    }

    @Override
    public void update(final double difficulty) {
        this.markers.stream()
                .forEach(op -> op.get().update(difficulty));
    }

    @Override
    public List<Optional<Marker>> getMarkers() {
        this.markers = this.markers.stream()
                .filter(op -> !op.get().isOutOfScreen())
                .collect(Collectors.toList());
        return this.markers;
    }

    private int approximatesDistance() {
        return this.numberNextMarker * DISTANCE_BETWEEN_MARKERS;
    }

}
