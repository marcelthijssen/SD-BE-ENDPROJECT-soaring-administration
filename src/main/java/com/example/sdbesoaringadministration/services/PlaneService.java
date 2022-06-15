/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 *
 * Purpos of this class
 */

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

    void assignOwnerToPlane( Long plane_id, Long person_id );

    void assignTechnicianToPlane( Long plane_id, Long person_id );

    void uploadFlightStatusPdf( Long plane_id, MultipartFile pdf ) throws IOException;

    PlaneDto getFlightStatusPdfById( Long plane_id );

    PlaneDto addMinutePrice( Long plane_id, PlaneDto dto );
}
