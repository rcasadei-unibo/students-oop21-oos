package model.marker;

public interface MarkerFactory {

    Marker createCommonMarker();

    Marker createLastDeathMarker();

    Marker createRecordMarker();

}
