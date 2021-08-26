package com.lark.assignment.artechassignment.payload;

import java.util.List;

import lombok.Data;

@Data
public class ArtNumberResult {

	private Integer sum;
	private Double average;
	private List<Integer> greaterThanAverage;
}
