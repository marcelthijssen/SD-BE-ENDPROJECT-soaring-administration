package com.example.sdbesoaringadministration.controllers;

import com.example.sdbesoaringadministration.dtos.MembershipDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.services.MembershipService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/memberships")
public class MembershipController {


    private final MembershipService membershipService;

    public MembershipController( MembershipService membershipService ) {
        this.membershipService = membershipService;
    }


    @GetMapping("")
    public ResponseEntity<Object> getAllMemberships() {
        List<MembershipDto> listMembershipDto = membershipService.getAllMemberships();
        return new ResponseEntity<>( listMembershipDto, HttpStatus.OK );
    }

    @GetMapping("/{mbid}")
    public ResponseEntity<Object> getMembershipById( @PathVariable(name = "mbid") Long mbid ) {
        MembershipDto MembershipDto = membershipService.getMembershipById( mbid );
        try {
            return ResponseEntity.ok( MembershipDto );
        } catch ( Exception ex ) {
            throw new RecordNotFoundException( "Type of Membership not found" );
        }
    }


    @PostMapping("")
    public ResponseEntity<Object> addMembership( @Valid @RequestBody MembershipDto MembershipDto, BindingResult br ) {
        if ( br.hasErrors() ) {
            StringBuilder sb = new StringBuilder();
            for ( FieldError fe : br.getFieldErrors() ) {
                sb.append( fe.getDefaultMessage() );
                sb.append( "\n" );
            }
            return new ResponseEntity<>( sb.toString(), HttpStatus.BAD_REQUEST );
        } else {
            membershipService.createMembership( MembershipDto );
            return new ResponseEntity<>( "new type of Membership has been added to the system", HttpStatus.CREATED );
        }
    }

    @DeleteMapping("/{mbid}")
    public ResponseEntity<Object> deleteMembershipById( @PathVariable("mbid") Long mbid ) {

        membershipService.deleteMembershipById( mbid );
        return new ResponseEntity<>( "Membership-type has been delteed", HttpStatus.ACCEPTED );

    }


    @PutMapping("/{mbid}")

    public MembershipDto updateMembership( @PathVariable("id") Long mbid, @RequestBody MembershipDto dto ) {

        MembershipDto MembershipDto = membershipService.updateMembership( mbid, dto );

        return MembershipDto;

    }


}
