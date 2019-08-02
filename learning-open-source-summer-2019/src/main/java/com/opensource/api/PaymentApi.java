package com.opensource.api;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentApi {

//	@Transactional(rollbackFor = Exception.class) // update data
//	@PostMapping("/order/order-food")
//	public ResponseEntity<?> addOrderFood(@Valid @RequestBody Payment order, Errors error) {
//
//		AjaxResponseBody result = new com.opensource.model.AjaxResponseBody();
//		if (error.hasErrors()) {
//			result.setMessage(
//					error.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
//			return ResponseEntity.badRequest().body(result);
//		}
//
//
//		result.setMessage("Lưu thành công!");
//		return ResponseEntity.ok(result);
//	}
	
}
