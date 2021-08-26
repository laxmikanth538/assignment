package com.lark.assignment.artechassignment.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ArtNumberMagicService {
	public Integer getSum(List<Integer> list) {
		return list.parallelStream().collect(Collectors.summingInt(Integer::intValue));
	}

	public Double getAverage(List<Integer> list) {
		return list.stream().mapToInt(Integer::intValue).average().getAsDouble();
	}

	public List<Integer> getGreaterThanAverage(List<Integer> list, Double average) {
		return list.parallelStream().filter((val) -> {
			if (val > average) {
				return true;
			}
			return false;
		}).collect(Collectors.toList());
	}
}
