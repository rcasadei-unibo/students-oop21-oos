package model.marker;

public interface MarkerFactory {

    Marker createCommonMarker(String text);

    Marker createLastDeathMarker();

    Marker createRecordMarker();

}
