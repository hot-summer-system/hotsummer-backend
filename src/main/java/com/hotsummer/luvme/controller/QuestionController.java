package com.hotsummer.luvme.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotsummer.luvme.controller.api.exception.CustomNotFoundException;
import com.hotsummer.luvme.model.response.QuestionResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RequestMapping("api/v1/question")
public interface QuestionController {
        @Operation(summary = "Get Question By Id", description = "Get Question By Question Id")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Get Question Success"),
                        @ApiResponse(responseCode = "404", description = "Question Not Exist"),
                        @ApiResponse(responseCode = "500", description = "Server Error"),
        })
        @GetMapping("/questions/{questionId}")
        @PreAuthorize("hasAuthority('CUSTOMER')")
        public ResponseEntity<QuestionResponse> getQuestionById(@PathVariable("questionId") Integer questionId)
                        throws CustomNotFoundException;
       //request param
        @Operation(summary = "Get First Question", description = "Get Question that not have in linked question id in any field of table answer")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Get Question Success"),
                        @ApiResponse(responseCode = "500", description = "Server Error"),
        })

        @GetMapping("/first")
        @PreAuthorize("hasAuthority('CUSTOMER')")
        public ResponseEntity<QuestionResponse> getFirstQuestion();
}