package com.example.PolicyService.services;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
@RequestMapping("/v1")
public class PolicyWS {

	private Map<Integer, String> map = Arrays.stream(new Object[][] { { 1, "one" }, { 2, "two" }, { 3, "three" } })
			.collect(Collectors.toMap(k -> (Integer) k[0], v -> (String) v[1]));

	@GetMapping(path = "/policies", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Map<Integer, String>> getPolicies() {
		// return ResponseEntity.ok().body(map); // Can also use this variant
		return ResponseEntity.ok(map);
	}
	/*
	 * public Map<Integer, String> getPolicies() { // Can also return map directly
	 * return map; }
	 */

	@GetMapping(path = "/policies/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public String getPolicy(@PathVariable(name = "id", required = false) Integer id) {
		return map.get(id);
	}
	
	@PostMapping(path = "/policies", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Map<Integer, String>> createPolicy(@RequestBody Policy policy) {
		map.put(policy.getId(), policy.getName());
		return ResponseEntity.ok(map);
	}
	
	@PutMapping(path = "/policies", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Map<Integer, String>> updatePolicy(@RequestBody Policy policy) {
		map.put(policy.getId(), policy.getName());
		return ResponseEntity.ok(map);
	}

	@DeleteMapping(path = "/policies/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Map<Integer, String>> deletePolicy(@PathVariable Integer id) {
		map.remove(id);
		return ResponseEntity.ok(map);
	}
}

@Data
class Policy {
	private Integer id;
	private String name;
}
