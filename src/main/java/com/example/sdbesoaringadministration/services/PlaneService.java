package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.PlaneDto;
import com.example.sdbesoaringadministration.models.Plane;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PlaneService {

    List<PlaneDto> getAllPlanes();

    PlaneDto getPlaneById( Long id );

    ResponseEntity<Object> createPlane( PlaneDto planeDto );

    void deletePlaneById( Long id );

    PlaneDto updatePlane( Long id, PlaneDto dto );

    void assignOwnerToPlane( Long plid, Long pid );

    void assignTechnicianToPlane( Long plid, Long pid );

    void uploadFlightStatusPdf( Long plid, MultipartFile pdf ) throws IOException;

    PlaneDto getFlightStatusPdfById( Long plid );

    PlaneDto addMinutePrice( Long plid, PlaneDto dto );
}
