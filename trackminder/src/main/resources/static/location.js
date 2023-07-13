
    function getLocation() {
    if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(showPosition);
} else {
        print("Geolocation is not supported by this browser.");
}
}

    function showPosition(position) {
        print("Latitude: " + position.coords.latitude +
        "<br>Longitude: " + position.coords.longitude);
}