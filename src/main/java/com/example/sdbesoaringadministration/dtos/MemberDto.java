//package com.example.sdbesoaringadministration.dtos;
//
//import com.example.sdbesoaringadministration.models.Membership;
//
//import java.time.LocalDate;
//
//public class MemberDto extends PersonDto{
//
//        private Long id;
//
//        private Boolean brevet;
//
//        private Boolean radioLicense;
//
//        private LocalDate lastCheck;
//
//    public MemberDto( ) {
//
//    }
//
//    public MemberDto( Long id, Membership membership, Boolean brevet, Boolean radioLicense, LocalDate lastCheck ) {
//        super(  );
//        this.brevet = brevet;
//        this.radioLicense = radioLicense;
//        this.lastCheck = lastCheck;
//    }
//
//    @Override
//        public Long getId() {
//            return id;
//        }
//
//        @Override
//        public void setId( Long id ) {
//            this.id = id;
//        }
//
//        public Boolean getBrevet() {
//            return brevet;
//        }
//
//        public void setBrevet( Boolean brevet ) {
//            this.brevet = brevet;
//        }
//
//        public Boolean getRadioLicense() {
//            return radioLicense;
//        }
//
//        public void setRadioLicense( Boolean radioLicense ) {
//            this.radioLicense = radioLicense;
//        }
//
//        public LocalDate getLastCheck() {
//            return lastCheck;
//        }
//
//        public void setLastCheck( LocalDate lastCheck ) {
//            this.lastCheck = lastCheck;
//        }
//}
