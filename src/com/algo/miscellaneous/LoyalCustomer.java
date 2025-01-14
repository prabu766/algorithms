package com.algo.miscellaneous;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 
 * @author prabhuddha.bhashitha
 * 
 * This code is written parallely to the medium article 
 * https://medium.com/@carloarg02/my-favorite-coding-question-to-give-candidates-17ea4758880c
 * 
 * The question is as below.
 * There is a website with two pages. It is logging customer id, page id and date in the log file.
 * They need to find customers who visited 2 distinct pages in two different days
 * 
 */
public class LoyalCustomer {
	
	public static void main(String[] args) {
		//read the file content to memory
		LoyalCustomer lc = new LoyalCustomer();
		System.out.println("Loyal customers are :"+ lc.findLoyalCustomerIds());
	}
	
	private List<String> findLoyalCustomerIds(){
		List<String> loyalCustomerIds = new ArrayList<>();
		List<String> fileNames = Arrays.asList("loyalcustomer_log1","loyalcustomer_log2");
		Map<String,Visit> visitMap = new HashMap<>();
			
		for(String fileName : fileNames) {
		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			
			stream.forEach(s -> {
				String[] data = s.split(",");
				String customerId = data[0];
				String pageId = data[1];
				String date = data[2];
				if(!loyalCustomerIds.contains(customerId)) {
					Visit v = visitMap.putIfAbsent(customerId, new Visit(pageId, date));
					if(v!=null) {//item already existing
						if(!v.pageId.equals(pageId) && !v.date.equals(date)) {
							loyalCustomerIds.add(customerId);
						}
					}
				}
			});
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		return loyalCustomerIds;
	}
		
	
	static class Visit{
		String pageId;
		String date;
		Visit(String pageId, String date){
			this.pageId= pageId;
			this.date= date;
		}
		
	}

}
