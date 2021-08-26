package com.lark.assignment.artechassignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lark.assignment.artechassignment.payload.ArtNumberMagicRequest;
import com.lark.assignment.artechassignment.payload.ArtNumberMagicResponse;
import com.lark.assignment.artechassignment.payload.ArtNumberResult;
import com.lark.assignment.artechassignment.service.ArtNumberMagicService;

@RestController
@RequestMapping("/api")
public class ArtNumbersMagicController {

	@Autowired
	ArtNumberMagicService service;

	private static final String STATUUS_SUCCESS = "SUCCESS";

	@PostMapping("/numberoperations")
	public ResponseEntity<ArtNumberMagicResponse> numberOperationsOperation(
			@RequestBody ArtNumberMagicRequest request) {

		List<Integer> input = request.getInput();

		Integer sum = service.getSum(input);
		Double average = service.getAverage(input);
		List<Integer> greaterThanAverage = service.getGreaterThanAverage(input, average);

		ArtNumberMagicResponse response = new ArtNumberMagicResponse();
		response.setStatus(STATUUS_SUCCESS);
		ArtNumberResult result = new ArtNumberResult();
		result.setSum(sum);
		result.setAverage(average);
		result.setGreaterThanAverage(greaterThanAverage);

		response.setResult(result);

		return new ResponseEntity<ArtNumberMagicResponse>(response, HttpStatus.OK);
	}

}
