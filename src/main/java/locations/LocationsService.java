package locations;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class LocationsService {

    private List<Location> locations = Collections.synchronizedList(new ArrayList<>(List.of(
            new Location(1L, "Debrecen", 1.1, 1.2),
            new Location(2L, "Szeged", 2.1, 2.2)
    )));

    public String getLocations() {
        StringBuilder locationsInString = new StringBuilder();
        for(Location location : locations) {
            locationsInString.append(location.toString());
        }
        return locationsInString.toString();
    }
}
