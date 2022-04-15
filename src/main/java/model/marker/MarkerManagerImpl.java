package model.marker;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MarkerManagerImpl implements MarkerManager {

    private static final int DISTANCE_BETWEEN_MARKERS = 100;
    private final double lastDeathDistance;
    private final double recordDistance;
    private int numberNextMarker;
    private final MarkerFactory markerFactory;
    private List<Optional<Marker>> markers;



    public MarkerManagerImpl(final double lastDeathDistance, final double recordDistance) {
        super();
        this.lastDeathDistance = lastDeathDistance;
        this.recordDistance = recordDistance;
        this.numberNextMarker = 1;
        //this.markerFactory = new MarkerFactoryImpl();
        this.markers = new ArrayList<>();
    }

    @Override
    public boolean isCommonMarkerToBeCreated(int distance) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void check() {
        // TODO Auto-generated method stub
        
    }


    @Override
    public List<Optional<Marker>> getMarkers() {
        // TODO Auto-generated method stub
        return null;
    }

}
