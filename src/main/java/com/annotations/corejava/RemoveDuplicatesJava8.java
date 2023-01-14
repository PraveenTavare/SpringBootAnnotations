package com.annotations.corejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RemoveDuplicatesJava8 {

	public static void main(String[] args) {

		List<String> companyList = new ArrayList<>();
		
		// 1. using Stream.distinct() method
		
		 // 1.1 add string elements to List
        companyList.add("Meta");
        companyList.add("Apple");
        companyList.add("Amazon");
        companyList.add("Netflix");
        companyList.add("Meta"); // duplicate
        companyList.add("Google");
        companyList.add("Apple"); // duplicate
        
        System.out.println("1. Original List with duplicates : ");
        companyList.forEach(System.out::println);
        System.out.println();
        System.out.println("Unique elements :");
        List<String> distinctCompanyList = companyList.stream().distinct().collect(Collectors.toList());
        System.out.println(distinctCompanyList);
        
        for(String distinctcmpy : distinctCompanyList) {
        	companyList.remove(distinctcmpy);
        }
        
        System.out.println("\n3. Duplicate elements : \n");
        companyList.forEach(System.out::println);
        System.out.println();
        
     // 2. using Stream.filter() and Collections.frequency() methods
        
        List<String> companyList2 = new ArrayList<>();
		
		// 1. using Stream.distinct() method
		
		 // 1.1 add string elements to List
        companyList2.add("Meta");
        companyList2.add("Apple");
        companyList2.add("Amazon");
        companyList2.add("Netflix");
        companyList2.add("Meta"); // duplicate
        companyList2.add("Google");
        companyList2.add("Apple"); // duplicate
        
        System.out.println("1. Original List with duplicates : ");
        companyList2.forEach(c-> System.out.println(c));
        
        System.out.println("unique elements after removing duplicates : ");

        Set<String> cmpySet = companyList2.stream().collect(Collectors.toSet());
        System.out.println(cmpySet);
        
//        for(String cmpySet2 : cmpySet) {
//        	companyList2.remove(cmpySet2);
//        }
//        
//        companyList2.forEach(System.out::println);
        
        Set<String> duplicatesSet = companyList2.stream().filter(company -> Collections.frequency(companyList2, company) > 1).collect(Collectors.toSet());
        System.out.println(duplicatesSet);
        
        System.out.println();
        List<String> cmpyList3 = Arrays.asList("Meta","Apple","Amazon","Netflix","Meta","Google","Apple");
        
        cmpyList3.forEach(System.out::println);
        System.out.println();
        
        Set<String> uniqueSet = new HashSet<>();
        
        Set<String> duplicateCmpySet =  
        		cmpyList3.stream().filter(cmpy -> !uniqueSet.add(cmpy)).collect(Collectors.toSet());
        
        System.out.println(uniqueSet);
        duplicateCmpySet.forEach(System.out::println);

        // 1. list of Strings
        List<String> companies = new ArrayList<String>();
        
        // using Collectors.toMap() and Math::addExact and  Integer::sum
        companies.add("Meta");
        companies.add("Apple");
        companies.add("Amazon");
        companies.add("Netflix");
        companies.add("Meta"); // duplicate
        companies.add("Google");
        companies.add("Apple"); // duplicate
 
 
        // 1.2 print original List to console
        System.out.println("1. Original List with duplicates : \n");
        companies.forEach(System.out::println);
 
 
        // 2. get duplicate count using Map
        Map<String, Integer> duplicateCountMap = companies
                .stream()
                .collect(
                        Collectors.toMap(Function.identity(), company -> 1, Integer::sum)
                        );
        
        System.out.println(duplicateCountMap);
        
        System.out.println("\n2. Map with Key and its duplicate count : \n");
        duplicateCountMap.forEach(
                (key, value) -> System.out.println("Key : " + key + "\t Count : " + value)
                );
        
        Map<String, Integer> duplicateCountMap1 = 
        		companies.stream().collect(Collectors.toMap(Function.identity(), Cmpany -> 1 ,Math::addExact));
        
        System.out.println("\n2. Map with Key and its duplicate count : \n");
        duplicateCountMap1.forEach(
                (key, value) -> System.out.println("Key : " + key + "\t Count : " + value)
                );
        
        
	}

}
