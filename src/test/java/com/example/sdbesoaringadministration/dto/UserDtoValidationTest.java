//package com.example.sdbesoaringadministration.dto;
//
//import com.example.sdbesoaringadministration.dtos.UserDto;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;
//
//import javax.validation.ConstraintViolation;
//import javax.validation.Validation;
//import javax.validation.Validator;
//import javax.validation.ValidatorFactory;
//import java.lang.reflect.Field;
//import java.util.Set;
//import java.util.stream.Stream;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//
//public class UserDtoValidationTest {
//
//
//        @Test
//         void givenValidDto_whenValidated_thenNoValidationError() {
//            UserDto userDto = getValidUserDto();
//
//            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//            final Validator validator = factory.getValidator();
//
//            Set<ConstraintViolation<UserDto>> constraintViolations =
//                    validator.validate(userDto);
//
//            assertThat(constraintViolations.size()).isZero();
//
//        }
//
//        static Stream<Arguments> provideFieldAndInvalidValue() {
//            return Stream.of(
//                    Arguments.of("username", null),
//                    Arguments.of("email", null)
//            );
//        }
//
//
//        @ParameterizedTest
//        @MethodSource("provideFieldAndInvalidValue")
//        void testInvalidDto(String fieldName, Object invalidValue) {
//            UserDto userDto = getValidUserDto();
//
//            Field field = UserDto.class.getDeclaredField(fieldName);
//            field.setAccessible(true);
//            field.set(userDto, invalidValue);
//
//            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//            final Validator validator = factory.getValidator();
//
//            Set<ConstraintViolation<UserDto>> constraintViolations =
//                    validator.validate(userDto);
//
//            assertThat(constraintViolations.size()).isOne();
//        }
//
//        private UserDto getValidUserDto() {
//            return new UserDto("someName", "something@gmail.com");
//        }
//    }}
