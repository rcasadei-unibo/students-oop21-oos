package model.marker;

import java.util.List;
import java.util.Optional;

public interface MarkerManager {

    void update();

    void check();

    boolean isCommonMarkerToBeCreated(int distance);

    List<Optional<Marker>> getMarkers();

}
