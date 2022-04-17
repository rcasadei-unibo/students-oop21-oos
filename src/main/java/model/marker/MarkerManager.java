package model.marker;

import java.util.List;
import java.util.Optional;

public interface MarkerManager {

    boolean isCommonMarkerToBeCreated(int distance);

    void check(int distance);

    void update(double difficulty);

    List<Optional<Marker>> getMarkers();

}
