//Custom JUnit listener
package com.listeners;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Collection;

import org.junit.experimental.categories.Category;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class CustomJunitListener extends RunListener{

	public void testStarted(Description description) throws Exception {
		Collection<Annotation> colAnnotations = description.getAnnotations();
		for(Annotation annot : colAnnotations){
			if(annot instanceof Category){
				Category cat = (Category)annot;
				String annotStr = Arrays.toString(cat.value());		
//				System.out.println(annotStr);
				if(annotStr.contains("Functional")){
					System.out.println("------------------Executing Functional tests------------------");
				}else if(annotStr.contains("Smoke")){
					System.out.println("------------------Executing Smoke tests------------------");
				}
			}
		}
		System.out.println(description.getMethodName() + " has started");
	}

	public void testFinished(Description description) throws Exception {
		System.out.println(description.getMethodName() + " is finished");
	}

	public void testFailure(Failure failure) throws Exception {
		System.out.println(failure.getDescription().getMethodName() + " is failed");
	} 
}
