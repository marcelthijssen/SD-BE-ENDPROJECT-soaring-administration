package com.example.sdbesoaringadministration.controllers;

import com.example.sdbesoaringadministration.dtos.MemberDto;
import com.example.sdbesoaringadministration.dtos.PersonDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.services.MemberService;
import com.example.sdbesoaringadministration.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController( MemberService memberService ) {
        this.memberService = memberService;
    }

    @GetMapping("/members")
    public ResponseEntity<Object> getAllPersons(){
        List<MemberDto> memberDtoList = memberService.getAllMembers();

        return new ResponseEntity<>( memberDtoList, HttpStatus.OK );
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<Object> getMemberById( @PathVariable(name = "id") Long id ) {
        MemberDto tv = memberService.getMemberById( id );
        try {
            return ResponseEntity.ok( tv );
        } catch ( Exception ex ) {
            throw new RecordNotFoundException( "Not found" );
        }
    }

    //    Check if member type is allready in db, if so do nothing and reply is already in db
    @PostMapping("/members")
    public ResponseEntity<Object> addTelevision( @Valid @RequestBody MemberDto memberDto, BindingResult br ) {
        if ( br.hasErrors() ) {
            StringBuilder sb = new StringBuilder();
            for ( FieldError fe : br.getFieldErrors() ) {
                sb.append( fe.getDefaultMessage() );
                sb.append( "\n" );
            }
            return new ResponseEntity<>( sb.toString(), HttpStatus.BAD_REQUEST );
        } else {
            memberService.addMember( memberDto );
            return new ResponseEntity( "Members is added to systeem", HttpStatus.CREATED );
        }
    }


    @DeleteMapping("/members/{id}")
    public void deleteMemberById( @PathVariable("id") Long id ) {

        memberService.deleteMemberById( id );

    }

    @PutMapping("/members/{id}")
    public MemberDto updateTelevision( @PathVariable("id") Long id, @RequestBody MemberDto memberDto ) {

        MemberDto dto = memberService.updateMember( id, memberDto );

        return dto;

    }

}
