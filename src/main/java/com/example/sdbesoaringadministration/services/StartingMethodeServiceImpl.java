package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.StartingMethodeDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.models.StartingMethode;
import com.example.sdbesoaringadministration.repositories.StartingMethodeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
            StartingMethodeDto dto = new StartingMethodeDto();
            dto.setId( sm.getId() );
            dto.setTitle( sm.getTitle() );
            dto.setPrice( sm.getPrice( dto.getPrice( sm.getPrice() ) ) );
            smDtoList.add( dto );
        }
        return smDtoList;
    }

    @Override
    public StartingMethodeDto getStartingMethodeById( Long id ) {
        Optional<StartingMethode> startingMethode = smRepository.findById( id );

        if ( smRepository.findById( id ).isPresent() ) {
            StartingMethodeDto dto = startingMethodeToDto(startingMethode.get());

            StartingMethode sm = smRepository.findById( id ).get();
            dto.setId( sm.getId() );
            dto.setTitle( sm.getTitle() );
            dto.setPrice( sm.getPrice( dto.getPrice( sm.getPrice() ) ) );
            return dto;
        } else {
            throw new RecordNotFoundException( "Starting methode not found" );
        }
    }

    @Override
    public void addStartingMethode( StartingMethodeDto dto ) {
        StartingMethode sm = dtoToStartingMethode( dto );
        smRepository.save( sm );
    }

    /*    @Override
    public void addStartingMethode( StartingMethodeDto startingMethodeDto ) {
        StartingMethode sm = new StartingMethode();
        sm.setId( startingMethodeDto.getId() );
        sm.setTitle( startingMethodeDto.getTitle() );
        sm.setPrice( startingMethodeDto.getPrice() );
        this.smRepository.save( sm );
    }*/

    @Override
    public void deleteStartingMethodeById( Long id ) {
        if ( smRepository.findById( id ).isPresent() ) {
            smRepository.deleteById( id );
        } else {
            throw new RecordNotFoundException( "Starting methode not found" );
        }
    }

    @Override
    public void updateStartingMethode( Long id, StartingMethodeDto dto ) {
        if ( smRepository.findById( id ).isPresent() ) {
            StartingMethode sm = smRepository.findById( id ).get();
            sm.setId( dto.getId() );
            sm.setTitle( dto.getTitle() );
            sm.setPrice( dto.getPrice( sm.getPrice() ) );
            smRepository.save( sm );
        } else {
            throw new RecordNotFoundException( "StartingMethode does not exist" );
        }
    }

    public StartingMethode dtoToStartingMethode( StartingMethodeDto dto){
        StartingMethode sm = new StartingMethode();

        sm.setId(dto.getId());
        sm.setTitle(dto.getTitle());
        sm.setPrice(dto.getPrice( sm.getPrice() ));

        return sm;
    }

    public StartingMethodeDto startingMethodeToDto( StartingMethode sm ) {
        var dto = new StartingMethodeDto();

        dto.setId( sm.getId() );
        dto.setTitle( sm.getTitle() );
        dto.setUnit( sm.getUnit() );
        dto.getPrice( sm.getPrice() );
        return dto;
    }
}
