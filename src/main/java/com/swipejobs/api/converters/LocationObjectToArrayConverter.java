package com.swipejobs.api.converters;


import com.swipejobs.api.dto.jobs.Location;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LocationObjectToArrayConverter implements Converter<Location, Double[]>{

    @Override
    public Double[] convert(Location location) {
        Double[] loc  = {Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude())};
        return loc;
    }
}
