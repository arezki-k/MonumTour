package com.monumtour.Services.Implementation;

import com.monumtour.Model.Monument;
import com.monumtour.Repository.MonumentRepository;
import com.monumtour.Services.Interfaces.IMonumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MonumentService implements IMonumentService {

    @Autowired
    private MonumentRepository monumentRepository;

    @Override
    public Monument saveMonument(Monument m) {
        return monumentRepository.save(m);
    }

    @Override
    public Monument updateMonument(Monument m) {
        return monumentRepository.save(m);
    }

    @Override
    public void deleteMonumentById(String id) {
        monumentRepository.deleteById(id);
    }

    @Override
    public Monument getMonument(String id) {
        return monumentRepository.findById(id).get();
    }

    @Override
    public List<Monument> getAllMonuments() {
        return monumentRepository.findAll();
    }


    /**
     * Calculate distance between two points in latitude and longitude taking
     * into account height difference. If you are not interested in height
     * difference pass 0.0. Uses Haversine method as its base.
     *
     * lat1, lon1 Start point lat2, lon2 End point el1 Start altitude in meters
     * el2 End altitude in meters
     * @returns Distance in Kilometers
     */
    @Override
    public float distance(String codeM1, String codeM2) {
        final int R = 6371; // Radius of the earth
        Monument m1 = monumentRepository.findById(codeM1).get();
        Monument m2 = monumentRepository.findById(codeM2).get();
        float latDistance = (float) Math.toRadians(m2.getLatitude() - m1.getLatitude());
        float lonDistance = (float) Math.toRadians(m2.getLongitude() - m1.getLongitude());
        float a = (float) (Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                        + Math.cos(Math.toRadians(m1.getLatitude())) * Math.cos(Math.toRadians(m2.getLatitude()))
                        * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2));
        float c = (float) (2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)));
        float distance = R * c * 1000; // convert to meters
        distance = (float) Math.pow(distance, 2);
        return (float) (Math.sqrt(distance)/1000);

    }
}
