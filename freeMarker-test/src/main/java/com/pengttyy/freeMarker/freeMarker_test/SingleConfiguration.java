package com.pengttyy.freeMarker.freeMarker_test;

import java.io.File;
import java.io.IOException;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;

public class SingleConfiguration {
	private volatile static Configuration single;

	private SingleConfiguration() {
	}

	public static Configuration getInstance() {
		if(null == single){
			synchronized (SingleConfiguration.class) {
				if(null == single){
					single = new Configuration();
					try {
						single.setDirectoryForTemplateLoading(new File("src/resource"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					single.setObjectWrapper(new DefaultObjectWrapper());
				}
			}
		}
		return single;
	}
}
