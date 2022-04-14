package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.PlaneDto;
import com.example.sdbesoaringadministration.models.Plane;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PlaneService {

    List<PlaneDto> getAllPlanes();

    PlaneDto getPlaneById( Long id );

    Plane addPlane( PlaneDto planeDto );

    void deletePlaneById( Long id );

    PlaneDto updatePlane( Long id, PlaneDto dto );

    void assignOwnerToPlane( Long plid, Long pid );

    void assignTechnicianToPlane( Long plid, Long pid );

    PlaneDto AddFlightStatusPdf( Long plid, MultipartFile pdf ) throws IOException;

    PlaneDto getPlaneflightStatusById( Long plid );

}
