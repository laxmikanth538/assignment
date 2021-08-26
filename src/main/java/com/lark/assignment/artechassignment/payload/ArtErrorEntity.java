package com.lark.assignment.artechassignment.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArtErrorEntity {

	private String status;
	private String msg;
}
