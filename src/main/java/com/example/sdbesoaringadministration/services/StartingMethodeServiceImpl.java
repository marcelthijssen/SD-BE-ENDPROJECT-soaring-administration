package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.StartingMethodeDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.models.StartingMethode;
import com.example.sdbesoaringadministration.repositories.StartingMethodeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.sdbesoaringadministration.dtos.StartingMethodeDto.startingMethodeDtoToStartingMethode;

@Service
public class StartingMethodeServiceImpl implements StartingMethodeService {

    private final StartingMethodeRepository smRepository;

    public StartingMethodeServiceImpl( StartingMethodeRepository smRepository ) {
        this.smRepository = smRepository;
    }

    @Override
    public List<StartingMethodeDto> getAllStartingMethodes() {
        List<StartingMethode> smList = this.smRepository.findAll();
        List<StartingMethodeDto> smDtoList = new ArrayList<>();

        for ( StartingMethode sm : smList ) {
            StartingMethodeDto dto = new StartingMethodeDto().startingMethodeToStartingMethodeDto(sm);

            smDtoList.add( dto );
        }
        return smDtoList;
    }

    @Override
    public StartingMethodeDto getStartingMethodeById( Long smid ) {

        if ( smRepository.findById( smid ).isPresent() ) {
            StartingMethode startingMethode = smRepository.findById( smid ).get();
            StartingMethodeDto dto = new StartingMethodeDto().startingMethodeToStartingMethodeDto(startingMethode);


            return dto;
        } else {
            throw new RecordNotFoundException( "Starting methode not found" );
        }
    }

    @Override
    public void addStartingMethode( StartingMethodeDto dto ) {
        StartingMethode sm = startingMethodeDtoToStartingMethode( dto );
        smRepository.save( sm );
    }


    @Override
    public void deleteStartingMethodeById( Long smid ) {
        if ( smRepository.findById( smid ).isPresent() ) {
            smRepository.deleteById( smid );
        } else {
            throw new RecordNotFoundException( "Starting methode not found" );
        }
    }

    @Override
    public void updateStartingMethode( Long smid, StartingMethodeDto dto ) {
        if ( smRepository.findById( smid ).isPresent() ) {
            StartingMethode sm = smRepository.findById( smid ).get();
            sm.setId( dto.getId() );
            sm.setTitle( dto.getTitle() );
            sm.setUnit( dto.getUnit() );
            sm.setPrice( dto.getPrice() );
            smRepository.save( sm );
        } else {
            throw new RecordNotFoundException( "StartingMethode does not exist" );
        }
    }


}
