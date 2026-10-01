import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    // Customer ID -> Check-in information
    private Map<Integer, CheckInInfo> checkIns;

    // Route -> Total time
    private Map<String, Long> totalTime;

    // Route -> Number of trips
    private Map<String, Integer> tripCount;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        totalTime = new HashMap<>();
        tripCount = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInInfo(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {

        // Get customer's check-in information
        CheckInInfo info = checkIns.get(id);

        String startStation = info.stationName;
        int startTime = info.time;

        // Calculate travel time
        int travelTime = t - startTime;

        // Create route key
        String route = startStation + "->" + stationName;

        // Update total time
        totalTime.put(
            route,
            totalTime.getOrDefault(route, 0L) + travelTime
        );

        // Update trip count
        tripCount.put(
            route,
            tripCount.getOrDefault(route, 0) + 1
        );

        // Customer is no longer checked in
        checkIns.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {

        String route = startStation + "->" + endStation;

        long total = totalTime.get(route);
        int count = tripCount.get(route);

        return (double) total / count;
    }

    // Helper class
    private static class CheckInInfo {
        String stationName;
        int time;

        CheckInInfo(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }
}