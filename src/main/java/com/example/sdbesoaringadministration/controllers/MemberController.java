package com.example.sdbesoaringadministration.controllers;

import com.example.sdbesoaringadministration.dtos.MemberDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.services.MemberService;
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
        MemberDto member = memberService.getMemberById( id );
        try {
            return ResponseEntity.ok( member );
        } catch ( Exception ex ) {
            throw new RecordNotFoundException( "Not found" );
        }
    }

    //    Check if member type is allready in db, if so do nothing and reply is already in db
    @PostMapping("/members")
    public ResponseEntity<Object> addMember( @Valid @RequestBody MemberDto memberDto, BindingResult br ) {
        if ( br.hasErrors() ) {
            StringBuilder sb = new StringBuilder();
            for ( FieldError fe : br.getFieldErrors() ) {
                sb.append( fe.getDefaultMessage() );
                sb.append( "\n" );
            }
            return new ResponseEntity<>( sb.toString(), HttpStatus.BAD_REQUEST );
        } else {
            memberService.addMember( memberDto );
            return new ResponseEntity<>( "Added to the memberlist", HttpStatus.CREATED );
        }
    }


    @DeleteMapping("/members/{id}")
    public ResponseEntity<Object> deleteMemberById( @PathVariable("id") Long id ) {

        memberService.deleteMemberById( id );
        return new ResponseEntity<>( "Member has been deleted from the memberlist.", HttpStatus.ACCEPTED );

    }

    @PutMapping("/members/{id}")
    public MemberDto updateMember( @PathVariable("id") Long id, @RequestBody MemberDto memberDto ) {

        MemberDto dto = memberService.updateMember( id, memberDto );

        return dto;

    }

}
